<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="board.dto.*"%>
<html>
<head>
	<title>글수정</title>
</head>
<%	BoardDTO dto = (BoardDTO)request.getAttribute("getBoard"); %>
<body>
	<form name="f" action="update.do" method="post">
		<input type="hidden" name="num" value="<%=dto.getNum()%>">
		<table border="1" width="600">
			<tr bgcolor="yellow">
				 <td align="center" colspan="2"><b>글 수 정</b></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">이 름</th>
				<td><input type="text" name="writer" value="<%=dto.getWriter()%>"></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">제 목</th>
				<td><input type="text" name="subject" value="<%=dto.getSubject()%>"></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">Email</th>
				<td><input type="text" name="email" value="<%=dto.getEmail()%>"></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">내 용</th>
				<td><textarea name="content" rows="10" cols="60"><%=dto.getContent()%></textarea></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">비밀번호</th>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr bgcolor="yellow">
				<td align="center" colspan="2">
					<input type="submit" value="글수정">
					<input type="reset" value="다시작성">
					<input type="button" value="목록보기" onClick="window.location='board_list.do'">
			</tr>
		</table>
	</form>
</body>
</html>