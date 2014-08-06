package com.gui.budgettracker;

import com.components.budgettracker.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.ExpandItem;


public class Graph extends Shell {
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Graph shell = new Graph(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Graph(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(null);
		
		CLabel lblFilters = new CLabel(this, SWT.NONE);
		lblFilters.setBounds(10, 10, 61, 21);
		lblFilters.setText("Filters:");
		
		CLabel lblPrice = new CLabel(this, SWT.NONE);
		lblPrice.setBounds(10, 51, 61, 21);
		lblPrice.setText("Price:");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(77, 51, 76, 21);
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(159, 51, 76, 21);
		
		final Combo combo = new Combo(this, SWT.NONE);
		combo.setBounds(77, 78, 91, 23);
		combo.add("All");
		combo.add("Food");
		combo.add("Entertainment");
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				System.out.println(combo.getText());
			}
		});
		btnNewButton.setBounds(349, 227, 75, 25);
		btnNewButton.setText("Filter!");

		
		CLabel lblCategory = new CLabel(this, SWT.NONE);
		lblCategory.setBounds(10, 78, 61, 21);
		lblCategory.setText("Category");
		
		DateTime dateTime = new DateTime(this, SWT.BORDER);
		dateTime.setBounds(87, 107, 76, 24);
		
		DateTime dateTime_1 = new DateTime(this, SWT.BORDER);
		dateTime_1.setBounds(169, 107, 76, 24);
		
		CLabel lblDataRange = new CLabel(this, SWT.NONE);
		lblDataRange.setBounds(10, 105, 71, 21);
		lblDataRange.setText("Date range");		
		
		
		createContents();
		
		
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
