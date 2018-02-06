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
public class Charge extends ServiteurDecorator{

	public Charge(Serviteur serviteur) {
		super(serviteur);
		serviteur.setCanAttack(true);
	}
	
	@Override
	public void attack(Cible target) {
		serviteur.attack(target);
	}
	
	@Override
	public String describe() {
		String desc = serviteur.describe() + "\n\t{CAPACITE} = " + " Charge";
		return desc;
	}
	
	@Override
	public String toString() {
		return this.describe();
	}
	

}
