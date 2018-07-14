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
public class loadComment extends ActionSupport {
	private String mid;
	private float [] percent;
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}
	public float[] getPercent() {
		return percent;
	}

	public void setPercent(float[] percent) {
		this.percent = percent;
	}

	public void loadComt(){

		
		try{
		HttpServletResponse responses = ServletActionContext.getResponse();
		//���ñ����ʽ,ע��λ������listǰ������utf-8��ʽ�᲻��list�����ã�������������
		responses.setCharacterEncoding("utf-8");
		PrintWriter writer = responses.getWriter();
		List<String[]> cmt = new ArrayList<>();
		movieDao movie = new movieDaoImp();
		
		cmt.addAll(movie.loadComment(mid));
		JSONArray jsonArray=JSONArray.fromObject(cmt);
		//д�뵽ǰ̨
		writer.write(jsonArray.toString());	
		writer.flush();
		writer.close();
		}catch(Exception e){
			
			
		}
		
		
	}
}
