package fr.hearthstone.main.designpattern.state;

import fr.hearthstone.main.modele.competence.Competence;

/**
 * 
 * @author Maxime GENEVIER
 *
 * Etat concret pour les Competence
 * Etat indisponible : lorsque la compétence 
 * a été utilisée
 */
public class EtatIndisponible implements CompetenceState{

	private Competence ability;
	
	public EtatIndisponible(Competence ability) {
		this.ability = ability;
	}

	@Override
	public void abilityUsed() {
		System.out.println("Vous avez déjà utilisé votre compétence."); // Compétence déjà utilisée
	}

	@Override
	public void abilityReloaded() {
		ability.changeStateEnable(); // Change l'état à disponible
	}
	
}
