<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="commonheader.jsp"%>
	<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
.loan-table{
width: 60%;
left: 15%
}
</style>
</head>
<body>

	<c:if test="${not empty loanrecord}">
		<table class="loan-table">
			<tr>
				<th>Loan Id</th>
				<th>Type of loan</th>
				<th>Customer Name</th>
				<th>Loan Amount</th>
				<th>Rate of Interest</th>
				<th>Date</th>
			</tr>
			
			<c:forEach items="${loanrecord}" var="record">
				<tr>
					<td>${record.id}</td>
					<td>${record.id}</td>
					<td>${record.firstName}</td>
					<td>${record.amount}</td>
					<td>${record.interest}</td>
					<td>${record.inititedDate}</td>
				</tr>
			</c:forEach>

		</table>
	</c:if>
</body>
</html>