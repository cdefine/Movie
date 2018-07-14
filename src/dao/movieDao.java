package dao;
import java.util.List;

import domain.Comment;
import domain.Movie;
import domain.Type;
public interface movieDao {
	boolean addMovie(Movie movie) throws Exception;	
	List<Type> getAllclass() throws Exception;
	List<String[]> getAllmovie() throws Exception;
	Movie getmovieByobj(String id) throws Exception;
	boolean addComment(Comment comt)throws Exception;
	List<String[]> loadComment(String mid)throws Exception;
	List<String[]> searchByType(String type)throws Exception;
	List<String[]> searchByKey(String key)throws Exception;
}
