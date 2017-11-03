package org.sid.eboutique;

import static org.junit.Assert.*;

import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.sid.eboutique.entities.*;
import org.sid.eboutique.metier.IAdminCategoriesMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestJPA {
	ClassPathXmlApplicationContext context;
	@Before
	public void setUp() throws Exception { 
		context =new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	}
	@Test
	public void test1() {
		try {
			IAdminCategoriesMetier metier=(IAdminCategoriesMetier) context.getBean("metier");
			List<Categorie> cats1=metier.listCategories(1L);
		/*	metier.ajouterCategorie(new Categorie("Ordinateur","Ordinateurs"));
			metier.ajouterCategorie(new Categorie("Imprimantes","Imprimantes"));*/
			List<Categorie> cats2=metier.listCategories(1L);
			assertTrue(cats2.size()==cats1.size()+2);
			} catch (Exception e) {
			assertTrue(e.getMessage(),false);
			}
	}
	@Test
	public void test2() {
		try {	
			IAdminCategoriesMetier metier=(IAdminCategoriesMetier) context.getBean("metier");
			List<Produit> prods=metier.listproduits(1L);
            metier.ajouterProduit(new Produit("HP452","HP4522","ggggg","eeeee","eeee",true),1L);
            metier.ajouterProduit(new Produit("HP452","HP4522","ggggg","eeeee","eeee",true),1L);
			List<Produit> prods2=metier.listproduits(1L);
			assertTrue(prods2.size()==prods.size()+2);
			} catch (Exception e) {
			assertTrue(e.getMessage(),false);
			}
	}

}
