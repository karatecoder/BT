package com.components.budgettracker;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.connectivity.com.User;
import com.gui.budgettracker.*;

public class DBConnection {

	private Connection con;
	private Statement st;
	private ResultSet rs;

	public DBConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/moneytracker", "root", "");
			st = con.createStatement();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void getAllData() {
		try {
			String query = "SELECT * FROM user";
			rs = st.executeQuery(query);
			System.out.println("Results are: ");
			while (rs.next()) {
				String name = rs.getString("userName");
				String pass = rs.getString("userPassword");
				System.out.println("Name :" + name + " pass: " + pass);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addUser(String username, String password, String country) {

		try {

			String condQuery = "SELECT userName from user where userName = \""
					+ username + "\"";

			rs = st.executeQuery(condQuery);
			;

			if (rs.next())
				System.out.println("Exista!!!");
			else {
				String query = "INSERT INTO user (userName, userPassword, country) VALUES (\""
						+ username
						+ "\",\""
						+ password
						+ "\",\""
						+ country
						+ "\")";
				st.execute(query);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addExpense(String category, int amount, String currentTime, String description, String user) {
		
		try{
			
			String query = "INSERT INTO " + user + " (amount, Category, TransactionDate, Description) VALUES ("
					+ amount
					+ ",\""
					+ category
					+ "\",\""
					+ currentTime
					+ "\",\""
					+ description
					+ "\")";
			System.out.println(query);
			st.execute(query);
			
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}

	}

	public boolean checkUser(String username, String password) {

		String condQuery = "SELECT userName from user where userName = \""
				+ username + "\" and userPassword = \"" + password + "\"";

		System.out.println(condQuery);
		try {
			rs = st.executeQuery(condQuery);
			if (rs.next())
				return true;
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// just in case
		return false;
	}

	public void createTable(String username) {

		String query = "CREATE TABLE `moneytracker`.`"
				+ username.toLowerCase()
				+ "` ( `idTransaction` INT NOT NULL AUTO_INCREMENT, `amount` INT NULL, `Category` VARCHAR(45) NULL, `TransactionDate` DATE NULL, `Description` VARCHAR(45) NULL, PRIMARY KEY (`idTransaction`));";

		try {
			System.out.println(query);
			st.execute(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
