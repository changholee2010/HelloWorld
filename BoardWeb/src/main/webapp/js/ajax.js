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
	console.log(xhtp.responseText);
	let data = JSON.parse(xhtp.responseText);
	data.forEach(function(item) {
		console.log(item);
		let tr = document.createElement('tr'); // <tr></tr>
		// 글번호,내용,작성자
		for (let prop of ['replyNo', 'reply', 'replyer']) {
			let td = document.createElement('td'); // <td>3</td>
			td.innerHTML = item[prop]; // item['replyNo']
			tr.appendChild(td); // <tr><td>3</td></tr>
		}
		// button생성.
		let td = document.createElement('td');
		let btn = document.createElement('button');
		btn.innerHTML = '삭제';
		btn.className = 'btn btn-danger';
		td.appendChild(btn);
		tr.appendChild(td);
		document.querySelector('tbody').appendChild(tr);
	});
	//document.querySelector('#show').innerHTML = xhtp.responseText;
};

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