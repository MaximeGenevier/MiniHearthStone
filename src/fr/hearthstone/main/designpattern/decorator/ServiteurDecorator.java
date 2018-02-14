/**
 * 
 */
package fr.hearthstone.main.designpattern.decorator;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;

/**
 * @author Maxime GENEVIER
 * 
 * Decorateur abstrait de Serviteur
 * 
 * Possède un attribut Serviteur et une méthode abstraite attack()
 * qui redéfinit la méthode Serviteur.attack()
 *
 */
public abstract class ServiteurDecorator extends Serviteur{
	
	protected Serviteur serviteur;
	
	public ServiteurDecorator(Serviteur serviteur) {
		this.serviteur = serviteur;
	}
	
	public abstract void attack(Cible target);

}
