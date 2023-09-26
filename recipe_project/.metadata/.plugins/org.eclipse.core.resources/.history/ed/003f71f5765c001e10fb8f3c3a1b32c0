<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div id="update">
	<h3>회원정보 수정</h3>
	<form method="POST" enctype="multipart/form-data" action="${cpath }/member/update/${login.idx}">
		<table>
			<tr>
				<td style="border-right: 1px solid grey">
					<img src="${cpath }/profile/${login.fileName }" width="80" height="70">
					
				</td>
				<td><input type="file" name="upload"></td>
			</tr>
	
			<tr>
				<th>아이디</th>			
				<td>${login.idx }. ${login.userid }</td>
			</tr>
			<tr>
				<th>비밀번호</th>			
				<td><input type="password" name="userpw" placeholder="변경할 비밀번호" required></td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${login.username }</td>
			</tr>			
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" value="${login.email }"></td>
			</tr>
			<tr>
				<th>인사말</th>
				<td><input type="text" name="memo" value="${login.memo }"></td>
			</tr>
	
		</table>
		<p>
			<button>수정</button>
		</p>
	</form>
</div>

</body>
</html>