<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="board.dto.*"%>
<html>
<head>
	<title>�ۼ���</title>
</head>
<%	BoardDTO dto = (BoardDTO)request.getAttribute("getBoard"); %>
<body>
	<form name="f" action="update.do" method="post">
		<input type="hidden" name="num" value="<%=dto.getNum()%>">
		<table border="1" width="600">
			<tr bgcolor="yellow">
				 <td align="center" colspan="2"><b>�� �� ��</b></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">�� ��</th>
				<td><input type="text" name="writer" value="<%=dto.getWriter()%>"></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">�� ��</th>
				<td><input type="text" name="subject" value="<%=dto.getSubject()%>"></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">Email</th>
				<td><input type="text" name="email" value="<%=dto.getEmail()%>"></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">�� ��</th>
				<td><textarea name="content" rows="10" cols="60"><%=dto.getContent()%></textarea></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">��й�ȣ</th>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr bgcolor="yellow">
				<td align="center" colspan="2">
					<input type="submit" value="�ۼ���">
					<input type="reset" value="�ٽ��ۼ�">
					<input type="button" value="��Ϻ���" onClick="window.location='board_list.do'">
			</tr>
		</table>
	</form>
</body>
</html>