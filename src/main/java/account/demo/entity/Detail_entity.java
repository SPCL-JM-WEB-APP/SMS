package account.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "fee")

public class Detail_entity
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int Sr_Number;
	  private String Fee_Title;
	  private String Fee_Type;
	  private int Amount_Payable;
	  private int Amount_Paid;
	  private int Amount_Paying;
	public Detail_entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Detail_entity(int sr_Number, String fee_Title, String fee_Type, int amount_Payable, int amount_paid,
			int amount_Paying) {
		super();
		Sr_Number = sr_Number;
		Fee_Title = fee_Title;
		Fee_Type = fee_Type;
		Amount_Payable = amount_Payable;
		Amount_Paid = amount_paid;
		Amount_Paying = amount_Paying;
	}
	public int getSr_Number() {
		return Sr_Number;
	}
	public void setSr_Number(int sr_Number) {
		Sr_Number = sr_Number;
	}
	public String getFee_Title() {
		return Fee_Title;
	}
	public void setFee_Title(String fee_Title) {
		Fee_Title = fee_Title;
	}
	public String getFee_Type() {
		return Fee_Type;
	}
	public void setFee_Type(String fee_Type) {
		Fee_Type = fee_Type;
	}
	public int getAmount_Payable() {
		return Amount_Payable;
	}
	public void setAmount_Payable(int amount_Payable) {
		Amount_Payable = amount_Payable;
	}
	public int getAmount_Paid() {
		return Amount_Paid;
	}
	public void setAmount_Paid(int amount_Paid) {
		Amount_Paid = amount_Paid;
	}
	public int getAmount_Paying() {
		return Amount_Paying;
	}
	public void setAmount_Paying(int amount_Paying) {
		Amount_Paying = amount_Paying;
	}
	
	  
	  
	

}
