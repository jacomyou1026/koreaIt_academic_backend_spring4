package service;

import java.util.List;

import dao.WorkDAOImpl;

public class WorkServiceImpl implements WorkService{
	WorkDAOImpl daoBean;
	
	public WorkServiceImpl(WorkDAOImpl daoBean) {
		this.daoBean=daoBean;
		System.out.println("df내가누구게");
	}
	
	@Override
	public List selectList() {
		return daoBean.selectList();
	}

}
