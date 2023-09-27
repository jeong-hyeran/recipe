<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<div class="boardList">
<h3>글목록</h3>

	<div style="font-size: 0.7rem;">'${keyword }'를 포함한 레시피 <span id="restore">X</span></div>
	<c:if test="${not empty excludeKeyword }">
		<div style="font-size: 0.7rem;">'${excludeKeyword }'를 제외한 레시피	 <span id="restore">X</span></div>
	</c:if>
	<div class="boardSearch">
	
	<form method="POST" action="${cpath }/board/searchList">
		 <p>
		 	<input type="hidden" name="keyword" value="${keyword }">
			<input type="search" name="excludeKeyword" placeholder="제외할 재료를 입력하세요">
			<input type="submit" value="제외">
		</p>
	</form>
</div>
<table>
	<thead>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>좋아요</th>
		</tr>
	</thead>
	<tbody>
			<tr>
				<c:if test="${empty list }">
					<td colspan="6" style="text-align: center;">
						작성 된 글이 없습니다.
					</td>
				</c:if>
			</tr>
			<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.idx }</td>
				<td>
					<a href="${cpath }/board/view/${dto.idx}">${dto.title }</a>
				</td>
				<td>${dto.member_username }</td>
				<td>${dto.wdate }</td>
				<td>👁️‍🗨️${dto.viewCount }</td>
				<td>❤️${dto.likeCount }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<ul>
	<li><a href="${cpath }/board/write"><button>글작성</button></a></li>
</ul>
</div>

<script>
    // "exclude" div를 클릭하면 이전 페이지로 이동
    document.getElementById('restore').onclick = function () {
        history.go(-1);
    };
</script>
</body>
</html>