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

class VehicleFactory // Factory Design Pattern Class 
{
    public static Vehicle createVehicle(VehicleType type,String number)
    {
        switch(type)
        {
            case BIKE:
                return new Bike(number);
            case CAR:
                return new Car(number);
            case TRUCK:
                return new truck(number);
            default:
                return null;
          
        }
        
    }
}
public class program979 {
    public static void main(String[] args) {
      
        Vehicle v1 = VehicleFactory.createVehicle(VehicleType.BIKE,"MH12VL9080");
        Vehicle v2 = VehicleFactory.createVehicle(VehicleType.CAR,"MH12VZ9080");
        Vehicle v3 = VehicleFactory.createVehicle(VehicleType.TRUCK,"MH12MN9080");
        v1.display();
        v2.display();
        v3.display();
    
    }
}
