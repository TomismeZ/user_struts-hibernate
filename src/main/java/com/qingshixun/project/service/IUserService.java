package com.qingshixun.project.service;

import java.util.List;

import com.qingshixun.project.dao.BaseDao;
import com.qingshixun.project.model.ChartData;
import com.qingshixun.project.model.PageBean;
import com.qingshixun.project.model.UserModel;

public interface IUserService extends BaseDao<UserModel, Integer>{

	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public UserModel loginUser(String username,String password);
	/**
	 * 
	 * @param pageSize为每页显示的记录数
	 * @param page为当前显示的网页
	 * @return 返回一个PageBean对象
	 */
	public PageBean getPageBean(int pageSize, int page);
	
	public UserModel findByName(String userName);
	
	 /**
     * 获取用户性别统计数据
     * @return
     */
    public ChartData getUserGenderData();
    
    /**
     * 获取用户创建日期统计数据
     * @return
     */
    public ChartData getUserCreateData();
}
