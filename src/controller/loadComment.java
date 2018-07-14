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
		//设置编码格式,注：位置需在list前，否则utf-8格式会不对list起作用，导致乱码问题
		responses.setCharacterEncoding("utf-8");
		PrintWriter writer = responses.getWriter();
		List<String[]> cmt = new ArrayList<>();
		movieDao movie = new movieDaoImp();
		
		cmt.addAll(movie.loadComment(mid));
		JSONArray jsonArray=JSONArray.fromObject(cmt);
		//写入到前台
		writer.write(jsonArray.toString());	
		writer.flush();
		writer.close();
		}catch(Exception e){
			
			
		}
		
		
	}
}
