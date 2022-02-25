package service;

import java.util.List;

import dao.BoardDAOImpl;

public class BoardServiceImpl implements BoardService{

	//Service클래스는 DAO들을 묶어서 한군데서 관리해주기 위한 역할
	BoardDAOImpl daoBean;
	
	public BoardServiceImpl(BoardDAOImpl daoBean) {
		this.daoBean=daoBean;
		System.out.println("---BoardServiceImpl생성--"+daoBean);
	}
	
	
	@Override
	public List select() {
		return daoBean.selectList();
	}

}
