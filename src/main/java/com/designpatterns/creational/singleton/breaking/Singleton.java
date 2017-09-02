package com.designpatterns.creational.singleton.breaking;

/*

Reference: Singleton
http://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/

How can one break Singleton ?
http://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/

The following can break Singleton:
- Reflection
    - Use Enums

- Serialization
    - implement readResolve() method - return the same instance

- Clone-ing
    - override clone method to thrown CloneNotSupportedException
 */

public class Singleton {


}
