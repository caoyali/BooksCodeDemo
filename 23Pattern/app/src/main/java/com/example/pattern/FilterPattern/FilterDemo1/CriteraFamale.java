package com.example.pattern.FilterPattern.FilterDemo1;

import java.util.ArrayList;
import java.util.List;

class CriteraFamale implements Criteria{

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getGender().equalsIgnoreCase("FEMALE")){
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
