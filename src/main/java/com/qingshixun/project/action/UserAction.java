package com.qingshixun.project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import com.opensymphony.xwork2.ActionSupport;
import com.qingshixun.project.model.ChartData;
import com.qingshixun.project.model.PageBean;
import com.qingshixun.project.model.UserModel;
import com.qingshixun.project.service.IUserService;

//使用拦截器注解时，必须引用package包name的值
@ParentPackage("web-default")
@Scope("prototype")
public class UserAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserAction userAction;

	@Autowired
	private IUserService userService;
	private UserModel user;
	private int page;
	//分页的数据
	private PageBean pageBean;
	//从页面上传过来的值，主要是用于编辑和删除
	private Integer id;
	
	private String message;
	
	 //用户性别统计数据
    private ChartData userGenderData;

    //用户创建日期统计数据
    private ChartData userCreateData;
	/**
	 * 跳转到登录界面
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "loginUser", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/user/login.jsp") })
	public String loginUser() throws Exception {
		return SUCCESS;
	}

	
	/**
	 * 验证登录时是否满足，ajax异步刷新
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "validateLogin", results = { @Result(name = SUCCESS,type="json") })
	public String validateLogin() throws Exception {
		System.out.println("进入验证登录模块:"+user);
		if (user != null) {
			if (userService.findByName(user.getName()) == null) {
				message = "用户名错误";

			} else {
				UserModel user1 = userService.loginUser(user.getName(),user.getPassword());
				if (user1 == null) {
					message = "密码输入错误，请重新选择";
					System.out.println("密码输入错误，请重新选择");

				}else{
					message = "success";
				}
				/*
				 * //可以根据用户名查找用户头像，这里就不需要设置了，可以在ajax实现这部分功能 id=1;
				 */
			}

		}
		return SUCCESS;

	}
	/**
	 * 登录成功后，就会重定向到finUser
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "loginResultUser", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/main.jsp"),
			@Result(name = "login", location = "/WEB-INF/views/user/login.jsp") })
	public String loginResultUser() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (user != null) {
			UserModel currentUser = userService.loginUser(user.getName(), user.getPassword());
			if (currentUser != null) {
				// ActionContext.getContext().getSession().put("userInfo", u);
				session.setAttribute("userInfo", currentUser);
				return SUCCESS;
			} else {
				return "login";
			}
		} else if (session.getAttribute("userInfo") != null) {
			return SUCCESS;
		} else {
			return "login";
		}

	}

	@Action(value = "registerUser", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/user/userForm.jsp") })
	public String registerUser() throws Exception {

		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "saveUser", results = {
			@Result(name = SUCCESS, type="redirectAction",params={"actionName","findUser"})})
	public String saveUser() throws Exception {
		userService.saveOrUpdate(user);
		return SUCCESS;
		
	}


	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "findUser",
			// interceptorRefs=@InterceptorRef("myInterceptorStack"),
			interceptorRefs = { @InterceptorRef("myInterceptorStack") }, results = {
					@Result(name = SUCCESS, location = "/WEB-INF/views/user/list.jsp"),
					@Result(name = "login", location = "/WEB-INF/views/user/login.jsp") })
	public String findUser() throws Exception {
		pageBean= userService.getPageBean(5, page);
		
		return SUCCESS;
	}
	
	/**
	 * 通过用户名来查找用户
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "findNameUser",
			// interceptorRefs=@InterceptorRef("myInterceptorStack"),
			interceptorRefs = { @InterceptorRef("myInterceptorStack") }, results = {
					@Result(name = SUCCESS, location = "/WEB-INF/views/user/list.jsp"),
					@Result(name = "login", location = "/WEB-INF/views/user/login.jsp") })
	public String findNameUser() throws Exception {
		pageBean=(PageBean) userService.findAll();
		return SUCCESS;
	}

	/**
	 * 刪除用戶
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "deleteUser", interceptorRefs = @InterceptorRef("myInterceptorStack"), results = {
			@Result(name = SUCCESS, type = "redirectAction", params = { "actionName", "findUser" }),
			@Result(name = ERROR, location = "/WEB-INF/views/user/userList.jsp"),
			@Result(name = "login", location = "/WEB-INF/views/user/login.jsp") })
	public String deleteUser() throws Exception {
		if(id!=null){
			System.out.println("删除ID的用户："+id);
			userService.delete(id);
		}	
		return SUCCESS;
	}

	/**
	 * 跳转到添加或者修改页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action(value = "toUser", interceptorRefs = @InterceptorRef("myInterceptorStack"), results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/user/form.jsp"),
			@Result(name = ERROR, location = "/WEB-INF/views/user/list.jsp"),
			@Result(name = "login", location = "/WEB-INF/views/user/login.jsp") })
	public String toUser() throws Exception {
		if(id!=null){
			user=userService.get(id);
		}
		
		return SUCCESS;
	}

	/**
	 * 退出登录
	 * 
	 * @return
	 */
	@Action(value = "logoutUser", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/user/login.jsp") })
	public String logoutUser() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object user = session.getAttribute("userInfo");
		if (user != null) {
			session.removeAttribute("userInfo");
			/* session.invalidate(); */
		}
		return SUCCESS;
	}
	
	/**
	 * 跳转到分析图界面
	 * @return
	 * @throws Exception
	 */
	@Action(value = "toAnalyze", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/user/analyze.jsp")})
	public String toAnalyze() throws Exception {
		 // 根据userId，查询用户信息
        userGenderData = userService.getUserGenderData();
        userCreateData = userService.getUserCreateData();
		return SUCCESS;
		
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public UserAction getUserAction() {
		return userAction;
	}

	public void setUserAction(UserAction userAction) {
		this.userAction = userAction;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getMessage() {
		return message;
	}


	public ChartData getUserGenderData() {
		return userGenderData;
	}


	public void setUserGenderData(ChartData userGenderData) {
		this.userGenderData = userGenderData;
	}


	public ChartData getUserCreateData() {
		return userCreateData;
	}


	public void setUserCreateData(ChartData userCreateData) {
		this.userCreateData = userCreateData;
	}

	

}
