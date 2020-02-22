<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>index.jsp</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet">
<link href="../resources/content.css" rel="stylesheet">
<script src="../resources/myscript.js" type="text/javascript"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"
	type="text/javascript"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
	type="text/javascript"></script>
</head>

<body>

	<!-- 메인카테고리 시작 -->
	<nav class="navbar navbar-default">

		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="../">Movie2020</a>
			</div>

			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<%
						Object s_id = session.getAttribute("s_id");
					%>
					<li><a href="../cover/intro.do">개봉·상영작 소개</a></li>
					<li><a href="../review/review.do">리뷰</a></li>
					<%
						if (s_id == null) {
					%>
					<li><a href="../member/login.do">로그인</a></li>
					<li><a href="../member/memberJoin.do">회원가입</a></li>
					<%
						} else {
					%>
					<li><a href="../member/logout.do">로그아웃</a></li>
					<li><a href="../member/myinfo.do">내정보</a></li>
					<%
						}
					%>
				</ul>
			</div>
			
		</div>
		
	</nav>
	
	<!-- 메인카테고리 끝 -->
	<div class="container-fluid bg-3 text-center">
		<br>
		<div class="row">
			<div class="col-sm-12">