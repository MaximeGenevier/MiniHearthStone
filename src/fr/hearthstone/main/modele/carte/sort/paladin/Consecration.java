/**
 * 
 */
package fr.hearthstone.main.modele.carte.sort.paladin;

import java.util.ArrayList;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.Carte;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;
import fr.hearthstone.main.modele.carte.sort.Sort;

/**
 * @author Maxime
 *
 */
public class Consecration extends Sort{

	public Consecration(Joueur player) {
		super("Consécration", 4, player, "Inflige 2 points de dégats aux serviteurs ennemis.");
	}

	@Override
	public void useSpell(Cible target) {
		if(this.getPlayer().getHero().useMana(this.getManaCost())) {
			ArrayList<Carte> enemiesMinions = this.getPlayer().getEnemy().getPlayedCards();
			for(Carte card : enemiesMinions) {
				((Serviteur)card).beAttacked(2);
			}
			this.getPlayer().removeHandCard(this);
		}
	}

}
