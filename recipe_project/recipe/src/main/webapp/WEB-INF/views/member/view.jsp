<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div id="memberView">
	<table>
		<tr>
			<td colspan="3"><img src="${cpath }/profile/${dto.fileName }" width="50">
				${dto.userid }</td>
		</tr>
		<tr>
			<td colspan="3">
				${dto.memo }
			</td>		
		</tr>
		
		<!-- 해당 유저가 쓴 글 목록 -->
		<c:forEach var="row" items="${list }">
			<tr>
				<td>
					<a href="${cpath }/board/view/${row.idx }">${row.title }</a>
				</td>
				<td>
					${row.wdate }
				</td>
				<td>
					${row.viewCount }
				</td>
			</tr>
		</c:forEach>
		
	</table>

</div>
</body>
</html>