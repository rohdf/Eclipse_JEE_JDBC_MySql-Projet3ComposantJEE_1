package com.nsis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.nsis.bo.LoginBo;
import com.nsis.service.LoginService;

import javafx.fxml.LoadException;

public class LoginDao {
	  private static boolean status = false;
	  private static Connection conn = null;
	  
 
 
 public static void init() throws ClassNotFoundException, SQLException{
  Class.forName("com.mysql.jdbc.Driver");

  Properties props = new Properties();
  props.setProperty("user", "sa");
  props.setProperty("password", "sa");

  String bd = "dblogin";
  String url = "jdbc:mysql://localhost:3306/dblogin?user=sa&password=sa";

  conn = DriverManager.getConnection(url);
 }

public static boolean validate(String identifiant, String motDePasse){
	 PreparedStatement pst = null;
	  ResultSet rs = null;
  try {
	  init();
	  
   pst = conn
     .prepareStatement("select * from utilisateur where identifiant=? and motdepasse=?");
   pst.setString(1, identifiant);
   pst.setString(2, motDePasse);

   rs = pst.executeQuery();

   status = rs.next();

   System.out.println("status" + status);

  } catch (Exception e) {
   e.printStackTrace();
	   try {
		throw new LoadException();
		} catch (LoadException e1) {
			e1.printStackTrace();
		}
  } finally {
   if (conn != null) {
    try {
     conn.close();
    } catch (SQLException e) {
     e.printStackTrace();
    }
   }
   if (pst != null) {
    try {
     pst.close();
    } catch (SQLException e) {
     e.printStackTrace();
    }
   }
   if (rs != null) {
    try {
     rs.close();
     
    } catch (SQLException e) {
     e.printStackTrace();
    }
   }
  }
  return status;
 }

public LoginBo findByLogin(String identifiant) {
	LoginBo login = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	  
	  try {

		  init();
		  
	   pst = conn
	     .prepareStatement("select * from utilisateur where identifiant=?");
	   pst.setString(1, identifiant);

	   rs = pst.executeQuery();

	   if(rs.next()){
		   login = new LoginBo();
		   login.setIdentifiant(rs.getString("identifiant")); 
		   login.setMotDePasse(rs.getString("motdepasse"));
	   }

	   

	  } catch (Exception e) {
	   e.printStackTrace();
		   try {
			throw new LoadException();
			} catch (LoadException e1) {
				e1.printStackTrace();
			}
	  } finally {
	   if (conn != null) {
	    try {
	     conn.close();
	    } catch (SQLException e) {
	     e.printStackTrace();
	    }
	   }
	   if (pst != null) {
	    try {
	     pst.close();
	    } catch (SQLException e) {
	     e.printStackTrace();
	    }
	   }
	   if (rs != null) {
	    try {
	     rs.close();
	     
	    } catch (SQLException e) {
	     e.printStackTrace();
	    }
	   }
	  }
	
	return login;
}
 
 
}