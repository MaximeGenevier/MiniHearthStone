package fr.hearthstone.main.designpattern.state;

import fr.hearthstone.main.modele.competence.Competence;

public class EtatDisponible implements CompetenceState{

	private Competence ability;
	
	public EtatDisponible(Competence ability) {
		this.ability = ability;
	}

	@Override
	public void abilityUsed() {
		this.ability.changeStateDisable();
	}

	@Override
	public void abilityReloaded() {
		System.out.println("Compétence disponible.");
	}
}
