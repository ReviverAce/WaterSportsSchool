package main;

import java.awt.Dimension;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import classes.*;
import enumy.RodzajGrupa;
import enumy.RozmiarPianka;
import enumy.Stan;
import enumy.Stopien;
import enumy.TypBom;
import enumy.TypLekcja;
import enumy.TypMaszt;
import enumy.TypPianka;
import enumy.TypWypozyczenie;
import gui.Menu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		try {
			
//			//sprzet
//			Sprzet s1 = Wioslo.dodajSprzet("JP", Stan.WOLNY, 10, "Sup", 145);
//			Sprzet s2 = Pianka.dodajSprzet("Quiksilver", Stan.WOLNY, 10, "WaterSports", TypPianka.MESKA,RozmiarPianka.XL);
//			Sprzet s3 = Latawiec.dodajSprzet("Naish", Stan.WOLNY, 15, "Kitesurfing", 145,"Freestyle");
//			Sprzet s4 = Deska.dodajSprzet("Fanatic", Stan.WOLNY, 15, "Windsurfing", 110,"Freewave",180,55);
//			Sprzet s5 = Zagiel.dodajSprzet("NeilPryde", Stan.WOLNY, 25, "Windsurfing",8,"Combat");
//			Sprzet s6 = Maszt.dodajSprzet("Naish", Stan.WOLNY, 10, "WindSurfing", 420, TypMaszt.RDM);
//			Sprzet s7 = Bom.dodajSprzet("JP", Stan.WOLNY, 10, "Sup", 210, TypBom.CARBON);
//			Sprzet s8 = Wioslo.dodajSprzet("Fanatic", Stan.WOLNY, 5, "Sup", 145);
//			Sprzet s9 = Pianka.dodajSprzet("NeilPryde", Stan.WOLNY, 15, "WaterSports", TypPianka.DAMSKA,RozmiarPianka.M);
//			Sprzet s10 = Latawiec.dodajSprzet("Weish", Stan.WOLNY, 20, "Kitesurfing", 145,"Freestyle");
//			Sprzet s11 = Deska.dodajSprzet("JP", Stan.WOLNY, 15, "Windsurfing", 100,"Slalom",140,70);
//			Sprzet s12 = Zagiel.dodajSprzet("Starboard", Stan.WOLNY, 30, "Windsurfing",8,"Wizard");
//			Sprzet s13 = Maszt.dodajSprzet("Wing", Stan.WOLNY, 15, "WindSurfing", 420, TypMaszt.SDM);
//			Sprzet s14 = Bom.dodajSprzet("BIC", Stan.WOLNY, 15, "Sup", 210, TypBom.ALUMINIUM);
//			
//			//osoba
//			Osoba o1 = Instruktor.dodajOsoba("Jan","Kowalski","123434676",40,Stopien.ZAAWANSOWANY);
//			Osoba o2 = Klient.dodajOsoba("Zbigniew","Chrzan","857496704",200);
//			Osoba o3 = Kursant.dodajOsoba("Magda","Kopytko","374948574");
//			Osoba o4 = Instruktor.dodajOsoba("Mariusz","Stefarzyk","453879678",30,Stopien.PODSTAWOWY);
//			Osoba o5 = Klient.dodajOsoba("Olaf","Wysocki","148395732",400);
//			Osoba o6 = Kursant.dodajOsoba("Anna","Kraszewska","997884772");
//			Osoba o7 = Instruktor.dodajOsoba("Jerzy","Killer","123434676",50,Stopien.ZAAWANSOWANY);
//			Osoba o8 = Klient.dodajOsoba("Mariusz","Cackowski","857496704",300);
//			Osoba o9 = Kursant.dodajOsoba("Pawel","Rogala","374948574");
//			Osoba o10 = Instruktor.dodajOsoba("Stefan","Wronko","453879678",35,Stopien.SREDNIOZAAWANSOWANY);
//			Osoba o11 = Klient.dodajOsoba("Johny","Wick","148395732",800);
//			Osoba o12 = Kursant.dodajOsoba("Ryszard","Siarzewski","997884772");
//			
//			((Kursant) o3).setInstruktor((Instruktor) o1);
//			((Instruktor) o4).dodajKursanta((Kursant) o6);
//			((Instruktor) o7).dodajKursanta((Kursant) o9);
//			((Instruktor) o10).dodajKursanta((Kursant) o12);
//			((Instruktor) o10).dodajKursanta((Kursant) o9);
//			((Instruktor) o10).dodajKursanta((Kursant) o6);
//	
//			
//						
//			Osoba.updateOsoba(o3);
//			Osoba.updateOsoba(o4);
//			Osoba.updateOsoba(o10);
//			Osoba.updateOsoba(o7);
//			
//			//lekcja
//			Lekcja l1 = Indywidualna.dodajLekcje(80,LocalDate.now(), TypLekcja.GODZINA,"Zatoka Pucka",(Instruktor)o1,(Kursant)o3);
//			Lekcja l2 = Grupowa.dodajLekcje(150,LocalDate.now(),TypLekcja.SZESC_GODZIN,"Morze",(Instruktor)o10,(Kursant)o6,2,RodzajGrupa.SREDNIOZAAWANSOWANA);
//			Lekcja l3 = Indywidualna.dodajLekcje(100,LocalDate.now(),TypLekcja.DZIESIEC_GODZIN,"Morze",(Instruktor)o1,(Kursant)o3);
//			Lekcja l4 = Grupowa.dodajLekcje(200,LocalDate.now(),TypLekcja.GODZINA,"Zatoka Pucka",(Instruktor)o10,(Kursant)o12,2,RodzajGrupa.ZAAWANSOWANA);
//			Lekcja l5 = Indywidualna.dodajLekcje(50,LocalDate.now(),TypLekcja.SZESC_GODZIN,"Morze",(Instruktor)o1,(Kursant)o9);
//			Lekcja l6 = Grupowa.dodajLekcje(75,LocalDate.now(),TypLekcja.DZIESIEC_GODZIN,"Morze",(Instruktor)o7,(Kursant)o12,2,RodzajGrupa.PODSTAWOWA);
//			
//			//wypozyczenieKlient
//			Wypozyczenie wp1 = Wypozyczenie.dodajWypozyczenie(LocalDate.now(),TypWypozyczenie.DZIEN,s1,(Klient) o2);
//			Wypozyczenie wp2 = Wypozyczenie.dodajWypozyczenie(LocalDate.now(),TypWypozyczenie.GODZINA,s3,(Klient) o5);
//			Wypozyczenie wp3 = Wypozyczenie.dodajWypozyczenie(LocalDate.now(),TypWypozyczenie.POLDNIA,s5,(Klient) o8);
//			Wypozyczenie wp4 = Wypozyczenie.dodajWypozyczenie(LocalDate.now(),TypWypozyczenie.SIEDIEM_DNI,s7,(Klient) o11);
//			Wypozyczenie wp5 = Wypozyczenie.dodajWypozyczenie(LocalDate.now(),TypWypozyczenie.TRZY_DNI,s8,(Klient) o5);
//			Wypozyczenie wp6 = Wypozyczenie.dodajWypozyczenie(LocalDate.now(),TypWypozyczenie.POLDNIA,s10,(Klient) o8);
//			Wypozyczenie wp7 = Wypozyczenie.dodajWypozyczenie(LocalDate.now(),TypWypozyczenie.POLDNIA,s3,(Klient) o5);
//			
////			Klient.showRecords();
////			Kursant.showRecords();
////			Instruktor.showRecords();
////			Indywidualna.showRecords();
////			Grupowa.showRecords();
////			Bom.showRecords();
////			Deska.showRecords();
////			Zagiel.showRecords();
////			Wypozyczenie.showRecords();
						
			new HibernateUtil();
			Menu menu=new Menu(500,400,0,0,0,0);
						
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
