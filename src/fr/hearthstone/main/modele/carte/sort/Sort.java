/**
 * 
 */
package fr.hearthstone.main.modele.carte.sort;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.Carte;

/**
 * @author Maxime GENEVIER
 * 
 * Sort abstrait
 * Un sort est utilisé (methode useSpell)
 *
 */
public abstract class Sort extends Carte{
	
	/**
	 * @param name
	 * @param manaCost
	 * @param player
	 * @param description
	 */
	public Sort(String name, int manaCost, Joueur player, String description) {
		super(name, manaCost, player, description);
	}
	
	/**
	 * Appelée pour déclencher l'effet du sort
	 * @param target Cible la cible du sort, par défaut tous les sorts ont une cible
	 */
	public abstract void useSpell(Cible target);
	
	@Override
	public String toString() {
		return super.toString();
	}

}
