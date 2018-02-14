package fr.hearthstone.main.designpattern.observer;


/**
 * @author Maxime GENEVIER
 * 
 * Pattern Observer pour afficher les changements
 * de statistiques des héros : vie, mana, armure
 *
 */
public interface HeroObserver {

	public void actualize(int currentHealth, int currentMana, int currentArmor);
	
}
