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

	<!-- 내가 쓴 글 목록 -->
	<table>	
	<c:forEach var="dto" items="${list }">
		<tr>
			<td>
				<a href="${cpath }/board/view/${dto.idx}">${dto.title }</a>
			</td>
			<td>${dto.wdate }</td>
			<td>${dto.viewCount }</td>
			<td><a href="${cpath }/board/update/${dto.idx}">수정</a></td>
			<td><a href="${cpath }/board/delete/${dto.idx}"><span id="removeBtn">x</span></a></td>
		</tr>
	</c:forEach>
	</table>
</div>

<p>
	<a href="${cpath }/member/updateCon"><button id="updateBtn">수정</button></a>
	<a href="${cpath }/member/deleteCon"><button id="deleteBtn">탈퇴</button></a>
</p>

<script>

	const updateBtn = document.getElementById('updateBtn');
	const deleteBtn = document.getElementById('deleteBtn');
	const removeBtn = document.getElementById('removeBtn');

	updateBtn.addEventListener('click', function(event) {
	  const flag = confirm('비밀번호 확인 후 가능합니다. 계속하시겠습니까?');
	  if (!flag) {
	    event.preventDefault(); // 취소를 선택한 경우에만 기본 동작 취소
	  }
	});

	deleteBtn.addEventListener('click', function(event) {
	  const flag = confirm('정말 삭제하시겠습니까?');
	  if (!flag) {
	    event.preventDefault(); // 취소를 선택한 경우에만 기본 동작 취소
	  }
	});
	
	removeBtn.addEventListener('click', function(event) {
		  const flag = confirm('정말 삭제하시겠습니까?');
		  if (!flag) {
		    event.preventDefault(); // 취소를 선택한 경우에만 기본 동작 취소
		  }
		});
	
</script>
</body>
</html>