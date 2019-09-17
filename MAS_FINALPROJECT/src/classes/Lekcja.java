package classes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;

import enumy.TypLekcja;

//zrobiona
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "lekcja")
@Table(name = "lekcja")
public abstract class Lekcja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "cena")
	private int cena;
	@Column(name = "dataLekcji")
	private LocalDate dataLekcji;
	@Enumerated(EnumType.STRING)
	private TypLekcja typLekcja;
	@Column(name = "spot")
	private String spot;
	@ManyToOne
	private Instruktor instruktor;
	@ManyToOne
	private Kursant kursant;

	public Lekcja() {

	}

	public Lekcja(int cena,LocalDate dataLekcji, TypLekcja typLekcja, String spot, Instruktor instruktor, Kursant kursant) {
		super();
		this.cena = cena;
		this.typLekcja = typLekcja;
		this.spot = spot;
		this.instruktor = instruktor;
		this.kursant = kursant;
		this.dataLekcji=dataLekcji;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public LocalDate getDataLekcji() {
		return dataLekcji;
	}

	public void setDataLekcji(LocalDate dataLekcji) {
		this.dataLekcji = dataLekcji;
	}

	public TypLekcja getTypLekcja() {
		return typLekcja;
	}

	public void setTypLekcja(TypLekcja typLekcja) {
		this.typLekcja = typLekcja;
	}

	public String getSpot() {
		return spot;
	}

	public void setSpot(String spot) {
		this.spot = spot;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public Instruktor getInstruktor() {
		return instruktor;
	}

	public void setInstruktor(Instruktor newInstruktor) {
		if (instruktor == null) {
			addInstruktor(newInstruktor);
		} else if (instruktor != newInstruktor) {
			instruktor.usunLekcje(this);
			addInstruktor(newInstruktor);
		}
	}

	public void removeInstruktor(Instruktor removedInstruktor) {
		if (instruktor != null) {
			if (instruktor.equals(removedInstruktor)) {
				instruktor = null;
				removedInstruktor.usunLekcje(this);
			}
		}
	}

	private void addInstruktor(Instruktor newInstruktor) {
		instruktor = newInstruktor;
		instruktor.dodajLekcje(this);
	}

	public Kursant getKursant() {
		return kursant;
	}

	public void setKursant(Kursant newKursant) {
		if (kursant == null) {
			addKursant(newKursant);
		} else if (kursant != newKursant) {
			kursant.usunLekcje(this);
			addKursant(newKursant);
		}
	}

	public void removeKursant(Kursant removedKursant) {
		if (kursant != null) {
			if (kursant.equals(removedKursant)) {
				kursant = null;
				removedKursant.usunLekcje(this);
			}
		}
	}

	private void addKursant(Kursant newKursant) {
		kursant = newKursant;
		kursant.dodajLekcje(this);
	}
	
	public static void updateLekcja(Lekcja o) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(o);
		session.getTransaction().commit();
	}
	
	public static List listRecords() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Lekcja> list = session.createQuery("from Lekcja").getResultList();
		session.getTransaction().commit();
		return list;
	}
}
