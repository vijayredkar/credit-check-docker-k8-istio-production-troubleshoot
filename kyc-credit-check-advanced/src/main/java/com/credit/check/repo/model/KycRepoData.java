package com.credit.check.repo.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document("kyc")
public class KycRepoData {
	
	@Id
	private String id;
	
	@Indexed(unique = true)
	private String firstName;
	private String lastName;
	private Date dateOfBirth;	
	private String gender;
	private String maritalStatus;
	private String citizenship;
	private String currentResidenceCountry;
	
	private String passportNumber;
	private Date passportExpiryDate;
	private String passportCountryOfIssue;
}