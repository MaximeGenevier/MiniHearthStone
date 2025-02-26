/**
 * 
 */
package fr.hearthstone.main.designpattern.decorator;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;

/**
 * @author Maxime GENEVIER
 * 
 * Décorateur concret de Serviteur
 * 
 * Permet à un Serviteur d'obtenir Provocation
 * Celui ci doit être tué avant de pouvoir cibler 
 * le héro ou les autres serviteurs adverses
 *
 */
public class Provocation extends ServiteurDecorator{

	public Provocation(Serviteur serviteur) {
		super(serviteur);
		serviteur.setShouldBeAttacked(true); // Surcharge constructeur
	}

	@Override
	public void die() {
		serviteur.die();
	}
	
	@Override
	public boolean isShouldBeAttack() {
		return serviteur.isShouldBeAttack();
	}
	
	@Override
	public void setCanAttack(boolean canAttack) {
		serviteur.setCanAttack(canAttack);
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
		String desc = serviteur.describe() + "\n\t{CAPACITE} = " + " Provocation"; // Surcharge describe()
		return desc;
	}
	
	@Override
	public String toString() {
		return this.describe();
	}
}
