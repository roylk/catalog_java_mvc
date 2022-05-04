/**
 * 
 */
package com.objis.cata_mvc_4.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author R. KOUANI
 *
 */
@Entity
@Data
public class Produit implements   Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String designation;
	private double prix;
	private int quantite;

	/**
	 * 
	 */
	public Produit() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param designation
	 * @param prix
	 * @param quantite
	 */
	public Produit(String designation, double prix, int quantite) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}

}
