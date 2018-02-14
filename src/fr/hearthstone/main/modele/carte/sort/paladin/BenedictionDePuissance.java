/**
 * 
 */
package fr.hearthstone.main.modele.carte.sort.paladin;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;
import fr.hearthstone.main.modele.carte.sort.Sort;

/**
 * @author Maxime GENEVIER
 * 
 * Sort concret du paladin
 * Ajoute 3 d'attaque a un serviteur
 *
 */
public class BenedictionDePuissance extends Sort{

	/**
	 * @param player
	 */
	public BenedictionDePuissance(Joueur player) {
		super("Bénédiction de puissance", 1, player, "Confère +3ATQ à un serviteur");
	}

	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.carte.sort.Sort#useSpell(fr.hearthstone.main.modele.Cible)
	 */
	@Override
	public void useSpell(Cible target) {
		if(this.getPlayer().getHero().useMana(this.getManaCost())){
			((Serviteur)target).increaseAttack(3); // Incrémente l'attaque
		}
	}

}
