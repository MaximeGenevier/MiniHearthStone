/**
 * 
 */
package fr.hearthstone.main.modele.carte.sort.mage;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.sort.Sort;

/**
 * @author Maxime GENEVIER
 * 
 * Sort concret du mage
 * Créé 2 serviteurs Reflet (dont le nom est ImageMiroir) avec provocation et 2 points de vie
 *
 */
public class ImageMiroir extends Sort{

	/**
	 * @param player
	 */
	public ImageMiroir(Joueur player) {
		super("Image miroir", 1, player, "Invoque 2 serviteurs 0/0/2 avec Provocation");
	}

	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.carte.sort.Sort#useSpell(fr.hearthstone.main.modele.Cible)
	 */
	@Override
	public void useSpell(Cible target) {		
		if(this.getPlayer().getHero().useMana(this.getManaCost())) {
			this.getPlayer().playSpecialCard("Reflet", this.getPlayer().getHero().getFactory()); // Créé les images miroirs
			this.getPlayer().playSpecialCard("Reflet", this.getPlayer().getHero().getFactory());
		}
	}

}
