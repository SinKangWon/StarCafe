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
			<h3>제품정보 변경</h3>
		</div>
		
		<form method="post">
			<div class="form-group mt-2">
				<label>제품명:</label>
				<input name="name" type="text" value="${item.name}" class="form-control">
			</div>
			
			<div class="form-group mt-2">
				<label>가격:</label>
				<input name="price" type="number" value="${item.price}" class="form-control">
			</div>
			
			<div class="form-group mt-2">
				<label>구분:</label>
				<select name="category" class="form-control">
					<option value="1" ${item.category == 1 ? "selected" : ""}>음료</option>
					<option value="2" ${item.category == 2 ? "selected" : ""}>푸드</option>
					<option value="3" ${item.category == 3 ? "selected" : ""}>상품</option>
					<option value="4" ${item.category == 4 ? "selected" : ""}>카드</option>
				</select>				
			</div>
			
			<div class="form-group mt-2">
				<label>판매여부:</label>
				<select name="status" class="form-control">
					<option value="0" ${item.status == 0 ? "selected" : ""}>판매중지</option>
					<option value="1" ${item.status == 1 ? "selected" : ""}>판매중</option>
				</select>				
			</div>
			
			<div class="form-group mt-3">
				<button class="btn btn-sm btn-primary">변경</button>
				<a href="../list"><button type="button" class="btn btn-sm btn-secondary">취소</button></a>
			</div>
		</form>
	</div>
</body>
</html>