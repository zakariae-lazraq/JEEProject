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
        try {
            String sql = "INSERT INTO users (name, email,password, adresse, telephone, role) VALUES ( ? , ? , ? , ? , ? , ? )";
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getAdresse());
            pst.setString(5, user.getPhone());
            pst.setString(6, user.getRole());
            
            System.out.print("add User : "+user.toString());
            
            int rows = pst.executeUpdate();
            
            if (rows > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                	pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return success;
    }
//	public boolean addElement(User user) {
//		// TODO Auto-generated method stub
//		try {
//			PreparedStatement ps=con.prepareStatement("insert into clients values(?,?,?,?,?)");
//			ps.setString(1, user.getName());
//			ps.setString(2, user.getEmail());
//			ps.setString(3, user.getPassword());
//			ps.setString(4, user.getAdresse());
//			ps.setString(5, user.getPhone());
//			ps.setString(6, user.getRole());
//			
//			ps.executeUpdate();
//			
//			con.commit();
//			System.out.println("client added");
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			try {
//				con.rollback();
//			}catch(SQLException e1) {
//				e1.printStackTrace();
//			}
//		}finally {
//			try {
//				con.rollback();
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	





	
	
	
	
}
