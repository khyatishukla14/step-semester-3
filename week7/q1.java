abstract class Toy{
    void makeSound();
    private static int counter;
    private final String toyID;
    String name;
    Toy(String name){
        this.name = name;
        this.toyID = counter++;
    }
    String getName(){
        return name;
    }
    String getID(){
        return toyID;
    }
}
class ToyCar extends Toy{
    ToyCar(String name){
        super(name);
    }
    String makeSound(){
        return name + "vroom vroom";
    }
}
class ToyRobot extends Toy{
    ToyRobot(String name){
        super(name);
    }
    String makesound(){
        return name + "beep boop";
    }
}
public class q1{
    public static void main(String args[]){
        ToyCar c = new ToyCar("Truck");
        ToyRobot r = new ToyRobot("Tass");
        System.out.println(c.getId());
        System.out.println(r.getId());
        System.out.println(c.makeSound());
        System.out.println(r.makesound());
    }
}
