package dao;

import java.util.ArrayList;
import java.util.List;

public class BoardDAOImpl implements BoardDAO{
	
	public BoardDAOImpl() {
		System.out.println("--스프링  빈을 통한 boarddaoimpl");
	}
	
	@Override
	public int insert(Object ob) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List selectList() {
		
		//DB에서 정보를 가져와서 list에 add()했다고 가정
		List<String> list = new ArrayList<String>();
		list.add("사과");
		list.add("수박");
		list.add("참외");
		list.add("복숭아");
		list.add("딸기");
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
