<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<c:if test="${ empty ds }">
	<p class="alert alert-warning">
		Không có dữ liệu
	</p>
</c:if>

<c:if test="${ !empty ds }">
	<table class="table">
		<thead class="table-primary">
			<th>Họ tên</th>
			<th>Giới tính</th>
			<th>SĐT</th>
			<th>Email</th>
			<th>Địa chỉ</th>
			<th>Loại KH</th>
		</thead>
		<tbody>
			<c:forEach items="${ ds }" var="user">
				<tr>
					<td>${ user.fullname }</td>
					<td>
					<c:choose>
						<c:when test="${ user.gioi_tinh == 1 }">Nam</c:when>
						<c:when test="${ user.gioi_tinh == 0 }">Nữ</c:when>
						<c:otherwise> - </c:otherwise>
					</c:choose>
					</td>
					<td>${ user.sdt }</td>
					<td>${ user.email }</td>
					<td>${ user.dia_chi }</td>
					<td>${ user.loai_tai_khoan }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
