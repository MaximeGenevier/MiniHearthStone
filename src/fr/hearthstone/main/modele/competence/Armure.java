package fr.hearthstone.main.modele.competence;

import fr.hearthstone.main.designpattern.state.EtatDisponible;
import fr.hearthstone.main.modele.hero.Guerrier;

/**
 * @author Maxime GENEVIER
 * 
 * Compétence concrete Armure du Guerrier
 * 
 * Ajoute deux points d'armure au héro
 *
 */
public class Armure extends Competence{
	
	private int armorAmount; // Montant de l'armure ajouté
	
	/**
	 * @param hero
	 */
	public Armure(Guerrier hero){
		super("Armure", hero, "Confère 2 points d'armure au guerrier.");
		armorAmount = 2;
	}
	
	/* (non-Javadoc)
	 * @see fr.hearthstone.main.modele.competence.Competence#useAbility()
	 */
	public void useAbility(){
		if(this.getState().getClass().equals(EtatDisponible.class)) { // vérifie la disponibilité
			if(this.hero.useMana(this.abilityCost)){ // Vérifie le mana
				this.abilityUsed(); // Met a jour l'etat
				this.hero.increaseArmor(this.armorAmount); // Incrémente l'armure
			}else{
				System.out.println("Vous n'avez pas assez de mana.");
			}
		}
	}
}