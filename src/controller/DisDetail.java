package controller;

import javax.xml.soap.Detail;

import com.opensymphony.xwork2.ActionSupport;

import dao.movieDao;
import dao.movieDaoImp;
import domain.Movie;

public class DisDetail extends ActionSupport {		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Movie movieInfo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Movie getMovieInfo() {
		return movieInfo;
	}
	public void setMovieInfo(Movie movieInfo) {
		this.movieInfo = movieInfo;
	}
	public String disDetail() throws Exception{
		movieDao movie =new movieDaoImp();
		movieInfo = movie.getmovieByobj(id);
		return "suc";
		
	}
	
}
