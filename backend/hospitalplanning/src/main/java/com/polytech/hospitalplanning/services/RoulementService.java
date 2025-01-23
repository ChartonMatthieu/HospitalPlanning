package com.polytech.hospitalplanning.services;

import java.util.Vector;
import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.hospitalplanning.models.Roulement;
import com.polytech.hospitalplanning.repositories.RoulementRepository;

@Service
public class RoulementService {
    // Vérifie si le roulement est équilibré
    public boolean verifierEquilibre(Roulement roulement) {
        return roulement.getPersonnes().size() == roulement.getShifts().size();
    }

    // Génère un cycle pour un roulement
    public void genererCycle(Roulement roulement) {
        Vector<Personne> personnes = roulement.getPersonnes();
        Vector<Shift> shifts = roulement.getShifts();

        if (personnes.isEmpty() || shifts.isEmpty()) {
            throw new IllegalStateException("Le roulement ne peut pas être généré : aucune personne ou aucun shift disponible.");
        }

        // Exemple de logique : assignation circulaire des shifts aux personnes
        for (int i = 0; i < shifts.size(); i++) {
            Personne personne = personnes.get(i % personnes.size());
            Shift shift = shifts.get(i);
            assignerShift(personne, shift);
        }
    }

    // Ajoute une personne au roulement
    public void ajouterPersonne(Roulement roulement, Personne personne) {
        roulement.getPersonnes().add(personne);
    }

    // Ajoute un shift au roulement
    public void ajouterShift(Roulement roulement, Shift shift) {
        roulement.getShifts().add(shift);
    }

    // Méthode simulée pour assigner un shift à une personne (peut être remplacée par une vraie logique)
    private void assignerShift(Personne personne, Shift shift) {}

    private final RoulementRepository repository;

    public RoulementService(RoulementRepository repository) {
        this.repository = repository;
    }

    public List<Roulement> findAll() {
        return repository.findAll();
    }

    public Roulement save(Roulement roulement) {
        return repository.save(roulement);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
