/**
 * 
 */
package fr.hearthstone.main.modele.carte.sort.mage;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.Carte;
import fr.hearthstone.main.modele.carte.sort.Sort;

/**
 * @author Maxime
 *
 */
public class Metamorphose extends Sort{

	public Metamorphose(Joueur player) {
		super("Métamorphose", 4, player, "Transforme un serviteur en serviteur 1/1/1 sans effet spécial.");
	}

	@Override
	public void useSpell(Cible target) {
		if(this.getPlayer().getHero().useMana(this.getManaCost())) {
			this.getPlayer().removePlayedCard(((Carte)target));
			this.getPlayer().playSpecialCard("Mouton");
			this.getPlayer().removeHandCard(this);
		}
	}

}
