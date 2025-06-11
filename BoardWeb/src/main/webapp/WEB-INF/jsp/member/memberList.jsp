<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../include/aheader.jsp" />
<h3>회원목록</h3>
<table class="table">
  <thead>
    <tr>
      <th><a href="memberList.do?order=member_id">아이디</a></th>
      <th><a href="memberList.do?order=member_name">이름</a></th>
      <th>권한</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="member" items="${memberList }">
      <tr>
        <td><c:out value="${member.memberId }"></c:out></td>
        <td><c:out value="${member.memberName }"></c:out></td>
        <td><c:out value="${member.responsibility }"></c:out></td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<jsp:include page="../../include/afooter.jsp" />