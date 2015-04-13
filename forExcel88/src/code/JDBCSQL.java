package code;



/**
 * @author WUJIAJUN  
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSQL {
	
	

	  static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //加载JDBC驱动
	  static String dbURL = "jdbc:sqlserver://10.0.200.21:1433; DatabaseName=YiHuNet2008";  //连接服务器和数据库test
	  static  String userName = "NetOper";  //默认用户名
	  static String userPwd = "Net123#YiHu";  //密码
	  static Connection dbConn = null;
	  
	  static{		
		  try {
			   Class.forName(driverName);
			   dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			   System.out.println("Connection Successful!");  //如果连接成功 控制台输出Connection Successful!
			  } catch (Exception e) {
			   e.printStackTrace();
			  }
		
		  
	  }


	public static void main(String[] args) throws SQLException {
		
		  
		
			
		forupdate_ZiXun_ConsumerOrders("888","999");
		  
		  
			}
	
	
	
	
	
	public static  int  forupdate_ZIXUN_CloseQue(String  olddoc,String newdoc) throws SQLException{
		

		  
		   String  sql="UPDATE  ZIXUN_CloseQue SET  doctorId=?   WHERE   doctorId=?;";
		  
		   PreparedStatement  stm= dbConn.prepareStatement(sql);
			stm.setString(1, newdoc);
			stm.setString(2, olddoc);
	
			
		    int back=  stm.executeUpdate();
			
		    
		   
		    if(back!=0){
		    	 System.err.println(back+"   ZIXUN_CloseQue");
		    }
			
		  
		  return back;
		
	}
	
	public static  int  forupdate_ZiXun_ConsumerOrders(String  olddoc,String newdoc) throws SQLException{
		

		  
		   String  sql="UPDATE  ZiXun_ConsumerOrders SET  ASK_DoctorID=?   WHERE   ASK_DoctorID=?;";
		  
		   PreparedStatement  stm= dbConn.prepareStatement(sql);
			stm.setString(1, newdoc);
			stm.setString(2, olddoc);
	
			
		    int back=  stm.executeUpdate();
		    if(back!=0){
		    	 System.err.println(back+"    ZiXun_ConsumerOrders");
		    }
		    		
			
		  
		  return back;
		
	}
	
	
	public static  int  forupdate_ZiXun_DoctorFreeCount(String  olddoc,String newdoc) throws SQLException{
		

		  
		   String  sql="UPDATE  ZiXun_DoctorFreeCount SET  doctorUid=?   WHERE   doctorUid=?;";
		  
		   PreparedStatement  stm= dbConn.prepareStatement(sql);
			stm.setString(1, newdoc);
			stm.setString(2, olddoc);
	
			
		    int back=  stm.executeUpdate();
			
		    if(back!=0){
		    	 System.err.println(back+"     ZiXun_DoctorFreeCount");
		    }
			
		  
		  return back;
		
	}
	
	
	public static  int  forupdate_ZiXun_QuesMain(String  olddoc,String newdoc) throws SQLException{
		

		  
		   String  sql="UPDATE  ZiXun_QuesMain SET  ASK_DoctorID=?   WHERE   ASK_DoctorID=?;";
		  
		   PreparedStatement  stm= dbConn.prepareStatement(sql);
			stm.setString(1, newdoc);
			stm.setString(2, olddoc);
	
			
		    int back=  stm.executeUpdate();
			
			
		    if(back!=0){
		    	 System.err.println(back+"     ZiXun_QuesMain");
		    }
			
		  
		  return back;
		
	}
	
	
	public static  int  forupdate_ZiXun_Reply(String  olddoc,String newdoc) throws SQLException{
		

		  
		   String  sql="UPDATE  ZiXun_Reply SET  ASK_DoctorID=?   WHERE   ASK_DoctorID=?;";
		  
		   PreparedStatement  stm= dbConn.prepareStatement(sql);
			stm.setString(1, newdoc);
			stm.setString(2, olddoc);
	
			
		    int back=  stm.executeUpdate();
			
		    if(back!=0){
		    	 System.err.println(back+"    ZiXun_Reply");
		    }
			
			
		  
		  return back;
		
	}
	
	
	
	
	
	

	

}
