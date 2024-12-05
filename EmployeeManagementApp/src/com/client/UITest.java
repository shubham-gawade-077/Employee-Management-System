package com.client;

import java.util.Scanner;

import com.service.*;

public class UITest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeServiceI esi = new EmployeeSercviceImpI();
		while (true) {
			System.out.println("***EmployeeManagementApp***");
			System.out.println("1.Add Employee");
			System.out.println("2.View Employee");
			System.out.println("3.Update Employee");
			System.out.println("4.Delete Employee");
			System.out.println("5.Create table");
			System.out.println("6.Drop Table");
			System.out.println("Enter your Chice");

			int ch = sc.nextInt();
			if (ch == 1) {
				esi.addEmployee();
			} else if (ch == 2) {
				esi.viewEmployee();
			} else if (ch == 3) {
				esi.updateEmployee();
			} else if (ch == 4) {
				esi.deleteEmployee();
			} else if (ch == 5) {
				esi.createTable();
			} else if (ch == 6) {
				esi.dropTable();
			} else {
				System.out.println("wrong choice");
			}
		}
	}
}
