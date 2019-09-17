package classes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.Session;

import enumy.Stan;
import enumy.TypWypozyczenie;

//zrobiona
@Entity(name = "Wypozyczenie")
@DiscriminatorValue(value = "wypozyczenie")
public class Wypozyczenie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "dataZwrotu")
	private LocalDate dataZwrotu;
	@Column(name = "dataWypozyczenia")
	private LocalDate dataWypozyczenia;
	@ManyToOne
	private Sprzet sprzet;
	@ManyToOne
	private Klient klient;
	@Enumerated(EnumType.STRING)
	private TypWypozyczenie naIle;

	public Wypozyczenie() {

	}

	public Wypozyczenie(LocalDate dataWypozyczenia, TypWypozyczenie naIle, Sprzet sprzet, Klient klient) {
		super();
		this.dataWypozyczenia = dataWypozyczenia;
		this.naIle = naIle;
		addSprzet(sprzet);
		addKlient(klient);
	}

	public LocalDate getDataZwrotu() {
		return dataZwrotu;
	}

	public void setDataZwrotu(LocalDate dataZwrotu) throws Exception {
		if (dataZwrotu.isAfter(dataWypozyczenia)) {
			this.dataZwrotu = dataZwrotu;
		} else
			throw new Exception("Data zwrotu musi być po dacie wypożyczenia");
	}

	public LocalDate getDataWypozyczenia() {
		return dataWypozyczenia;
	}

	public void setDataWypozyczenia(LocalDate dataWypozyczenia) {
		this.dataWypozyczenia = dataWypozyczenia;
	}

	public void dodajSprzet(Sprzet s) {
		if (this.sprzet == null) {
			addSprzet(s);
		} else if (this.sprzet != s) {
			s.usunKlienta(this);
			addSprzet(s);
		}
	}

	public void usunSprzet(Sprzet s) {
		if (this.sprzet != null) {
			if (this.sprzet.equals(s)) {
				this.sprzet = null;
				s.usunKlienta(this);
			}
		}

	}

	public void dodajKlienta(Klient k) {
		if (this.klient == null) {
			addKlient(k);
		} else if (this.klient != k) {
			k.oddajSprzet(this);
			addKlient(k);
		}
	}

	public void usunKlienta(Klient k) {
		if (this.klient != null) {
			if (this.klient.equals(k)) {
				this.klient = null;
				k.oddajSprzet(this);
			}
		}
	}

	private void addSprzet(Sprzet s) {
		this.sprzet = s;
		s.dodajKlienta(this);
	}

	private void addKlient(Klient k) {
		this.klient = k;
		k.WypozyczSprzet(this);
	}

	public Sprzet getSprzet() {
		return sprzet;
	}

	public void setSprzet(Sprzet sprzet) {
		this.sprzet = sprzet;
	}

	public Klient getKlient() {
		return klient;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public TypWypozyczenie getNaIle() {
		return naIle;
	}

	public void setNaIle(TypWypozyczenie naIle) {
		this.naIle = naIle;
	}

	public static Wypozyczenie dodajWypozyczenie(LocalDate dataWypozyczenia, TypWypozyczenie naIle, Sprzet sprzet,
			Klient klient) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Wypozyczenie w = new Wypozyczenie(dataWypozyczenia, naIle, sprzet, klient);
		sprzet.setStan(Stan.WYPOZYCZONY);
		session.update(sprzet);
		session.save(w);
		session.getTransaction().commit();
		return w;
	}

	public static void usunWypozyczenie(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from Wypozyczenie id=" + id).executeUpdate();
		session.getTransaction().commit();
	}

	public static void showRecords() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Wypozyczenie> list = session.createQuery("from Wypozyczenie").getResultList();
		for(Wypozyczenie os : list) {
			System.out.println(os);
		}
		session.getTransaction().commit();
	}
	
	public static List listRecords() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Wypozyczenie> list = session.createQuery("from Wypozyczenie").getResultList();
		session.getTransaction().commit();
		return list;
	}

//	@Override
//	public String toString() {
//		if(getDataZwrotu()!=null) {
//			return "Wypożyczenie ---  data wypożyczenia: "+getDataWypozyczenia()+" data zwrotu: "+getDataZwrotu()+" na ile: "+getNaIle()+" klient : "+getKlient().getImie() + getKlient().getNazwisko();	
//		}
//		return "Wypożyczenie ---  data wypożyczenia: "+getDataWypozyczenia()+" | data zwrotu: brak | na ile: "+getNaIle()+" | sprzet: "+getSprzet().getClass().getSimpleName()+" | klient : "+getKlient().getImie() +" "+ getKlient().getNazwisko();
//	}
	
	@Override
	public String toString() {
		return Wypozyczenie.class.getSimpleName() + " : " + getDataWypozyczenia();
	}

}
