package tech.hongjian.springhb.dao.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BasicDaoImpl<T, ID> implements BasicDao<T, ID> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public BasicDaoImpl() {
		Class<?> c = this.getClass();
		Type type = c.getGenericSuperclass();
		ParameterizedType pType = (ParameterizedType ) type;
		Type[] actualTypeArgs = pType.getActualTypeArguments();
		clazz = (Class<T>) actualTypeArgs[0];
		
	}
	
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void save(T entity) {
		getSession().save(entity);
	}

	public void remove(ID id) {
		T entity = find(id);
		if (entity != null)
			getSession().remove(entity);
	}

	public T find(ID id) {
		return getSession().find(clazz, id);
	}

}
