<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<div id="join">
<h3>회원가입</h3>

<form method="POST" enctype="multipart/form-data">
	<p><input type="text" name="userid" placeholder="ID" required autofocus autocomplete="off"></p>
	<p><input type="password" name="userpw" placeholder="Password" required></p>
	<p><input type="text" name="username" placeholder="Name" required autocomplete="off"></p>
	<p><input type="email" name="email" placeholder="Email" required autocomplete="off"></p>
	<p><input type="text" name="memo" placeholder="인사말" autocomplete="off"></p>
	<p>프로필 이미지<br><input type="file" name="upload"></p>
	<p><input type="submit" value="회원가입"></p>
</form>

</div>
</body>
</html>