package com.example.demo.ws.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
public class CompanyCustomer {
	
	// "cutomer_id_seq" is Oracle sequence name.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "cutomer_id_seq", allocationSize = 1, name = "CUST_SEQ")
	 private Long  Id; 	
	 
	 /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompanyCustomer [Id=" + Id + ", companyProductId=" + companyProductId + ", cutomerName=" + cutomerName
				+ ", phone=" + phone + ", notes=" + notes + ", companyName=" + companyName + ", demography="
				+ demography + ", email=" + email + ", date=" + date + "]";
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		Id = id;
	}
	/**
	 * @return the companyProductId
	 */
	public Long getCompanyProductId() {
		return companyProductId;
	}
	/**
	 * @param companyProductId the companyProductId to set
	 */
	public void setCompanyProductId(Long companyProductId) {
		this.companyProductId = companyProductId;
	}
	/**
	 * @return the cutomerName
	 */
	public String getCutomerName() {
		return cutomerName;
	}
	/**
	 * @param cutomerName the cutomerName to set
	 */
	public void setCutomerName(String cutomerName) {
		this.cutomerName = cutomerName;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the demography
	 */
	public String getDemography() {
		return demography;
	}
	/**
	 * @param demography the demography to set
	 */
	public void setDemography(String demography) {
		this.demography = demography;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	private Long  companyProductId;
	 private String cutomerName;
	 private String phone; 					
	 private String notes; 					
	 private String companyName; 			
	 private String demography; 			
	 private String email; 	
	 @Column(name = "CREATED_DATE")
	 private Date date;
}
