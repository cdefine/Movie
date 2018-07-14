package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Comment;
import domain.Movie;
import domain.Type;

public class movieDaoImp implements movieDao {

	private static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=mov";
    private static String user="sa";
    private static String pass="";  
    private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public boolean addMovie(Movie movie) throws Exception {
		// TODO Auto-generated method stub
		boolean isSuc = false;
		Class.forName(driver);
		String sql1 = "insert into movie values(?,?,?,?,?,?,?,?,?)";
		String sql2 ="update class set num=num+1 where id = ? or id=? or id= ?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt1 = con.prepareStatement(sql1);
				PreparedStatement pstmt2 = con.prepareStatement(sql2);) {
			pstmt1.setString(1, movie.getName());
			pstmt1.setString(2, movie.getDirector());
			pstmt1.setString(3, movie.getActor());
			pstmt1.setString(4,movie.getType1() );	
			pstmt1.setString(5,movie.getType2() );
			pstmt1.setString(6,movie.getType3() );
			pstmt1.setString(7,movie.getDate() );	
			pstmt1.setString(8,movie.getLanguage() );	
			pstmt1.setString(9,movie.getProfile() );
			pstmt2.setString(1,movie.getType1() );	
			pstmt2.setString(2,movie.getType2() );
			pstmt2.setString(3,movie.getType3() );
		    int row=pstmt1.executeUpdate();
		    pstmt2.executeUpdate();
		    isSuc=row>0;
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
			return isSuc;	
		}
			
	}
	@Override
	public List<Type> getAllclass() throws Exception {
		List<Type> types = new ArrayList<>();
		Class.forName(driver);
		String sql = "select * from class";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while(rs.next()){//保存每行的数据
					Type t = new Type();
					t.setId(rs.getInt("id"));
					t.setName(rs.getString("name")+"("+rs.getInt("num")+")");
					t.setNum(rs.getInt("num"));
					types.add(t);
				}
			}
		}
		return types;
	}
	@Override
	public List<String[]> getAllmovie() throws Exception {
		// TODO Auto-generated method stub
		List<String[]> mov = new ArrayList<>();
		Class.forName(driver);
		String sql = "select * from movie";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while(rs.next()){//保存每行的数据
					String[] row=new String[2];
					row[0]=rs.getString("id");
					row[1]=rs.getString("name");
					mov.add(row);
				}
			}
		}finally{
		
		return mov;
		}
	}
	@Override
	public Movie getmovieByobj(String id) throws Exception {
		Movie t = new Movie();
		Class.forName(driver);
		String sql1 = "select * from movie where id=?";
		String sql2 = "select name from class where id=? or id=? or id=?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt1 = con.prepareStatement(sql1);
				PreparedStatement pstmt2 = con.prepareStatement(sql2);) {
			pstmt1.setString(1, id);
			try (ResultSet rs = pstmt1.executeQuery();) {
				while(rs.next()){//保存每行的数据
					
					t.setId(rs.getString("id"));
					t.setName(rs.getString("name"));
					t.setDirector(rs.getString("director"));
					t.setActor(rs.getString("actor"));
					pstmt2.setString(1, rs.getString("class1"));
					pstmt2.setString(2, rs.getString("class2"));
					pstmt2.setString(3, rs.getString("class3"));
					t.setLanguage(rs.getString("lang"));
					t.setDate(rs.getString("years"));
					t.setProfile(rs.getString("prof"));
				}
			}	
			try (ResultSet rs = pstmt2.executeQuery();) {
				int i=0;
				String [] a =new String[3];
				while(rs.next()){
					a[i]=rs.getString("name");
					i++;
				}
				t.setType1(a[0]);
				t.setType2(a[1]);
				t.setType3(a[2]);
		
			}	

		}
		return t;
	}
	@Override
	public boolean addComment(Comment comt) throws Exception {
		// TODO Auto-generated method stub
		boolean isSuc = false;
		Class.forName(driver);
		String sql1 ="select id  from usr where username = ? ";
		String sql2 ="select * from  remark where pid = ? and mid = ? ";
		String sql3 = "insert into remark values(?,?,?,?,?)";
		String sql4 = "update remark set comment = ?,point = ? where pid = ?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt1 = con.prepareStatement(sql1);
				PreparedStatement pstmt2 = con.prepareStatement(sql2);
				PreparedStatement pstmt3 = con.prepareStatement(sql3);
				PreparedStatement pstmt4 = con.prepareStatement(sql4);) {
			pstmt1.setString(1, comt.getPid());
			ResultSet rs1 = pstmt1.executeQuery();
			String id =null;
			if(rs1.next()){
			id = rs1.getString("id");
			pstmt2.setString(1, id);
			pstmt2.setString(2, comt.getMid());
			}
			ResultSet rs2 = pstmt2.executeQuery();
			if(rs2.next()){
				pstmt4.setString(1, comt.getComment());
				pstmt4.setString(2, comt.getPoint());
				pstmt4.setString(3, id);
			    int row=pstmt4.executeUpdate();
			    isSuc=row>0;
			    
			}
			else{

				pstmt3.setString(1, comt.getMid());
				pstmt3.setString(2, id);
				pstmt3.setString(3, comt.getRtime());
				pstmt3.setString(4, comt.getComment());
				pstmt3.setString(5, comt.getPoint());
			    int row=pstmt3.executeUpdate();
			    isSuc=row>0;
			}

		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
			return isSuc;	
		}
	}
	@Override
	public List<String[]> loadComment(String mid) throws Exception {
		// TODO Auto-generated method stub
		List<String[]> comt = new ArrayList<>();
		Class.forName(driver);
		String sql = "select username,rtime,comment,point from remark,usr where mid= ? and id = pid";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			 pstmt.setString(1, mid);
			try (ResultSet rs = pstmt.executeQuery();) {
				while(rs.next()){//保存每行的数据
					String[] row=new String[4];
					row[0]=rs.getString("username");
					row[1]=rs.getString("rtime");
					row[2]=rs.getString("comment");
					row[3]=rs.getString("point");
					comt.add(row);
					
				}
			}
		}finally{
		
		return comt;
		}
	}
	@Override
	public List<String[]> searchByType(String type) throws Exception {
		// TODO Auto-generated method stub
		List<String[]> info = new ArrayList<>();
		String id;
		Class.forName(driver);
		String sql1 = "select id from class where name= ?";
		String sql2 = "select id ,name from movie where class1 =? or class2=? or class3=?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt1 = con.prepareStatement(sql1);
				PreparedStatement pstmt2 = con.prepareStatement(sql2);) {
			 pstmt1.setString(1, type);
			try (ResultSet rs = pstmt1.executeQuery();) {
					rs.next();
					id=rs.getString("id");	
					pstmt2.setString(1, id);
					pstmt2.setString(2, id);
					pstmt2.setString(3, id);
				ResultSet rs1 = pstmt2.executeQuery();

				while(rs1.next()){//保存每行的数据
					String[] row=new String[2];
					row[0]=rs1.getString("id");
					row[1]=rs1.getString("name");
					info.add(row);		
					}
			}

		}finally{		
		return info;
		}
	}
	@Override
	public List<String[]> searchByKey(String key) throws Exception {
		List<String[]> mov = new ArrayList<>();
		Class.forName(driver);
		String sql = "select * from movie where director like ? or actor like ? or name like ? ";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			key="%"+key+"%";
			pstmt.setString(1, key);
			pstmt.setString(2, key);
			pstmt.setString(3, key);
			try (ResultSet rs = pstmt.executeQuery();) {
			while(rs.next()){//保存每行的数据
					String[] row=new String[2];
					row[0]=rs.getString("id");
					row[1]=rs.getString("name");
					mov.add(row);
				}
			}
		}finally{
		
		return mov;
		}
	}
		
}
