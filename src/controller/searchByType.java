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

public class searchByType extends ActionSupport {
		private String type;
		List<String[]> info;
	
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public List<String[]> getInfo() {
			return info;
		}

		public void setInfo(List<String[]> info) {
			this.info = info;
		}



		public void searchType() throws Exception{
			
			
			try{
				HttpServletResponse responses = ServletActionContext.getResponse();
				//���ñ����ʽ,ע��λ������listǰ������utf-8��ʽ�᲻��list�����ã�������������
				responses.setCharacterEncoding("utf-8");
				PrintWriter writer = responses.getWriter();
				movieDao m = new movieDaoImp();
				info = new ArrayList<>();
				info.addAll(m.searchByType(type));
				JSONArray jsonArray=JSONArray.fromObject(info);
				//д�뵽ǰ̨
				writer.write(jsonArray.toString());	
				writer.flush();
				writer.close();
				}catch(Exception e){
								
				}	
			
			
			
		}
}
