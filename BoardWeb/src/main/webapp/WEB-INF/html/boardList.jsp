<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>글목록(boardList.jsp)</h3>

<form action="boardList.do">
  <div class="row">
    <div class="col-sm-4">
      <select name="searchCondition" class="form-control">
        <option value="">선택하세요</option>
        <option value="T" ${not empty searchCondition and searchCondition eq 'T' ? 'selected' : '' }>제목</option>
        <option value="W" ${searchCondition ne null && searchCondition == 'W' ? 'selected' : '' }>작성자</option>
        <option value="TW" ${searchCondition ne null && searchCondition == 'TW' ? 'selected' : '' }>제목 & 작성자</option>
      </select>
    </div>
    <div class="col-sm-6">
      <input type="text" name="keyword" value="${keyword ne null ? keyword : '' }" class="form-control">
    </div>
    <div class="col">
      <input type="submit" value="검색" class="form-control">
    </div>
  </div>
</form>
<table class="table">
  <thead>
    <tr>
      <th>글번호</th>
      <th>제목</th>
      <th>작성자</th>
      <th>작성일시</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="bvo" items="${list }">
      <tr>
        <td align="center">
          <a href="board.do?page=${paging.currentPage }&keyword=${empty keyword ? '' : keyword }&searchCondition=${empty searchCondition ? '' : searchCondition }&board_no=${bvo.boardNo}">${bvo.boardNo }</a>
        </td>
        <td><c:out value="${bvo.title }" /></td>
        <td><c:out value="${bvo.writer }" /></td>
        <td>${bvo.creationDate }</td>
      </tr>
    </c:forEach>
  </tbody>
</table>

<!-- paging. -->
<nav aria-label="...">
  <ul class="pagination">
    <!--  이전 10개 목록이 존재하면 Previous를 활성화. -->
    <c:choose>
      <c:when test="${paging.prev }">
        <li class="page-item">
          <a class="page-link" href="boardList.do?keyword=${keyword ne null ? keyword : '' }&searchCondition=${!empty searchCondition ? searchCondition : '' }&page=${paging.startPage - 1 }">Previous</a>
        </li>
      </c:when>
      <c:otherwise>
        <li class="page-item disabled">
          <span class="page-link">Previous</span>
        </li>
      </c:otherwise>
    </c:choose>

    <!-- startPage와 endPage의 값에 해당하는 링크를 반복적으로 생성. -->
    <!-- 출력하는 페이지와 현재페이지가 같으면 링크생략. -->
    <c:forEach var="p" begin="${paging.startPage }" end="${paging.endPage }">
      <c:choose>
        <c:when test="${paging.currentPage == p }">
          <li class="page-item active" aria-current="page">
            <span class="page-link">${p }</span>
          </li>
        </c:when>
        <c:otherwise>
          <li class="page-item">
            <a class="page-link" href="boardList.do?keyword=${keyword eq null ? '' : keyword }&searchCondition=${searchCondition eq null ? '' : searchCondition }&page=${p }">${p }</a>
          </li>
        </c:otherwise>
      </c:choose>
    </c:forEach>
    <!-- 현재목록 이후에 새로운 목록이 존재하면.. -->
    <c:choose>
      <c:when test="${paging.next }">
        <li class="page-item">
          <a class="page-link" href="boardList.do?keyword=${keyword ne null ? keyword : '' }&searchCondition=${searchCondition ne null ? searchCondition : '' }&page=${paging.endPage + 1 }">Next</a>
        </li>
      </c:when>
      <c:otherwise>
        <li class="page-item disabled">
          <span class="page-link">Next</span>
        </li>
      </c:otherwise>
    </c:choose>
  </ul>
</nav>
<!-- paging. -->
<jsp:include page="../includes/footer.jsp"></jsp:include>