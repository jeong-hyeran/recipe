<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div id="mypage">
	<table>
		<tr>
			<td style="border-right: 1px solid grey">
				<img src="${cpath }/profile/${login.fileName }" width="80" height="70">
			</td>
			<td>${login.userid }</td>
		</tr>

		<tr>
			<th>이름</th>
			<td>${login.username }</td>
		</tr>			
		<tr>
			<th>이메일</th>
			<td>${login.email }</td>
		</tr>
		<tr>
			<th>인사말</th>
			<td>${login.memo }</td>
		</tr>
	</table>
</div>

<p>
	<a href="${cpath }/member/updateCon"><button id="updateBtn">수정</button></a>
	<a href="${cpath }/member/deleteCon"><button id="deleteBtn">탈퇴</button></a>
</p>

<script>
	const updateBtn = document.getElementById('updateBtn')
	
	const updateHandler = function(event) {
		event.preventDefault()
		const url = event.target.parentNode.href
		const flag = confirm('비밀번호 확인 후 가능합니다')
		if(flag) {
			location.href = url 
		}
	}
	updateBtn.onclick = updateHandler
	
	const deleteBtn = document.getElementById('deleteBtn')
	const deleteHandler = function(event) {
		event.preventDefault()
		const url = event.target.parentNode.href
		const flag = confirm('정말 삭제하시겠습니까?')
		if(flag) {
			location.href = url
		}
	}
	
	deleteBtn.onclick = deleteHandler
</script>
</body>
</html>