package service;

import java.util.List;

import dao.WorkDAO;
import dao.WorkDAOImpl;

public class WorkServiceImpl implements WorkService{
	
	WorkDAOImpl dao;

	public WorkServiceImpl(WorkDAOImpl dao) {
		System.out.println("service값hbjbjb");
		this.dao = dao;
	}
	

	@Override
	public List selectList() {
		return dao.select();
	}

}
