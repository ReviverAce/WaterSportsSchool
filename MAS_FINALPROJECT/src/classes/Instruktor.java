package classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import org.hibernate.Session;

import enumy.Stopien;

//zrobiona
@Entity(name = "instruktor")
@DiscriminatorValue(value = "instruktor")
public class Instruktor extends Osoba {

	@Column(name = "stawka")
	private int stawka;
	@Enumerated(EnumType.STRING)
	private Stopien stopien;

	@OneToMany(mappedBy = "instruktor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Kursant> kursanci;

	@OneToMany(mappedBy = "instruktor", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Lekcja> lekcja;

	public Instruktor() {

	}

	public Instruktor(String imie, String nazwisko, String telefon, int stawka, Stopien stopien) {
		super(imie, nazwisko, telefon);
		this.stawka = stawka;
		this.stopien = stopien;
		this.kursanci = new ArrayList<Kursant>();
		this.lekcja = new ArrayList<Lekcja>();
	}

	public void dodajKursanta(Kursant newKursant) {
		if (!kursanci.contains(newKursant)) {
			if (newKursant != null) {
				kursanci.add(newKursant);
				newKursant.setInstruktor(this);
			}
		}
	}

	public void usunKursanta(Kursant removedKursant) {
		if (kursanci.contains(removedKursant)) {
			kursanci.remove(removedKursant);
			((Kursant) removedKursant).removeInstruktor(this);
		}
	}

	public void dodajLekcje(Lekcja newLekcja) {
		if (!lekcja.contains(newLekcja)) {
			if (newLekcja != null) {
				lekcja.add(newLekcja);
				newLekcja.setInstruktor(this);
			}
		}
	}

	public void usunLekcje(Lekcja removedLekcja) {
		if (lekcja.contains(removedLekcja)) {
			lekcja.remove(removedLekcja);
			removedLekcja.removeInstruktor(this);
		}
	}

	public List<Kursant> getKursanci() {
		return kursanci;
	}

	public void setKursanci(List<Kursant> kursanci) {
		this.kursanci = kursanci;
	}

	public List<Lekcja> getLekcja() {
		return lekcja;
	}

	public void setLekcja(List<Lekcja> lekcja) {
		this.lekcja = lekcja;
	}

	public int getStawka() {
		return stawka;
	}

	public void setStawka(int stawka) throws Exception {
		if (stawka < 0) {
			throw new Exception("Stawka nie może być mniejsza od zera");
		} else {
			this.stawka = stawka;
		}
	}

	public Stopien getStopien() {
		return stopien;
	}

	public void setStopien(Stopien stopien) {
		this.stopien = stopien;
	}

	public static Osoba dodajOsoba(String imie, String nazwisko, String telefon, int stawka, Stopien stopien) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Osoba o = new Instruktor(imie, nazwisko, telefon, stawka, stopien);
		session.save(o);
		session.getTransaction().commit();
		return o;
	}

	public static void usunOsoba(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from Lekcja where instruktor_id=" + id).executeUpdate();
		session.createQuery("delete from Osoba where id=" + id).executeUpdate();
		session.getTransaction().commit();
	}

	@Override
	public String toString() {
		return Instruktor.class.getSimpleName() + " : " + getImie() + " " + getNazwisko();
	}

}
