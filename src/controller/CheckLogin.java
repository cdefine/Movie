package controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.UserDaoImp;
import dao.userDao;
public class CheckLogin extends ActionSupport {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		String username;
		int power;
		String pass;
		public int getPower() {
			return power;
		}
		public void setPower(int power) {
			this.power = power;
		}

	   public void setPass(String _pass){
		   this.pass=_pass;
	   }
	   public String getPass(){return this.pass;}
		
		public void setUsername(String username) {
			this.username = username;
		}
		public String getUsername() {
			return username;
		}

		 public String checkInDb()throws Exception{
			 userDao dao=new UserDaoImp();
			 boolean isHave=dao.check(username,pass,power);
			 if(isHave){
			   Map session=ActionContext.getContext().getSession();
			   session.put("username", username);
			   if(power==1){
				   return "admin";//管理员界面
			   }
			   else{
				   return "user";
			   }
			 }else
				 return "fail";
		}
}
