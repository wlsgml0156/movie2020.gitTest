<%@ page import="kr.co.movie_2020.review.ReviewDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!-- 본문시작 reviwBbs.jsp -->

<div class="container">
	<h3>리뷰</h3>

	<p class="hiddenbtn">
		<button type="button" class="btn btn-default">
			<%
				if (s_id != null) {
			%>

			<a href="reviewAdd.do">글쓰기</a>

			<%
				} else {
			%>
			<a href="../member/login.do" onclick="loginReady()">글쓰기</a>
			<%
				}
			%>
		</button>
	</p>

	<input type="hidden" name="글번호">

	<table class="table table-hover review-table ">

		<thead>
			<tr>
				<th>제목</th>
				<th>조회수</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${list}">
				<tr class="review-table-text">
					<td><a href="./detail.do?bbsno=${dto.bbsno}">${dto.subject}</a></td>
					<td>${dto.readcnt}</td>
					<td>${dto.wname}</td>
					<td>${dto.regdt}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<div>
		<jsp:include page="paging.jsp"></jsp:include>
	</div>

</div>

<!-- 본문끝 -->
<%@ include file="../include/footer.jsp"%>