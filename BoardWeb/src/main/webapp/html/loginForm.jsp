<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../includes/header.jsp"></jsp:include>  
<h3>로그인화면(loginForm.jsp)</h3>
<form action="login.do" method="post">
<table class="table">
  <tr>
    <th>아이디</th>
    <td><input type="text" class="form-control" name="id"></td>
  </tr>
  <tr>
    <th>비밀번호</th>
    <td><input type="password" class="form-control" name="pw"></td>
  </tr>
  <tr>
    <td colspan="2" align="center">
      <input type="submit" class="btn btn-primary" value="로그인">
    </td>
  </tr>
</table>
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>  
    