package classes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import enumy.Stan;

@Entity(name = "pednik")
@DiscriminatorValue(value = "pednik")
public abstract class Pednik extends Sprzet{
	
	public Pednik() {
		
	}

	public Pednik(String marka, Stan stan, int cena, String kategoria) {
		// TODO Auto-generated constructor stub
		super(marka,stan,cena,kategoria);
	}

}
