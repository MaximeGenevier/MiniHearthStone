/**
 * 
 */
package fr.hearthstone.main.modele.carte.sort;

import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.Carte;

/**
 * @author Maxime
 *
 */
public abstract class Sort extends Carte{

	public Sort(String name, int manaCost, Joueur player) {
		super(name, manaCost, player);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
