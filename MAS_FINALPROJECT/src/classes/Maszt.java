package classes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.Session;

import enumy.Stan;
import enumy.TypMaszt;
//zrobiona
@Entity(name = "maszt")
@DiscriminatorValue(value = "maszt")
public class Maszt extends Pednik{

	@Column(name="dlugosc")
	private int dlugosc;
	@Enumerated(EnumType.STRING)
	private TypMaszt typMaszt;
	
	public Maszt() {
		
	}
	
	public Maszt(String marka, Stan stan, int cena, String kategoria,int dlugosc,TypMaszt typMaszt){
		super(marka,stan,cena,kategoria);
		this.dlugosc=dlugosc;
		this.typMaszt=typMaszt;
	}

	public int getDlugosc() {
		return dlugosc;
	}

	public void setDlugosc(int dlugosc) {
		this.dlugosc = dlugosc;
	}

	public TypMaszt getTypMaszt() {
		return typMaszt;
	}

	public void setTypMaszt(TypMaszt typMaszt) {
		this.typMaszt = typMaszt;
	}

	public static Sprzet dodajSprzet(String marka, Stan stan, int cena, String kategoria, int dlugosc,TypMaszt typMaszt) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Sprzet s = new Maszt(marka, stan, cena, kategoria, dlugosc, typMaszt);
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
	
	public static void showRecords() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Sprzet> list = session.createQuery("from Sprzet where type='maszt'").getResultList();
		for(Sprzet os : list) {
			System.out.println(os);
		}
		session.getTransaction().commit();
	}

	@Override
	public String toString() {
		return Maszt.class.getSimpleName() + " : #" + getId();
	}

}
