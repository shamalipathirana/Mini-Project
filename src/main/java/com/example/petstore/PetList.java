package com.example.petstore;

import java.util.ArrayList;
import java.util.List;

public class PetList {
    private static PetList myInstance;
    public List<Pet> pets = new ArrayList<Pet>();
    Pet pet1 = new Pet();
    Pet pet2 = new Pet();
    Pet pet3 = new Pet();
    Pet pet4 = new Pet();
    Pet pet5 = new Pet();

    private PetList() {
        pet1.setPetId(1);
        pet1.setPetAge(3);
        pet1.setPetName("Boola");
        pet1.setPetType("Dog");

        pet2.setPetId(2);
        pet2.setPetAge(4);
        pet2.setPetName("Sudda");
        pet2.setPetType("Cat");

        pet3.setPetId(3);
        pet3.setPetAge(2);
        pet3.setPetName("Peththappu");
        pet3.setPetType("Parrot");

        pet4.setPetId(4);
        pet4.setPetAge(1);
        pet4.setPetName("Tutu");
        pet4.setPetType("Cat");

        pet3.setPetId(5);
        pet3.setPetAge(2);
        pet3.setPetName("Nikki");
        pet3.setPetType("Dog");

        pets.add(pet1);
        pets.add(pet2);
        pets.add(pet3);
        pets.add(pet4);
        pets.add(pet5);
    }
    public static PetList getInstance() {
        if (myInstance == null)
            myInstance = new PetList();
        return myInstance;
    }
    public void setArrayList(List<Pet> pets) {
        this.pets = pets;
    }
    public List<Pet> getArrayList() {
        return this.pets;

    }
}


