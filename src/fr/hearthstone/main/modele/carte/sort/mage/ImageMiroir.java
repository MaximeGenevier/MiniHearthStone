/**
 * 
 */
package fr.hearthstone.main.modele.carte.sort.mage;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.sort.Sort;

/**
 * @author Maxime
 *
 */
public class ImageMiroir extends Sort{

	public ImageMiroir(Joueur player) {
		super("Image miroir", 1, player, "Invoque 2 serviteurs 0/0/2 avec Provocation");
	}

	@Override
	public void useSpell(Cible target) {		
		if(this.getPlayer().getHero().useMana(this.getManaCost())) {
			this.getPlayer().playSpecialCard("Reflet");
			this.getPlayer().playSpecialCard("Reflet");
			this.getPlayer().removeHandCard(this);
		}
	}

}
