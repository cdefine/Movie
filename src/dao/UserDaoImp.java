package dao;

import java.sql.*;
import java.util.*;
import domain.User;
public class UserDaoImp implements userDao {
	
    private static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=mov";
    private static String user="sa";
    private static String pass="";  
    private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	@SuppressWarnings("finally")
	@Override
	public boolean check(String username ,String passwd,int power) throws Exception {
		// TODO Auto-generated method stub
		boolean isHave = false;
		Class.forName(driver);
		String sql = "select * from usr where username =? and password=? and pow=?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, username);
			pstmt.setString(2, passwd);
			pstmt.setInt(3, power);;
			try (ResultSet rs = pstmt.executeQuery();) {
				isHave = rs.next();
			}
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
			return isHave;	
		}
			
			
		
	}
	@Override
	public boolean addUser(User userInfo) throws Exception {
		boolean isSuc = false;
		Class.forName(driver);
		String sql = "insert into usr values(?,?,?,?)";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, userInfo.getName());
			pstmt.setString(2, userInfo.getSex());
			pstmt.setInt(3, userInfo.getPow());
			pstmt.setString(4,userInfo.getPassword() );	
		    int row=pstmt.executeUpdate();
		    isSuc=row>0;
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
			return isSuc;	
		}
			
	}
	

}
