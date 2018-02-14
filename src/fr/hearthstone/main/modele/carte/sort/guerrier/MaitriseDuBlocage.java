/**
 * 
 */
package fr.hearthstone.main.modele.carte.sort.guerrier;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.sort.Sort;

/**
 * @author Maxime GENEVIER
 * 
 * Sort concret du Guerrier
 * Ajoute 5 d'armure au héro et il pioche une carte
 *
 */
public class MaitriseDuBlocage extends Sort{

	/**
	 * @param player
	 */
	public MaitriseDuBlocage(Joueur player) {
		super("Maitrise du blocage", 3, player, "+5ARM et place une carte dans votre main.");
	}

	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.carte.sort.Sort#useSpell(fr.hearthstone.main.modele.Cible)
	 */
	@Override
	public void useSpell(Cible target) {
		if(this.getPlayer().getHero().useMana(this.getManaCost())) {
			this.getPlayer().getHero().increaseArmor(5); // incrémente l'armure
			this.getPlayer().drawCard();	// pioche une carte
		}
	}

}