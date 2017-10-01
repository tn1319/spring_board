<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int num=0, re_step=0, re_level=0;
	if(request.getParameter("num")!=null){
		num=Integer.parseInt(request.getParameter("num"));
		re_step=Integer.parseInt(request.getParameter("re_step"));
		re_level=Integer.parseInt(request.getParameter("re_level"));
	}
%>

<html>
<head>
	<title>글쓰기</title>
</head>
<body>
	<form name="f" action="board_writeForm.do" method="post">
		<input type="hidden" name="num" value="<%=num %>"/>
		<input type="hidden" name="re_step" value="<%=re_step %>"/>
		<input type="hidden" name="re_level" value="<%=re_level %>"/>
		<table border="1" width="600">
			<tr bgcolor="yellow">
				<td align="center" colspan="2"><b>글 쓰 기</b></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">이 름</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">제 목</th>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">Email</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">내 용</th>
				<td><textarea name="content" rows="10" cols="60"></textarea></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">비밀번호</th>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr bgcolor="yellow">
				<td align="center" colspan="2">
					<input type="submit" value="글쓰기">
					<input type="reset" value="다시쓰기">
					<input type="button" value="목록보기" onClick="window.location='board_list.do'">
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>