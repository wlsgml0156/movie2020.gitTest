<%@ page contentType="text/html; charset=UTF-8"%>
<link href="../css/mystyle.css" rel="stylesheet">
<%@ include file="../include/header.jsp"%>
<!-- 본문시작 loginForm.jsp -->

<div class="container">
	<h3>로그인</h3>
	<form class="Form_default" action="login.do" method="post" onsubmit="return loginCheck(this)">
		<table class="logintable">
		
			<tr>
				<td><label for="id">아이디: </label> <input type="text"
					class="form-control" id="m_id" name="m_id"
					placeholder="아이디를 입력해주세요"></td>

			</tr>
			<tr>
				<td><label for="id">비밀번호: </label> <input type="password"
					class="form-control" id="m_pwd" name="m_pwd"
					placeholder="비밀번호를 입력해주세요"></td>
			</tr>

		</table>
		
		<div class="btnBox">
			<button type="submit" class="btn btn-primary">로그인</button>
			<button type="button" class="btn btn-primary"
				onclick="location.href='memberJoin.do'">회원가입</button>
		</div>
		
	</form>

</div>

<!-- 본문끝 -->
<%@ include file="../include/footer.jsp"%>