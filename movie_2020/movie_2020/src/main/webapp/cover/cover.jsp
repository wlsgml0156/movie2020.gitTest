<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!-- 본문시작 cover.jsp -->

<div class="container">

	<%
		String master = "jinny";
		s_id = (String) s_id;
		if (s_id == null) {
	%>
	
	<h3>${msg1}월개봉영화</h3>

	<%
		} else if (s_id.equals(master)) {
	%>


	<h3>${msg1}월개봉영화</h3>

	<p class="hiddenbtn">
		<button type="button" class="btn btn-primary"
			onclick="location.href='movieAdd.do'">영화 추가</button>
	</p>

	<%
		}
	%>
	<table class="mtable">

		<tr>
			<c:forEach var="cnt" begin="1" end="12">

				<c:if test="${cnt<10}">
					<td><input type="hidden" name="imonth" value="0${cnt}">
						<a href="../cover/intro.do?imonth=0${cnt}">
							<button class="btn btn-info">0${cnt}월</button>
					</a></td>
				</c:if>

				<c:if test="${cnt>=10}">
					<td><input type="hidden" name="imonth" value="${cnt}">
						<a href="../cover/intro.do?imonth=${cnt}">
							<button class="btn btn-info">${cnt}월</button>
					</a></td>
				</c:if>
			</c:forEach>

		</tr>


		<tr>
		
			<td colspan="12">
				<!-- <div id="month01" style="display: block"> -->
				<div class="mbbs_card">

					<c:forEach var="dto" items="${list}">
						<a href="./deatil.do?imovieno=${dto.imovieno}">
							<div class="card">
								<div class="card-header">
									<img alt="" src="./storage/${dto.poster}"><br> <span>${dto.irlsDate}</span>
								</div>
								<div class="card-body">${dto.ititle}</div>
								<div class="card-footer"></div>
							</div>
						</a>
					</c:forEach>

				</div>
			</td>
			
		</tr>
		
	</table>

	${msg2}

</div>


<!-- 본문끝 -->
<%@ include file="../include/footer.jsp"%>