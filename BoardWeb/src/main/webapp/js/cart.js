/**
 * cart.js
 */
// 장바구니 상품.
const cartItems = [{
	itemId: 1,
	itemName: "상품1",
	price: 2500,
	qty: 3,
	image: 'basket1.jpg'
}, {
	itemId: 2,
	itemName: "상품2",
	price: 3500,
	qty: 2,
	image: 'basket2.jpg'
}, {
	itemId: 3,
	itemName: "상품3",
	price: 4500,
	qty: 1,
	image: 'basket3.jpg'
}]

// 상품목록을 출력하기.
cartItems.forEach(product => {
	const template = `
            <div class="row data" data-id="${product.itemId}">
                <div class="subdiv">
                    <div class="check"><input type="checkbox" name="buy" value="260" checked="">&nbsp;</div>
                    <div class="img"><img src="./images/${product.image}" width="60"></div>
                    <div class="pname"> <span>${product.itemName}-${product.itemId}</span> </div>
                </div>
                <div class="subdiv">
                    <div class="basketprice">
                        <input type="hidden" name="p_price" id="p_price${product.itemId}" class="p_price" value="${product.price}">${product.price}원
                    </div>
                    <div class="num">
                        <div class="updown">
                            <input type="text" name="p_num1" id="p_num${product.itemId}" size="2" maxlength="4" class="p_num" value="${product.qty}"
                                onkeyup="javascript:basket.changePNum(event);">
                            <span onclick="javascript:basket.changePNum(event);">
                                <i class="fas fa-arrow-alt-circle-up up"></i> </span>
                            <span onclick="javascript:basket.changePNum(event);">
                                <i class="fas fa-arrow-alt-circle-down down"></i> </span>
                        </div>
                    </div>
                    <div class="sum">${product.price * product.qty}원</div>
                </div>
                <div class="subdiv">
                    <div class="basketcmd">
                        <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem(event);">삭제</a>
                    </div>
                </div>
            </div>`;
	document.querySelector('#basket').insertAdjacentHTML('beforeend', template);
})

// basket 객체와 메소드.
const basket = {
	// 장바구니 수량 변경.
	changePNum(e) {
		let elem = e.target; // 이벤트대상찾기.
		let subdiv = elem.closest('div.subdiv'); // elem의 부모요소에서 <div class="subdiv"></div> 찾기.
		let inputElem = subdiv.querySelector('input[name="p_num1"]');// 하위요소중에서 <input name="p_num1">을 찾아서...
		let currentQty = parseInt(inputElem.value); //현재수량.
		let itemPrice = subdiv.querySelector('input[name="p_price"]').value;//가격.
		// icon의 up/ down을 나눠서 처리.
		if (elem.classList.contains('up') || e.key == 'ArrowUp') { //수량증가
			currentQty++;
		} else if (elem.classList.contains('down') || e.key == 'ArrowDown') { //수량감소
			if (!(currentQty - 1)) { // 최소수량은 1로 정하자.
				return;
			}
			currentQty--;
		}
		inputElem.value = currentQty;
		subdiv.querySelector('div.sum').innerText = currentQty * itemPrice + "원";
		// 합계결과.
		this.allItem();
	},
	// 상품삭제.
	delItem(e) {
		e.target.closest('div.data').remove();
		// 합계결과.
		this.allItem();
	},
	// 선택상품삭제.
	delCheckedItem() {
		document.querySelectorAll('input[name="buy"]').forEach(item => {
			if (item.checked) {
				item.closest('div.data').remove();
			}
		});
		// 합계결과.
		this.allItem();
	},
	// 장바구니 비우기.
	delAllItem() {
		document.querySelectorAll('input[name="buy"]').forEach(item => item.closest('div.data').remove());
		// 합계결과.
		this.allItem();
	},
	// 전체수량과 금액을 계산해서 보여주기.
	allItem() {
		// 전체수량출력, 합계금액 출력.
		let sumQty = 0, sumPrice = 0;
		document.querySelectorAll('div.data input[name="p_num1"]').forEach(item => {
			sumQty += parseInt(item.value);
		})
		document.querySelectorAll('div.data div.sum').forEach(item => {
			sumPrice += parseInt(item.innerText.substring(0, item.innerText.length - 1));
		})
		document.querySelector('div.sumcount>span').innerText = sumQty;
		document.querySelector('div.summoney>span').innerText = sumPrice;
	}
}
// 화면출력시 합계정보를 보여주기 위해서 call.
basket.allItem();
