package classes;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.Session;

import enumy.RozmiarPianka;
import enumy.Stan;
import enumy.TypPianka;
//zrobiona
@Entity(name = "pianka")
@DiscriminatorValue(value = "pianka")
public class Pianka extends Sprzet{
	
	@Enumerated(EnumType.STRING)
	private TypPianka typPianka;
	@Enumerated(EnumType.STRING)
	private RozmiarPianka rozmiarPianka;
	
	public Pianka() {
		
	}
	
	public Pianka(String marka, Stan stan, int cena, String kategoria,TypPianka typPianka,RozmiarPianka rozmiar){
		super(marka,stan,cena,kategoria);
		this.typPianka=typPianka;
		this.rozmiarPianka=rozmiar;
	}

	public static Sprzet dodajSprzet(String marka, Stan stan, int cena, String kategoria, TypPianka pianka, RozmiarPianka rozmiar) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Sprzet s = new Pianka(marka,stan,cena,kategoria,pianka,rozmiar);
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

	public TypPianka getTypPianka() {
		return typPianka;
	}

	public void setTypPianka(TypPianka typPianka) {
		this.typPianka = typPianka;
	}

	public RozmiarPianka getRozmiarPianka() {
		return rozmiarPianka;
	}

	public void setRozmiarPianka(RozmiarPianka rozmiarPianka) {
		this.rozmiarPianka = rozmiarPianka;
	}

	public static void showRecords() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Sprzet> list = session.createQuery("from Sprzet where type='pianka'").getResultList();
		for(Sprzet os : list) {
			System.out.println(os);
		}
		session.getTransaction().commit();
	}

	@Override
	public String toString() {
		return Pianka.class.getSimpleName() + " : #" + getId();
	}

}
