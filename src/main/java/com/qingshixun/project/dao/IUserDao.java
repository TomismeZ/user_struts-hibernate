package com.qingshixun.project.dao;

import java.util.List;

import com.qingshixun.project.model.PageBean;
import com.qingshixun.project.model.UserModel;

public interface IUserDao extends BaseDao<UserModel, Integer>{
	
	public UserModel loginUser(String username,String password);
	public List<UserModel> queryByPage(String hql, int offset, int pageSize);

	/**
	 * 通过hql语句得到数据库中记录总数
	 */
	public int getAllRowCount(String hql);
	
	public UserModel findByName(String userName);
	
	 /**
     * 获取根据性别分组统计数据
     * @return
     */
    public List getUserGenderNumbers();
    
    /**
     * 获取根据创建日期分组统计数据
     * @return
     */
    public List getUserCreateDateNumbers();
}
