<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>홈페이지에 잘왔습니다!!</title>
  <link href="css/styles.css" rel="stylesheet" />
  <script type="module" src="js/covid.js"></script>
</head>

<body>
  <h3>Welcome My Home!!</h3>
  <h3>코로나19 센터정보</h3>

  <!-- <input id="centerName" type="text"> -->
  <select id="sido" class="form-control col-sm-5">
    <option>선택하세요</option>
  </select>
  <button class="btn btn-primary">조회</button>

  <table class="table">
    <thead>
      <tr>
        <th>센터ID</th><th>센터이름</th><th>전화</th>
      </tr>
    </thead>
    <tbody id="centerList">
      <!-- 목록출력. -->
    </tbody>
  </table>
  
  <ul id="target"></ul>

</body>

</html>