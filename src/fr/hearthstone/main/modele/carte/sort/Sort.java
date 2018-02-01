/**
 * 
 */
package fr.hearthstone.main.modele.carte.sort;

import fr.hearthstone.main.modele.carte.Carte;

/**
 * @author Maxime
 *
 */
public abstract class Sort extends Carte{

	public Sort(String name, int manaCost) {
		super(name, manaCost);
	}

}
