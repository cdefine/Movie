package controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.movieDao;
import dao.movieDaoImp;
import domain.Movie;
import domain.Type;
import net.sf.json.JSONArray;

public class ManageMovie extends ActionSupport {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Movie movie;
    private List<Type> classes;
	public List<Type> getClasses() {
		return classes;
	}

	public void setClasses(List<Type> classes) {
		this.classes = classes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}



	public String addMovie() throws Exception{
		boolean isHave=false;
		movieDao dao = new movieDaoImp();
		isHave=dao.addMovie(movie);
			if(isHave)	return "suc";
				
			else	return "fail";
			
	}
	public String loadClass() throws Exception{

		movieDao m = new movieDaoImp();
		classes = new ArrayList<>();
		classes.addAll(m.getAllclass());
		return "suc";

		
		
		
	}




}
