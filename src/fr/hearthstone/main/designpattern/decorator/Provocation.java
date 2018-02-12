/**
 * 
 */
package fr.hearthstone.main.designpattern.decorator;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;

/**
 * @author Maxime
 *
 */
public class Provocation extends ServiteurDecorator{

	public Provocation(Serviteur serviteur) {
		super(serviteur);
		serviteur.setShouldBeAttack(true);
	}

	@Override
	public void die() {
		serviteur.die();
	}



	@Override
	public String getName() {
		return serviteur.getName();
	}



	@Override
	public int getManaCost() {
		return serviteur.getManaCost();
	}



	@Override
	public Joueur getPlayer() {
		return serviteur.getPlayer();
	}



	@Override
	public void attack(Cible target) {
		serviteur.attack(target);
	}
	
	@Override
	public String describe() {
		String desc = serviteur.describe() + "\n\t{CAPACITE} = " + " Provocation";
		return desc;
	}
	
	@Override
	public String toString() {
		return this.describe();
	}
}
