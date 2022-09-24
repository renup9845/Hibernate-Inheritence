package com.slot1hibernate;

//One To Many

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class student1dao {
	
	Configuration conf;
	Session ses;
	Transaction tx;
	
	public void connect(){
	Configuration conf = new Configuration().configure().addAnnotatedClass(student1.class).addAnnotatedClass(laptop1.class);
		
	SessionFactory sf = conf.buildSessionFactory();
		
	Session ses = sf.openSession();
		
	Transaction tx = ses.beginTransaction();
	
	
	}
	
	public void disconnect() {
		tx.commit();
		ses.close();
	}
	
	public Session registerSt(student1 s) {
		ses.save(s);
		return ses;
	}
	
	public Session registerlap(laptop1 l) {
		ses.save(l);
		return ses;
		
	}
	
	public int deleteStd(int id) {
		Query q = ses.createQuery("delete from student s where s.siId=: Id").setParameter("Id",id);
		int count = q.executeUpdate();
		return count;
	
	
	}
	
	public student1 fetchStd(int id) {
		student1 s = (student1)ses.load(student1.class, id);
		return s;
	}
	
	public laptop1 fetchLap(int id) {
		laptop1 l = (laptop1)ses.load(laptop1.class, id);
		return l;
	}
	
	public List fetchAllLap() {
		Query q = ses.createQuery("from laptop1");
		List<laptop1> l = q.getResultList();
		return l;
	}
	
	public List fetchAll() {
		Query q = ses.createQuery("from student1");
		List<student1> s = q.getResultList();
		return s;
	} 
	
	
	
}
