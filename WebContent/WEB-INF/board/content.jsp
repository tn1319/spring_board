<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,board.dto.*"%>
<%BoardDTO dto=(BoardDTO)request.getAttribute("getBoard");%>
<html>
<head>
	<title>게시판</title>
</head>
<body>
	<div align="center">
		<b>글내용 보기</b>
		<table border="1" width="600">
			<tr>
				<th bgcolor="yellow" width="20%">글번호</th>
				<td align="center" width="30%"><%=dto.getNum() %></td>
				<th bgcolor="yellow" width="20%">조회수</th>
				<td align="center" width="30%"><%=dto.getReadCount()%></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">작성자</th>
				<td align="center" width="30%"><%=dto.getWriter() %></td>
				<th bgcolor="yellow" width="20%">작성일</th>
				<td align="center" width="30%"><%=dto.getReg_date()%></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">글제목</th>
				<td align="center" width="80%" colspan="3"><%=dto.getSubject() %></td>
			</tr>
			<tr>
				<th bgcolor="yellow" width="20%">글내용</th>
				<td align="center" width="80%" colspan="3"><%=dto.getContent() %></td>
			</tr>
			<tr>
				<td align="right" colspan="4">
					<input type="button" value="답글쓰기" onclick="window.location='board_writeForm.do?num=<%=dto.getNum()%>&re_step=<%=dto.getRe_step()%>&re_level=<%=dto.getRe_level()%>'">
					<input type="button" value="글수정" onclick="window.location='update.do?num=<%=dto.getNum()%>'">
					<input type="button" value="글삭제" onclick="window.location='delete.do?num=<%=dto.getNum()%>'">
					<input type="button" value="글목록" onclick="window.location='board_list.do'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>