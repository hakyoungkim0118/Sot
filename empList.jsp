<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- El -->
	Result ::
	<br>
	<c:forEach var="i" items="${requestScope.findall}">
		<table>
			<tr>
				<td>${i.empno}</td>
				<td>${i.ename}</td>
				<td>${i.job}</td>
				<td>${i.mgr}</td>
				<td>${i.hiredate}</td>
				<td>${i.sal}</td>
				<td>${i.comm}</td>
				<td>${i.deptno}</td>
			</tr>
		</table>
	</c:forEach>

	${findById}
	${findByDept}

</body>
</html>