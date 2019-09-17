package classes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.Session;

import enumy.RodzajGrupa;
import enumy.TypLekcja;

@Entity(name = "grupowa")
@DiscriminatorValue(value = "grupowa")
public class Grupowa extends Lekcja {

	@Column(name = "numer")
	private int numer;
	@Enumerated(EnumType.STRING)
	private RodzajGrupa rodzajGrupa;

	public Grupowa() {

	}

	public Grupowa(int cena, LocalDate dataLekcji,TypLekcja typLekcja, String spot, Instruktor instruktor, Kursant kursant, int numer,
			RodzajGrupa rodzajGrupa) {
		super(cena, dataLekcji, typLekcja, spot, instruktor, kursant);
		this.numer = numer;
		this.rodzajGrupa = rodzajGrupa;
	}

	public int getNumer() {
		return numer;
	}

	public void setNumer(int numer) {
		this.numer = numer;
	}

	public RodzajGrupa getRodzajGrupa() {
		return rodzajGrupa;
	}

	public void setRodzajGrupa(RodzajGrupa rodzajGrupa) {
		this.rodzajGrupa = rodzajGrupa;
	}

	public static Lekcja dodajLekcje(int cena, LocalDate dataLekcji,TypLekcja typLekcja, String spot, Instruktor instruktor, Kursant kursant,
			int numer, RodzajGrupa rodzajGrupa) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Lekcja l = new Grupowa(cena, dataLekcji, typLekcja, spot, instruktor, kursant, numer, rodzajGrupa);
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
		List<Grupowa> list = session.createQuery("from Lekcja where type='grupowa'").getResultList();
		for(Grupowa os : list) {
			System.out.println(os);
		}
		session.getTransaction().commit();
	}

//	@Override
//	public String toString() {
//		return Lekcja.class.getSimpleName()+" --- cena: "+getCena()+" | typ: "+getTypLekcja()+" | spot: "+getSpot()+" | numer: "+getNumer()+" | rodzaj: "+getRodzajGrupa()+" | Instruktor: "+getInstruktor().getImie()+ " "+getInstruktor().getNazwisko();
//	}
	
	@Override
	public String toString() {
		return Lekcja.class.getSimpleName()+" Data: "+getDataLekcji();
	}

}
