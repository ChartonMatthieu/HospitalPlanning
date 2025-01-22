package com.polytech.hospitalplanning.models;

import java.util.Vector ;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Roulement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    private Vector<Personne> personnes = new Vector<>();

    @ManyToMany
    private Vector<Shift> shifts = new Vector<>();

    // Méthodes

    public Integer getId() {
        return id;
    }

    public void setId(Integer newId) {
        this.id = newId;
    }

    public Vector<Personne> getPersonnes() {
        return new Vector<>(personnes);
    }

    public Vector<Shift> getShifts() {
        return new Vector<>(shifts);
    }

    public void ajouterPersonne(Personne personne) {
        personnes.add(personne);
    }

    public void ajouterShift(Shift shift) {
        shifts.add(shift);
    }

    public boolean verifierEquilibre() {
        return personnes.size() == shifts.size();
    }

    public void genererCycle() {}

    public boolean isValidRotation() {
        return personnes.size() == shifts.size();
    }

    public void addPersonneToShift(Personne personne, Shift shift) {
        personnes.add(personne);
        shifts.add(shift);
    }
}