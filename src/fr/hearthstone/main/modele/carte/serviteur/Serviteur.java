/**
 * 
 */
package fr.hearthstone.main.modele.carte.serviteur;

import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.carte.Carte;

/**
 * @author Maxime GENEVIER
 * 
 * Serviteur abstrait, un serviteur connait sa vie actuelle, sa vie
 * maximum, son attaque, s'il peut attaquer et s'il doit etre attaqué
 *
 */
public abstract class Serviteur extends Carte implements Cible{

	protected int 		currentHealth;		// Vie actuelle
	protected int 		maxHealth;			// Vie maximum
	protected int 		attack;				// Montant de l'attaque
	protected boolean 	shouldBeAttack;		// Vrai lorsque le serviteur a provocation
	protected boolean 	canAttack;			// Faux par défaut, vaut vrai lorsque le serviteur a charge ou lorsque un tour commence
	
	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.Cible#attack(fr.hearthstone.main.modele.Cible)
	 */
	public void attack(Cible target) {
		if(this.canAttack) {
			target.beAttacked(this.attack); // attaque la cible
			this.canAttack = false;			// Change la possibilité d'attaque
		}else {
			System.out.println("Ce serviteur ne peut pas encore attaquer.");
		}
	}
	
	/**
	 * Implémentée lorsqu'une carte à un effet spécial sur le terrain lorsqu'elle 
	 * est invoquée (ChefDeRaid)
	 */
	public void proceed() {
		
	}
	
	/**
	 * Appelée lorsque le serviteur meurt
	 * Le retire des cartes du plateau du joueur
	 */
	public void die() {
		this.getPlayer().removePlayedCard(this);
	}
	
	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.Cible#beAttacked(int)
	 */
	public boolean beAttacked(int damageAmount) {
		this.currentHealth -= damageAmount;
		if(this.currentHealth <= 0) { // Si les pv du serviteur sont < 0
			this.currentHealth = 0;
			System.out.println(this.getName() + " meurt.");
			this.die(); // Le serviteur meurt
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.Cible#beHealed(int)
	 */
	public void beHealed(int healAmount) {
		// En prevision d'autres cartes : sort de soin par exemple
		this.currentHealth += healAmount;
		
		if(this.currentHealth > this.maxHealth) {
			this.currentHealth = this.maxHealth;
		}
		
	}
	
	/**
	 * Appelée pour incrémenter l'attaque du serviteur
	 * @param increaseAmount
	 */
	public void increaseAttack(int increaseAmount) {
		this.attack += increaseAmount;
	}
	
	/**
	 * Appelée pour décrémenter l'attaque du serviteur
	 * @param decreaseAmount
	 */
	public void decreaseAttack(int decreaseAmount) {
		this.attack -= decreaseAmount;
	}
	
	/**
	 * Appelée pour incrémenter la vie maximum du serviteur et 
	 * met  à jour sa vie actuelle
	 * @param increaseAmount
	 */
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
	public void setShouldBeAttacked(boolean shouldBeAttack) {
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
	
	@Override
	public String describe() {
		String peutAttaquer = "Faux";
		String doitEtreAttaquer = "Faux";
		
		if(this.canAttack == true) {
			peutAttaquer = "Vrai";
		}
		
		if(this.shouldBeAttack == true) {
			doitEtreAttaquer = "Vrai";
		}
		
		String desc = super.describe() + "\t{ATTAQUE} = " + this.getAttack() + "\t{VIE} = " + this.getCurrentHealth()
			+ "\n\t{PEUT ATTAQUER} = " + peutAttaquer + "\t{DOIT ETRE ATTAQUE} = " + doitEtreAttaquer;
		
		return desc;
	}
	
	@Override
	public String toString() {
		return this.describe();
	}
}