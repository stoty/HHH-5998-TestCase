package org.hibernate.bugs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * This is the Test Case for HHH-5998
 */
public class HHH5998H2TestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void hhh5998TestH2() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			entityManager.getTransaction().begin();

			SomeTable s = new SomeTable();
			s.setId(1);

			entityManager.persist(s);

			CompositeKey k = new CompositeKey();
			k.setKeyOne(1);
			k.setKeyTwo(2);

			TableWithCompositeKey c = new TableWithCompositeKey();
			c.setId(k);

			entityManager.persist(c);

			Query q = entityManager.createQuery("select s from SomeTable s where exists (select c from TableWithCompositeKey c where c.id.keyOne = s.id)");
			List result = q.getResultList();

			assertFalse(result.isEmpty());
			
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		} finally {
			entityManager.close();
		}
	}
}
