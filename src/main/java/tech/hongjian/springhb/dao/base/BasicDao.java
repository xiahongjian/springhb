package tech.hongjian.springhb.dao.base;

public interface BasicDao<T, ID> {
	void save(T entity);
	
	void remove(ID id);
	
	T find(ID id);
}
