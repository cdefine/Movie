package controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.movieDao;
import dao.movieDaoImp;
import net.sf.json.JSONArray;

public class searchBykey extends ActionSupport {

	public String key;
	List<String[]> info;
	public List<String[]> getInfo() {
		return info;
	}

	public void setInfo(List<String[]> info) {
		this.info = info;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void searchkey(){
		
		try{
			HttpServletResponse responses = ServletActionContext.getResponse();
			//设置编码格式,注：位置需在list前，否则utf-8格式会不对list起作用，导致乱码问题
			responses.setCharacterEncoding("utf-8");
			PrintWriter writer = responses.getWriter();
			movieDao m = new movieDaoImp();
			info = new ArrayList<>();
			info.addAll(m.searchByKey(key));
			JSONArray jsonArray=JSONArray.fromObject(info);
			//写入到前台
			writer.write(jsonArray.toString());	
			writer.flush();
			writer.close();
			}catch(Exception e){
							
			}
	
		
		
	}
}
