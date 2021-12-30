package com.test.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.test.bean.Student;

public class StudentService {
	Connection con;
	Student stud;
	Boolean b;
	ArrayList<Student> ar;
	public boolean addStuent(Student stud)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Studentapp","root","******");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("kk");
			e.printStackTrace();
		}
		try {
			PreparedStatement pst=con.prepareStatement("insert into studentinfo (name,roll) values(?,?)");
			pst.setString(1,stud.getName());
			pst.setInt(2, stud.getRoll());
			Boolean b=pst.execute();
			this.b=b;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.b;
		
	}
	public List<Student> getAllStudents()
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Studentapp","root","******");
		PreparedStatement pst=con.prepareStatement("select * from studentinfo");
		ResultSet rs=pst.executeQuery();
		ar= new ArrayList<Student>();
		while(rs.next())
		{
			Student s=new Student();
			s.setName(rs.getString(1));
			s.setRoll(rs.getInt(2));
			ar.add(s);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ar;
		
	}

}
