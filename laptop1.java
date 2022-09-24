package com.slot1hibernate;

//One To Many
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public final class laptop1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lapId;
	private String lapName;
	private int lapRAM;
	public int getLapId() {
		return lapId;
	}
	public void setLapId(int lapId) {
		this.lapId = lapId;
	}
	public String getLapName() {
		return lapName;
	}
	public void setLapName(String lapName) {
		this.lapName = lapName;
	}
	public int getLapRAM() {
		return lapRAM;
	}
	public void setLapRAM(int lapRAM) {
		this.lapRAM = lapRAM;
	}
	@Override
	public String toString() {
		return "laptop1 [lapId=" + lapId + ", lapName=" + lapName + ", lapRAM=" + lapRAM + "]";
	}
	
	


}
