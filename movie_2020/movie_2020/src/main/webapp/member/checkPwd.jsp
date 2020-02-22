<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!-- 본문 시작 checkPwd.jsp-->

<div class="container">
	<br>
	<form name="regForm" class="Form_default mForm" method="post"
		action="memberScsn.do">
		<input type="hidden" name="m_id" value="${s_id}">
	
		<table>

			<tr>
				<td><label for="pwd">비밀번호:</label> <input type="password"
					class="form-control" name="m_pwd"></td>
			</tr>

		</table>

		<div class="btnBox">
			<button type="submit" class="btn btn-primary">탈퇴하기</button>
		</div>

	</form>

</div>

<!-- 본문끝 -->
<%@ include file="../include/footer.jsp"%>
