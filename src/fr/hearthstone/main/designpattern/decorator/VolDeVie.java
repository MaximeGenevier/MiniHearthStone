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
public class VolDeVie extends ServiteurDecorator{

	public VolDeVie(Serviteur serviteur) {
		super(serviteur);
	}
	
	@Override
	public void attack(Cible target) {
		serviteur.attack(target);
		serviteur.getPlayer().getHero().beHealed(serviteur.getAttack());
	}

	@Override
	public String describe() {
		String desc = serviteur.describe() + "\n\t{CAPACITE} = " + " Vol de vie";
		return desc;
	}
	
	@Override
	public String toString() {
		return this.describe();
	}
	
}
