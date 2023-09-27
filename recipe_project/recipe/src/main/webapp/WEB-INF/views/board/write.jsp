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
		<div id="files">
			<p>	
				<input type="file" name="upload[0]" required>
			</p>
		</div>
		<div id = "text">
			<p>
				<textarea name="contents[0]" placeholder="내용을 입력하세요" rows="10" cols="50" required></textarea>
			</p>
		</div>
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
	
	function conRenameHandler() {
		document.querySelectorAll('textarea').forEach(
				function(e, i) {
					e.name = 'contents[' + i + ']'
				}
		)
	}
	
	function deleteHandler(event) {
		const contents = document.getElementById('contents')
		const div = event.target.parentNode.parentNode
		contents.removeChild(div)
		renameHandler()
		conRenameHandler()
	}
	
	function getFileCount() {
		return document.querySelectorAll('input[type="file"]').length
	}

	function addHandler(event) {
		const write = document.getElementById('contents')
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
		contents.appendChild(div)
		
		renameHandler()
		conRenameHandler()

	}

	const addBtn = document.getElementById('addBtn')

	addBtn.onclick = addHandler
</script>



</div>
</body>
</html>