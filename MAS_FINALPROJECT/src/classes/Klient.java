package classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.Session;

//zrobiona
@Entity(name = "klient")
@DiscriminatorValue(value = "klient")
public class Klient extends Osoba {

	@Column(name = "ileZaplacono")
	private int ileZaplacono;
	@OneToMany(mappedBy = "klient", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Wypozyczenie> wypozyczenie;

	public Klient() {

	}

	public Klient(String imie, String nazwisko, String telefon, int ileZaplacono) {
		super(imie, nazwisko, telefon);
		this.ileZaplacono = ileZaplacono;
		wypozyczenie = new ArrayList<Wypozyczenie>();
	}

	public void WypozyczSprzet(Wypozyczenie wyp) {
		if (!wypozyczenie.contains(wyp)) {
			wypozyczenie.add(wyp);
			wyp.dodajKlienta(this);
		}
	}

	public void oddajSprzet(Wypozyczenie wyp) {
		if (wypozyczenie.contains(wyp)) {
			wypozyczenie.remove(wyp);
			wyp.usunKlienta(this);
		}
	}

	public int getIleZaplacono() {
		return ileZaplacono;
	}

	public void setIleZaplacono(int ileZaplacono) throws Exception {
		if (ileZaplacono < 0) {
			throw new Exception("Kwota nie może być mniejsza od zera");
		}
		this.ileZaplacono = ileZaplacono;
	}

	public static Osoba dodajOsoba(String imie, String nazwisko, String telefon, int ileZaplacono) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Osoba o = new Klient(imie, nazwisko, telefon, ileZaplacono);
		session.save(o);
		session.getTransaction().commit();
		return o;
	}
	
	public static void usunOsoba(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from Wypozyczenie where klient_id=" + id).executeUpdate();
		session.createQuery("delete from Osoba where id=" + id).executeUpdate();
		session.getTransaction().commit();
	}

	public String getInfoWypozyczenie() {
		String info = "";
		for (Wypozyczenie ks : wypozyczenie) {
			info += ks;
		}
		return info;
	}
	
	
	public List<Wypozyczenie> getWypozyczenie() {
		return wypozyczenie;
	}

	public void setWypozyczenie(List<Wypozyczenie> wypozyczenie) {
		this.wypozyczenie = wypozyczenie;
	}	

	@Override
	public String toString() {
		return Klient.class.getSimpleName() + " : " + getImie() + " " + getNazwisko();
	}
}
