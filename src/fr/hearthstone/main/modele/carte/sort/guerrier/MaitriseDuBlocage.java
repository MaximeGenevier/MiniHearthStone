/**
 * 
 */
package fr.hearthstone.main.modele.carte.sort.guerrier;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.sort.Sort;

/**
 * @author Maxime
 *
 */
public class MaitriseDuBlocage extends Sort{

	public MaitriseDuBlocage(Joueur player) {
		super("Maitrise du blocage", 3, player, "+5ARM et place une carte dans votre main.");
	}

	@Override
	public void useSpell(Cible target) {
		if(this.getPlayer().getHero().useMana(this.getManaCost())) {
			this.getPlayer().getHero().increaseArmor(5);
			this.getPlayer().drawCard();
		}
	}

}