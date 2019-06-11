package GuiceServletDemo;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;

public class MainClass {
	public static void main(String args[]) {
		Injector i = Guice.createInjector(new GuiceModule());
		/* Specs s = i.getInstance(Specs.class); System.out.println(s.getDetails()); */
		MyService ms = i.getInstance(MyService.class);
		ms.saveNewPerson(new Person("Sajal"));

	}
}
/*
 * class GuiceModule extends ServletModule { protected void configureSerlvet() {
 * install(new JpaPersistModule("myJpaUnit"));
 * filter("/*").through(PersistFilter.class);
 * 
 * } }
 */

class GuiceModule extends AbstractModule {
	protected void configure() {

	}
	
	@Provides @Singleton
	public EntityManagerFactory provideEntityManagerFactory() {
		
		/*
		 * Map<String, String> properties = new HashMap<String, String>();
		 * properties.put("javax.persistence.jdbc.url",
		 * "jdbc:postgresql://localhost:5432/Mappingdb3");
		 * properties.put("javax.persistence.jdbc.user", "axelor");
		 * properties.put("javax.persistence.jdbc.password", "axelor");
		 * properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
		 * properties.put("eclipselink.logging.level", "FINE");
		 * properties.put("eclipselink.ddl-generation", "create-tables");
		 * properties.put("hibernate.hbm2ddl.auto", "update");
		 */
		 
	    return Persistence.createEntityManagerFactory("PU");
	  }

	@Provides
	public EntityManager provideEntityManager(EntityManagerFactory entityManagerFactory) {
		return entityManagerFactory.createEntityManager();
	}
}
