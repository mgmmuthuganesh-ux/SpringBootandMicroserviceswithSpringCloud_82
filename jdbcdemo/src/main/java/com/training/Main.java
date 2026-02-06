package com.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springboot_microservices", "root",
					"admin");
			//Statement stmt = con.createStatement();
			//stmt.execute("insert into account values(456,1000,'anand')");
			con.setAutoCommit(false);
			
			System.out.println("DEBIT ACCOUNT :: ");
			Scanner sc = new Scanner(System.in);
			Integer fromaccount  = sc.nextInt();
			
			System.out.println("CREDIT ACCOUNT :: ");
			Integer toAccouint  = sc.nextInt();
			
			System.out.println("AMMOUNT TRANSFER :: ");
			Integer ammounttransfer  = sc.nextInt();
			
			PreparedStatement pstmt = con.prepareStatement("select * from account where acnum=?");
			pstmt.setInt(1, fromaccount);
			ResultSet rs= pstmt.executeQuery();
			rs.next();
			int debitBalance = rs.getInt("balance");
			
			pstmt.setInt(1, toAccouint);
			ResultSet rsac2= pstmt.executeQuery();
			rsac2.next();
			int creditBalance = rsac2.getInt("balance");
			
			if(debitBalance>=ammounttransfer) {
				//debit frist
				debitBalance =  debitBalance - ammounttransfer;
				PreparedStatement pstmt1 = con.prepareStatement("update account set balance=? where acnum = ?");
				pstmt1.setInt(1, debitBalance);
				pstmt1.setInt(2, fromaccount);
				pstmt1.execute(); //commit
				
				System.out.println(3/0);
				//credit second
				creditBalance = creditBalance+ammounttransfer;
				PreparedStatement pstmt2 = con.prepareStatement("update account set balance=? where acnum = ?");
				pstmt2.setInt(1, creditBalance);
				pstmt2.setInt(2, toAccouint);
				pstmt2.execute();
				con.commit();
				System.out.println("============== AMOUNT TRANSFERRED =========");
			}else {
				System.out.println("Insuffecient Balance");
			}
			
			
			con.close();
		} catch (Exception e) {
			System.out.println("====== FAILED TO TRANSFER =======");
			e.printStackTrace();
		}
	}
}
