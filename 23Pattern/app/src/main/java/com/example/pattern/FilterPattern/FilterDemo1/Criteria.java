package com.example.pattern.FilterPattern.FilterDemo1;

import java.util.List;

public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
