<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../includes/header.jsp"></jsp:include>
<%
  String logId = (String) session.getAttribute("logId");
%>
<h3>게시글 등록화면(boardForm.jsp)</h3>
<form action="board.do" method="post">
  <table class="table">
    <tr>
      <th>제목</th>
      <td><input type="text" class="form-control" name="title"></td>
    </tr>
    <tr>
      <th>내용</th>
      <td><textarea cols="25" class="form-control" rows="3" name="content"></textarea></td>
    </tr>
    <tr>
      <th>작성자</th>
      <td><input type="text" readonly class="form-control" name="writer" value="<%=logId%>"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="게시글등록">
      </td>
    </tr>
  </table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>
