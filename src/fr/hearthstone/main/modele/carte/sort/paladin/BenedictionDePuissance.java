/**
 * 
 */
package fr.hearthstone.main.modele.carte.sort.paladin;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.carte.serviteur.Serviteur;
import fr.hearthstone.main.modele.carte.sort.Sort;

/**
 * @author Maxime
 *
 */
public class BenedictionDePuissance extends Sort{

	public BenedictionDePuissance(Joueur player) {
		super("Bénédiction de puissance", 1, player, "Confère +3ATQ à un serviteur");
	}

	@Override
	public void useSpell(Cible target) {
		if(this.getPlayer().getHero().useMana(this.getManaCost())){
			((Serviteur)target).increaseAttack(3);
		}
	}

}
