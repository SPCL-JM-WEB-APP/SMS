package account.demo.entity;



import jakarta.annotation.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student1")

public class Fees_Collection_entity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Student_id;
	   private String Student_name;
	   private String Standard;
	   private String Division;
	   private int Previous_Fees;
	   private int Paid_Fees;
	   private int Remaining_Fees;
	   private int Total_Fee;
	public int getStudent_id() {
		return Student_id;
	}
	public void setStudent_id(int student_id) {
		Student_id = student_id;
	}
	public String getStudent_name() {
		return Student_name;
	}
	public void setStudent_name(String student_name) {
		Student_name = student_name;
	}
	public String getStandard() {
		return Standard;
	}
	public void setStandard(String standard) {
		Standard = standard;
	}
	public String getDivision() {
		return Division;
	}
	public void setDivision(String division) {
		Division = division;
	}
	public int getPrevious_Fees() {
		return Previous_Fees;
	}
	public void setPrevious_Fees(int previous_Fees) {
		Previous_Fees = previous_Fees;
	}
	public int getPaid_Fees() {
		return Paid_Fees;
	}
	public void setPaid_Fees(int paid_Fees) {
		Paid_Fees = paid_Fees;
	}
	public int getRemaining_Fees() {
		return Remaining_Fees;
	}
	public void setRemaining_Fees(int remaining_Fees) {
		Remaining_Fees = remaining_Fees;
	}
	public int getTotal_Fee() {
		return Total_Fee;
	}
	public void setTotal_Fee(int total_Fee) {
		Total_Fee = total_Fee;
	}

	
	
	   
	   
	   
	   
}
