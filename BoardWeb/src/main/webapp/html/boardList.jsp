<%@page import="com.yedam.common.PageDTO"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>글목록(boardList.jsp)</h3>
<%
List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
%>
<form action="boardList.do">
<div class="row">
  <div class="col-sm-4">
    <select name="searchCondition" class="form-control">
      <option value="">선택하세요</option>
      <option value="T">제목</option>
      <option value="W">작성자</option>
      <option value="TW">제목 & 작성자</option>
    </select>
  </div>
  <div class="col-sm-6">
    <input type="text" name="keyword" class="form-control">
  </div>
  <div class="col">
    <input type="submit" value="검색" class="form-control">
  </div>
</div>
</form>
<table class="table">
  <thead>
    <tr>
      <th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th>
    </tr>
  </thead>
  <tbody>
    <%for (BoardVO bvo : list) { %>
    <tr>
      <td align="center"><a href="board.do?board_no=<%=bvo.getBoardNo() %>"><%=bvo.getBoardNo() %></a></td>
      <td><%=bvo.getTitle() %></td>
      <td><%=bvo.getWriter() %></td>
      <td><%=bvo.getCreationDate() %></td>
    </tr>
    <%} %>
  </tbody>
</table>

<!-- paging. -->
<%
  PageDTO paging = (PageDTO) request.getAttribute("paging");
%>
<p><%=paging %></p>
<nav aria-label="...">
  <ul class="pagination">
    <%
    // 이전 10개 목록이 존재하면 Previous를 활성화.
    if (paging.isPrev()) {
    %>
    <li class="page-item">
      <a class="page-link" href="boardList.do?page=<%=paging.getStartPage()-1 %>">Previous</a>
    </li>
	<%
    } else {
	%>
    <li class="page-item disabled">
      <span class="page-link">Previous</span>
    </li>
    <%
    }
    // startPage와 endPage의 값에 해당하는 링크를 반복적으로 생성.
    for(int p = paging.getStartPage(); p <= paging.getEndPage(); p++) {
        // 출력하는 페이지와 현재페이지가 같으면 링크생략.
    	if(paging.getCurrentPage() == p) {
    %>
    <li class="page-item active" aria-current="page">
      <span class="page-link"><%=p%></span>
    </li>
    <%  } else { %>
    <li class="page-item"><a class="page-link" href="boardList.do?page=<%=p%>"><%=p%></a></li>
    <%
        }  // end of if.
    }  // end of for.
    // 현재목록 이후에 새로운 목록이 존재하면..
    if (paging.isNext()) {
    %>
    <li class="page-item">
      <a class="page-link" href="boardList.do?page=<%=paging.getEndPage()+1 %>">Next</a>
    </li>
    <%
    } else {
    %>
    <li class="page-item disabled">
      <span class="page-link">Next</span>
    </li>
    <%} // end of if. 
    %>
  </ul>
</nav>
<!-- paging. -->
<jsp:include page="../includes/footer.jsp"></jsp:include>
