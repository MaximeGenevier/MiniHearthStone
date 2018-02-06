/**
 * 
 */
package fr.hearthstone.main.modele.carte.serviteur.paladin;

import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;

/**
 * @author Maxime
 *
 */
public class ChampionFrisselame extends Serviteur{

	public ChampionFrisselame(Joueur player) {
		this.name = "Champion frisselame";
		this.manaCost = 4;
		this.maxHealth = 2;
		this.currentHealth = this.maxHealth;
		this.attack = 3;
		this.canAttack = false;
		this.shouldBeAttack = false;
		this.player = player;
	}

}
