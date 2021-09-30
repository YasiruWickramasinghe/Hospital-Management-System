
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>



<html style="width: 100%; height: 100%;">

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/all.css" rel="stylesheet">
<link rel="icon" href="images/logoonly.png" type="image">
<title>Hospital management system</title>
</head>
<body
	style="width: 100%; min-height: 100% !important; position: relative;">

	<nav class="navbar navbar-expand navbar-light bg-light">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><img src="images/logoonly.png"
				width="30" height="30" alt=""> <a class="navbar-brand"
				href="home.jsp">Home</a></li>
			<li class="nav-item">
				<form method="post" action="DashboardController" class="">
					<div onClick="javascript:this.parentNode.submit();"
						class="navbar-brand" style="cursor: pointer;">Dashboard</div>
				</form>
			</li>
		</ul>

		<ul class="navbar-nav">
			<li class="nav-item"><a class="navbar-brand" href="UserProfile">Profile
					<i class="fas fa-user"></i>
			</a></li>
		</ul>
	</nav>