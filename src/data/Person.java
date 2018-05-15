package data;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Person {
	
	
	
	private String vorname;
	private String nachname;
	private String adresse;
	private int plz;
	
	private static ArrayList<Person> PersonenListe = new ArrayList<>();
	
	
	public String toString() {
		return getVorname() + " " + getNachname() + " " + getAdresse() + " " + getPLZ(); 
	}
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getPLZ() {
		return plz;
	}
	public void setPLZ(int plz) {
		this.plz = plz;
		
		
	}

	public static ArrayList<Person> getPersonenListe() {
		return PersonenListe;
	}

	public static void setPersonenListe(ArrayList<Person> personenListe) {
		PersonenListe = personenListe;
	}
	public static void write2JSON() throws IOException {
		Writer writer = new FileWriter("C:\\temp\\output.json");
		Gson gson = new GsonBuilder().serializeNulls().create();
		gson.toJson(Person.getPersonenListe(), writer);
		writer.flush();
		writer.close();

	}
	
	public static void readFromJSON() {
		//personenListe = readFromJSON

	
	
	
	
	
	
	
	}
	
}

