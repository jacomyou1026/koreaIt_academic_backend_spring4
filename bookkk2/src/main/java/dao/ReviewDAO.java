package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ReviewVO;

public class ReviewDAO {
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//리뷰테이블 조회
	public List<ReviewVO> selectList(int start, int end, int num){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("s", start);
		map.put("e", end);
		map.put("n",num);
		List<ReviewVO> list = sqlSession.selectList("review.review_list",map);

		return list;
	}
	
	//전체 게시물 수
		public int rowTotal() {
			int res = sqlSession.selectOne("review.review_count");
			return res;
		}
	
	//리뷰 작성
	public int insert(ReviewVO vo) {
		int res = sqlSession.insert("review.review_insert", vo);
		
		return res;
	}
	
	//리뷰 평점 가져오기
	public float selectAvg(int num) {
		float res = sqlSession.selectOne("review.review_avg",num);
		return res;
	}
	
	//기준 리뷰 가져오기
	public ReviewVO selectOne(int reviewNum) {
		ReviewVO vo = sqlSession.selectOne("review.review_one", reviewNum);
		
		return vo;
	}
	
	//기준글의 step보다 큰 값을 가진 step들을 +1처리 
	public int update_step(ReviewVO vo) {
		int res = sqlSession.update("review.update_step", vo);
		return res;
	}
	

	//댓글 등록
		public int reply(ReviewVO vo) {
			int res = sqlSession.insert("review.review_reply", vo);
			
			return res;
		}
}
