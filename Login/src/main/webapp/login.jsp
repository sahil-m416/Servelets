
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Transparent Login Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<style>
body {
	margin: 0;
	padding: 0;
	font-family: sans-serif;
	background: url(D:\Java%20Project%20J2EE\Login\paris.jpg) no-repeat;
	background-size: cover;
}

.loginBox {
	width: 280px;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	color: #2e2d33;
}

.loginBox h1 {
	float: left;
	font-size: 40px;
	border-bottom: 6px solid;
	margin-bottom: 50px;
	padding: 13px 0px;
}

.textbox {
	width: 100%;
	overflow: hidden;
	font-size: 20px;
	padding: 8px 0;
	margin: 8px 0;
	border-bottom: 1px solid #2e2d33;
}

.textbox i {
	width: 26px;
	float: left;
	text-align: center;
}

.textbox input {
	border: none;
	outline: none;
	background: none;
	color: #2e2d33;
	font-size: 18px;
	width: 80%;
	float: left;
	margin: 0 10px;
}

.btn {
	width: 100%;
	background: none;
	border: 2px solid #2e2d33;
	color: #ffffff;
	padding: 5px;
	font-size: 18px;
	cursor: pointer;
	margin: 12px 0;
}
</style>

</head>


<body>
	<form method="post" action="LoginCheck">
		<div class="loginBox">
			<h1>Login</h1>
			<div class="textbox">
				<i class="fa fa-user" aria-hidden="true"></i> <input type="text"
					placeholder="Username" name="uname">
			</div>
			<div class="textbox">
				<i class="fa fa-lock" aria-hidden="true"></i> <input type="password"
					placeholder="Password" name="password">
			</div>
			<input class="btn" type="submit" name="" value="Sign in">
		</div>
	</form>
</body>
</html>
