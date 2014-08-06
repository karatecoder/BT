package com.components.budgettracker;

import com.gui.budgettracker.LoginScreen;

public class BudgetTracker {

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			LoginScreen window = new LoginScreen();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
