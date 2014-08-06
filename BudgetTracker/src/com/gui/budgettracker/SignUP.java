package com.gui.budgettracker;

import com.components.budgettracker.DBConnection;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;

public class SignUP {

	protected Shell shell;
	private Text text;
	private Text text_2;
	private Text text_1;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SignUP window = new SignUP();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
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
		shell.setSize(450, 300);
		shell.setText("SWT Application");

		CLabel lblUsername = new CLabel(shell, SWT.NONE);
		lblUsername.setBounds(57, 116, 86, 21);
		lblUsername.setText("Username:");

		CLabel lblPassword = new CLabel(shell, SWT.NONE);
		lblPassword.setBounds(57, 152, 61, 21);
		lblPassword.setText("Password:");

		CLabel lblCreateANew = new CLabel(shell, SWT.NONE);
		lblCreateANew.setBounds(141, 40, 180, 21);
		lblCreateANew.setText("Create a new user");

		text = new Text(shell, SWT.BORDER);
		text.setBounds(177, 116, 86, 21);

		Button btnSignUp = new Button(shell, SWT.NONE);
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				DBConnection myCon = new DBConnection();
				String username = text.getText();
				String pass = text_1.getText();
				String country = text_2.getText();

				if (myCon.checkUser(username, pass)) {
					BadLoginDialog bld = new BadLoginDialog(shell, 0,
							"Username already exsits!");
					bld.open();
				} else {
					myCon.addUser(username, pass, country);
					myCon.createTable(username);
				}

			}
		});

		btnSignUp.setBounds(330, 211, 75, 25);
		btnSignUp.setText("Sign up !");

		CLabel lblCountry = new CLabel(shell, SWT.NONE);
		lblCountry.setBounds(57, 192, 61, 21);
		lblCountry.setText("Country");

		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(177, 192, 86, 21);
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(177, 152, 86, 21);

	}
}
