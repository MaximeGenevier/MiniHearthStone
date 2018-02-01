/**
 * 
 */
package fr.hearthstone.main.modele.carte.serviteur;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.carte.Carte;
import fr.hearthstone.main.modele.hero.Hero;

/**
 * @author Maxime
 *
 */
public abstract class Serviteur extends Carte implements Cible{

	private int currentHealth;
	private int maxHealth;
	private int attack;
	private boolean shouldBeAttack;
	private boolean canAttack;
	
	public Serviteur(String name, int manaCost, int maxHealth, int attack,
			boolean shouldBeAttack, boolean canAttack) {
		super(name, manaCost);
		this.maxHealth = maxHealth;
		this.currentHealth = this.maxHealth;
		this.attack = attack;
		this.shouldBeAttack = shouldBeAttack;
		this.canAttack = canAttack;
	}
	
	public void attack(Cible target) {
		target.beAttacked(this.attack);
	}
	
	public boolean beAttacked(int damageAmount) {
		if(this.currentHealth > damageAmount) {
			this.currentHealth -= damageAmount;
			return false;
		}else {
			System.out.println(this.getName() + " die.");
			return true;
		}
	}
	
	public void beHealed(int healAmount) {
		
		this.currentHealth += healAmount;
		
		if(this.currentHealth > this.maxHealth) {
			this.currentHealth = this.maxHealth;
		}
		
	}
	
	public void increaseAttack(int increaseAmount) {
		this.attack += increaseAmount;
	}
	
	public void increaseMaxHealth(int increaseAmount) {
		this.maxHealth += increaseAmount;
		this.currentHealth += increaseAmount;
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
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * @return the shouldBeAttack
	 */
	public boolean isShouldBeAttack() {
		return shouldBeAttack;
	}

	/**
	 * @param shouldBeAttack the shouldBeAttack to set
	 */
	public void setShouldBeAttack(boolean shouldBeAttack) {
		this.shouldBeAttack = shouldBeAttack;
	}

	/**
	 * @return the canAttack
	 */
	public boolean isCanAttack() {
		return canAttack;
	}

	/**
	 * @param canAttack the canAttack to set
	 */
	public void setCanAttack(boolean canAttack) {
		this.canAttack = canAttack;
	}
	
}