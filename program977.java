 enum VehicleType 
{
    BIKE,
    CAR,
    TRUCK
}

abstract class Vehicle 
{
    private String number;

    public Vehicle (String number)
    {
        this.number = number;
    }

    public String getNumber()
    {
        return this.number;
    }

    public abstract void display();


}

class Bike extends Vehicle{
    public Bike (String number)
    {
        super(number);
    }
    public void display()
    {
        System.out.println("Bike :"+getNumber());
    }
}

class Car extends  Vehicle
{
     public Car (String number)
    {
        super(number);
    }
    public void display()
    {
        System.out.println("Car :"+getNumber());
    }
}

class truck extends Vehicle
{
     public truck (String number)
    {
        super(number);
    }
    public void display()
    {
        System.out.println("Truck :"+getNumber());
    }
}


public class program977 {
    public static void main(String[] args) {
      

        Car cobj= new Car("MH12VL9080");
        cobj.display();

        truck tobj = new truck("MH12WZ9080");
        tobj.display();

    }
}
