package classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;

import enumy.Stan;
//zrobiona
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "sprzet")
@Table(name = "sprzet")
public abstract class Sprzet {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "marka")
	private String marka;
	@Enumerated(EnumType.STRING)
	private Stan stan;
	@Column(name = "cena")
	private int cena;
	@Column(name = "kategoria")
	private String kategoria;
	 @OneToMany(
	            mappedBy = "sprzet",
	            cascade = CascadeType.ALL,
	            orphanRemoval = true
	    )
	private List<Wypozyczenie> wypozyczenie;

	public Sprzet() {

	}

	public Sprzet(String marka, Stan stan, int cena, String kategoria) {
		super();
		this.marka = marka;
		this.stan = stan;
		this.cena = cena;
		this.kategoria = kategoria;
		this.wypozyczenie=new ArrayList<Wypozyczenie>();
	}
	
	public void dodajKlienta(Wypozyczenie wyp) {
		if(!wypozyczenie.contains(wyp)) {
			wypozyczenie.add(wyp);
			wyp.dodajSprzet(this);
		}
	}
	
	public void usunKlienta(Wypozyczenie wyp) {
		if (wypozyczenie.contains(wyp)) {
			wypozyczenie.remove(wyp);
			wyp.usunSprzet(this);
		}
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public Stan getStan() {
		return stan;
	}

	public void setStan(Stan stan) {
		this.stan = stan;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getKategoria() {
		return kategoria;
	}

	public void setKategoria(String kategoria) {
		this.kategoria = kategoria;
	}
	
	public List<Wypozyczenie> getWypozyczenie() {
		return wypozyczenie;
	}

	public void setWypozyczenie(List<Wypozyczenie> wypozyczenie) {
		this.wypozyczenie = wypozyczenie;
	}

	public String toString() {
		String info="";
		for(Wypozyczenie ks : wypozyczenie) {
			info+=ks;
		}
		return info;
	}
	
	public static void updateSprzet(Sprzet o) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(o);
		session.getTransaction().commit();
	}
	
			public static List listEquipment() {
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				session.beginTransaction();
				List result = session.createQuery("from Sprzet").list();
				session.getTransaction().commit();
				return result;
			}

}
