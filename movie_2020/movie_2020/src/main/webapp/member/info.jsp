<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!-- 본문 시작 info.jsp-->

<div class="container">

	<h2>내 정보</h2>
	<br> <br>
	<form class="Form_default" method="post" action="myInfoChange.do">

		<table class="logintable">

			<tr>
				<td><label for="id">아이디:</label> <input type="text"
					class="form-control" name="m_id" value="${m_id}" readonly></td>

			</tr>
			<tr>
				<td><label for="pwd">비밀번호:</label> <input type="password"
					class="form-control" name="m_pwd" value="${m_pwd}" readonly></td>
			</tr>
			<tr>
				<td><label for="name">이름:</label> <input type="text"
					class="form-control" name="m_name" value="${m_name}" readonly></td>
			</tr>
			<tr>
				<td><label for="email">이메일:</label> <input type="text"
					class="form-control" name="m_email" value="${m_email}" readonly></td>
			</tr>

		</table>

		<div class="btnBox">
			<button type="submit" class="btn btn-primary">수정하기</button>
			<button type="button" class="btn btn-primary"
				onclick="location.href='memberScsn.do', alert('비밀번호 확인이 필요합니다.') ">탈퇴하기</button>
		</div>
		
	</form>

</div>

<!-- 본문끝 -->
<%@ include file="../include/footer.jsp"%>

