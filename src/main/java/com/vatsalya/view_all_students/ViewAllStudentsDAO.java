package com.vatsalya.view_all_students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import com.vatsalya.add_student.*;
import com.vatsalya.db_connection.DBConnection;

public class ViewAllStudentsDAO {

	public ArrayList<StudentBean> al = new ArrayList<StudentBean>();
	
	public ArrayList<StudentBean> retrieve()
	{
		try {
			
			Connection con = DBConnection.getCon();//Accessing Connection object
			PreparedStatement ps1 = con.prepareStatement("select * from Student71");
			PreparedStatement ps2 = con.prepareStatement("select * from Marks71");
			
			ResultSet rs1 = ps1.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			
			while(rs1.next() && rs2.next()) {
				
				StudentBean sb = new StudentBean();//Bean object
				sb.setRollno(rs1.getString(1));
				sb.setName(rs1.getString(2));
				sb.setCourse(rs1.getString(3));
				sb.setTotalMarks(rs1.getInt(4));
				sb.setPercentage(rs1.getFloat(5));
				sb.setResult(rs1.getString(6));
				sb.getMk().setCoreJava(rs2.getInt(2));
				sb.getMk().setAdvJava(rs2.getInt(3));
				sb.getMk().setUi(rs2.getInt(4));
				sb.getMk().setDb(rs2.getInt(5));
				sb.getMk().setTools(rs2.getInt(6));
				al.add(sb);
				
			}
			
			
		}catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		return al;
	}
}
