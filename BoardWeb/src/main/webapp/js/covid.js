/*
* covid.js
*/
import { makeRow, url } from './covid_module.js';

// document.querySelector('#centerList').innerHTML = "Hello";
// 변수선언.
let centerAry;

fetch(url)
	.then(data => data.json())
	.then(result => {
		centerAry = result.data; // [{},{},{}....{}]
		// 시도정보 배열.
		let sidoAry = [];
		// tr>td*2
		// #centerList
		// [].forEach(function(elem, idx, ary) {       })
		centerAry.forEach((center, idx) => {
			// sidoAry에 중복하지 않고 담기.
			if (sidoAry.indexOf(center.sido) == -1) {
				sidoAry.push(center.sido); // 추가.
			}
			if (idx < 10) {
				//console.log(center);
				// tr생성하기.
				let tr = makeRow(center);
				document.querySelector('#centerList').appendChild(tr);
			} // end of if.
		}); // end of for.
		console.log(sidoAry);
		// sidoAry의 갯수만큼 <option value="sido정보">sido정보</option>
		sidoAry.forEach(sido => {
			let opt = document.createElement('option');
			opt.value = sido;
			opt.innerText = sido;
			document.getElementById('sido').appendChild(opt);
		})
	})
	.catch(err => console.log(err))

// 조회 event.
document.querySelector('button.btn-primary')//
	.addEventListener('click', function(e) {
		// 목록지우고...
		document.querySelector('#centerList').innerHTML = "";//clear.
		let keyword = document.getElementById('centerName').value;//검색값.

		centerAry // 배열.
			//.filter(center => center.centerName.indexOf(keyword) != -1) // 배열.
			.filter(center => center.centerName.includes(keyword)) // 배열.
			.forEach(center => {
				let tr = makeRow(center);
				document.querySelector('#centerList').appendChild(tr);
			})
	});

// select태그의 change이벤트.
document.querySelector('#sido').addEventListener('change', function(e) {
	// 목록지우고...
	document.querySelector('#centerList').innerHTML = "";//clear.
	let keyword = document.getElementById('sido').value;//검색값.
	centerAry // 배열.
		.reduce((acc, center) => {
			if (center.sido == keyword) {
				let tr = makeRow(center);
				acc.appendChild(tr);
			}
			return acc; // 다음순번의 acc값으로 반환.
		}, document.querySelector('#centerList'));
});

// [].push(), [].unshift(), [].pop(), [].shift() => [].splice();
// reduce();

let result = [1, 3, 5, 7].reduce(function(acc, elem, idx, ary) {
	console.log(acc, elem);
	if (elem > 14) {
		let li = document.createElement('li');
		li.innerHTML = elem;
		acc.appendChild(li);
	}
	return acc; // <ul><li>5</li></ul>
}, document.querySelector('#target'));
console.log('결과: ', result);





