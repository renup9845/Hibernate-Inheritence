package com.slot1hibernate;

//One To Many

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class student1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stId;
	private String stName;
	private String stPhn;
	private int stAge;
	
	@OneToMany
	@JoinColumn(name = "stId")
	
	private List<laptop1> l;
	
	public int getStId() {
		return stId;
	}
	public void setStId(int stId) {
		this.stId = stId;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getStPhn() {
		return stPhn;
	}
	public void setStPhn(String stPhn) {
		this.stPhn = stPhn;
	}
	public int getStAge() {
		return stAge;
	}
	public void setStAge(int stAge) {
		this.stAge = stAge;
	}
	
	public List<laptop1> getL(){
		return l;
	}
	
	public void setL(List<laptop1> l) {
		this.l = l;
	}
	
	@Override
	public String toString() {
		return "student1 [stId=" + stId + ", stName=" + stName + ", stPhn=" + stPhn + ", stAge=" + stAge + "]";
	}
	
	
	
	

}
