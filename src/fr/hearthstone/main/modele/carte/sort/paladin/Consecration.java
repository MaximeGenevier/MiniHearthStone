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
 * @author Maxime GENEVIER
 * 
 * Sort concret du paladin
 * Inflige 2 points de dégats aux serviteurs ennemis
 *
 */
public class Consecration extends Sort{

	/**
	 * @param player
	 */
	public Consecration(Joueur player) {
		super("Consécration", 4, player, "Inflige 2 points de dégats aux ennemis.");
	}

	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.carte.sort.Sort#useSpell(fr.hearthstone.main.modele.Cible)
	 */
	@Override
	public void useSpell(Cible target) {
		if(this.getPlayer().getHero().useMana(this.getManaCost())) {
			ArrayList<Carte> enemiesMinions = this.getPlayer().getEnemy().getPlayedCards();
			for(int i = 0; i < enemiesMinions.size(); i++) {
				boolean shouldDecrease = ((Serviteur)enemiesMinions.get(i)).getCurrentHealth() <= 2; // Un serviteur va mourir
				((Serviteur)enemiesMinions.get(i)).beAttacked(2); // inflige des dégats aux serviteurs ennemis
				if(shouldDecrease){
					i--;
				}
			}
			this.getPlayer().getEnemy().getHero().beAttacked(2);
		}
	}

}
