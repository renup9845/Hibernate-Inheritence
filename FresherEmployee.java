package com.slot1hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Fresher")
public class FresherEmployee extends employee1{
	
	private int contractPeriod;
	private int increment;
	private int Salary;
	public int getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(int contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	public int getIncrement() {
		return increment;
	}
	public void setIncrement(int increment) {
		this.increment = increment;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	@Override
	public String toString() {
		return "FresherEmployee [contractPeriod=" + contractPeriod + ", increment=" + increment + ", Salary=" + Salary
				+ "]";
	}
	

}
