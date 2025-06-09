<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />
  <h3>글등록화면(addBoard.jsp)</h3>
  <form action="addBoard.do" method="post">
    <table class="table">
      <tr>
        <th>제목</th>
        <td><input type="text" class="form-control" required name="title"></td>
      </tr>
      <tr>
        <th>내용</th>
        <td><textarea class="form-control" required name="content"></textarea></td>
      </tr>
      <tr>
        <th>작성자</th>
        <td><input type="text" class="form-control" required name="writer"></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" class="btn btn-primary" value="등록">
          <input type="reset" class="btn btn-warning" value="취소">
        </td>
      </tr>
    </table>
  </form>
<jsp:include page="../include/footer.jsp" />