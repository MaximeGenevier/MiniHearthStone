/**
 * 
 */
package fr.hearthstone.main.modele.hero;

import fr.hearthstone.main.modele.Cible;

/**
 * @author Maxime
 *
 */
public abstract class Hero implements Cible{
	
	private String name;
	private int currentHealth;
	private int maxHealth;
	private int currentMana;
	private int maxMana;
	private int armor;
	
	public Hero(String name) {
		super();
		this.name = name;
		this.currentHealth = 30;
		this.maxHealth = 30;
		this.maxMana = 1;
		this.currentMana = this.maxMana;
		this.armor = 0;
	}

	public boolean beAttacked(int damageAmount) {
		displayOnScreen("Current health: " + currentHealth + " Damage amount : " + damageAmount);
		if(this.armor > 0) {
			this.currentHealth -= this.decreaseArmor(damageAmount);
			if(this.currentHealth < 0) {
				displayOnScreen("Hero die");
				return true;
			}else {
				displayOnScreen("Hero still alive");
				return false;
			}
		}else {
			if(this.currentHealth > damageAmount) {
				this.currentHealth -= damageAmount;
				displayOnScreen("Hero still alive");
				return false;
			}else {
				displayOnScreen("Hero die");
				return true;
			}
		}
	}
	
	public void beHealed(int healAmount) {
		this.currentHealth += healAmount;
		if(this.currentHealth > this.maxHealth) {
			this.currentHealth = this.maxHealth;
		}
	}
	
	public void increaseArmor(int armorAmount) {
		this.armor += armorAmount;
		displayOnScreen("Armor amount : " + armor);
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
		displayOnScreen("Remaining damage : " + Integer.toString(remainingDamage));
		return remainingDamage;
	}
	
	public void increaseMaxMana() {
		this.maxMana++;
		displayOnScreen("Max Mana: " + Integer.toString(this.maxMana));
		this.currentMana = this.maxMana;
		displayOnScreen("Current Mana : " + Integer.toString(this.currentMana));
	}
	
	private void displayOnScreen(String message) {
		System.out.println("Display : " + message);
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
	
}
