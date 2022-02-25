package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.BoardVO;

public class BoardDAO {
	SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<BoardVO> select(int start, int end) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("s", start);
		map.put("e", end);
		
		List<BoardVO> list = sqlSession.selectList("b.board_list",map);
		return  list;
	}
	
	public int Insret(BoardVO vo) {
		int res = sqlSession.insert("b.board_insert",vo);
		return res;
	}
	
	//게시글 상세보기
	public BoardVO selectOne(int idx){
		BoardVO li = sqlSession.selectOne("b.board_one",idx);
		return li;
	}
	
	//조회수 증가시키기
	public int update_readhit(int idx) {
		int res = sqlSession.update("b.update_readhit",idx);
		return res;
	}
	//댓글처리를 위한 step+1
	public int update_step(BoardVO baseVO ) {
		int res = sqlSession.update("b.update_step",baseVO);
		return res;
	}
	//댓글등록
	public int reply(BoardVO vo) {
		int res = sqlSession.insert("b.board_reply",vo);
		return res;
	}
	
	
	//게시글 삭제
	public int del_update(BoardVO baseVO ) {
		int res = sqlSession.update("b.del_update",baseVO);
		return res;
	}
	
	//전체 게시물 수
	public int rowTotal() {
		int res = sqlSession.selectOne("b.board_count");
		return res;
	}
	
}
