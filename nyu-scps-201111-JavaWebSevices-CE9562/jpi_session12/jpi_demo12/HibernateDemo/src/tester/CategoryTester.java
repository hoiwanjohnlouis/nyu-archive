package tester;

import java.util.Iterator;
import java.util.List;

import model.Category;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

import junit.framework.TestCase;

public class CategoryTester extends TestCase {
	
	public void testSaveCategory(){
		
		Transaction transaction = null; 
		try { 
			Session session = HibernateUtil.getSessionFactory().openSession(); 
			String name = "Category2";
			transaction = session.beginTransaction(); 
			
			Category Category = new Category();
			Category.setName(name);
			session.save(Category);
			Query query = session.createQuery("from Category a where a.name='" + name + "'");
			List<Category> CategoryList = (List<Category>) query.list();
			assertNotNull(CategoryList);
			transaction.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			fail("Category Save failed");
		}

	}

	public void testRetrieveCategoryByPrimaryKey(){
		
		try { 
			Session session = HibernateUtil.getSessionFactory().openSession();
			int CategoryId = 91;
			Category Category = (Category) session.get(Category.class, CategoryId);
			assertNotNull(Category);
			assertEquals(CategoryId,Category.getId());
			System.out.print(Category.getId()+ "\t");
			System.out.print(Category.getName() + "\t");
			System.out.println(Category.getType());
 		}
		catch(Exception e){
			e.printStackTrace();
			fail("Category retrieve by id failed");
		}

	}

	public void testRetrieveCategoryByName(){
		
		try { 
			Session session = HibernateUtil.getSessionFactory().openSession(); 
			Query query = session.createQuery("from Category a where a.name='Pop'");
			List<Category>	CategoryList = (List<Category>) query.list();
			assertNotNull(CategoryList);
			Iterator<Category> CategoryIterator = CategoryList.iterator();
			while (CategoryIterator.hasNext()){
				Category Category = CategoryIterator.next();
				System.out.print(Category.getId()+ "\t");
				System.out.print(Category.getName() + "\t");
				System.out.println(Category.getType());
				
			}
 		}
		catch(Exception e){
			e.printStackTrace();
			fail("Category retrieve by name failed");
		}

	}
}
