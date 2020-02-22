<%@page import="kr.co.movie_2020.review.ReviewDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!-- 본문시작 reviwInfo.jsp -->

<div class="container">
<h3>리뷰 수정</h3>
	<form name="regForm" class="Form_default" method="post"
		action="mdfy.do?bbsno=${bbsno}" onsubmit="return reviewCheck(this)">
		
		<input type="hidden" name="${dto.bbsno}">
		
		<table class="review-table review-table-text">
		
			<tr>
				<td><label for="subject">제목: </label> <input type="text"
					class="form-control" name="subject" id="subject" value="${subject}"></td>
			</tr>
			<tr>
				<td><label for="content">내용: </label> <textarea rows="5"
						cols="30" name="content" id="content" class="form-control">${content}</textarea></td>
			</tr>

		</table>
		
		<div class="btnBox">
			<button type="submit" class="btn btn-primary">완료</button>
		</div>
		
	</form>
	
</div>

<!-- 본문끝 -->
<%@ include file="../include/footer.jsp"%>