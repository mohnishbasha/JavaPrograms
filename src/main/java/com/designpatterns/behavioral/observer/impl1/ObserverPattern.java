package com.designpatterns.behavioral.observer.impl1;

interface Shape{
    public void draw();
}

class Circle implements Shape{
    public void draw(){
        System.out.println(" inside Circle object ");
    }
}

class Rectangle implements Shape{
    public void draw(){
        System.out.println(" inside Rectangle object ");
    }
}

class Polygon implements Shape{
    public void draw(){
        System.out.println(" inside Polygon object ");
    }
}

class ShapeFactory extends AbstractFactory {

    public Shape getShape(String shape){
        if(shape.equals("Circle"))
            return new Circle();
        else if(shape.equals("Rectangle"))
            return new Rectangle();
        else if(shape.equals("Polygon"))
            return new Polygon();
        return null;
    }

    public Color getColor(String color) {
        return null;
    }
}


interface Color{
    public void fill();
}

class Red implements Color{
    public void fill(){
        System.out.println(" inside color red object ");
    }
}

class Green implements Color{
    public void fill(){
        System.out.println(" inside color gren object ");
    }
}

class Blue implements Color{
    public void fill(){
        System.out.println(" inside color blue object ");
    }
}

class ColorFactory extends AbstractFactory {

    public Color getColor(String color){
        if(color.equals("Red"))
            return new Red();
        else if(color.equals("Green"))
            return new Green();
        else if(color.equals("Blue"))
            return new Blue();
        return null;
    }

    public Shape getShape(String shape) {
        return null;
    }


}

abstract class AbstractFactory{
    public abstract Shape getShape(String shape);
    public abstract Color getColor(String color);
}


class FactoryProducer {
   public static AbstractFactory getFactory(String choice){
   
      if(choice.equalsIgnoreCase("SHAPE")){
         return new ShapeFactory();
         
      }else if(choice.equalsIgnoreCase("COLOR")){
         return new ColorFactory();
      }
      
      return null;
   }
}


class AbstractFactoryDemo{
    public static void main(String[] args){
        
      AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

      //get an object of Shape Circle
      Shape shape1 = shapeFactory.getShape("CIRCLE");

      //call draw method of Shape Circle
      shape1.draw();

      //get an object of Shape Rectangle
      Shape shape2 = shapeFactory.getShape("RECTANGLE");

      //call draw method of Shape Rectangle
      shape2.draw();
      
      //get an object of Shape Square 
      Shape shape3 = shapeFactory.getShape("SQUARE");

      //call draw method of Shape Square
      shape3.draw();

      //get color factory
      AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

      //get an object of Color Red
      Color color1 = colorFactory.getColor("RED");

      //call fill method of Red
      color1.fill();

      //get an object of Color Green
      Color color2 = colorFactory.getColor("Green");

      //call fill method of Green
      color2.fill();

      //get an object of Color Blue
      Color color3 = colorFactory.getColor("BLUE");

      //call fill method of Color Blue
      color3.fill();
        
    }
}