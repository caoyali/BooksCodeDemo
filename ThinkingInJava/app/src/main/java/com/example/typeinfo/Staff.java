package com.example.typeinfo;

import java.util.ArrayList;

public class Staff extends ArrayList<Position> {
    public void add(String title, Person person) {
        add(new Position(title, person));
    }

    public Staff(String... titles) {
        for (String t : titles) {
            add(new Position(t));
        }
    }

    public boolean positionAvaliable(String title) {
        for (Position position : this) {
            if (title.equals(position.getTitle())) {
                return position.getPerson() != Person.NULL;
            }
        }
        return false;
    }

    public void fillPosition(String title, Person hire) {
        for (Position position : this) {
            if (title.equals(position.getTitle()) && Person.NULL == position.getPerson()) {
                position.setPerson(hire);
            }
        }
    }

}
