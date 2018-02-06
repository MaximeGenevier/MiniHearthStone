/**
 * 
 */
package fr.hearthstone.main.designpattern.decorator;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;

/**
 * @author Maxime
 *
 */
public abstract class ServiteurDecorator extends Serviteur{
	
	protected Serviteur serviteur;
	
	public ServiteurDecorator(Serviteur serviteur) {
		this.serviteur = serviteur;
	}
	
	public abstract void attack(Cible target);

}
