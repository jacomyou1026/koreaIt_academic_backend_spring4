package dao;

import java.util.ArrayList;
import java.util.List;

public class WorkDAOImpl implements WorkDAO{

	@Override
	public int insert(Object ob) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List select() {
		List<String> list = new ArrayList<String>();
		list.add("사과");
		list.add("수박");
		list.add("복숭아");
		list.add("딸기");
		System.out.println(list+"dfd");
		return list;
	}

	@Override
	public int update(Object ob) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int idx) {
		// TODO Auto-generated method stub
		return 0;
	}

}
