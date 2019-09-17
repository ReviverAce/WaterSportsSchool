package classes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.Session;

import enumy.Stan;
import enumy.TypBom;
import enumy.TypMaszt;
//zrobiona
@Entity(name = "bom")
@DiscriminatorValue(value = "bom")
public class Bom extends Pednik{

	@Column(name="dlugosc")
	private int dlugosc;
	@Enumerated(EnumType.STRING)
	private TypBom typBom;
	
	public Bom() {
		
	}
	
	public Bom(String marka, Stan stan, int cena, String kategoria,int zakres,TypBom typBom){
		super(marka,stan,cena,kategoria);
		this.dlugosc=zakres;
		this.typBom=typBom;
	}

	public static Sprzet dodajSprzet(String marka, Stan stan, int cena, String kategoria, int zakres,TypBom typBom) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Sprzet s = new Bom(marka, stan, cena, kategoria, zakres, typBom);
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

	public int getDlugosc() {
		return dlugosc;
	}

	public void setDlugosc(int dlugosc) {
		this.dlugosc = dlugosc;
	}

	public TypBom getTypBom() {
		return typBom;
	}

	public void setTypBom(TypBom typBom) {
		this.typBom = typBom;
	}

	public static void showRecords() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Sprzet> list = session.createQuery("from Sprzet where type='bom'").getResultList();
		for(Sprzet os : list) {
			System.out.println(os);
		}
		session.getTransaction().commit();
	}
	
	@Override
	public String toString() {
		return Bom.class.getSimpleName() + " : #" + getId();
	}

}
