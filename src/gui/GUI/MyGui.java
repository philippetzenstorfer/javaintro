package gui.GUI;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import data.Mensch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MyGui {

	protected Shell shell;
	private Text vorname_textfeld;
	private Label lblNachname;
	private Text nachname_textfeld;
	private Label lbladresse;
	private Text adresse_textfeld;
	private Text plz_textfeld;
	private Label lblOrt;
	private Text ort_textfeld;
	private Button btnSave;


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MyGui window = new MyGui();
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
		shell.setSize(538, 392);
		shell.setText("SWT Application");
		
		Label lblVorname = new Label(shell, SWT.NONE);
		lblVorname.setBounds(29, 33, 46, 15);
		lblVorname.setText("Vorname");
		
		Button btnOkayd = new Button(shell, SWT.NONE);
		btnOkayd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//System.out.println(getVorname().getText());
			    //System.out.println(getNachname().getText());
				//System.out.println(getAdresse().getText());
                //Person p= new Person();
				try {
				Mensch m = new Mensch(vorname_textfeld.getText(),nachname_textfeld.getText(),Integer.parseInt(plz_textfeld.getText()),adresse_textfeld.getText(),ort_textfeld.getText()); 
					System.out.println(m);
				Mensch.getMenschlist().add(m);
				int i;
				for(i = 0; i < Mensch.getMenschlist().size(); i++) {
					System.out.println(Mensch.getMenschlist().get(i));
				}
				clearMask();
				//
				try {
					Writer writer1 = new FileWriter("C:\\temp\\output.json");
					Gson gson1 = new GsonBuilder().serializeNulls().create();
					gson1.toJson(Mensch.getMenschlist(), writer1);
					writer1.flush();
					writer1.close();
				} catch (IOException ioe1) {
					ioe1.printStackTrace();
				}
				
				
			}catch(NumberFormatException nfe) {
				MessageBox fehler = new MessageBox(shell, SWT.ICON_ERROR|SWT.OK);
				fehler.setText("Fehler");
				fehler.setMessage("du bist ein großer fehler - in deiner Postleitzahl ist ein Buchstabe ungleich + oder -");
				fehler.open();
				
				System.out.println("Das Hinweißfeld fehler wurde geschlossen.");
			}
		}
		}
			);
		btnOkayd.setBounds(66, 194, 75, 25);
		btnOkayd.setText("OKAY :D");
		
		setVorname(new Text(shell, SWT.BORDER));
		getVorname().setBounds(98, 30, 215, 21);
		
		lblNachname = new Label(shell, SWT.NONE);
		lblNachname.setText("Nachname");
		lblNachname.setBounds(29, 65, 56, 15);
		
		nachname_textfeld = new Text(shell, SWT.BORDER);
		nachname_textfeld.setBounds(98, 62, 215, 21);
		
		lbladresse = new Label(shell, SWT.NONE);
		lbladresse.setText("Adresse");
		lbladresse.setBounds(29, 96, 46, 15);
		
		adresse_textfeld = new Text(shell, SWT.BORDER);
		adresse_textfeld.setBounds(98, 93, 215, 21);
		
		plz_textfeld = new Text(shell, SWT.BORDER);
		plz_textfeld.setBounds(98, 126, 215, 21);
		
		Label lblPlz = new Label(shell, SWT.NONE);
		lblPlz.setBounds(38, 132, 37, 15);
		lblPlz.setText("PLZ");
		
		lblOrt = new Label(shell, SWT.NONE);
		lblOrt.setText("Ort");
		lblOrt.setBounds(48, 156, 27, 15);
		
		ort_textfeld = new Text(shell, SWT.BORDER);
		ort_textfeld.setBounds(98, 153, 215, 21);
		
		Button btnAus = new Button(shell, SWT.NONE);
		btnAus.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		btnAus.setBounds(228, 194, 75, 25);
		btnAus.setText("Aus");
		
		btnSave = new Button(shell, SWT.NONE);
		btnSave.setBounds(189, 285, 75, 25);
		btnSave.setText("Save");
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Mensch.SaveList();
					
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				MessageBox save = new MessageBox(shell, SWT.ICON_INFORMATION|SWT.OK);
				save.setText("ListSave");
				save.setMessage("Bis jetzt " + Mensch.getMenschlist().size() + " gespeicherte Kontakte." );
				save.open();

			}
		});
		btnSave.setBounds(202, 194, 75, 25);
		btnSave.setText("Save");
		
		Button btnRead = new Button(shell, SWT.NONE);
		btnRead.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Mensch.ReadList();
					
					
				} catch (FileNotFoundException e1) {
					System.out.println("Fehler!");
				}
			}
		});
		btnRead.setBounds(10, 318, 75, 25);
		btnRead.setText("Read");
		
		
	}
	protected void clearMask() {
		adresse_textfeld.setText("");
		vorname_textfeld.setText("");
		nachname_textfeld.setText("");
		plz_textfeld.setText("");
		ort_textfeld.setText("");
	}

	protected Text getVorname() {
		return vorname_textfeld;
	}

	public void setVorname(Text vorname) {
		this.vorname_textfeld = vorname;
	}
	protected Text getNachname() {
		return nachname_textfeld;
	}
	public void setNachname(Text nachname) {
		this.nachname_textfeld = nachname;
	}
	protected Text getAdresse( ) {
		return adresse_textfeld;
	}
	public void setAdresse(Text adresse) {
		this.adresse_textfeld = adresse;
	}
	protected Text getPlz_textfeld() {
		return plz_textfeld;
	}	
	public Text getOrt_textfeld() {
		return ort_textfeld;
	}
	public Button getBtnSave() {
		return btnSave;
	}
}
