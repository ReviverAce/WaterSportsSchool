package classes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.Session;

import enumy.RozmiarPianka;
import enumy.Stan;
import enumy.TypPianka;
//zrobiona
@Entity(name = "deska")
@DiscriminatorValue(value = "deska")
public class Deska extends Sprzet{
	
	@Column(name = "wypornosc")
	private int wypornosc;
	@Column(name = "typ")
	private String typ;
	@Column(name = "dlugosc")
	private int dlugosc;
	@Column(name = "szerokosc")
	private int szerokosc;
	
	public Deska() {
		
	}
	
	public Deska(String marka, Stan stan, int cena, String kategoria,int wypornosc,String typ,int dlugosc, int szerokosc){
		super(marka,stan,cena,kategoria);
		this.wypornosc=wypornosc;
		this.typ=typ;
		this.dlugosc=dlugosc;
		this.szerokosc=szerokosc;
	}

	public static Sprzet dodajSprzet(String marka, Stan stan, int cena, String kategoria, int wypornosc,String typ,int dlugosc, int szerokosc) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Sprzet s = new Deska(marka,stan,cena,kategoria,wypornosc,typ,dlugosc,szerokosc);
		session.save(s);
		session.getTransaction().commit();
		return s;
	}
	
	public static void usunSprzet(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from Wypozyczenie where sprzet_id="+id).executeUpdate();
		session.createQuery("delete from Sprzet where id="+id).executeUpdate();
		session.getTransaction().commit();
	}

	public int getWypornosc() {
		return wypornosc;
	}

	public void setWypornosc(int wypornosc) {
		this.wypornosc = wypornosc;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public int getDlugosc() {
		return dlugosc;
	}

	public void setDlugosc(int dlugosc) {
		this.dlugosc = dlugosc;
	}

	public int getSzerokosc() {
		return szerokosc;
	}

	public void setSzerokosc(int szerokosc) {
		this.szerokosc = szerokosc;
	}

	public static void showRecords() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Sprzet> list = session.createQuery("from Sprzet where type='deska'").getResultList();
		for(Sprzet os : list) {
			System.out.println(os);
		}
		session.getTransaction().commit();
	}

	@Override
	public String toString() {
		return Deska.class.getSimpleName() + " : #" + getId();
	}

}
