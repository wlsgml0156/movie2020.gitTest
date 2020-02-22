<%@ page contentType="text/html; charset=UTF-8"%>
<link href="../css/mystyle.css" rel="stylesheet">
<%@ include file="../include/header.jsp"%>
<!-- 본문시작 updateForm.jsp -->

<div class="container">

	<h3>영화 정보</h3>

	<form method="post" action="mdfy.do" enctype="multipart/form-data"
		class="Form_defaul defaul-Form">

		<table class="mydefaul-table">
			<tr>

				<td><label for="ititle">제목: </label> <input type="text"
					class="form-control" name="ititle" value=${dto.ititle} ></td>
			</tr>
			<tr>
				<td><label for="igenre">장르: </label> <input type="text"
					class="form-control" name="igenre" value="${dto.igenre}"></td>
			</tr>
			<tr>
				<td><label for="iforeman">감독: </label> <input type="text"
					class="form-control" name="iforeman" value="${dto.iforeman}"></td>
			</tr>
			<tr>
				<td><label for="icast">출연진: </label> <input type="text"
					class="form-control" name="icast" value="${dto.icast}"></td>
			</tr>
			<tr>
				<td><label for="irlsDate">개봉날짜: </label> <input type="text"
					class="form-control" name="irlsDate" value="${dto.irlsDate}"></td>
			</tr>
			<tr>
				<td><label for="">등급: </label> <select name="irating">

						<option <c:if test="${dto.irating eq '전체 관람가'}">selected</c:if>>전체
							관람가</option>
						<option <c:if test="${dto.irating eq '19세 관람가'}">selected</c:if>>19세
							관람가</option>
						<option <c:if test="${dto.irating eq '15세 관람가'}">selected</c:if>>15세
							관람가</option>
						<option <c:if test="${dto.irating eq '12세 관람가'}">selected</c:if>>12세
							관람가</option>
				</select></td>
			</tr>
			<tr>
				<td><label for="">포스터: </label> <input type='file'
					name='posterMF' size='50' value="${dto.poster}"></td>
			</tr>

			<tr>

				<td><label for="icontent">줄거리: </label> <textarea rows="15"
						cols="30" name="icontent" class="form-control">${dto.icontent}</textarea></td>
			</tr>

			<tr>
				<td><input type="hidden" value=${dto.imovieno } name="imovieno"></td>
			</tr>
			
		</table>

		<div class="btnBox">
			<button type="submit" class="btn btn-primary">완료</button>
		</div>
		
	</form>

</div>

<!-- 본문끝 -->
<%@ include file="../include/footer.jsp"%>
