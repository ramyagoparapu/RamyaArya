package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Databasepage {
	Connection connection;
	java.sql.Statement statement;
	ResultSet rs=null;
	
	public String takedatafromDB(String columnname) {

		String columnvalue=null;
		
		//setting properties for mysql
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sqlurl="jdbc:mysql://localhost:3306/september2021";
			String sqlusername="root";
			String sqlpassword="root";
			String sqlquery="select * from users";
			//create connection to local DB
			connection=DriverManager.getConnection(sqlurl, sqlusername, sqlpassword);
		//Empower the connection reference to exececute statement
		statement= connection.createStatement();
		//Delivering the query
		rs= statement.executeQuery(sqlquery);
		while(rs.next()) {
		columnvalue=rs.getString(columnname);
		return columnvalue;
		}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
					if (connection!=null) {
						try {
							connection.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
		}
		return columnvalue;
		
	}

}
