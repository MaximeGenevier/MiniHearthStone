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
 * @author Maxime GENEVIER
 * 
 * Sort concret du mage
 * Inflige 1 point de dégats aux serviteurs ennemis
 *
 */
public class ExplosionDesArcanes extends Sort{

	/**
	 * @param player
	 */
	public ExplosionDesArcanes(Joueur player) {
		super("Explosion des arcanes", 2, player, "Inflige 1 point de dégats aux serviteurs adverses.");
	}

	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.carte.sort.Sort#useSpell(fr.hearthstone.main.modele.Cible)
	 */
	@Override
	public void useSpell(Cible target) {
		if(this.getPlayer().getHero().useMana(this.getManaCost())) {
			ArrayList<Carte> enemiesMinions = this.getPlayer().getEnemy().getPlayedCards();
			for(int i = 0; i < enemiesMinions.size(); i++){
				boolean shouldDecrease = ((Serviteur)enemiesMinions.get(i)).getCurrentHealth() <= 1; // Un serviteur va mourir
				((Serviteur)enemiesMinions.get(i)).beAttacked(1); // inflige des degats aux serviteurs ennemis
				if(shouldDecrease){
					i--;
				}
			}
		}
	}

}
