<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>
<body>
  <%
    List<BoardVO> list = (List<BoardVO>) request.getAttribute("blist");
    
  %>
  <h3>게시글 목록</h3>

  <table class="table">
    <thead>
      <tr>
        <th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th><th>조회수</th>
      </tr>
    </thead>
    <tbody>
      <%for (BoardVO board : list) {%>
      <tr>
        <td><%=board.getBoardNo() %></td><td><%=board.getTitle() %></td>
        <td><%=board.getWriter() %></td><td><%=board.getWriteDate() %></td>
        <td><%=board.getReadCnt() %></td>
      </tr>
      <%} %>
    </tbody>
  </table>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous">
  </script>
</body>
</html>