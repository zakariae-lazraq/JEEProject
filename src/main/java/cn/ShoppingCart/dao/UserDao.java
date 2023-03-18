package cn.ShoppingCart.dao;

import java.sql.*;

import cn.ShoppingCart.connection.DbCon;
import cn.ShoppingCart.model.User;


public class UserDao {
	private Connection con =null;

	private String query;
    private PreparedStatement pst;
    

	public UserDao(Connection con) {
		this.con = con;
	}
	
	public User userLogin(String email, String password) {
		User user = null;
        try {
            query = "select * from users where email=? and password=?";
            pst = con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
             ResultSet rs = pst.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setId(rs.getInt("id"));
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("email"));
            	user.setAdresse(rs.getString("adresse"));
            	user.setRole(rs.getString("role"));
            	user.setPhone(rs.getString("telephone"));
            	user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }
	
	public boolean addUser(User user) {
        boolean success = false;
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO users (name, email, adresse, telephone, password) VALUES (?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getAdresse());
            stmt.setString(4, user.getPhone());
            stmt.setString(5, user.getPassword());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return success;
    }
	

	





	
	
	
	
}
