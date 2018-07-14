package controller;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.config.impl.MockConfiguration;

import dao.movieDao;
import dao.movieDaoImp;
import domain.Comment;
import net.sf.json.JSONArray;

public class addComment extends ActionSupport {
	private String pid;

	private String mid;
	private String comment;
	private String rtime;
	private String point;
	private Comment comt;
	public Comment getComt() {
		return comt;
	}

	public void setComt(Comment comt) {
		this.comt = comt;
	}
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}


	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRtime() {
		return rtime;
	}

	public void setRtime(String rtime) {
		this.rtime = rtime;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public void addComt() throws Exception{
		comt = new Comment();
		comt.setPid(pid);
		comt.setMid(mid);
		comt.setComment(comment);
		comt.setPoint(point);
		comt.setRtime(rtime);
		movieDao movie = new movieDaoImp();
		boolean isSuc = movie.addComment(comt);
		try{
			HttpServletResponse responses = ServletActionContext.getResponse();
			//设置编码格式,注：位置需在list前，否则utf-8格式会不对list起作用，导致乱码问题
			responses.setCharacterEncoding("utf-8");
			PrintWriter writer = responses.getWriter();
			JSONArray jsonArray=JSONArray.fromObject(isSuc);
			//写入到前台
			writer.write(jsonArray.toString());	
			writer.flush();
			writer.close();
			}catch(Exception e){
				
				
			}
	}
	
}
