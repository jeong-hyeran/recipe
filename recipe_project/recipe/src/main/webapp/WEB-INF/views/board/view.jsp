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
</body>
</html>