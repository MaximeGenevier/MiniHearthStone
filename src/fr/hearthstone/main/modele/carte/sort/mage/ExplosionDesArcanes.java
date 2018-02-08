/**
 * 
 */
package fr.hearthstone.main.modele.carte.sort.mage;

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
public class ExplosionDesArcanes extends Sort{

	public ExplosionDesArcanes(Joueur player) {
		super("Explosion des arcanes", 2, player, "Inflige 1 point de dégats aux serviteurs adverses.");
	}

	@Override
	public void useSpell(Cible target) {
		if(this.getPlayer().getHero().useMana(this.getManaCost())) {
			ArrayList<Carte> enemiesMinions = this.getPlayer().getEnemy().getPlayedCards();
			for(Carte card : enemiesMinions) {
				((Serviteur)card).beAttacked(1);
			}
			this.getPlayer().removeHandCard(this);
		}
	}

}
