package org.hdcd.vo;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Member {
	// 문자열이 null이 아니고 trim한 길이가 0보다 크다는 것을 검사
	@NotBlank
	private String userId = "a001";
	// 문자열이 null이 아니고 trim한 길이가 0보다 크다는 것을 검사
	@NotBlank
	private String password = "1234";
	// 문자열 0~3사이 길이를 검사
	@Size(max=3)
	// 문자열이 null이 아니고 trim한 길이가 0보다 크다는 것을 검사
	@NotBlank
	private String userName = "hongkd";
	private int coin = 100;
	// 과거 날짜인지를 검사
	@Past
	// @DateTimeFormat 설정시 사용
	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@DateTimeFormat(iso=ISO.DATE) // yyyy-MM-dd or yyyyMMdd 형식 둘다 받을 수 있다.
//	@DateTimeFormat(iso=ISO.DATE_TIME)
	private Date dateOfBirth;
	// 이메일 양식인지 검사
	@Email
	private String email;
	private String gender;
	private String hobby;
	private String[] hobbyArray;
	private List<String> hobbyList;
	private boolean foreigner;
	private String developer;
	private String nationality;
	// 중첩된 자바빈즈의 입력값 검증을 지정
	@Valid
	private Address address;
	// 중첩된 자바빈즈의 입력값 검증을 지정
	@Valid
	private List<Card> cardList;
	private String cars;
	private String[] carArray;	
	private List<String> carList;
	private String introduction;
	private String birthDay;

	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getCoin() {
		return coin;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Card> getCardList() {
		return cardList;
	}
	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String[] getHobbyArray() {
		return hobbyArray;
	}
	public void setHobbyArray(String[] hobbyArray) {
		this.hobbyArray = hobbyArray;
	}
	public List<String> getHobbyList() {
		return hobbyList;
	}
	public void setHobbyList(List<String> hobbyList) {
		this.hobbyList = hobbyList;
	}
	public boolean isForeigner() {
		return foreigner;
	}
	public void setForeigner(boolean foreigner) {
		this.foreigner = foreigner;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getCars() {
		return cars;
	}
	public void setCars(String cars) {
		this.cars = cars;
	}
	public String[] getCarArray() {
		return carArray;
	}
	public void setCarArray(String[] carArray) {
		this.carArray = carArray;
	}
	public List<String> getCarList() {
		return carList;
	}
	public void setCarList(List<String> carList) {
		this.carList = carList;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	
}
