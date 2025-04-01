package com.vatsalya.add_student;

import java.sql.*;

import com.vatsalya.db_connection.DBConnection;

public class AddStudentDAO 
{
	public int k =0;
	
	public int insert(StudentBean sb) {
		
		try {
			
			Connection con = DBConnection.getCon();
			
			PreparedStatement ps1 = con.prepareStatement
					("insert into Student71 values (?,?,?,?,?,?)");
			
			PreparedStatement ps2 = con.prepareStatement
					("insert into Marks71 values(?,?,?,?,?,?)");
			
			ps1.setString(1,sb.getRollno());
			ps1.setString(2, sb.getName());
			ps1.setString(3, sb.getCourse());
			ps1.setInt(4, sb.getTotalMarks());
			ps1.setFloat(5, sb.getPercentage());
			ps1.setString(6, sb.getResult());
			
			int p = ps1.executeUpdate();
				if(p>0) 
				{
					ps2.setString(1, sb.getRollno());
					ps2.setInt(2,sb.getMk().getCoreJava());
					ps2.setInt(3, sb.getMk().getAdvJava());
					ps2.setInt(4, sb.getMk().getUi());
					ps2.setInt(5, sb.getMk().getDb());
					ps2.setInt(6, sb.getMk().getTools());
				
					k = ps2.executeUpdate();
				}
			
		}catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	
		return k;
		
	}
}




