package com.vatsalya.update_marks;

import java.sql.*;
import com.vatsalya.add_student.StudentBean;
import com.vatsalya.db_connection.*;

public class UpdateMarksDAO {

	public int k =0;
	public int update(StudentBean sb) {
		
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update Marks71 set CoreJava=?,AdvJava=?,ui=?,db=?,tools=? where rollno=?");
			PreparedStatement ps2 = con.prepareStatement("update Student71 set totmarks = ?, per = ? , result = ? where rollno=? ");
			
			String rollNo = sb.getRollno();
			int coreJava = sb.getMk().getCoreJava();
			int advJava = sb.getMk().getAdvJava();
			int ui = sb.getMk().getUi();
			int db = sb.getMk().getDb();
			int tools = sb.getMk().getTools();
			int totMarks = coreJava + advJava + ui + db + tools;
			float per = (float)totMarks/5;
			String result = null;
			
			if(per >70) result = "A";
			else if(per >60) result = "B";
			else if(per >50) result = "C";
			else if(per <50) result = "D";
			
			ps.setInt(1,coreJava);
			ps.setInt(2, advJava);
			ps.setInt(3, ui);
			ps.setInt(4, db);
			ps.setInt(5, tools);
			ps.setString(6, rollNo);
			int p  = ps.executeUpdate();
			
			if(p>0) {
				
				ps2.setInt(1, totMarks);
				ps2.setFloat(2, per);
				ps2.setString(3, result);
				ps2.setString(4,rollNo );
				
				k = ps2.executeUpdate();
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return k;
	}
}
