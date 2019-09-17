package classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.Session;
//zrobiona
@Entity(name = "kursant")
@DiscriminatorValue(value = "kursant")
public class Kursant extends Osoba{
	
	@ManyToOne
	private Instruktor instruktor;
	@OneToMany(
            mappedBy = "kursant",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
	List<Lekcja> lekcja;
	
	public Kursant() {
		
	}
	
	public Kursant(String imie, String nazwisko, String telefon){
		super(imie,nazwisko,telefon);
		this.lekcja=new ArrayList<Lekcja>();
	}

	public Instruktor getInstruktor() {
		return instruktor;
	}

	public void setInstruktor(Instruktor newInstruktor) {
		if (instruktor == null) {
			addInstruktor(newInstruktor);
		} else if(instruktor != newInstruktor){
			instruktor.usunKursanta(this);
			addInstruktor(newInstruktor);
		}
	}
	
	public void removeInstruktor(Instruktor removedInstruktor) {
		if(instruktor != null) {
			if(instruktor.equals(removedInstruktor)) {
				instruktor=null;
				removedInstruktor.usunKursanta(this);
			}
		}
	}
	
	private void addInstruktor(Instruktor newInstruktor) {
		instruktor = newInstruktor;
		instruktor.dodajKursanta(this);
	}
	
	public void dodajLekcje(Lekcja newLekcja) {
		if (!lekcja.contains(newLekcja)) {
			if (newLekcja != null) {
				lekcja.add(newLekcja);
				newLekcja.removeKursant(this);
			}
		}
	}

	public void usunLekcje(Lekcja removedLekcja) {
		if (lekcja.contains(removedLekcja)) {
			lekcja.remove(removedLekcja);
			removedLekcja.removeKursant(this);
		}
	}
	
	public static Osoba dodajOsoba(String imie, String nazwisko, String telefon) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Osoba o = new Kursant(imie,nazwisko,telefon);
		session.save(o);
		session.getTransaction().commit();
		return o;
	}
	
	public static void usunOsoba(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from Lekcja where kursant_id="+id).executeUpdate();
		session.createQuery("delete from Osoba where id="+id).executeUpdate();
		session.getTransaction().commit();
	}
	
	public List<Lekcja> getLekcja() {
		return lekcja;
	}

	public void setLekcja(List<Lekcja> lekcja) {
		this.lekcja = lekcja;
	}

	@Override
	public String toString() {
		return Kursant.class.getSimpleName() + " : " + getImie() + " " + getNazwisko();
	}

}
