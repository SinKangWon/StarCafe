<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../header.jsp"></jsp:include>

</head>
<body>
	<div class="container">
		<div>
			<h3>고객정보 변경</h3>
		</div>
		
		<form method="post">
			<div class="form-group mt-2">
				<label>고객명:</label>
				<input name="name" type="text" value="${item.name}" class="form-control">
			</div>
			
			<div class="form-group mt-2">
				<label>전화번호:</label>
				<input name="tel" type="text" value="${item.tel}" class="form-control">
			</div>
			
			<div class="form-group mt-2">
				<label>포인트:</label>
				<input name="point" type="number" value="${item.point}" class="form-control">
			</div>
			
			<div class="form-group mt-3">
				<button class="btn btn-sm btn-primary">변경</button>
				<a href="../list"><button type="button" class="btn btn-sm btn-secondary">취소</button></a>
			</div>
		</form>
	</div>
</body>
</html>