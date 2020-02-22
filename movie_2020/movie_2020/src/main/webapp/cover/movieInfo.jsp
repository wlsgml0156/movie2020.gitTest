<%@ page contentType="text/html; charset=UTF-8"%>
<link href="../css/mystyle.css" rel="stylesheet">
<%@ include file="../include/header.jsp"%>
<!-- 본문시작 movieInfo.jsp -->

<div class="container">

	<form method="get" action="mdfy.do" enctype="multipart/form-data"
		class="Form_defaul">

		<h3>${dto.ititle}</h3>

		<div class="movieForm">

			<div>
				<img class="movieInfoimg" alt="" src="./storage/${dto.poster}">
			</div>
			<div>
				<label for="igenre">장르: </label> ${dto.igenre} <br> <label
					for="iforeman">감독: </label> ${dto.iforeman} <br> <label
					for="icast">출연진: </label> ${dto.icast} <br> <label
					for="irlsDate">개봉날짜: </label> ${dto.irlsDate} <br> <label
					for="irating">등급: </label> ${dto.irating} <br> <label
					for="icontent">줄거리: </label><br> ${dto.icontent} <br>
			</div>

		</div>

		<input type="hidden" value=${dto.imovieno } name="imovieno">

		<%
			String master = "jinny";
			s_id = (String) s_id;
			if (s_id == null) {
			} else if (s_id.equals(master)) {
		%>

		<div class="btnBox">
			<button type="submit" class="btn btn-primary">수정</button>
			<button type="button" class="btn btn-primary"
				onclick="location.href='del.do?imovieno=${dto.imovieno}'">삭제</button>
		</div>
		<%
			}
		%>

	</form>

</div>

<!-- 본문끝 -->
<%@ include file="../include/footer.jsp"%>
