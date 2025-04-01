package com.vatsalya.admin_login_files;

import java.sql.*;
import com.vatsalya.db_connection.*;

public class AdminLoginDAO {

	public AdminBean ab = null;
	
	public AdminBean login(String uN, String pW) {
		
		Connection con = DBConnection.getCon();
		try {
		PreparedStatement ps = con.prepareStatement("select * from Admin71 where uname = ? and pword = ?");
		
		ps.setString(1, uN);
		ps.setString(2, pW);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			ab = new AdminBean();
			ab.setuName(rs.getString(1));
			ab.setuPassword(rs.getString(2));
			ab.setfName(rs.getString(3));
			ab.setlName(rs.getString(4));
			ab.setCity(rs.getString(5));
			ab.setMailId(rs.getString(6));
			ab.setPhNo(rs.getLong(7));
		}
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return ab;
	}
}
