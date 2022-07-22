package com.skillstorm.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.skillstorm.beans.Album;
//import com.skillstorm.beans.Artist;

public class HelloHibernate {
	public static final SessionFactory SESSION_FACTORY =  new Configuration().configure().buildSessionFactory();
	public static void main(String[] args) {
		//create the session factory
		Session session = SESSION_FACTORY.openSession();
		//ArtistDAO dao = new ArtistDAO(session);
		//System.out.println(dao.findById(89));
		//dao.save(new Artist("Bear Family Revival"));
		//System.out.println("Da Bears");
		//System.out.println(dao.findAll());
		//System.out.println(dao.findByName("Black"));
		//System.out.println(dao.findByNameCriteria("Black"));
		//System.out.println(dao.findByNameLike("Black"));
		AlbumDAO dao = new AlbumDAO(session);
		List<Album> result = (List<Album>) dao.findByNameLike("Black");
		session.close();
		System.out.println(result);
	}
}
