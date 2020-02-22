<%@page import="kr.co.movie_2020.review.ReviewDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!-- 본문시작 reviwDetail.jsp -->

<div class="container">
	<%
		String wname = (String) session.getAttribute("s_id");
		System.out.println(wname);
	%>

	<h3>리뷰 상세페이지</h3>
	<c:forEach var="dto" items="${list}">
		<input type="hidden" name="wname" value="${dto.wname}">
		<input type="hidden" name="wname" value="${dto.bbsno}">

		<table class=" table-striped table review-table review-table-text">

			<thead>
				<tr>
					<th>${dto.subject}</th>
					<th class="text-right"><span>${dto.wname}</span> | 조회
						${dto.readcnt} | ${dto.regdt}</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="2">${dto.content}</td>
				</tr>
			</tbody>

		</table>

		<div class="btnBox">
			<c:if test="${sessionScope.s_id == dto.wname}">
				<button type="button" class="btn btn-primary"
					onclick="location.href='mdfy.do?bbsno=${dto.bbsno}'">수정</button>
				<button type="button" class="btn btn-primary"
					onclick="location.href='del.do?bbsno=${dto.bbsno}'">삭제</button>
			</c:if>
		</div>

	</c:forEach>

</div>

<!-- 본문끝 -->
<%@ include file="../include/footer.jsp"%>