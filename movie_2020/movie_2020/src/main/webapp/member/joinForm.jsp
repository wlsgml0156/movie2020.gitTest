<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!-- 본문시작 joinForm.jsp -->

<div class="container">
	<h3>회/원/가/입</h3>
	<br> <br>
	<form class="Form_default" method="post" action="memberJoin.do"
		onsubmit="return memberCheck(this)">

		<table class="logintable">
			<tr>
				<td><label for="m_id">아이디: <span id="demo"
						style="display: none"></span>
				</label> <input type="text" class="form-control" name="m_id" id="m_id"></td>

			</tr>

			<tr>
				<td><label for="m_pwd">비밀번호:</label> <span id="demo2"
					style="display: none"></span> <input type="password"
					class="form-control" name="m_pwd" id="m_pwd"></td>

			</tr>

			<tr>
				<td><label for="m_name">이름:</label> <input type="text"
					class="form-control" name="m_name" id="m_name"></td>

			</tr>
			<tr>
				<td><label for="m_email">이메일:</label> <input type="text"
					class="form-control" name="m_email" id="m_email"></td>
			</tr>

		</table>
		<div class="btnBox">
			<button type="submit" class="btn btn-primary">가입하기</button>
		</div>
	</form>

</div>

<script>
	$("#m_id").keyup(function() {

		$.post("idcheck.do", //요청명령어
		"m_id=" + $("#m_id").val(),//전달값
		responseProc1 //콜백함수
		);//post() end

	});//keyup() end

	function responseProc1(result) {
		$("#demo").empty();
		$("#demo").html(result);
		$("#demo").show();
	}//responseProc() end
</script>

<script>
	$("#m_pwd").keyup(function() {

		$.post("pwdcheck.do", //요청명령어
		"m_pwd=" + $("#m_pwd").val(),//전달값
		responseProc2 //콜백함수
		);//post() end

	});//keyup() end

	function responseProc2(result) {
		$("#demo2").empty();
		$("#demo2").html(result);
		$("#demo2").show();
	}//responseProc() end
</script>

<!-- 본문끝 -->
<%@ include file="../include/footer.jsp"%>
