<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="//cdn.datatables.net/2.3.2/css/dataTables.dataTables.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="//cdn.datatables.net/2.3.2/js/dataTables.min.js"></script>

<h3>게시글 목록</h3>

<table id="example" class="display">
  <thead>
    <tr>
      <th>글번호</th>
      <th>제목</th>
      <th>작성자</th>
      <th>작성일시</th>
      <th>조회수</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="board" items="${blist }">
      <tr>
        <td><a href="board.do?bno=${board.boardNo }&searchCondition=${search.searchCondition }&keyword=${search.keyword }&page=${pageInfo.currentPage}">${board.boardNo}</a></td>
        <td>${board.title }</td>
        <td><c:out value="${board.writer }" /></td>
        <td><fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd" /></td>
        <td><fmt:formatNumber value="${board.readCnt }" pattern="#,###" /></td>
      </tr>
    </c:forEach>
  </tbody>
  <tfoot>
    <tr>
      <th>글번호</th>
      <th>제목</th>
      <th>작성자</th>
      <th>작성일시</th>
      <th>조회수</th>
    </tr>
  </tfoot>
</table>

<script>
let table = new DataTable('#example', {
	order: [[0, 'desc']]
});
</script>
