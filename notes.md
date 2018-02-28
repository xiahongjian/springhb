关于泛型参数中类型的获取
============================================

#### 接口与类

```java
public interface BasicDao<T, ID> {
	void save(T entity);
	
	void remove(ID id);
	
	T find(ID id);
}

@Transactional
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

	@Transactional(value = TxType.SUPPORTS)
	public T find(ID id) {
		return getSession().find(clazz, id);
	}

}
```

实现T find(ID id)此方法时，由于Session的find方法的签名为 find(Class<T> entityClass, Object primaryKey)，
因此需要传入Class<T>。解决方法是在BasicDaoImpl中保存泛型参数中的T的Class，详细过程见代码。