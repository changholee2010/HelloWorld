/**
 * js/board.js
 * 사용페이지: board.jsp
 */
console.log('start');

// 댓글정보 -> row 생성.
function makeRow(reply = {}) {
	let html = `<li data-rno="${reply.replyNo}">
				  <span class="col-sm-2">${reply.replyNo}</span>
				  <span class="col-sm-5">${reply.reply}</span>
				  <span class="col-sm-2">${reply.replyer}</span>
				  <span class="col-sm-2">
				    <button class="btn btn-danger" 
					       onclick="deleteReply(${reply.replyNo})">삭제</button>
				  </span>
				</li>`;
	let target = document.querySelector('div.reply ul.list');
	target.insertAdjacentHTML('beforeend', html);
	// target 태그의 <tag><li/><li/><li/><li/><li/></tag>
} // end of makeRow().

// 댓글 -> 삭제 -> retCode(OK, Fail)
function deleteReply(rno = 1) {
	fetch('removeReply.do?rno=' + rno)
		.then(result => result.json())
		.then(result => {
			console.log(result)
			if (result.retCode == 'OK') {
				alert("삭제완료.");
				document.querySelector('li[data-rno="' + rno + '"]').remove();
			} else {
				alert("삭제가 안됨.");
			}
		})
		.catch(err => console.log(err))
}

// 댓글목록 5건씩 출력.
function showReplyList() {
	fetch('replyList.do?bno=' + bno + '&page=' + page)
		.then(result => result.json())
		.then(result => {
			// 기존목록 clear.
			document.querySelector('ul.list').innerHTML = '';
			for (let reply of result) {
				makeRow(reply); // 댓글정보 -> <li/> 생성.
			}
			// 페이지 생성.
			createPageList();
		})
		.catch(err => console.log(err));
}

// 페이지 정보 지정.
let page = 1;

// 글번호 -> 전체건수를 활용해서 페이지계산하는 함수.
function createPageList() {

	fetch('getCount.do?bno=' + bno)
		.then(result => result.json())
		.then(result => {
			let totalCnt = result.replyCount; // 댓글전체건수. 75건(15페이지).
			// 이전, 이후 페이지여부, 첫번째 ~ 마지막 페이지.
			let prev, next; // 이전, 이후
			let startPage, endPage, realEnd;
			endPage = Math.ceil(page / 10) * 10; // 현재페이지 기준으로 마지막페이지 계산.
			startPage = endPage - 9; // 마지막페이지 - 9 => 첫째페이지.
			if (startPage > 1) {
				prev = true;
			}
			realEnd = Math.ceil(totalCnt / 5);
			if (endPage > realEnd) { // 현재11 20
				endPage = realEnd;
			}
			if (endPage < realEnd) { // 이후 목록의 존재?
				next = true;
			}

			// 목록작성.
			let pagination = document.querySelector('ul.pagination');
			pagination.innerHTML = '';
			// 이전페이지
			if (prev) {
				let html = `<li class="page-item" data-page="${startPage-1}">
				              <a class="page-link" href="#" aria-label="Previous">
				                <span aria-hidden="true">&laquo;</span>
				              </a>
				            </li>`;
				pagination.insertAdjacentHTML('beforeend', html);
			}
			// 목록건수(for반복문)
			for (let p = startPage; p <= endPage; p++) {
				let html = `<li class="page-item" data-page="${p}">
				              <a class="page-link" href="#">${p}</a></li>`;
				pagination.insertAdjacentHTML('beforeend', html);
			}
			// 이후페이지
			if (next) {
				let html = `<li class="page-item" data-page="${endPage+1}">
				              <a class="page-link" href="#" aria-label="Next">
				                <span aria-hidden="true">&raquo;</span>
				              </a>
				            </li>`;
				pagination.insertAdjacentHTML('beforeend', html);
			}

			// 페이징 a 태그의 클릭.
			document.querySelectorAll('ul.pagination a').forEach(item => {
				item.addEventListener('click', function(e) {
					e.preventDefault(); // 기본기능 차단.
					// 목록출력.
					page = item.parentElement.getAttribute('data-page');
					console.log(item.parentElement.getAttribute('data-page'));
					showReplyList();
				})
			})
		})
		.catch(err => console.log(err));
} // end of createPageList().


// 댓글등록 이벤트.
document.querySelector('#addBtn').addEventListener('click', function(e) {
	// 로그인정보, 원본글정보, 댓글내용.
	let reply = document.querySelector('#reply').value;
	// 필수항목 확인.
	if (!logId || !reply) {
		alert("필수입력값을 확인.")
		return;
	}

	fetch('addReply.do?bno=' + bno + '&replyer=' + logId + '&reply=' + reply)
		.then(result => result.json())
		.then(result => {
			console.log(result); // 결과확인. retCode:OK
			let reply = result.retVal;
			if (result.retCode == 'OK') {
				alert("등록성공")
				makeRow(reply);
				//초기화.
				document.querySelector('#reply').value = '';
			} else {
				alert("등록실패")
			}

		})
		.catch(err => console.log(err));

})

// 댓글목록 출력.
showReplyList();
