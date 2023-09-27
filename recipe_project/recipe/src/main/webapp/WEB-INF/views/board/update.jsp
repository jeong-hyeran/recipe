<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div id="boardUpdate">
	<form method="POST" enctype="multipart/form-data">
		<div id="boardTitle"><input type="text" name="title" value="${dto.title }"></div>
		<div id="boardUserid">${dto.member_userid }</div>
		<div id="boardContent">
		<c:forEach var="content" items="${contentList}" varStatus="status">
		    <div>
		        <img src="${cpath }/recipe/${fileNameList[status.index] }">  
		        <input type="file" name="upload[${status.index }]">
		    </div>
		
		    <div><textarea name="contents[${status.index }]" cols="50" rows="10">${content }</textarea></div>
		</c:forEach>
		</div>
		<p>
			<input id="addBtn" type="button" value="파일 추가">
			<input type="submit" value="수정">
		</p>
	</form>
</div>

<script>
	function renameHandler() {
		document.querySelectorAll('input[type="file"]').forEach(
				function(e, i) {
					e.name = 'upload[' + i + ']'
				}
		)
	}
	
	function conRenameHandler() {
		document.querySelectorAll('textarea').forEach(
				function(e, i) {
					e.name = 'contents[' + i + ']'
				}
		)
	}
	
	function deleteHandler(event) {
		const contents = document.getElementById('boardContent')
		const div = event.target.parentNode.parentNode
		contents.removeChild(div)
		renameHandler()
		conRenameHandler()
	}
	
	function addHandler(event) {
		const boardContent = document.getElementById('boardContent')
		const div = document.createElement('div')
		const p = document.createElement('p')
		const p1 = document.createElement('p')
		
		const input_file = document.createElement('input')
		input_file.type = 'file'
		input_file.name = 'upload'
		input_file.required = 'required'

		const input_button = document.createElement('input')
		input_button.type = 'button'
		input_button.className = 'deleteBtn'
		input_button.value = 'X'
		input_button.onclick = deleteHandler
		
		const input_text = document.createElement('textarea')
		input_text.type = 'textarea'
		input_text.name= 'contents'
		input_text.placeholder = '내용을 입력하세요'
		input_text.rows = '10'
		input_text.cols = '50'
		input_text.required = 'required'
		
		p.appendChild(input_file)
		p.appendChild(input_button)
		p1.appendChild(input_text)
		div.appendChild(p)
		div.appendChild(p1)
		boardContent.appendChild(div)
		
		renameHandler()
		conRenameHandler()

	}

	const addBtn = document.getElementById('addBtn')

	addBtn.onclick = addHandler
</script>
</body>
</html>