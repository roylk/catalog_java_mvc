package com.objis.cata_mvc_4.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.objis.cata_mvc_4.dao.ProduitRepository;
import com.objis.cata_mvc_4.entities.Produit;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProduitController {

	@Autowired
	private ProduitRepository produitRepository;

	//@RequestMapping(value = "/produits")
        @GetMapping(value = "/produits")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "5") int s,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {

		// List<Produit> produits = ".findAll(); retourner la liste des
		// produits
		// model.addAttribute("listeProduits", produits);

		// Page<Produit> pageProduits = produitRepository.findAll(new PageRequest(p,
		// s));

//		Page<Produit> pageProduits = produitRepository.rechercher("%" + mc + "%", new PageRequest(p, s));
                //Page<Produit> pageProduits = produitRepository.findByDesignationContains(mc, new PageRequest(p, s));
                 Page<Produit> pageProduits = produitRepository.findByDesignationContains(mc, PageRequest.of(p, s));
		model.addAttribute("listeProduits", pageProduits.getContent());
		int[] pages = new int[pageProduits.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);// ajout de la taille(nombre d'éléments) dans le model
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", mc); // ajout du paramètre mc dans le model afin de pouvoir l'utiliser dans la vue
		return "produits";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	// ajout des paramètres de page, taille et motCle
	public String delete(Long id, String motCle, int page, int size) {
		produitRepository.deleteById(id);
		return "redirect:/produits?page=" + page + "&size=" + size + "&motCle=" + motCle; // redirection avec paramètres

	}

}
