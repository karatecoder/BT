package com.gui.budgettracker;

import java.util.Calendar;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Combo;

import com.components.budgettracker.DBConnection;
import com.connectivity.com.User;

public class MainPage {
	protected Shell shlMainPage;
	private Table table;
	private Text text_6;
	private Text text_7;
	private User user;

	/**
	 * @wbp.parser.entryPoint
	 */
	public MainPage(User user) {
		this.user = user;
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	/*	public static void main(String[] args) {
		try {
			MainPage window = new MainPage();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	*/
	

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlMainPage.open();
		shlMainPage.layout();
		while (!shlMainPage.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlMainPage = new Shell();
		shlMainPage.setText("Main Page : Welcome " + user.getName());

		shlMainPage.setSize(780, 532);
		shlMainPage.setLayout(null);

		table = new Table(shlMainPage, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		Button btnCheckButton = new Button(shlMainPage, SWT.CHECK);
		btnCheckButton.setBounds(3, 450, 93, 16);
		btnCheckButton.setText("Received");

		text_6 = new Text(shlMainPage, SWT.BORDER);
		text_6.setBounds(134, 382, 93, 20);

		text_7 = new Text(shlMainPage, SWT.BORDER);
		text_7.setBounds(347, 352, 305, 85);

		DateTime dateTime = new DateTime(shlMainPage, SWT.BORDER);
		dateTime.setBounds(134, 352, 93, 24);

		CLabel lblDateOfShit = new CLabel(shlMainPage, SWT.NONE);
		lblDateOfShit.setBounds(10, 352, 86, 21);
		lblDateOfShit.setText("Date of shit");

		CLabel lblNewLabel = new CLabel(shlMainPage, SWT.NONE);
		lblNewLabel.setBounds(10, 382, 76, 21);
		lblNewLabel.setText("Value of shit");
		
		Combo combo = new Combo(shlMainPage, SWT.NONE);
		combo.setBounds(134, 408, 91, 23);
		combo.add("Food");
		combo.add("Health");
		combo.add("Personal");
		combo.add("Transport");
		combo.add("Leisure");

		Button btnNewButton_2 = new Button(shlMainPage, SWT.NONE);
		btnNewButton_2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseDown(MouseEvent e) {

				

				
				// get date
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, dateTime.getYear());
				cal.set(Calendar.MONTH, dateTime.getMonth());
				cal.set(Calendar.DAY_OF_MONTH, dateTime.getDay());
				Date myDate = cal.getTime();

				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
						"yyyy-MM-dd");
				String currentTime = sdf.format(myDate);
				System.out.println(currentTime);
				
			
				// other values
				String category = combo.getText();
				String description = text_7.getText();
				int value = Integer.parseInt(text_6.getText());
				
				//System.out.println(category + " " + description + " " + value);
				DBConnection myCon = new DBConnection();
				myCon.addExpense(category, value, currentTime, description, user.getName());
				

			}
		});

		btnNewButton_2.setBounds(667, 412, 75, 25);
		btnNewButton_2.setText("Enter");

		Button btnNewButton_3 = new Button(shlMainPage, SWT.NONE);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Graph a = new Graph(Display.getDefault());
				a.open();
				a.layout();
			}
		});
		btnNewButton_3.setBounds(667, 285, 75, 25);
		btnNewButton_3.setText("Plot");

		CLabel lblCategory = new CLabel(shlMainPage, SWT.NONE);
		lblCategory.setBounds(10, 409, 61, 21);
		lblCategory.setText("Category");



		CLabel lblDescription = new CLabel(shlMainPage, SWT.NONE);
		lblDescription.setBounds(259, 352, 82, 21);
		lblDescription.setText("Description");

	}

	public static class Filters {

		public Filters() {

		}

	}
}
