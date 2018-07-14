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
		//���ñ����ʽ,ע��λ������listǰ������utf-8��ʽ�᲻��list�����ã�������������
		responses.setCharacterEncoding("utf-8");
		PrintWriter writer = responses.getWriter();
		List<String[]> mucs = new ArrayList<>();
		movieDao m = new movieDaoImp();
		mucs.addAll(m.getAllmovie());
		JSONArray jsonArray=JSONArray.fromObject(mucs);
		//д�뵽ǰ̨
		writer.write(jsonArray.toString());	
		writer.flush();
		writer.close();
		}catch(Exception e){
						
		}		
	}
}
