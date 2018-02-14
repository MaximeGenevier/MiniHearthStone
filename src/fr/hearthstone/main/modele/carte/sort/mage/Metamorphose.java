/**
 * 
 */
package fr.hearthstone.main.modele.carte.sort.mage;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.Carte;
import fr.hearthstone.main.modele.carte.sort.Sort;

/**
 * @author Maxime GENEVIER
 * 
 * Sort concret du mage
 * Transforme un serviteur ennemi en mouton 1/1/1
 *
 */
public class Metamorphose extends Sort{

	/**
	 * @param player
	 */
	public Metamorphose(Joueur player) {
		super("Métamorphose", 4, player, "Transforme un serviteur en serviteur 1/1/1 sans effet spécial.");
	}

	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.carte.sort.Sort#useSpell(fr.hearthstone.main.modele.Cible)
	 */
	@Override
	public void useSpell(Cible target) {
		if(this.getPlayer().getHero().useMana(this.getManaCost())) {
			Joueur player = ((Carte)target).getPlayer();
			player.removePlayedCard(((Carte)target)); // Retire le serviteur
			player.playSpecialCard("Mouton", this.getPlayer().getHero().getFactory()); // Ajoute le mouton
		}
	}

}
