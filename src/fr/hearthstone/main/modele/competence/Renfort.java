package fr.hearthstone.main.modele.competence;

import fr.hearthstone.main.designpattern.state.EtatDisponible;
import fr.hearthstone.main.modele.hero.Paladin;

/**
 * @author Maxime GENEVIER
 * 
 * Competence concrete Renfort du Paladin
 * 
 * Invoque une Recrue de la main d'argent
 *
 */
public class Renfort extends Competence{
	
	/**
	 * @param hero
	 */
	public Renfort(Paladin hero){
		super("Renfort", hero, "Invoque un serviteur Recrue de la Main d’argent 1/1.");
	}
	
	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.competence.Competence#useAbility()
	 */
	public void useAbility(){
		if(this.getState().getClass().equals(EtatDisponible.class)) { // Vérifie l'etat
			if(this.hero.useMana(this.abilityCost)){	// Verifie le mana
				this.abilityUsed();	// Change l'etat
				this.hero.getPlayer().playSpecialCard("RecrueDeLaMainDArgent", hero.getFactory()); // Ajoute la recrue
			}else{
				System.out.println("Vous n'avez pas assez de mana.");
			}
		}
	}
}