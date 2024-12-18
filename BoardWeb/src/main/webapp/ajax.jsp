<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ajax.jsp -->
	<script>
    // Asynchronous Javascript And Xml
    console.log('1');
    
    fetch('fullData.do')
      .then(result => result.json())
      .then(result => {
    	console.log('2');
      })
      .catch(err => console.log(err));
    
    console.log('3');
    
  </script>
</body>
</html>