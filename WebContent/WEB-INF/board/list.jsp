<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,board.dto.*"%>
<html>
<head>
	<title>spring 게시판</title>
</head>
<body>
	<div align="center">
		<b>글 목 록</b>
		<table border="0" width="600">
			<tr bgcolor="yellow">
				<td align="right"><a href="board_writeForm.do">글쓰기</a></td>
			</tr>
		</table>
		<table border="1" width="600">
			<tr bgcolor="green">
				<th>번호</th>
				<th width="40%">제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
				<th>IP</th>
			</tr>
<%	List<BoardDTO> list=(List)request.getAttribute("boardList"); 
	if(list==null||list.size()==0){%>
			<tr>
				<td colspan="6">등록된 게시글이 없습니다.</td>
			</tr>
<%}else{ 
		for(BoardDTO dto:list){%>
			<tr>
				<td><%=dto.getNum() %></td>
				<td>
<%				if(dto.getRe_level()>0){ %>
					<img src="level.gif" width="<%=dto.getRe_level()*10 %>" height="20">
					<img src="re.gif">
<%				} %>
					<a href="content.do?num=<%=dto.getNum()%>"><%=dto.getSubject() %></a>
<% 				if(dto.getReadCount()>10){%>
					<img src="hot.gif">
<%				} %>
				</td>
				<td><%=dto.getWriter() %></td>
				<td><%=dto.getReg_date() %></td>
				<td><%=dto.getReadCount() %></td>
				<td><%=dto.getIp() %></td>
			</tr>
<%		}
	}%>
		</table>
	</div>
</body>
</html>