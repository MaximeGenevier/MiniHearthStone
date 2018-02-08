/**
 * 
 */
package fr.hearthstone.main.vue;

import fr.hearthstone.main.controleur.ControleurJeu;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.hero.Hero;
import fr.hearthstone.main.modele.hero.Mage;
import fr.hearthstone.main.modele.hero.Paladin;

/**
 * @author maxime
 *
 */
public class MiniHearthstone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Joueur joueur1 = new Joueur("Arthas Menethil");
		Joueur joueur2 = new Joueur("Antonidas");
		
		Hero paladin = new Paladin(joueur1);
		Hero mage = new Mage(joueur2);
		
		joueur1.setHero(paladin);
		joueur2.setHero(mage);
		
		joueur1.setEnemy(joueur2);
		joueur2.setEnemy(joueur1);
		
		ControleurJeu controleur = new ControleurJeu(joueur1, joueur2);
		controleur.gameBegins();
		
	}

}
