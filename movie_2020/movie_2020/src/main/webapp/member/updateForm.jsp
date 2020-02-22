<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!-- 본문시작 updateForm.jsp -->

<div class="container">
	<h2>정보 수정</h2>
	<br> <br>
	<form class="Form_default mForm" method="post"
		action="myInfoChangeOK.do" onsubmit="return memberCheck(this)">

		<table class="logintable">

			<tr>
				<td><label for="id">아이디:</label> <input type="text"
					class="form-control" name="m_id" value="${m_id}" readonly></td>
			</tr>
			<tr>
				<td><label for="pwd">비밀번호:</label> <input type="password"
					class="form-control" name="m_pwd" value="${m_pwd}"></td>
			</tr>
			<tr>
				<td><label for="name">이름:</label> <input type="text"
					class="form-control" name="m_name" value="${m_name}"></td>
			</tr>
			<tr>
				<td><label for="email">이메일:</label> <input type="text"
					class="form-control" name="m_email" value="${m_email}"></td>
			</tr>

		</table>
		
		<div class="btnBox">
			<button type="submit" class="btn btn-primary">수정하기</button>

		</div>
		
	</form>

</div>

<!-- 본문끝 -->
<%@ include file="../include/footer.jsp"%>