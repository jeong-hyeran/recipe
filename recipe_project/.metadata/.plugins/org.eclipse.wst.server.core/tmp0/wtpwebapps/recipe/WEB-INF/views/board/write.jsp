<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<div id="write">
<h3>글작성</h3>
<c:if test="${empty login }">
	<c:redirect url="/member/login"/>
</c:if>
<form method="POST" enctype="multipart/form-data">
	<p><input type="text" name="title" placeholder="제목을 입력하세요" required autofocus></p>
	<div id="contents">
	<p>
		<textarea name="content" placeholder="내용을 입력하세요" required></textarea>
	</p>
	</div>
	<div id="files">
		<p>	
			<input type="file" name="upload[0]" required>
		</p>
	</div>
	<input id="addBtn" type="button" value="파일 추가">
	<p><input type="submit" value="작성완료"></p>
</form>
 
<script>
	function renameHandler() {
		document.querySelectorAll('input[type="file"]').forEach(
				function(e, i) {
					e.name = 'upload[' + i + ']'
				}
		)
	}
	function deleteHandler(event) {
		const flies = document.getElementById('files')
		const p = event.target.parentNode
		files.removeChild(p)
		renameHandler()
	}

	function getFileCount() {
		return document.querySelectorAll('input[type="file"]').length
	}

	function addHandler(event) {
		const files = document.getElementById('files')
		const p = document.createElement('p')

		const input_file = document.createElement('input')
		input_file.type = 'file'
		input_file.name = 'upload[' + getFileCount() + ']'
		input_file.required = 'required'

		const input_button = document.createElement('input')
		input_button.type = 'button'
		input_button.className = 'deleteBtn'
		input_button.value = 'X'
		input_button.onclick = deleteHandler

		p.appendChild(input_file)
		p.appendChild(input_button)
		files.appendChild(p)

		renameHandler()

	}

	const addBtn = document.getElementById('addBtn')

	addBtn.onclick = addHandler
</script>



</div>
</body>
</html>