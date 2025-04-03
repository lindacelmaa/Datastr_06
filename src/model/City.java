package model;

public class City {
	private String title;
	public String getTitle() {
		return title;
	}
	public float getSqureKm() {
		return squreKm;
	}
	public String getSurnameOfMayor() {
		return surnameOfMayor;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setSqureKm(float squreKm) {
		this.squreKm = squreKm;
	}
	public void setSurnameOfMayor(String surnameOfMayor) {
		this.surnameOfMayor = surnameOfMayor;
	}
	private float squreKm;
	private String surnameOfMayor;
	
	public City(String title, String SurnameOfMayor, float squreKm) {
		setTitle(title);
		setSurnameOfMayor(surnameOfMayor);
		setSqureKm(squreKm);
	}
	
}
