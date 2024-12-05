package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.model.Employee;

public class EmployeeSercviceImpI implements EmployeeServiceI {
	Scanner sc = new Scanner(System.in);

	@Override
	public void addEmployee() {
		// TODO Auto-generated method stub
		Employee e = new Employee();
		System.out.println("enter eid");
		e.setEid(sc.nextInt());
		System.out.println("enter name");
		e.setName(sc.next());
		System.out.println("enter username");
		e.setUsername(sc.next());
		System.out.println("enter password");
		e.setPassword(sc.next());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			String sql = "insert into employee1 values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, e.getEid());
			ps.setString(2, e.getName());
			ps.setString(3, e.getUsername());
			ps.setString(4, e.getPassword());
			ps.executeUpdate();
			System.out.println("Employee added successfully...");

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void viewEmployee() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			String sql = "select * from Employee1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void updateEmployee() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			String sql = "update employee1 set name=?,username=?,password=? where eid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("enter eid");
			ps.setInt(1, sc.nextInt());
			System.out.println("enter name");
			ps.setString(2, sc.next());
			System.out.println("enter username");
			ps.setString(3, sc.next());
			System.out.println("enter password");
			ps.setString(4, sc.next());
			ps.executeUpdate();
			System.out.println("Employee update successfully...");

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createTable() {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			String sql = "create table employee1(eid int primary key,ename varchar(30),username varchar(30),password varchar(30))";
			Statement smt = con.createStatement();
			smt.execute(sql);
			System.out.println("table created");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void dropTable() {
		// TODO Auto-generated method stub

	}

}
