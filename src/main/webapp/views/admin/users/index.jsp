<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div>
	<a
		href="/SP22B2_SOF3011_IT16305/users/create"
		class="btn btn-success">Thêm mới</a>
</div>

<c:if test="${ empty ds }">
	<p class="alert alert-warning">
		Không có dữ liệu
	</p>
</c:if>

<c:if test="${ !empty ds }">
	<table class="table">
		<thead class="table-primary">
			<th>Họ tên</th>
			<th>SĐT</th>
			<th>Email</th>
			<th>Địa chỉ</th>
			<th colspan="2">Thao tác</th>
		</thead>
		<tbody>
			<c:forEach items="${ ds }" var="user">
				<tr>
					<td>${ user.hoTen }</td>
					<td>${ user.sdt }</td>
					<td>${ user.email }</td>
					<td>${ user.diaChi }</td>
					<td>
						<a class="btn btn-primary"
	href="/SP22B2_SOF3011_IT16305/users/edit?id=${ user.id }"
						>Cập nhật</a>
					</td>
					<td>
						<a class="btn btn-danger"
	href="/SP22B2_SOF3011_IT16305/users/delete?id=${ user.id }"
						>Xóa</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
