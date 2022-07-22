<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

	<style>
		.my-custom-scrollbar {
			position: relative;
			height: 500px;
			overflow: auto;
		}
		.table-wrapper-scroll-y {
			display: block;
		}
	</style>
</head>
<body>
	<div class="container" style="background-color: lightblue;width: 100%;height: 100%">
		<div class="col-md-offset-1 col-md-10">
			<h2>Employee Details</h2>
			<hr style="background-color: black;border-width: 5px"/>

			<input type="button" value="Add Employee"
				onclick="window.location.href='showForm'; return false;"
				class="btn btn-primary" />
				<br/><br/>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Employee List</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered mb-0" style="width: 100%">
						<tr>
							<th style="width: 20%">EmpId</th>
							<th style="width: 20%">First Name</th>
							<th style="width: 20%">Last Name</th>
							<th style="width: 20%">EmailId</th>
							<th style="width: 20%">Action</th>
						</tr>
					</table>
					<div class="table-wrapper-scroll-y my-custom-scrollbar">
					<table class="table table-striped table-bordered mb-0" style="width: 100%">
						<%--<tr>
							<th>EmpId</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>EmailId</th>
						</tr>--%>

						<!-- loop over and print our customers -->
						<c:forEach var="tempCustomer" items="${employeeList}">

							<!-- construct an "update" link with customer id -->
							<c:url var="updateLink" value="/customer/updateForm">
								<c:param name="customerId" value="${tempCustomer.empId}" />
							</c:url>

							<!-- construct an "delete" link with customer id -->
							<c:url var="deleteLink" value="/customer/delete">
								<c:param name="customerId" value="${tempCustomer.empId}" />
							</c:url>

							<tr>
								<td style="width: 20%">${tempCustomer.empId}</td>
								<td style="width: 20%">${tempCustomer.firstName}</td>
								<td style="width: 20%">${tempCustomer.lastName}</td>
								<td style="width: 20%">${tempCustomer.email}</td>

								<td style="width: 20%">
									<!-- display the update link --> <a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
								</td>

							</tr>

						</c:forEach>

					</table>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>

</html>









