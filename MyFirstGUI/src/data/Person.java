package data;

import java.util.ArrayList;

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
	

	
	
	
	
	
	
	
	
	
}

