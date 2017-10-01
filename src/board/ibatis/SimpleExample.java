package board.ibatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import board.dto.BoardDTO;

import com.ibatis.common.resources.Resources;

import java.io.Reader;
import java.io.IOException;
import java.util.List;
import java.sql.SQLException;

/**
 * This is not a best practices class. It's just an example to give you an idea
 * of how iBATIS works. For a more complete example, see JPetStore 5.0 at
 * http://www.ibatis.com.
 */
public class SimpleExample {

	/**
	 * SqlMapClient instances are thread safe, so you only need one. In this case,
	 * we'll use a static singleton. So sue me. ;-)
	 */
	private static SqlMapClient sqlMapper;

	/**
	 * It's not a good idea to put code that can fail in a class initializer, but
	 * for sake of argument, here's how you configure an SQL Map.
	 */
	static {
		try {
			Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			// Fail fast.
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}

	public static List<BoardDTO> listBoard() {
		List<BoardDTO> list = null;
		try {
			list = sqlMapper.queryForList("listBoard");
		} catch (SQLException e) {
			System.out.println("listBoard 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}
		return list;
	}

	public static BoardDTO getBoard(int num) {
		BoardDTO dto = null;
		try {
			dto = (BoardDTO) sqlMapper.queryForObject("getBoard", num);
		} catch (SQLException e) {
			System.out.println("getBoard 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}
		return dto;
	}

	public static void plusReadcount(int num) {
		try {
			sqlMapper.update("plusReadcount", num);
		} catch (SQLException e) {
			System.out.println("plusReadcount 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}
	}

	public static int insertBoard(BoardDTO dto) {
		try {
			sqlMapper.insert("insertBoard", dto);
		} catch (SQLException e) {
			System.out.println("insertBoard 메소드 실행 중 오류 방생!!");
			e.printStackTrace();
		}
		return 1;
	}

	public static void plusRe_step1() {
		try {
			sqlMapper.update("plusRe_step1");
		} catch (SQLException e) {
			System.out.println("plusRe_step1 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}
	}

	public static void plusRe_step2(int re_step) {
		try {
			sqlMapper.update("plusRe_step2", re_step);
		} catch (SQLException e) {
			System.out.println("plusRe_step2 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}
	}

	public static int deleteBoard(int num) {
		int res = 0;
		try {
			res = sqlMapper.delete("deleteBoard", num);
		} catch (SQLException e) {
			System.out.println("deleteBoard 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}
		return res;
	}

	public static int updateBoard(BoardDTO dto) {
		int res = 0;
		try {
			res = sqlMapper.update("updateBoard", dto);
		} catch (SQLException e) {
			System.out.println("deleteBoard 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}
		return res;
	}
}
