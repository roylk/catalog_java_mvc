/**
 * 
 */
package com.objis.cata_mvc_4.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.objis.cata_mvc_4.entities.Produit;

/**
 * @author R. KOUANI
 *
 */
public interface ProduitRepository extends JpaRepository<Produit, Long> {

	@Query("select p from Produit p where p.designation like :x") // methode personnalisée pour la recherche
	public Page<Produit> rechercher(@Param("x") String mc, Pageable pageable);
        
        
        public Page<Produit>findByDesignationContains(String mc, Pageable pageable);

	/**
	 * 
	 */
}
