<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />
<h3>수정화면(modifyForm.jsp)</h3>
<%
  BoardVO board = (BoardVO) request.getAttribute("board");
%>

<form action="modifyBoard.do" method="post">
  <input type="hidden" name="bno" value="<%=board.getBoardNo() %>">
  <table class="table">
    <tr>
        <th>글번호</th><td><%=board.getBoardNo() %></td>
        <th>조회수</th><td><%=board.getReadCnt() %></td>
    </tr>
    <tr>
        <th>제목</th><td colspan="3"><input type="text" name="title" value="<%=board.getTitle() %>"></td>
    </tr>
    <tr>
        <th>내용</th><td colspan="3"><textarea cols="45" rows="4" class="form-control" name="content"><%=board.getContent() %></textarea></td>
    </tr>
    <tr>
        <th>작성자</th><td colspan="3"><%=board.getWriter() %></td>
    </tr>
    <tr>
        <th>작성일시</th><td colspan="3"><%=board.getWriteDate() %></td>
    </tr>
    <tr>
        <td colspan="4" align="center">
            <input type="submit" value="저장" class="btn btn-warning">
            <button class="btn btn-danger">삭제</button>
        </td>
    </tr>
  </table>
</form>

<jsp:include page="../include/footer.jsp" />