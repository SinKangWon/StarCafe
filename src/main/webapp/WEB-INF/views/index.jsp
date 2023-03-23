<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="header.jsp"></jsp:include>

</head>
<body>
	<div>
		<div>
			<h1>Welcome to the StarCafe</h1>
		</div>
		<div>
			<ul>
				<li><a href="product/list">제품목록</a></li>
				<li><a href="/resources/html/product.html">제품관리 (AJAX)</a></li>
				<li><a href="customer/list">고객목록</a></li>
				<li><a href="/resources/html/customer.html">고객관리 (AJAX)</a></li>
			</ul>
		</div>
	</div>
</body>
</html>