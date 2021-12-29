package com.test.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.test.bean.Student;

public class StudentService {
	Connection con;
	Student stud;
	Boolean b;
	public void addStuent(Student stud)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","Sury@171");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("kk");
			e.printStackTrace();
		}
//		try {
//			PreparedStatement pst=con.prepareStatement("insert into studentinfo (name,roll) values(?,?)");
//			pst.setString(1,stud.getName());
//			pst.setInt(2, stud.getRoll());
//			Boolean b=pst.execute();
//			this.b=b;
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return this.b;
		
	}
//	public List<Student> getAllStudents()
//	{
//		
//	}

}
