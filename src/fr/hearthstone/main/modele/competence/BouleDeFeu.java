package fr.hearthstone.main.modele.competence;

import fr.hearthstone.main.designpattern.state.EtatDisponible;
import fr.hearthstone.main.modele.Cible;
import fr.hearthstone.main.modele.hero.Mage;

/**
 * @author Maxime GENEVIER
 * 
 * Competence concrete Boule de feu du Mage
 * 
 * Inflige 2 points de dégats à une cible
 *
 */
public class BouleDeFeu extends Competence{
	
	private int damageAmount; // Montant des dommages
	
	/**
	 * @param hero
	 */
	public BouleDeFeu(Mage hero){
		super("Boule de feu", hero, "Inflige 1 point de dégâts à un adversaire.");
		this.damageAmount = 2;
	}
	
	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.competence.Competence#useAbility(fr.hearthstone.main.modele.Cible)
	 */
	@Override
	public void useAbility(Cible target){
		if(this.getState().getClass().equals(EtatDisponible.class)) { // vérifie la disponibilité
			if(this.hero.useMana(this.abilityCost)){	// Vérifie le mana
				this.abilityUsed();	// Change l'etat
				target.beAttacked(this.damageAmount);	// Inflige les dégats
			}else{
				System.out.println("Vous n'avez pas assez de mana.");
			}
		}
	}

	@Override
	public void useAbility() {
		
	}
}