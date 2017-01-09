package com.designpatterns.structural.filter.impl1;

import java.util.List;

/*

Step 2
Create an interface for Criteria

 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}