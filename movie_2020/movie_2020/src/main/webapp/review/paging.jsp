<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.paging {
	padding: 10px 0px;
	text-align: center;
}

.paging div a {
	display: inline-block;
	padding: 4px;
	margin-right: 3px;
	width: 15px;
	color: black;
	font-size: 12px;
	font-weight: bold;
	border: thin solid lightgray;
	text-align: center;
	text-decoration: none;
}

.paging div a.text {
	width: 30px;
}

.paging div a#curPage, .paging div a:hover {
	color: #fff;
	border: 1px solid orange;
	background-color: orange;
}
</style>
</head>
<body>

	<div class="paging"></div>
</body>

<script>
  
    if (${pageInfo.startPage} > 1) {
        $(".paging").append("<a class='text' href='?page=1'>맨앞</a>");
    }
 
    if (${pageInfo.startPage} > 1) {
        $(".paging").append("<a class='text' href='?page=" + ${pageInfo.prevPage}  + "'>이전</a>");
    }
 
    for (var i = ${pageInfo.startPage}; i <= ${pageInfo.endPage}; i++) {
        if (i == ${pageInfo.page}) {
            $(".paging").append("<a id='curPage' href='?page=" + i + "'>" + i + "</a>");
        } else {
            $(".paging").append("<a href='?page=" + i + "'>" + i + "</a>");
        }
    }
 
    if (${pageInfo.endPage} != ${pageInfo.totalPage}) {
        $(".paging").append("<a class='text' href='?page=" + ${pageInfo.nextPage}  + "'>다음</a>");
    }
 
    if (${pageInfo.endPage} != ${pageInfo.totalPage}) {
        $(".paging").append("<a class='text' href='?page=" + ${pageInfo.totalPage} + "'>맨뒤</a>");
    }
    
</script>
</html>