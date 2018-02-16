/**
 * 
 */
package fr.hearthstone.main.modele.carte.sort.guerrier;

import java.util.ArrayList;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.Carte;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;
import fr.hearthstone.main.modele.carte.sort.Sort;

/**
 * @author Maxime GENEVIER
 * 
 * Sort concret du guerrier
 * Inflige 1 point de dégats à tous les serviteurs
 *
 */
public class Tourbillon extends Sort{

	/**
	 * @param player
	 */
	public Tourbillon(Joueur player) {
		super("Tourbillon", 1, player, "Inflige 1 point de dégats à TOUS les serviteurs.");
	}

	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.carte.sort.Sort#useSpell(fr.hearthstone.main.modele.Cible)
	 */
	@Override
	public void useSpell(Cible target) {
		if(this.getPlayer().getHero().useMana(this.getManaCost())) {
			ArrayList<Carte> enemiesMinions = this.getPlayer().getEnemy().getPlayedCards();
			ArrayList<Carte> alliesMinions = this.getPlayer().getPlayedCards();
			
			for(int i = 0; i < enemiesMinions.size(); i++){
				boolean shouldDecrease = ((Serviteur)enemiesMinions.get(i)).getCurrentHealth() <= 1; // Un serviteur va mourir
				((Serviteur)enemiesMinions.get(i)).beAttacked(1); // inflige des dégats aux serviteurs ennemis
				if(shouldDecrease){
					i--;
				}
			}
			
			for(int i = 0; i < alliesMinions.size(); i++){
				boolean shouldDecrease = ((Serviteur)enemiesMinions.get(i)).getCurrentHealth() <= 1; // Un serviteur va mourir
				((Serviteur)alliesMinions.get(i)).beAttacked(1); // inflige des dégats aux serviteurs alliés
				if(shouldDecrease){
					i--;
				}
			}
		}
	}

}
