/**
 * 
 */
package fr.hearthstone.main.modele.hero;

import java.util.ArrayList;
import java.util.List;

import fr.hearthstone.main.designpattern.factory.CarteFactory;
import fr.hearthstone.main.designpattern.observer.HeroObserver;
import fr.hearthstone.main.designpattern.observer.Sujet;
import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.Joueur;
import fr.hearthstone.main.modele.competence.Competence;

/**
 * @author Maxime GENEVIER
 * 
 * Classe correspondant au héro générique avec un nom, des pv actuels, pv max,
 * le mana actuel et max, son armure, les cartes que le hero peut posseder,
 * et le joueur auquel il appartient
 *
 */
public abstract class Hero implements Cible, Sujet{
	
	protected String name;
	protected Competence ability;
	protected int currentHealth;
	protected int maxHealth;
	protected int currentMana;
	protected int maxMana;
	protected int armor;
	protected CarteFactory factory;
	protected List<String> availableCardsName;
	protected Joueur player;
	protected ArrayList<HeroObserver> observers;
	
	public Hero(String name, Joueur player) {
		super();
		this.name = name;
		this.currentHealth = 30;
		this.maxHealth = 30;
		this.maxMana = 1;
		this.currentMana = this.maxMana;
		this.armor = 0;
		this.player = player;
		this.observers = new ArrayList<>();
		this.availableCardsName = new ArrayList<String>();
		
		// Cette liste est utilisée pour tirer une carte aléatoirement
		// dans la méthode drawCard()
		// Est remplie ici avec les cartes communes
		this.addAvailableCardName("ChefDeRaid");
		this.addAvailableCardName("ChevaucheurDeLoup");
		this.addAvailableCardName("SanglierBrocheroc");
		this.addAvailableCardName("SoldatDuComteDeLor");
		this.addAvailableCardName("YetiNoroit");
	}

	public boolean beAttacked(int damageAmount) {
		if(this.armor > 0) {
			this.currentHealth -= this.decreaseArmor(damageAmount);
			if(this.currentHealth <= 0) {
				this.currentHealth = 0;
				setHeroStatistics();
				return true;
			}
			setHeroStatistics();
			return false;
		}else {
			this.currentHealth -= damageAmount;
			if(this.currentHealth <= 0) {
				this.currentHealth = 0;
				setHeroStatistics();
				return true;
			}
			setHeroStatistics();
			return false;
		}
	}
	
	public void beHealed(int healAmount) {
		this.currentHealth += healAmount;
		if(this.currentHealth > this.maxHealth) {
			this.currentHealth = this.maxHealth;
		}
		setHeroStatistics();
	}
	
	public void increaseArmor(int armorAmount) {
		this.armor += armorAmount;
		setHeroStatistics();
	}
	
	/**
	 * @param damageAmount
	 * @return int difference between armor and damage.
	 */
	public int decreaseArmor(int damageAmount) {
		int remainingDamage = 0;
		this.armor -= damageAmount;
		if(this.armor < 0){
			remainingDamage = this.armor;
			this.armor = 0;
		}
		setHeroStatistics();
		return remainingDamage;
	}
	
	public void increaseMaxMana() {
		this.maxMana++;
		if(this.maxMana > 10){
			this.maxMana = 10;
		}
		this.currentMana = this.maxMana;
	}
	
	public boolean useMana(int manaCost) {
		if(this.currentMana >= manaCost) {
			this.currentMana -= manaCost;
			return true;
		}else {
			System.out.println("Vous n'avez pas assez de mana.");
			return false;
		}
	}
	
	public void registerObs(HeroObserver obs) {
		observers.add(obs);
	}
	
	public void deleteObs(HeroObserver obs) {
		observers.remove(obs);
	}
	
	public void notifyObs() {
		for(HeroObserver obs : observers) {
			obs.actualize(currentHealth, currentMana, armor);
		}
	}
	
	public void setHeroStatistics() {
		notifyObs();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the currentHealth
	 */
	public int getCurrentHealth() {
		return currentHealth;
	}

	/**
	 * @param currentHealth the currentHealth to set
	 */
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	/**
	 * @return the maxHealth
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * @param maxHealth the maxHealth to set
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	/**
	 * @return the currentMana
	 */
	public int getCurrentMana() {
		return currentMana;
	}

	/**
	 * @param currentMana the currentMana to set
	 */
	public void setCurrentMana(int currentMana) {
		this.currentMana = currentMana;
	}

	/**
	 * @return the maxMana
	 */
	public int getMaxMana() {
		return maxMana;
	}

	/**
	 * @param maxMana the maxMana to set
	 */
	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	/**
	 * @return the armor
	 */
	public int getArmor() {
		return armor;
	}

	/**
	 * @param armor the armor to set
	 */
	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	public CarteFactory getFactory() {
		return factory;
	}

	/**
	 * @return the availableCardsName
	 */
	public List<String> getAvailableCardsName() {
		return availableCardsName;
	}

	public void addAvailableCardName(String name) {
		this.availableCardsName.add(name);
	}
	
	/**
	 * @return the player
	 */
	public Joueur getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Joueur player) {
		this.player = player;
	}

	/**
	 * @return the ability
	 */
	public Competence getAbility() {
		return ability;
	}

	/**
	 * @param ability the ability to set
	 */
	public void setAbility(Competence ability) {
		this.ability = ability;
	}

	public String describe() {
		String desc = "[HERO] {NOM} = " + this.getName() + "\n\t{VIE} = " + this.currentHealth + "/" + this.maxHealth 
				+ "\t{MANA} = " + this.currentMana + "/" + this.maxMana + "\t{ARMURE} = " + this.armor
				+ "\n" + this.ability.describe();
		return desc;
	}
	
	@Override
	public String toString() {
		return this.describe();
	}
	
}
