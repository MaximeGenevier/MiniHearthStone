package fr.hearthstone.main.designpattern.state;

import fr.hearthstone.main.modele.competence.Competence;

/**
 * 
 * @author Maxime GENEVIER
 * 
 * Etat concret pour les Competence
 * Etat disponible : lorsque la compétence 
 * n'a pas été utilisée
 *
 */
public class EtatDisponible implements CompetenceState{

	private Competence ability;
	
	public EtatDisponible(Competence ability) {
		this.ability = ability;
	}

	@Override
	public void abilityUsed() {
		this.ability.changeStateDisable(); // Change l'état disponible à indisponible
	}

	@Override
	public void abilityReloaded() {
		System.out.println("Compétence disponible."); // L'état est déjà à disponible
	}
}
