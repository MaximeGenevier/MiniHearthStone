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
 * Decorateur concret de Serviteur 
 * Confère vol de vie à un Serviteur
 * Lorsqu'il attaque, il rend à son héro 
 * un montant de point de vie égal à son
 * attaque
 *
 */
public class VolDeVie extends ServiteurDecorator{

	public VolDeVie(Serviteur serviteur) {
		super(serviteur);
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
	public void increaseAttack(int increaseAmount) {
		serviteur.increaseAttack(increaseAmount);
	}
	
	@Override
	public void setCanAttack(boolean canAttack) {
		serviteur.setCanAttack(canAttack);
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
		if(serviteur.isCanAttack()) { // Redéfinie la méthode Serviteur.attack()
			serviteur.attack(target);
			serviteur.getPlayer().getHero().beHealed(serviteur.getAttack()); // Rend les PV au héro
		}
	}

	@Override
	public String describe() {
		String desc = serviteur.describe() + "\n\t{CAPACITE} = " + " Vol de vie"; // Surcharge describe()
		return desc;
	}
	
	@Override
	public String toString() {
		return this.describe();
	}
	
}
