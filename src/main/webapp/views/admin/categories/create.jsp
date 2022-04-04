<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form method="POST"
		id="form_create"
		action="/SP22B2_SOF3011_IT16305/categories">
		<div>
			<label>Tên danh mục</label>
			<input type="text" id="ten" name="ten" />
		</div>
		<div>
			<label>Người tạo</label>
			<select name="user_id" id="user_id">
				<c:forEach items="${ dsUser }" var="user">
				<option value="${ user.id }">
					${ user.hoTen }
				</option>
				</c:forEach>
			</select>
		</div>
		<button>Thêm mới</button>
	</form>
	
	<!-- <script>
		document.getElementById("form_create")
			.addEventListener("submit", function (event) {
				event.preventDefault();
				const ten = document.getElementById("ten");
				const userId = document.getElementById("user_id");
				const data = {
					ten: ten,
					user_id: userId,
					
				};
				const url = "http://localhost:8080/SP22B2_SOF3011_IT16305/categories";
				fetch(url, {
					method: "POST",
					body: JSON.stringify(data)

				})
					.then(function (response) {
						console.log(response);
					})
			});
	</script> -->
</body>
</html>
