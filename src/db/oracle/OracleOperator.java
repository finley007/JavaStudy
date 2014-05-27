package db.oracle;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.IDBOperator;

public class OracleOperator implements IDBOperator {

	public void operate() {
		// TODO Auto-generated method stub
		try {
			Driver driver = (Driver) (Class.forName("oracle.jdbc.driver.OracleDriver").newInstance());  
			DriverManager.registerDriver(driver);
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@10.10.51.175:1521:esb", "icopdev", "icopdev"); 
			PreparedStatement ps = conn.prepareStatement("select * from pcm_cust_logon_config t2 where t2.id = '1001'");
			ResultSet set = ps.executeQuery();
			while(set.next()){
				System.out.println(set.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		IDBOperator operator = new OracleOperator();
		operator.operate();
	}

}
