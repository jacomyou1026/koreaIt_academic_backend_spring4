package dao;

import java.util.List;

public interface WorkDAO {
	int insert(Object ob);
	List select();
	int update(Object ob);
	int delete(int idx);
}
