package com.slot1hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Experienced")
public class ExperienceEmployee extends employee1 {
	
	private int experience;
	private int hike;
	private int salary;
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getHike() {
		return hike;
	}
	public void setHike(int hike) {
		this.hike = hike;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "ExperienceEmployee [experience=" + experience + ", hike=" + hike + ", salary=" + salary + "]";
	}
	

}
