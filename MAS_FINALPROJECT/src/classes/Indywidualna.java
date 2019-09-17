package classes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.Session;

import enumy.RodzajGrupa;
import enumy.TypLekcja;

//zrobiona
@Entity(name = "indywidualna")
@DiscriminatorValue(value = "indywidualna")
public class Indywidualna extends Lekcja {

	public Indywidualna() {

	}

	public Indywidualna(int cena, LocalDate dataLekcji, TypLekcja typLekcja, String spot, Instruktor instruktor,
			Kursant kursant) {
		super(cena, dataLekcji, typLekcja, spot, instruktor, kursant);
	}

	public static Lekcja dodajLekcje(int cena, LocalDate dataLekcji, TypLekcja typLekcja, String spot,
			Instruktor instruktor, Kursant kursant) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Lekcja l = new Indywidualna(cena, dataLekcji, typLekcja, spot, instruktor, kursant);
		session.save(l);
		session.getTransaction().commit();
		return l;
	}

	public static void usunLekcje(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from Lekcja where id=" + id).executeUpdate();
		session.getTransaction().commit();
	}

	public static void showRecords() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Indywidualna> list = session.createQuery("from Lekcja where type='indywidualna'").getResultList();
		for (Indywidualna os : list) {
			System.out.println(os);
		}
		session.getTransaction().commit();
	}

//	@Override
//	public String toString() {
//		return Lekcja.class.getSimpleName() + " --- cena: " + getCena() + " | typ: " + getTypLekcja() + " | spot: "
//				+ getSpot() + " | Instruktor: " + getInstruktor().getImie() + " " + getInstruktor().getNazwisko();
//	}
	
	@Override
	public String toString() {
		return Lekcja.class.getSimpleName()+" Data: "+getDataLekcji();
	}

}
