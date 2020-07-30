<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원을 찾아랏!</title>
</head>
<body>
	<h2>Emp data</h2>

	<form action="/empFind">
		<label> Find All Emp: </label> <input type="submit" name="button" value="findAll">
	</form>
<br>
	<form action="/empFind">
		<label> Number: </label> <input type="number" id="num" name="num">
		<input type="submit" name="button" value="findByEmpno">
	</form>
<br>
	<form action="/empFind">
		<label> Dept : </label> 
		<select class = "dept" id="dept" name="dept">
			<option value="" selected></option>
			<option value="10">Accounting</option>
			<option value="20">Research</option>
			<option value="30">Sales</option>
			<option value="40">Operations</option>
		</select>
		<input type="submit" name="button" value="findByDept">
	</form>
	
	
</body>
</html>