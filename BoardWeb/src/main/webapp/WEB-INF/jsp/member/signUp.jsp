<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>회원가입(signUp.jsp)</h3>
<form name="signForm" action="signup.do" method="post" enctype="multipart/form-data">
  <table class="table">
    <tr>
      <th>아이디</th>
      <td><input class="form-control" type="text" name="userId" required></td>
    </tr>
    <tr>
      <th>비밀번호</th>
      <td><input class="form-control" type="password" name="userPw" required></td>
    </tr>
    <tr>
      <th>이름</th>
      <td><input class="form-control" type="text" name="userName" required></td>
    </tr>
    <tr>
      <th>이미지</th>
      <td><input class="form-control" type="file" name="userImg"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" class="btn btn-primary" value="회원가입">
        <input type="reset" class="btn btn-secondary" value="초기화">
      </td>
  </table>
</form>

<script>
  let check1 = false;
  let check2 = false;
  // document.forms
  document.forms.signForm.addEventListener('submit', function (e) {
    if (!check1 || !check2) {
      e.preventDefault(); // 
      alert('입력값을 확인...');
      return;
    }
    this.submit();
  })

  // 아이디 check.
  document.querySelector('input[name="userId"]').addEventListener('change', function (e) {
    console.log(this);
    let user = this.value;
    if (user.length < 4) {
      alert('아이디는 4글자 이상 입력하세요.');
      check1 = false;
      return;
    }
    // 회원입력값 check.
    fetch('checkId.do?id=' + user)
      .then(data => data.json())
      .then(result => {
        if (result.retCode == "Exist") {
          check1 = false;
          alert("존재하는 아이디.");
        } else {
          alert('사용가능한 아이디.');
          check1 = true;
        }
      })
      .catch(err => console.log(err))
  })

  // 비밀번호 check.
  document.querySelector('input[name="userPw"]').addEventListener('change', function (e) {
    let pw = e.target.value.length;
    if (pw < 5) {
      alert('비밀번호는 5글자 이상 입력하세요.');
      check2 = false;
      this.focus();
      return;
    }
    check2 = true;
  });
</script>