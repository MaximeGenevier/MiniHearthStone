package fr.hearthstone.main.designpattern.state;

import fr.hearthstone.main.modele.competence.Competence;

public class EtatIndisponible implements CompetenceState{

	private Competence ability;
	
	public EtatIndisponible(Competence ability) {
		this.ability = ability;
	}

	@Override
	public void abilityUsed() {
		System.out.println("Vous avez déjà utilisé votre compétence.");
	}

	@Override
	public void abilityReloaded() {
		ability.changeStateEnable();
	}
	
}
