package clinicapp;

import java.util.Objects;

public class Patients {

    private String name;
    private Owner owner;
    private Species species;

    public Patients(String name, Owner owner, Species species) {
        this.name = name;
        this.owner = owner;
        this.species = species;
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patients patient = (Patients) o;
        return Objects.equals(name, patient.name) && Objects.equals(owner, patient.owner) && species == patient.species;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, owner, species);
    }

    public String getInfo() {
        return this.name + " " + this.owner.getInfo() + " " + this.species;


   }
 }
