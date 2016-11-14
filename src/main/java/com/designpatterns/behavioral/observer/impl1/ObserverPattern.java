public interface Shape{
    public static void draw();
}

public class Circle implements Shape{
    public void draw(){
        System.out.println(" inside Circle object ");
    }
}

public class Rectangle implements Shape{
    public void draw(){
        System.out.println(" inside Rectangle object ");
    }
}

public class Polygon implements Shape{
    public void draw(){
        System.out.println(" inside Polygon object ");
    }
}

public class ShapeFactory extends AbstractFactory {

    public Shape getShape(String shape){
        if(shape.equals("Circle"))
            return new Circle();
        else if(shape.equals("Rectangle"))
            return new Rectangle();
        else if(shape.equals("Polygon"))
            return new Polygon();
        return null;
    }
}


public interface Color{
    public void fill();
}

public class Red implements Color{
    public void fill(){
        System.out.println(" inside color red object ");
    }
}

public class Green implements Color{
    public void fill(){
        System.out.println(" inside color gren object ");
    }
}

public class Blue implements Color{
    public void fill(){
        System.out.println(" inside color blue object ");
    }
}

public class ColorFactory extends AbstractFactory {

    public Color getColor(String color){
        if(color.equals("Red"))
            return new Red();
        else if(color.equals("Green"))
            return new Green();
        else if(color.equals("Blue"))
            return new Blue();
        return null;
    }
    
    public Color getColor()
}

public abstract class AbstractFactory{
    public Shape getShape(String shape);
    public Color getColor(String color);
}


public class FactoryProducer {
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


///////////////////////////////////



public interface Observer{
    private subject;
    public void update();
}


public class Subject{
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;
    
    public int getState(){
        return state;
    }
    
    public void setState(int state){
        this.state = state;
        notifyAll();
    }
    
    public void attach(Observer o){
        observers.add(o);
    }
    
    private void notifyAll(){
        for(Observer observer: observers){
            observer.update();
        }
    }
}

public class HexaObject implements Observer{
    public HexaObject(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    
    public void update(){
        System.out.println(" Hexa observer value"+ Integer.toHexString(subject.getState()));
    }
}

public class OctalObject implements Observer{
    public OctalObject(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    
    public void update(){
        System.out.println(" Octal observer value"+ Integer.toOctalString(subject.getState()));
    }
}

public class BinaryObject implements Observer{
    public BinaryObject(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    
    public void update(){
        System.out.println(" Binary observer value"+ Integer.toBinaryString(subject.getState()));
    }
}


class ObserverDemo{
    public static void main(String[] args){
        Subject subject = new Subject();
        
        new HexaObject(subject);
        new OctalObject(subject);
        new BinaryObject(subject);
        
        System.out.println("Set state to 5");
        subject.setState(5);
    }
}
