package com.example.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class <? extends Pet>> sTypes = new ArrayList<>();

    private static String[] sTypeNames = new String[] {
            "com.example.typeinfo.pets.Pet",
            "com.example.typeinfo.pets.Cymric",
            "com.example.typeinfo.pets.Dog",
            "com.example.typeinfo.pets.EgyptianMau",
            "com.example.typeinfo.pets.Hamster",
            "com.example.typeinfo.pets.Manx",
            "com.example.typeinfo.pets.Mouse",
            "com.example.typeinfo.pets.Mutt",
            "com.example.typeinfo.pets.Pug",
            "com.example.typeinfo.pets.Rat",
            "com.example.typeinfo.pets.Rodent",
    };

    private static void loadClasses() {
        String name = "";
        for(int i = 0; i <sTypeNames.length; i++){
            name = sTypeNames[i];
            Class<? extends Pet> petClass = null;
            try {
                petClass = (Class<? extends Pet>) Class.forName(name);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            sTypes.add(petClass);
        }
    }
    static {
        loadClasses();
    }
    @Override
    public List<Class<? extends Pet>> types() {
        return sTypes;
    }
}
