package GuiceServletDemo;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import javax.persistence.*;

public class MyService {

	EntityManager em;

	@Inject
	public MyService(EntityManager em) {
		super();
		this.em = em;
	}

	@Transactional
	public void saveNewPerson(Person p) {
		System.out.println(p.getName());
		
		em.getTransaction().begin();
		
		/*
		 * em.persist(p); System.out.println("Data Entered successfully!!");
		 */
		
		Person p1=em.find(Person.class, 3);
		p1.setName("Shivank");
		System.out.println("Data Upadation is complete.");
		em.getTransaction().commit();
	}
}
