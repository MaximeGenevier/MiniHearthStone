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
public class Charge extends ServiteurDecorator{

	public Charge(Serviteur serviteur) {
		super(serviteur);
		serviteur.setCanAttack(true);
	}
	
	@Override
	public boolean isShouldBeAttack() {
		return serviteur.isShouldBeAttack();
	}
	
	@Override
	public void increaseAttack(int increaseAmount) {
		serviteur.increaseAttack(increaseAmount);
	}

	@Override
	public boolean beAttacked(int damageAmount) {
		return serviteur.beAttacked(damageAmount);
	}

	@Override
	public void decreaseAttack(int decreaseAmount) {
		serviteur.decreaseAttack(decreaseAmount);
	}

	@Override
	public void setCanAttack(boolean canAttack) {
		serviteur.setCanAttack(canAttack);
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
		String desc = serviteur.describe() + "\n\t{CAPACITE} = " + " Charge";
		return desc;
	}
	
	@Override
	public String toString() {
		return this.describe();
	}

}
