package board.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import board.dto.BoardDTO;

public class BoardMapper {
	private static SqlSessionFactory sqlMapper;
	static {
		try {
			String resource = "SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}
	
	public static List<BoardDTO> listBoard(){
		SqlSession session = sqlMapper.openSession();
		List<BoardDTO> list = null;
		try {
			list = session.selectList("listBoard");
			//selectList => 검색한 갯수만큼 DTO를 만들어 list에 저장시켜준다
			return list;
   		}finally {
			session.close();  
		}
	}
	
	public static void plusReadcount(int num) {
		SqlSession session = sqlMapper.openSession();
		try {
			session.update("plusReadcount",num);
			session.commit();//데이터 변경시 커밋 꼭 해야한다
   		}finally {
			session.close();  
		}
	}

	public static BoardDTO getBoard(int num) {
		SqlSession session = sqlMapper.openSession();
		BoardDTO dto = null;
		try {
			dto = session.selectOne("getBoard",num);
			return dto;
   		}finally {
			session.close();  
		}
	}

	public static void plusRe_step(String sql) {
		SqlSession session = sqlMapper.openSession();
		java.util.Map<String,String> map =new java.util.HashMap<String,String>();
		map.put("sql",sql);
		try {
			session.update("plusRe_step",map);
			session.commit();
   		}finally {
			session.close();  
		}
	}

	public static int insertBoard(BoardDTO dto) {
		SqlSession session = sqlMapper.openSession();
		int res=-1;
		try {
			res=session.insert("insertBoard",dto);
			session.commit();
			return res;
   		}finally {
			session.close();  
		}
	}

	public static int deleteBoard(int num) {
		SqlSession session = sqlMapper.openSession();
		int res=-1;
		try {
			res=session.delete("deleteBoard",num);
			session.commit();
			return res;
   		}finally {
			session.close();  
		}
	}

	public static int updateBoard(BoardDTO dto) {
		SqlSession session = sqlMapper.openSession();
		int res=-1;
		try {
			res=session.update("updateBoard",dto);
			session.commit();
			return res;
   		}finally {
			session.close();  
		}
	}
}















