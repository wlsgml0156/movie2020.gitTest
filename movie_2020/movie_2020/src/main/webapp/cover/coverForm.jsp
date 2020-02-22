<%@ page contentType="text/html; charset=UTF-8"%>
<link href="../css/mystyle.css" rel="stylesheet">
<%@ include file="../include/header.jsp"%>
<!-- 본문시작 coverForm.jsp -->

<div class="container">

	<h3>영화 추가하기</h3>

	<form method="post" action="movieAdd.do" enctype="multipart/form-data"
		class="Form_defaul" onsubmit="return coverCheck(this)" >

		<table class="mydefaul-table">
		
			<tr>
				<td><label for="ititle">제목: </label> <input type="text"
					class="form-control" name="ititle" id="ititle"></td>
			</tr>
			<tr>
				<td><label for="igenre">장르: </label> <input type="text"
					class="form-control" name="igenre" id="igenre"></td>
			</tr>
			<tr>
				<td><label for="iforeman">감독: </label> <input type="text"
					class="form-control" name="iforeman" id="iforeman"></td>
			</tr>
			<tr>
				<td><label for="icast">출연진: </label> <input type="text"
					class="form-control" name="icast" id="icast"></td>
			</tr>
			<tr>
				<td><label for="irlsDate">개봉날짜: </label> <input type="text"
					class="form-control" name="irlsDate" id="irlsDate"
					placeholder="2020년 1월5일→2020.01.05"></td>
			</tr>
			<tr>
				<td><label for="">등급: </label> <select name="irating">
						<option>전체 관람가</option>
						<option>19세 관람가</option>
						<option>15세 관람가</option>
						<option>12세 관람가</option>
				</select></td>
			</tr>
			<tr>
				<td><label for="">포스터: </label> <input type='file'
					name='posterMF'  id="posterMF" size='50'></td>
			</tr>
			<tr>
				<td><label for="icontent">줄거리: </label> <textarea rows="15"
						cols="30" name="icontent"  id="icontent" class="form-control"></textarea></td>
			</tr>

		</table>
		<div class="btnBox">
			<button type="submit" class="btn btn-primary" >등록</button>
		</div>
	</form>

</div>

<!-- 본문끝 -->
<%@ include file="../include/footer.jsp"%>
