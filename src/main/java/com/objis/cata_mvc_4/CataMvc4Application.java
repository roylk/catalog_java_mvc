package com.objis.cata_mvc_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.objis.cata_mvc_4.dao.ProduitRepository;
import com.objis.cata_mvc_4.entities.Produit;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CataMvc4Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CataMvc4Application.class, args);
		ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class); // recuperation du contexte
		
//		 produitRepository.save(new Produit("LXTA", 2500, 2));
//		 produitRepository.save(new Produit("PC hp probook", 350000, 90));
//		 produitRepository.save(new Produit("imprimant epson 458", 42700, 17));
//		 produitRepository.save(new Produit("pc ASUS 1010", 408000, 10));
//		 

		produitRepository.findAll().forEach(p -> System.out.println(p.getDesignation()));// expression lambda
	}

}
