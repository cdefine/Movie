package controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDaoImp;
import dao.userDao;
import domain.User;

public class UserRegist extends ActionSupport {
	
	private String username;
	private String sex;
	private String pass;
			public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

			
	public String regist() throws Exception{
		boolean isSuc = false;
		 userDao dao=new UserDaoImp();
		 User user = new User();
		 user.setName(username);
		 user.setPassword(pass);
		 if(sex.equals("1"))
			 user.setSex("男");
		 else{
			 user.setSex("女");
		 }
		 user.setPow(0);
		 isSuc = dao.addUser(user);
		 if(isSuc){
		   Map session=ActionContext.getContext().getSession();
		   session.put("username", username);
		   return "suc";//自定义指向的页面
		 }else
			 return "fail";
	}
		
		
		
		
		
}
			
