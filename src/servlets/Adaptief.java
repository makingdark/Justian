package servlets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import domein.Antwoord;
import domein.Vraag;
import DAO.VraagDAO;

public class Adaptief implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 592535668166401344L;
	private static ArrayList<Vraag> vr;
	private static ArrayList<Integer> set1;
	private static ArrayList<Integer> set2;
	private static ArrayList<Integer> set3;
	
	public static ArrayList<Integer> set1(ArrayList<Vraag> vragen) {
		vr = vragen;
		set1  = new ArrayList<Integer>();
		int meet = 0;
		int verband = 0;
		int verhouding = 0;
		int getal = 0;
		Collections.shuffle(vr);

		for (Vraag v : vr) {
			if (v.getType().equals("meet")) {
				if (meet < 5) {
					meet++;
					set1.add(v.getNummer());
				}
			}
			if (v.getType().equals("verband")) {
				if (verband < 5) {
					verband++;
					set1.add(v.getNummer());
				}
			}
			if (v.getType().equals("getal")) {
				if (getal < 5) {
					getal++;
					set1.add(v.getNummer());
				}
			}
			if (v.getType().equals("verhouding")) {
				if (verhouding < 5) {
					verhouding++;
					set1.add(v.getNummer());
				}
			}
		}
		// for (Vraag vraag : set) {
		// vr.remove(vraag);
		// }
		return set1;
	}

	/**
	 * deze methode berekend de 2e set vragen nadat er 20 antwoorden staan in de
	 * datastore
	 * <p>
	 * Er wordt per vraag gekeken of deze juist is beantwoord<br>
	 * vervolgens wordt per categorie het aantal fouten bijgehouden<br>
	 * en er wordt een nieuwe vraag van de betreffende categorie toegevoegd aan
	 * de 2e set vragen.<br>
	 * Daarna worden alle fouten bij elkaar opgeteld en van het totaal getal
	 * afgetrokken zo wordt er een restwaarde gecreeerd. aan de hand van de
	 * restwaarde worden er meer vragen van een categorie toegevoegd
	 * 
	 * @param antwoorden
	 * @param set
	 * @return ArrayList set2
	 */
	public static ArrayList<Integer> set2(ArrayList<Antwoord> antwoorden, ArrayList<Vraag> set) {
		int meet = 0;
		int verband = 0;
		int verhouding = 0;
		int getal = 0;
		int totaal = set.size();		
		vr = set;
		System.out.println("set2" + vr);
		set2 = new ArrayList<Integer>();
		for (int i = 0; i < totaal-1; i++) {
			if (antwoorden != null) {
				System.out.println("i " + i);
				Boolean antwoord = antwoorden.get(i).checkAntwoord();
				// als antwoord onjuist is
				if (!antwoord) {
					if (set.get(i).getType().equals("meet")) {
						addVraag2("meet");
						meet++;
					}
					if (set.get(i).getType().equals("verband")) {
						addVraag2("verband");
						verband++;
					}
					if (set.get(i).getType().equals("getal")) {
						addVraag2("getal");
						getal++;
					}
					if (set.get(i).getType().equals("verhouding")) {
						addVraag2("verhouding");
						verhouding++;
					}
				}
			}
		}
		ArrayList<Integer> type = new ArrayList<Integer>();
		type.add(meet);
		type.add(verband);
		type.add(getal);
		type.add(verhouding);
		Collections.sort(type);
		for(int i=0; i< 4; i++){
			if(type.get(i)==0){
				type.add(i, 1);
			}
		}
		int aantalFout = (type.get(0) + type.get(1) + type.get(2) + type.get(3));
		int restAantal = totaal - aantalFout;		
		for (int i = 0; i < restAantal; i++) {
			int hoogst = type.get(3);
			if (hoogst == meet && restAantal>0) {
				addVraag2("meet");
				restAantal--;
				meet--;
			}
			if (hoogst == verband && restAantal>0) {
				addVraag2("verband");
				restAantal--;
				verband--;
			}
			if (hoogst == getal && restAantal>0) {
				addVraag2("getal");
				restAantal--;
				getal--;
			}
			if (hoogst == verhouding && restAantal>0) {
				addVraag2("verhouding");
				restAantal--;
				verhouding--;
			}
			
			type.add(meet);
			type.add(verband);
			type.add(getal);
			type.add(verhouding);
			Collections.sort(type);			
		}
		return set2;
	}
	
	/**
	 * deze methode berekend de 3e set vragen nadat er 40 antwoorden staan in de
	 * datastore
	 * <p>
	 * Er wordt per vraag gekeken of deze juist is beantwoord<br>
	 * vervolgens wordt per categorie het aantal fouten bijgehouden<br>
	 * en er wordt een nieuwe vraag van de betreffende categorie toegevoegd aan
	 * de 3e set vragen.<br>
	 * Daarna worden alle fouten bij elkaar opgeteld en van het totaal getal
	 * afgetrokken zo wordt er een restwaarde gecreeerd. aan de hand van de
	 * restwaarde worden er meer vragen van een categorie toegevoegd
	 * 
	 * @param antwoorden
	 * @param set
	 * @return ArrayList set3
	 */
	public static ArrayList<Integer> set3(ArrayList<Antwoord> antwoorden, ArrayList<Vraag> set) {
		int meet = 0;
		int verband = 0;
		int verhouding = 0;
		int getal = 0;
		int totaal = set.size();		
		vr = set;
		set3 = new ArrayList<Integer>();
		for (int i = 20; i < totaal-1; i++) {
			if (!antwoorden.isEmpty()) {
				Boolean antwoord = antwoorden.get(i).checkAntwoord();
				System.out.println("antwoord " + antwoorden.get(i));
				// als antwoord onjuist is
				if (!antwoord) {
					if (set.get(i).getType().equals("meet")) {
						addVraag3("meet");
						meet++;
					}
					if (set.get(i).getType().equals("verband")) {
						addVraag3("verband");
						verband++;
					}
					if (set.get(i).getType().equals("getal")) {
						addVraag3("getal");
						getal++;
					}
					if (set.get(i).getType().equals("verhouding")) {
						addVraag3("verhouding");
						verhouding++;
					}
				}
			}
		}
		int aantalFout = meet + verband + verhouding + getal;
		int restAantal = 20 - aantalFout;
		ArrayList<Integer> type = new ArrayList<Integer>();
		type.add(meet);
		type.add(verband);
		type.add(getal);
		type.add(verhouding);
		Collections.sort(type);
		for (int i = 0; i < restAantal; i++) {
			int hoogst = type.get(3);
			if (hoogst == meet && restAantal>0) {
				addVraag3("meet");
				restAantal--;
				meet--;
			}
			if (hoogst == verband && restAantal>0) {
				addVraag3("verband");
				restAantal--;
				verband--;
			}
			if (hoogst == getal && restAantal>0) {
				addVraag3("getal");
				restAantal--;
				getal--;
			}
			if (hoogst == verhouding && restAantal>0) {
				addVraag3("verhouding");
				restAantal--;
				verhouding--;
			}			
			type.add(meet);
			type.add(verband);
			type.add(getal);
			type.add(verhouding);
			Collections.sort(type);			
		}
		return set3;
	}

	public static void addVraag2(String type) {
		for (Vraag vraag : vr) {
			if (vraag.getType().equals(type)) {
				set2.add(vraag.getNummer());	
				break;
			}			
		}
	}
	public static void addVraag3(String type) {
		for (Vraag vraag : vr) {
			if (vraag.getType().equals(type)) {
				set3.add(vraag.getNummer());	
				break;
			}			
		}
	}
}
