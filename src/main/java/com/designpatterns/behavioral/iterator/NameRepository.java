package com.designpatterns.behavioral.iterator;


/*

Iterator pattern is very commonly used design pattern in Java and .Net programming environment. This pattern is used to
 get a way to access the elements of a collection object in sequential manner without any need to know its underlying
 representation.

Iterator pattern falls under behavioral pattern category.

Implementation
We're going to create a Iterator interface which narrates navigation method and a Container interface which retruns the
 iterator . Concrete classes implementing the Container interface will be responsible to implement Iterator interface
  and use it

IteratorPatternDemo, our demo class will use NamesRepository, a concrete class implementation to print a Names stored
as a collection in NamesRepository.


 */

/*
Step 2
Create concrete class implementing the Container interface. This class has inner class NameIterator
implementing the Iterator interface.

 */

/*
Step 4
Verify the output.

Name : Robert
Name : John
Name : Julie
Name : Lora

 */
public class NameRepository implements Container {
    public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};

    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        public boolean hasNext() {

            if(index < names.length){
                return true;
            }
            return false;
        }

        public Object next() {

            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}