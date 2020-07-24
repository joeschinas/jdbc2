package Application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import db.Db;
import db.DbException;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st =null;
		ResultSet rs = null;
		
		try {
		conn = 	Db.getConnection();
		st = conn.createStatement();
		rs = st.executeQuery("select * from department");
		
		while(rs.next()) {
		System.out.println(rs.getInt("Id")+" - "+rs.getString("Name"));
			
			
		}
			
		}catch(SQLException erro) {
			throw new DbException (erro.getMessage());
			
		}
		finally {
			Db.closeResultSet(rs);
			Db.closeStatement(st);
			Db.closeConnection();
		}

	}

}
