package dao;

import java.util.List;

public interface WorkDAO {
	int insert(Object ob);
	List selectList();
	int update(Object ob);
	int delete(int idx);
}
