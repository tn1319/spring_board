<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%String num=request.getParameter("num"); %>
<html>
<head>
	<title>게시판</title>
</head>
<body>
	<div align="center">
		<b>글삭제</b>
		<form name="f" action='delete.do' method="post">
			<input type="hidden" name="num" value="<%=num %>"/>
			<table border="1" width="400">
				<tr>
					<th bgcolor="yellow">비밀번호를 입력해 주세요.</th>
				</tr>
				<tr>
					<td align="center">비밀번호 :<input type="password" name="passwd"></td>
				</tr>
				<tr>
					<th bgcolor="yellow"><input type="submit" value="글삭제"><input type="button" value="글목록" onclick="window.location='board_list.do'"></th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>