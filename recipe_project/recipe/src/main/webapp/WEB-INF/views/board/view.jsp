<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<div id="boardView">
<h3>단일 조회</h3>

	<div id="boardTitle">${dto.title }</div>
	<div id="boardContent">
	<c:forEach var="content" items="${contentList}" varStatus="status">
	    <div>
	        <img src="${cpath }/recipe/${fileNameList[status.index] }">  
	    </div>
	
	    <div>${content }</div>
	</c:forEach>
	</div>
</div>

<p>
	<a href="${cpath }/board/list"><button>글 목록</button></a>
	<a href="${cpath }/board/update/${dto.idx }"><button id="updateBtn">수정</button></a>
	<a href="${cpath }/board/list"><button>삭제</button></a>
</p>

<script>
	const updateBtn = document.getElementById('updateBtn')

	const updateHandler = function(event) {
		event.preventDefault()
		if('${login.userid}' != '${dto.member_userid}') {
			alert('본인 글만 수정할 수 있습니다')
			return 
		}
		const url = event.target.parentNode.href
		location.href = url  
	}
	updateBtn.addEventListener('click', updateHandler)
	
</script>
</body>
</html>