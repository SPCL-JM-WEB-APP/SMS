package com.springjava.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "teachers_dtl")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Name")
	private String fullname;
	private String fathersname;
	private int age;
	private String dob;
	private String languageknown;
	private String englishProficiency;
	private String qualification;
	private String institute;
	private String board;
	private int marks;
	private int period;
	private String organizationaddress;
	private String designation;
	private String personalachievement;
	private String document;
	private String declaration;
	

	public String getEnglishProficiency() {
		return englishProficiency;
	}

	public void setEnglishProficiency(String englishProficiency) {
		this.englishProficiency = englishProficiency;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getFathersname() {
		return fathersname;
	}

	public void setFathersname(String fathersname) {
		this.fathersname = fathersname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
    
	public String getLanguageknown() {
		return languageknown;
	}

	public void setLanguageknown(String languageknown) {
		this.languageknown = languageknown;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}


	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getOrganizationaddress() {
		return organizationaddress;
	}

	public void setOrganizationaddress(String organizationaddress) {
		this.organizationaddress = organizationaddress;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPersonalachievement() {
		return personalachievement;
	}

	public void setPersonalachievement(String personalachievement) {
		this.personalachievement = personalachievement;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getDeclaration() {
		return declaration;
	}

	public void setDeclaration(String declaration) {
		this.declaration = declaration;
	}
	

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", fullname=" + fullname + ", fathersname=" + fathersname + ", age=" + age
				+ ", dob=" + dob + ", languageknown=" + languageknown + ", englishProficiency=" + englishProficiency
				+ ", qualification=" + qualification + ", institute=" + institute + ", board=" + board + ", marks="
				+ marks + ", period=" + period + ", organizationaddress=" + organizationaddress + ", designation="
				+ designation + ", personalachievement=" + personalachievement + ", document=" + document
				+ ", declaration=" + declaration + "]";
	}

	

}

