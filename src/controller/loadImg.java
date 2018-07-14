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

public class loadImg extends ActionSupport {
	

	public  void loadimg() throws Exception{	
		
		try{
		HttpServletResponse responses = ServletActionContext.getResponse();
		//设置编码格式,注：位置需在list前，否则utf-8格式会不对list起作用，导致乱码问题
		responses.setCharacterEncoding("utf-8");
		PrintWriter writer = responses.getWriter();
		List<String[]> mucs = new ArrayList<>();
		movieDao m = new movieDaoImp();
		mucs.addAll(m.getAllmovie());
		JSONArray jsonArray=JSONArray.fromObject(mucs);
		//写入到前台
		writer.write(jsonArray.toString());	
		writer.flush();
		writer.close();
		}catch(Exception e){
						
		}		
	}
}
