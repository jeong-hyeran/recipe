<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<div id="boardView">
<h3>단일 조회</h3>

	<div id="boardTitle">
			<a href="${cpath }/member/view/${dto.member_idx }"><img src="${cpath }/profile/${dto.member_fileName }" width="40"></a>
			${dto.title }
	</div>
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
	<a href="${cpath }/board/delete/${dto.idx }"><button id="deleteBtn">삭제</button></a>
</p>

<script>
	const updateBtn = document.getElementById('updateBtn')
	const deleteBtn = document.getElementById('deleteBtn')
	
	const Handler = function(event) {
	    event.preventDefault()
	    if ('${login.userid}' != '${dto.member_userid}') {
	        alert('본인 글만 수정/삭제할 수 있습니다')
	        return
	    }
	    
	    if (event.target === deleteBtn) {
	        if (!confirm('정말 삭제하시겠습니까?')) {
	            return
	        }
	    }
        const url = event.target.parentNode.href
        location.href = url
	}
	
	updateBtn.addEventListener('click', Handler)
	deleteBtn.addEventListener('click', Handler)
</script>


</body>
</html>