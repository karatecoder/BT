package com.gui.budgettracker;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.custom.CLabel;


public class BadLoginDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Button btnNewButton_1;
	private String message;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public BadLoginDialog(Shell parent, int style, String message) {
		super(parent, style);
		setText("SWT Dialog");
		this.message = message;
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.SHELL_TRIM);
		shell.setSize(240, 120);
		shell.setText(getText());
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				shell.dispose();
			}
		});
		btnNewButton.setBounds(66, 47, 96, 25);
		btnNewButton.setText("OK");
		
		CLabel lblNewLabel = new CLabel(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 204, 31);
		lblNewLabel.setText(message);


	}
}
