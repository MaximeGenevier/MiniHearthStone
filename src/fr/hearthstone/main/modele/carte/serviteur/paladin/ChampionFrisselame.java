/**
 * 
 */
package fr.hearthstone.main.modele.carte.serviteur.paladin;

import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;

/**
 * @author Maxime GENEVIER
 * 
 * Serviteur concret du paladin
 * Possède vol de vie
 *
 */
public class ChampionFrisselame extends Serviteur{

	/**
	 * @param player
	 */
	public ChampionFrisselame(Joueur player) {
		this.player = player;
		this.name = "Champion frisselame";
		this.manaCost = 4;
		this.maxHealth = 2;
		this.currentHealth = this.maxHealth;
		this.attack = 3;
		this.canAttack = false;
		this.shouldBeAttack = false;
	}

}
