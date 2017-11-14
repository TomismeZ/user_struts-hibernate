package com.qingshixun.project.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qingshixun.project.dao.IUserDao;
import com.qingshixun.project.model.UserModel;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	/**
	 * 当设置该属性时，就可以引用该对象，也不需要set注入了
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	 /**
     * 使用hibernate提供的分页功能，得到分页显示的数据
     */
	@Override
	public List<UserModel> queryByPage(String hql, int offset, int pageSize) {
		List<UserModel> list=null;
		try {
			list=getCurrentSession().createQuery(hql).setFirstResult(offset).setMaxResults(pageSize).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			list=null;
		}finally{
			if(getCurrentSession()!=null&&getCurrentSession().isOpen()){
				getCurrentSession().close();
			}
			
		}
		return list;
	}
	

	/**
	 * 通过hql语句得到数据库中记录总数
	 */
	@Override
	public int getAllRowCount(String hql) {
		Integer allRows=0;
		allRows = getCurrentSession().createQuery(hql).getResultList().size();
		return allRows;
	}

	@Override
	public UserModel load(Integer id) {
		// TODO Auto-generated method stub
		return getCurrentSession().load(UserModel.class, id);
	}

	@Override
	public UserModel get(Integer id) {
		// TODO Auto-generated method stub
		return getCurrentSession().get(UserModel.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserModel> findAll() {
		
		return getCurrentSession().createQuery("from UserModel").getResultList();
	}

	@Override
	public void persist(UserModel entity) {
		getCurrentSession().persist(entity);
		
	}

	@Override
	public Integer save(UserModel entity) {
		
		return (Integer) getCurrentSession().save(entity);
	}

	@Override
	public void saveOrUpdate(UserModel entity) {
		getCurrentSession().saveOrUpdate(entity);
		
	}

	@Override
	public void delete(Integer id) {
		UserModel userModel = getCurrentSession().get(UserModel.class, id);
		if(userModel!=null){
			getCurrentSession().delete(userModel);
		}
		
		
	}

	@Override
	public void flush() {
		getCurrentSession().flush();
		
	}

	@Override
	public UserModel loginUser(String username, String password) {
		Query query = getCurrentSession().createQuery("FROM UserModel WHERE name=? AND password=?");
		query.setParameter(0, username);
		query.setParameter(1, password);
		/*getCurrentSession().createCriteria(UserModel.class);*/
		return (UserModel) query.getSingleResult();
	}

	@Override
	public UserModel findByName(String userName) {
		
		return (UserModel) getCurrentSession().createQuery("FROM UserModel WHERE name=?").setParameter(0, userName).getSingleResult();
	}

	  /**
     * 获取根据性别分组统计数据
     * @return
     */
	@Override
	public List getUserGenderNumbers() {
		//根据 gender 分组统计用户性别人数
        String hql = "select count(*) as number,gender from UserModel group by gender";
        Query query = getCurrentSession().createQuery(hql);
        return query.list();
	}

	 /**
     * 获取根据创建日期分组统计数据
     * @return
     */
	@Override
	public List getUserCreateDateNumbers() {
		//根据 createTime 分组统计用户创建日期人数（ 利用 MySQL 提供的 DATE_FORMAT 函数对 createTime 进行格式化）
        String hql = "select count(*) as number,DATE_FORMAT(createTime,'%Y-%m-%d') from UserModel group by DATE_FORMAT(createTime,'%Y-%m-%d')";
        Query query = getCurrentSession().createQuery(hql);
        return query.list();
	}

}
