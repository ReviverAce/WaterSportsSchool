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
@Entity(name = "wioslo")
@DiscriminatorValue(value = "wioslo")
public class Wioslo extends Sprzet{

	@Column(name = "dlugosc")
	private int dlugosc;
	
	public Wioslo() {
		
	}
	
	public Wioslo(String marka, Stan stan, int cena, String kategoria,int dlugosc){
		super(marka,stan,cena,kategoria);
		this.dlugosc=dlugosc;
	}

	public static Sprzet dodajSprzet(String marka, Stan stan, int cena, String kategoria, int dlugosc) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Sprzet s = new Wioslo(marka,stan,cena,kategoria,dlugosc);
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

	public int getDlugosc() {
		return dlugosc;
	}

	public void setDlugosc(int dlugosc) {
		this.dlugosc = dlugosc;
	}

	public static void showRecords() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Sprzet> list = session.createQuery("from Sprzet where type='wioslo'").getResultList();
		for(Sprzet os : list) {
			System.out.println(os);
		}
		session.getTransaction().commit();
	}

	@Override
	public String toString() {
		return Wioslo.class.getSimpleName() + " : #" + getId();
	}
	
}
