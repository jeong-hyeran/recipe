<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div id="boardUpdate">
	<form method="POST" enctype="multipart/form-data">
		<div id="boardTitle">${dto.title }</div>
		<div id="boardIngredient">
			<input type="text" name="ingr" value="${dto.ingr}">
		</div>
		<div id="boardContent">
			<c:forEach var="content" items="${contentList}" varStatus="status">
				<div>
					<img src="${cpath }/recipe/${fileNameList[status.index] }"> <input
						type="file" name="upload[${status.index }]">
				</div>

				<div>
					<textarea name="content[${status.index }]" cols="50" rows="10">${content }</textarea>
				</div>
			</c:forEach>
		</div>
	</form>
</div>
</body>
</html>