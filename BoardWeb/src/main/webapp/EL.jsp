<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="com.yedam.service.BoardServiceImpl"%>
<%@page import="com.yedam.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL.jsp</title>
</head>
<body>

  <%
    request.setAttribute("msg", "Hello");
    session.setAttribute("errorMsg", "ID,PW확인.");
    application.setAttribute("projectName", "BoardWeb");
    String name = "hong";
    System.out.print(name);
    
    BoardService svc = new BoardServiceImpl();
    SearchDTO search = new SearchDTO();
    search.setPage(1);
    List<BoardVO> list = svc.boardList(search);
    request.setAttribute("blist", list);
  %>
  ${10 - 5 le 10 }
  <p>${!empty msg }</p>
  <p>${errorMsg }</p>
  <p>${empty hello }</p>
  <!-- 변수선언 -->  
  <c:set var="name" value="Hongkildong"></c:set>
  <c:out value="${name }"></c:out>
  <!-- if -->
  <c:set var="age" value="15"></c:set>
  <c:if test="${age >= 20 }">
    <p>성인</p>
  </c:if>
  <!-- 조건(if,else) -->
  <c:choose>
    <c:when test="${!empty logId }">
      <p>로그인상태</p>
    </c:when>
    <c:otherwise>
      <p>로그아웃상태</p>
    </c:otherwise>
  </c:choose>
  <!-- 반복 -->
  <c:forEach var="i" begin="1" end="5" step="2">
    <span>i의 값은 ${i }</span>
  </c:forEach>
  <!-- 반복2 -->
  <table border="1">
  <c:forEach var="board" items="${blist }">
    <tr>
      <td>${board.boardNo }</td> <!-- board.getBoardNo() -->
      <td>${board.title }</td> <!-- board.getTitle() -->
      <td><c:out value="${board.writer }" /></td>
      <td><fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
    </tr>
  </c:forEach>
  </table>
</body>
</html>
