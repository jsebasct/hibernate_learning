package people.hiber.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
//@Table(name="BANK_ACCOUNT")
@Embeddable
public class BankAccount {

//	@Id
	@GeneratedValue
	@Column(name="BANK_ACCOUNT_ID")
	private int id;
	
	@Column(name="BANK_ACCOUNT_NUMBER")
	private int number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
}
