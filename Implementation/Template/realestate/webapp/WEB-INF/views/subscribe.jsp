<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>
</head>
<body>
	<p>${ error }</p>
	<form method="post" action="subscribe">
		<input type="text" name="username" placeholder="username">
		<br><br>
		<input type="email" name="email" placeholder="email">
		<br><br>
		<input type="password" name="password" placeholder="password">
		<br><br>
		<input type="password" name="repassword" placeholder="repassword">
		<br><br>
		<input type="text" name="name" placeholder="name">
		<br><br>
		<input type="text" name="f_name" placeholder="f_name">
		<br><br>
		<input type="text" name="birthdate" placeholder="birthdate">
		<br><br>
		<input type="text" name="phone" placeholder="phone">
		<br><br>
		<input type="text" name="address" placeholder="address">
		<br><br>
		<input type="text" name="gender" placeholder="gender">
		<br><br>
		<input type="submit" value="login">
	</form>

</body>
</html>