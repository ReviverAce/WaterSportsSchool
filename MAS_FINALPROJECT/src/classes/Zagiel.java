package classes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.Session;

import enumy.Stan;
//zrobiona
@Entity(name = "zagiel")
@DiscriminatorValue(value = "zagiel")
public class Zagiel extends Pednik {
	@Column(name="rozmiar")
	private int rozmiar;
	@Column(name="typ")
	private String typ;
	
	public Zagiel() {
		
	}
	
	public Zagiel(String marka, Stan stan, int cena, String kategoria,int rozmiar,String typ){
		super(marka,stan,cena,kategoria);
		this.typ=typ;
		this.rozmiar=rozmiar;
	}

	public static Sprzet dodajSprzet(String marka, Stan stan, int cena, String kategoria, int rozmiar, String typ) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Sprzet s = new Zagiel(marka, stan, cena, kategoria, rozmiar, typ);
		session.save(s);
		session.getTransaction().commit();
		return s;
	}

	public static void usunSprzet(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from Wypozyczenie where sprzet_id=" + id).executeUpdate();
		session.createQuery("delete from Sprzet where id=" + id).executeUpdate();
		session.getTransaction().commit();
	}

	public int getRozmiar() {
		return rozmiar;
	}

	public void setRozmiar(int rozmiar) {
		this.rozmiar = rozmiar;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public static void showRecords() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Sprzet> list = session.createQuery("from Sprzet where type='zagiel'").getResultList();
		for(Sprzet os : list) {
			System.out.println(os);
		}
		session.getTransaction().commit();
	}

	@Override
	public String toString() {
		return Zagiel.class.getSimpleName() + " : #" + getId();
	}
}
