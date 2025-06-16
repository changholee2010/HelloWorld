/**
 * reply.js
 */
console.log(bno);
// Date객체에 format메소드 추가.
Date.prototype.format = function() {
	let yyyy = this.getFullYear(); // 2025-05-27 12:39:23
	let MM = this.getMonth() + 1;
	let dd = this.getDate();
	let hh = this.getHours();
	let mm = this.getMinutes();
	let ss = this.getSeconds();

	return yyyy + '-' + ('0' + MM).slice(-2) + '-' + ('0' + dd).slice(-2) + ' '//
	//+ ('0' + hh).slice(-2) + ':' + ('0' + mm).slice(-2) + ':' + ('0' + ss).slice(-2);
}
// 이벤트.
// 댓글등록이벤트.
document.querySelector('#addReply').addEventListener('click', addReplyHandler);
function addReplyHandler(e) {
	let reply = document.querySelector('#reply').value;
	if (!logId || !reply) {
		alert('값을 확인하세요!');
		return;
	}
	// 댓글등록.
	svc.addReply({ bno, reply, replyer: logId } // 첫번째 매개값.
		, result => {
			let ul = document.querySelector('#target');
			if (result.retCode == "Success") {
				let rval = result.retVal; // 반환값에는 retCode, retVal 있음.
				ul.insertAdjacentHTML("afterbegin", makeTemplate(rval));
				document.querySelector('#reply').value = ""; // 입력값 초기화.
			} // end of if.
		} // 두번째 매개값.
		, err => console.log(err) // 세번째 매개값.
	)
} // end of addReplyHandler.
// 글목록 출력.
svc.replyList(bno //게시글번호
	, result => {
		let ul = document.querySelector('#target');
		let template = document.querySelector('#target li');
		console.log(result);
		for (let reply of result) {
			template = makeTemplate(reply);
			//
			ul.insertAdjacentHTML("beforeend", template);
		}
	}
	, err => console.log(err)
);
// 댓글화면출력.
function makeTemplate(reply = {}) {
	let rdate = new Date(reply.replyDate).format();
	template = `
      <li data-rno=${reply.replyNo}>
        <span class="col-sm-2">${reply.replyNo}</span>
        <span class="col-sm-4">${reply.reply}</span>
        <span class="col-sm-2">${reply.replyer}</span>
        <span class="col-sm-2">${rdate}</span>
        <span class="col-sm-1"><button onclick="deleteReply(event)" class="btn btn-danger">삭제</button></span>
      </li>
	`;
	return template; // <li>...</li> 반환.
}
// 댓글삭제함수.
function deleteReply(e) {
	let rno = e.target.parentElement.parentElement.dataset.rno;
	svc.removeReply(rno
		, result => {
			if (result.retCode == "Success") {
				alert("처리성공!");
				e.target.parentElement.parentElement.remove();
			} else {
				alert("처리실패!");
			}
		}
		, err => console.log(err)
	)
} // end of deleteReply.
