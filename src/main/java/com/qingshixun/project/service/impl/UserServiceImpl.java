package com.qingshixun.project.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingshixun.project.dao.IUserDao;
import com.qingshixun.project.model.ChartData;
import com.qingshixun.project.model.PageBean;
import com.qingshixun.project.model.UserModel;
import com.qingshixun.project.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	IUserDao userDao;

	/**
	 * pageSize为每页显示的记录数
	 * page为当前显示的网页
	 */
	@Override
	public PageBean getPageBean(int pageSize, int page) {
		PageBean pageBean=new PageBean();
		String hql="from UserModel";
		int allRows=userDao.getAllRowCount(hql);
		int totalPage=pageBean.getTotalPages(pageSize, allRows);
		int currentPage=pageBean.getCurPage(page);
		int offset=pageBean.getCurrentPageOffset(pageSize, currentPage);
		List<UserModel> list=userDao.queryByPage(hql, offset, pageSize);
		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	@Override
	public UserModel load(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 通过id来查找用户
	 */
	@Override
	public UserModel get(Integer id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}
	
	/**
	 * 查找所有的用户
	 */
	@Override
	public List<UserModel> findAll() {
		
		return userDao.findAll();
	}

	/**
	 * 插入数据到数据库
	 */
	@Override
	public void persist(UserModel entity) {
		userDao.persist(entity);
		
	}
	
	/**
	 * 保存数据到数据库
	 */
	@Override
	public Integer save(UserModel entity) {
		
		return userDao.save(entity);
	}
	
	/**
	 * 保存并更新数据到数据库
	 */
	@Override
	public void saveOrUpdate(UserModel entity) {
		
		userDao.saveOrUpdate(entity);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
		
	}

	@Override
	public void flush() {
		userDao.flush();
		
	}

	@Override
	public UserModel loginUser(String username, String password) {
		
		return userDao.loginUser(username, password);
	}

	@Override
	public UserModel findByName(String userName) {
		// TODO Auto-generated method stub
		return userDao.findByName(userName);
	}

	@Override
	public ChartData getUserGenderData() {
		//获取根据性别分组统计数据
        List genderNumberList = userDao.getUserGenderNumbers();
        
        for (Object object : genderNumberList) {
			System.out.println("对象：--"+object);
		}
        int genderNumberCount = genderNumberList.size();
        String[] names = new String[genderNumberCount];
        String[] values = new String[genderNumberCount];
        //遍历统计数据，转换成 Chart.js 所需要的数据格式
        for (int i = 0, n = genderNumberCount; i < n; i++) {
            Object[] genderNumbers = (Object[]) genderNumberList.get(i);
            //性别标签名称，如：male、female
            names[i] = "\"" + String.valueOf(genderNumbers[1]) + "\"";
            //性别对应的用户数据
            values[i] = String.valueOf(genderNumbers[0]);
        }
        ChartData userGenderData = new ChartData();
        userGenderData.setNames("[" + String.join(",", names) + "]");
        userGenderData.setValues("[" + String.join(",", values) + "]");

        logger.debug("User gender data:" + userGenderData);
        return userGenderData;
	}

	/**
     * 获取用户创建日期统计数据
     * @return
     */
	@Override
	public ChartData getUserCreateData() {
		//获取根据创建日期分组统计数据
        List createDateNumberList = userDao.getUserCreateDateNumbers();
        int createDateNumberCount = createDateNumberList.size();
        String[] names = new String[createDateNumberCount];
        String[] values = new String[createDateNumberCount];

        //遍历统计数据，转换成 Chart.js 所需要的数据格式
        for (int i = 0, n = createDateNumberCount; i < n; i++) {
            Object[] createDateNumbers = (Object[]) createDateNumberList.get(i);
            //日期标签，如：2017-03-21
            names[i] = "\"" + String.valueOf(createDateNumbers[1]) + "\"";
            //日期对应的创建用户数量
            values[i] = String.valueOf(createDateNumbers[0]);
        }
        ChartData userCreateDateData = new ChartData();
        userCreateDateData.setNames("[" + String.join(",", names) + "]");
        userCreateDateData.setValues("[" + String.join(",", values) + "]");

        logger.debug("User create data:" + userCreateDateData);
        return userCreateDateData;
	}


}
