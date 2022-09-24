package com.slot1hibernate;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class employee1dao {
	
	Configuration conf;
	Session ses;
	Transaction tx;
	
	public void connect(){
	Configuration conf = new Configuration().configure().addAnnotatedClass(employee1.class).addAnnotatedClass(FresherEmployee.class).addAnnotatedClass(ExperienceEmployee.class);
	
	SessionFactory sf = conf.buildSessionFactory();
	
	Session ses = sf.openSession();
	
	Transaction tx = ses.beginTransaction();

	}

public void disconnect() {
	tx.commit();
	ses.close();
}

public Session registerEmp(employee1 emp) {
	ses.save(emp);
	return ses;
	
}

public Session registerEmp(FresherEmployee f) {
	ses.save(f);
	return ses;
}

public Session registerEmp(ExperienceEmployee e) {
	ses.save(e);
	return ses;
}

public int deleteEmp(int id) {
	Query q = ses.createQuery("delete from employee1 emp where emp.empId=: Id").setParameter("Id" , id);
	int count = q.executeUpdate();
	return count;
}

public employee1 fetchEmp(int id) {
	employee1 emp = (employee1)ses.load(employee1.class, id);
	return emp;
	
}

public List fetchAll() {
	Query q = ses.createQuery("from employee1");
	List<employee1> empl = q.getResultList();
	return empl;
} 
}
