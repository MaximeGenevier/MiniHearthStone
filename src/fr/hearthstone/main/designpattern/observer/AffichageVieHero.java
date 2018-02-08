/**
 * 
 */
package fr.hearthstone.main.designpattern.observer;

import fr.hearthstone.main.modele.hero.Hero;

/**
 * @author maxime
 *
 */
public class AffichageVieHero implements HeroObserver, HeroAffichage{

	private int heroCurrentHealth;
	private int heroCurrentMana;
	private int heroCurrentArmor;
	private Sujet hero;
	
	public AffichageVieHero(Sujet hero) {
		this.hero = hero;
		this.hero.registerObs(this);
	}
	
	@Override
	public void print() {
		System.out.println("[HERO]" + ((Hero)hero).getName() + "\n\t{VIE} : " + heroCurrentHealth
				+ " {MANA} : " + heroCurrentMana + " {ARMURE} : " + heroCurrentArmor);
	}

	@Override
	public void actualize(int currentHealth, int currentMana, int currentArmor) {
		this.heroCurrentHealth = currentHealth;
		this.heroCurrentMana = currentMana;
		this.heroCurrentArmor = currentArmor;
		this.print();
	}

}
