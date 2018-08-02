package com.rup.projet.com.rup.projet.jpa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.OrderBy;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.ETP;
import entity.Experience;
import entity.Fonction;
import entity.Profil;
import entity.User;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		EntityManager em1 = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// creation d'un user avec les profil
		User user1 = new User(1, "amine");
		User user2 = new User(2, "akram");
		User user3 = new User(3, "naji");
		User user4 = new User(4, "Professeur");
		Profil profil = new Profil(2, "manager");

		List<User> allUser = new ArrayList<User>();

		user1.setProfil(profil);
		user2.setProfil(profil);
		user3.setProfil(profil);
		user4.setProfil(profil);

		allUser.add(user1);
		allUser.add(user2);
		allUser.add(user3);

		// profil.setUser(allUser);
		
		// creation d'un user avec persistence directement
		 em.persist(profil);

		// Merge

		// profil.setType("Encadrant");
		// allUser.remove(user1);
		// allUser.add(user4);
		//
		//
		// Utilisation de DAO entitymanager

		// insertion de la ligne avec la classe DAO
		// Dao<User,Integer> dao = new Dao<>(em,User.class);
		// dao.creer(userr);
		// User u = dao.rechercherParPk(1);
//		em.find(User.class, 1);
//		User u = em1.find(User.class, 1);
//		System.out.println(u.getName());
		// //supprimmer un user by id
		// Dao<User,Long> daoo = new Dao<>(em,User.class);
		// //daoo.supprimerByid(1);
		// daoo.supprimer(userr);
		// //supprimer
		// supprimer un profil

		// Dao<Profil,Long> daoo = new Dao<>(em,Profil.class);
		// daoo.supprimerByid(2);

		// Query JPQL

		// Query q = em.createQuery("select c from User c where c.name = :fname order By
		// c.name");
		// q.setParameter("fname", "Amine");
		//
		// List<User> alluser = (List<User>) q.getResultList();
		// Iterator i = alluser.iterator();
		// while (i.hasNext()) {
		// System.out.println(i.next());
		// }

		// Query NamedQuery

		// Query q = em.createNamedQuery("Order:findAllOrders");
		// List<User> alluser = (List<User>) q.getResultList();
		// Iterator i = alluser.iterator();
		// while (i.hasNext()) {
		// System.out.println(i.next());
		// }
		// Query jointure

		// Query f = em.createQuery("select distinct o from Profil o left outer join
		// o.user li where li.id > :id");
		// f.setParameter("id", 1) ;
		// List<Profil> profils = (List<Profil>) f.getResultList();
		// Iterator j = profils.iterator();
		// while (j.hasNext()) {
		// System.out.println(j.next());
		// }

		// System.out.println(alluser);

		// Query jointure de cote user attribut
		// Query q4 = em.createQuery("SELECT u FROM User u WHERE u.profil.type =
		// :type");
		// q4.setParameter("type", "manager");
		//
		// List<User> users = (List<User>) q4.getResultList();
		//
		// for (User user : users) {
		// System.out.println(user.getName());
		// }

		// query jointure entre les 3 classes
		// Query q2 = em.createQuery("SELECT u FROM User u join u.profil.fonction f
		// where f.role = :role");
		// q2.setParameter("role", "inserer");
		// List<User> userss = (List<User>) q2.getResultList();
		//
		// for (User user : userss) {
		// System.out.println(user.getName());
		// }

		// query jpql fonctionne

		// String t1 ="SELECT u.id, concat(u.name) FROM User u";
		// Query q7 = em.createQuery(t1);
		// List<Object[]> liste = (List<Object[]>) q7.getResultList();
		// for(Object[] info : liste) {
		// System.out.println(info[0]+" gagne "+info[1]);
		// }

		// exemple Mouad alami

		// Query q6 = em.createQuery("SELECT u.id, concat(u.nom, concat(' ', u.prenom))
		// FROM User u join u.profil.listFonction f where f.nom = :fnom");
		// q6.setParameter("fnom", "modification");
		// List<User> usersF = (List<User>) q6.getResultList();
		// List<Object[]> liste = (List<Object[]>) q6.getResultList();
		//
		// /*
		// for(User user: usersF ) {
		// System.out.println(user.toString());
		// }*/
		//
		// for(Object[] info : liste ) {
		// System.out.println(info[0] + " gagne " + info[1]);
		// }
		// table id name /, concat(' ', u.prenom)

		// jointure et insertion dans un tableau avec un ordre

		// Query q6 = em.createQuery("SELECT u.id, concat(u.name,u.name) FROM User u");
		// // join
		// List<Object[]> liste = (List<Object[]>) q6.getResultList();
		// for (Object[] info : liste) {
		// System.out.println(info[0] + " s'appelle " + info[1]);
		// }

		// String t = "Select distinct c from User c join fetch c.profil";
		// Query q =em.createQuery(t);
		// List<User> users = (List<User>) q.getResultList();
		//
		// for (User user : users) {
		// System.out.println(user);
		// }

		// fetch type egger on ajoute fetch au sein de la requete

		// String t = "Select distinct c from Profil c left join fetch c.user ";
		// Query q = em.createQuery(t);
		// List<Profil> profils = (List<Profil>) q.getResultList();
		//
		// for (Profil profil : profils) {
		// System.out.println(profil);
		// System.out.println(profil.getUser().size());
		// }

		// FROM User u join u.profil.listFonction f where f.nom = :fnom")
		// Query q6 = em.createQuery("SELECT distinct p.type,size(p.user) FROM Profil p
		// join p.user");
		//
		// List<Object[]> liste = (List<Object[]>) q6.getResultList();
		// for (Object[] info : liste) {
		// System.out.println(" le profil " + info[0] + " à pour nombre d'utilisateur "
		// + info[1]);
		// }

		// Query q = em.createQuery("update User u where u.name = naji set
		// u.name=:name");
		// q.setParameter("name", "amine") ;

		// Merge

		// Profil p = new Profil(6,"Directeur");
		// p.setType("Encadrant");
		// // allUser.remove(user1);
		// // allUser.add(user4);
		//
		// em.persist(p);
		// // Dao<Profil,Long> dao = new Dao<>(em,Profil.class);
		// //dao.creer(userr);
		// // dao.
		// p.setType("encad");
		// em.merge(p);
		//

		// vendredi 20 juillet 2018
		// Single table pour tous les entity
		//
		// Experience ex = new Experience ("Stage");
		//// em.persist(ex);
		// ETP etp = new ETP("NAji");
		// em.persist(etp);
		//

//		Query q11 = em.createQuery("SELECT u FROM User u");
//		q11.setHint("org.hibernate.cacheable", true);
//		List<Profil> profils = (List<Profil>) q11.getResultList();
//		List<Profil> profils2 = (List<Profil>) q11.getResultList();

		em.getTransaction().commit();

		emf.close();

		tx.commit();
		em.close();
		emf.close();

	}

	/**
	 * le cas de join le cas des table
	 */
}
