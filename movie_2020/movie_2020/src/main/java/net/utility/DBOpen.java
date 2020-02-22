package net.utility;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component
public class DBOpen {
  
  public DBOpen() {
    System.out.println("---DBOpen()객체생성"); 
  }    
  public Connection getConnection() {
    String url     ="jdbc:mariadb://127.0.0.1:3307/mysql";
    String user    ="root";
    String password="@a2031519";
    String driver  ="org.mariadb.jdbc.Driver";
    
    Connection con=null;
    
    try {
      Class.forName(driver);
      con=DriverManager.getConnection(url, user, password);

    }catch (Exception e) {
      System.out.println("DB오픈실패:"+e);
    }//try end 
    
    return con;
  }//getConnection() end  
  
}//class end
