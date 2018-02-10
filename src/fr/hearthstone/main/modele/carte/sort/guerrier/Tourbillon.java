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
 * @author Maxime
 *
 */
public class Tourbillon extends Sort{

	public Tourbillon(Joueur player) {
		super("Tourbillon", 1, player, "Inflige 1 point de dégats à TOUS les serviteurs.");
	}

	@Override
	public void useSpell(Cible target) {
		if(this.getPlayer().getHero().useMana(this.getManaCost())) {
			ArrayList<Carte> enemiesMinions = this.getPlayer().getEnemy().getPlayedCards();
			ArrayList<Carte> alliesMinions = this.getPlayer().getPlayedCards();
			
			for(Carte card : enemiesMinions) {
				((Serviteur)card).beAttacked(1);
			}
			
			for(Carte card : alliesMinions) {
				((Serviteur)card).beAttacked(1);
			}
		}
	}

}
