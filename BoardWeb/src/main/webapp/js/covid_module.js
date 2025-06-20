/**
 * covid_module.js
 */
const defaultNum = 10;
let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=qCwQYxNXeK%2FaB1Ngf9oNZDttjmjQ6ku1OdR6%2Fd0Jj5EIdqOxMXolplih%2BYjTqB4uxCuK636co3tf9T5%2Fr9OLvw%3D%3D`;

function makeRow(center) {
	let tr = document.createElement('tr');
	tr.addEventListener('click', function(e) {
		window.open('map.jsp?lat=' + center.lat + '&lng=' + center.lng + '&name=' + center.centerName);
	})
	for (const prop of ['id', 'centerName', 'phoneNumber']) {
		let td = document.createElement('td'); // <td></td>
		td.innerHTML = center[prop]; // center['id'] // <td>1</td>
		tr.appendChild(td);
	}
	return tr;
}

export { makeRow, url }
