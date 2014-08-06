package com.gui.budgettracker;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
//import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.custom.CLabel;

import com.components.budgettracker.DBConnection;
import com.connectivity.com.User;

public class LoginScreen {

	protected Shell shell;
	private Text text;
	private Text text_1;
	Display display;

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

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(200, 199);
		shell.setText("SWT Application");
		shell.setLayout(null);

		text = new Text(shell, SWT.BORDER);
		text.setBounds(10, 45, 164, 21);

		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(10, 99, 164, 21);

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				String user = text.getText();
				String pass = text_1.getText();

				text.setText("");
				text_1.setText("");

				if (checkLogin(user, pass)) {
					User localUser = new User(user);
					display.dispose();
					(new MainPage(localUser)).open();
				} 
				else {
					BadLoginDialog bld = new BadLoginDialog(shell, 0, "Invalid username or password");
					bld.open();
				}

			}
		});

		btnNewButton.setBounds(10, 126, 75, 25);
		btnNewButton.setText("Login");

		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				shell.dispose();

			}
		});
		btnNewButton_1.setBounds(99, 126, 75, 25);
		btnNewButton_1.setText("Cancel");

		CLabel lblNewLabel_1 = new CLabel(shell, SWT.NONE);
		lblNewLabel_1.setBounds(10, 10, 82, 21);
		lblNewLabel_1.setText("Username");

		CLabel lblNewLabel_2 = new CLabel(shell, SWT.NONE);
		lblNewLabel_2.setBounds(10, 72, 164, 21);
		lblNewLabel_2.setText("Password");

		Button btnNewButton_4 = new Button(shell, SWT.NONE);
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				display.dispose();
			 (new SignUP()).open();
				
			}
		});
		btnNewButton_4.setBounds(99, 10, 75, 25);
		btnNewButton_4.setText("Sign up");

	}

	protected boolean checkLogin(String user, String pass) {

		DBConnection myCon = new DBConnection();
		return myCon.checkUser(user, pass);

	}
}
