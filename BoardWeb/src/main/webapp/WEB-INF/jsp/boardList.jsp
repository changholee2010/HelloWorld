<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="../include/header.jsp" />
<p>${pageInfo }${blist }${search }</p>
<h3>게시글 목록</h3>
<!-- 검색조건추가. -->
<form action="boardList.do">
  <div class="row">
    <div class="col-sm-4">
      <select name="searchCondition" class="form-control">
        <option value="">선택하세요</option>
        <option value="T" ${!empty search.searchCondition && search.searchCondition == 'T' ? 'selected' : '' }>제목</option>
        <option value="W" ${!empty search.searchCondition && search.searchCondition == 'W' ? 'selected' : '' }>작성자</option>
        <option value="TW" ${!empty search.searchCondition && search.searchCondition == 'TW' ? 'selected' : '' }>제목&작성자</option>
      </select>
    </div>
    <div class="col-sm-6">
      <input type="text" name="keyword" class="form-control" value="${empty search.keyword ? '' : search.keyword}">
    </div>
    <div class="col-sm-2">
      <input type="submit" value="검색" class="btn btn-primary">
    </div>
  </div>
</form>

  <table class="table">
    <thead>
      <tr>
        <th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th><th>조회수</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="board" items="${blist }">
      <tr>
        <td><a href="board.do?bno=${board.boardNo }&searchCondition=${search.searchCondition }&keyword=${search.keyword }&page=${pageInfo.currentPage}">${board.boardNo }</a></td>
        <td>${board.title }</td>
        <td><c:out value="${board.writer }" /></td>
        <td><fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd"/></td>
        <td><fmt:formatNumber value="${board.readCnt }" pattern="#,###" /></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
  <!-- paging 시작. -->
<nav aria-label="Page navigation example">
<ul class="pagination justify-content-center">
  <!-- 이전페이지 활성화. -->
  <%if(!paging.isPrev()) {%>
  <li class="page-item disabled">
    <a class="page-link">Previous</a>
  </li>
  <%} else { %>
  <li class="page-item">
    <a class="page-link" href="boardList.do?page=<%=paging.getStart()-1 %>">Previous</a>
  </li>
  <%} %>
  
  <!-- paging 정보를 활용. -->
  <%for(int p = paging.getStart(); p <= paging.getEnd(); p++) { %>
  <%  if(p != paging.getCurrentPage()) {%>
  <li class="page-item">
    <a class="page-link" href="boardList.do?searchCondition=<%=search.getSearchCondition()%>&keyword=<%=search.getKeyword() %>&page=<%=p %>"><%=p %></a>
  </li>
  <%}else{ %>
  <li class="page-item active" aria-current="page">
    <span class="page-link"><%=p %></span>
  </li>
  <%} } %>

  <!-- 이후페이지 활성화. -->
  <%if(!paging.isNext()) {%>
  <li class="page-item disabled">
    <a class="page-link">Next</a>
  </li>
  <%} else { %>
  <li class="page-item">
    <a class="page-link" href="boardList.do?page=<%=paging.getEnd()+1 %>">Next</a>
  </li>
  <%} %>

</ul>
</nav>  
  <!-- paging 종료. -->
<jsp:include page="../include/footer.jsp" />