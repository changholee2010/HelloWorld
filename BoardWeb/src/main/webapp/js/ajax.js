/**
 * ajax.js
 * Asynchronous Javascript And Xml 
 */

// 비동기 vs 동기 방식
// setTimeout(function () {
// 	console.log("1");
// }, 2000);

// setTimeout(function () {
// 	console.log("2");
// }, 1000);

// setTimeout(function () {
// 	console.log("start");
// }, 1500);

// {"id": 1, "first_name": "Hong"} => json객체
// -> {id: 1, first_name: "Hong"} => javascript객체

// 객체. XMLHttpRequest
//console.log("start");
let xhtp = new XMLHttpRequest();
xhtp.open('get', 'replyList.do?bno=213'); // 요청할 페이지 지정.
xhtp.send(); // 페이지 요청.
xhtp.onload = function() {
	let data = JSON.parse(xhtp.responseText); // json문자열 -> 자바스크립트 객체.
	console.log(data);
	data.forEach(function(item) {
		//console.log(item);
		let tr = makeRow(item);
		// tr을 tbody에 추가.
		document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
	});
	//document.querySelector('#show').innerHTML = xhtp.responseText;
};
// 등록이벤트.
document.querySelector('#addReply').addEventListener('click', addReplyFnc);
// 댓글등록 함수.
function addReplyFnc(e) {
	const bno = document.querySelector('#bno').value;
	const reply = document.querySelector('#reply').value;
	// 필수입력.
	if (!bno || !reply || !logId) {
		alert('필수값 입력!');
		return;
	}
	const addAjax = new XMLHttpRequest();
	addAjax.open('get', 'addReply.do?bno=' + bno + '&reply=' + reply + '&replyer=' + logId);
	addAjax.send();
	addAjax.onload = function(ev) {
		let result = JSON.parse(addAjax.responseText);
		if (result.retCode == 'Success') {
			alert('등록성공!');
			let tr = makeRow(result.retVal);
			// 부모요소.insertBefore(새요소, 대상)
			let target = document.querySelector('table:nth-of-type(2) tbody tr');
			document.querySelector('table:nth-of-type(2) tbody')//
				.insertBefore(tr, target);
		} else {
			alert('등록실패!');
		}
	}
}
// 댓글삭제 함수.
function deleteReplyFnc(e) {
	if (!confirm("삭제하시겠습니까?")) {
		return;
	}
	let rno = e.target.parentElement.parentElement.dataset.rno;
	console.log(rno);
	const delAjax = new XMLHttpRequest();
	delAjax.open('get', 'removeReply.do?rno=' + rno);
	delAjax.send();
	delAjax.onload = function(ev) {
		let result = JSON.parse(delAjax.responseText);
		if (result.retCode == 'Success') {
			e.target.parentElement.parentElement.remove(); //화면처리.			
		} else {
			alert('처리실패')
		}
	}
} // end of deleteReplyFnc.
// 댓글을 row 생성.
function makeRow(item) {
	let tr = document.createElement('tr'); // <tr></tr>
	tr.setAttribute('data-rno', item.replyNo); // <tr data-rno="8" ></tr>
	// 글번호,내용,작성자
	for (let prop of ['replyNo', 'reply', 'replyer']) {
		let td = document.createElement('td'); // <td>3</td>
		td.innerHTML = item[prop]; // item['replyNo']
		tr.appendChild(td); // <tr><td>3</td></tr>
	}
	// button생성.
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.addEventListener('click', deleteReplyFnc);
	btn.innerHTML = '삭제';
	btn.className = 'btn btn-danger';
	td.appendChild(btn);
	tr.appendChild(td);
	return tr; // makeRow를 호출한 영역으로 tr 반환.
} // end of makeRow.
function memberList() {
	//console.log("1");
	//console.log(xhtp.responseText); // parsing
	let data = JSON.parse(xhtp.responseText);
	//console.log(data);
	let str = "<ul>";
	data.forEach(function(item, idx, arr) {
		console.log(item);
		str += "<li>" + item.id + "," + item.first_name + "</li>";
	});
	str += "</ul>";
	document.querySelector('#show').innerHTML = str;
}
//console.log("end");

// fetch('data/sample.json')