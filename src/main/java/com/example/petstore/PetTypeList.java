package com.example.petstore;
import java.util.ArrayList;
import java.util.List;

public class PetTypeList {

    private static PetTypeList myInstance;
    public List<PetTypes> petTypes = new ArrayList<PetTypes>();
    PetTypes petTypes1 = new PetTypes();
    PetTypes petTypes2 = new PetTypes();
    PetTypes petTypes3 = new PetTypes();
    PetTypes petTypes4 = new PetTypes();
    private PetTypeList() {

        petTypes1.setPetTypeId(1);
        petTypes1.setPetType("Dogs");
        petTypes1.setPetsQuantity(15);

        petTypes2.setPetTypeId(2);
        petTypes2.setPetType("Cats");
        petTypes2.setPetsQuantity(20);

        petTypes3.setPetTypeId(3);
        petTypes3.setPetType("Parrots");
        petTypes3.setPetsQuantity(15);

        petTypes4.setPetTypeId(4);
        petTypes4.setPetType("Rabbits");
        petTypes4.setPetsQuantity(30);

        petTypes.add(petTypes1);
        petTypes.add(petTypes2);
        petTypes.add(petTypes3);
        petTypes.add(petTypes4);
    }
    public static PetTypeList getInstance() {
        if (myInstance == null)
            myInstance = new PetTypeList();
        return myInstance;
    }
    public void setArrayList(List<PetTypes> petTypes) {
        this.petTypes = petTypes;
    }
    public List<PetTypes> getArrayList() {
        return this.petTypes;
    }
}


