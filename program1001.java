/*
    Parkinlot Automation Systems
    Step 1 - Create Required Enums 
    Step 2 - Vehicle Hierarchy creation 
    Step 3 - Vehicle Factory Creation ( Factory Design Pattern)
    Step 4 - Parkingspot Hierarchy 
    Step 5 - Parking Observer class 
    Step 6 - ParkingFlorr Class 
    Step 7 - Parking Display Board  (Observer Pattern)
    Step 8 - Parking Strategy Class (Strategy Pattern)
    Step 9 - Pricing Strategy Class (Strategy Pattern )
    Step 10 - Payement Strategy Class 
    Step 11 - Parking Ticket Class 
    Step 12 - Entrygate class 
    step 13 - ExitGate class 
    Step 14 - ParkingLot class ( Singleton Pattern)
    Step 15 -  Main Class Controller 
*/


import java.util.*;
import java.time.Duration; // Calculates Difference Between Two Diff Dates or Time 
import java.time.LocalDateTime; // Gives system time 


////////////////////////////////////////////
/// 
///  Step 1 : Create Enums 
/// Used To Create Fixed Constants Which are 
/// requried throughout the project  
/// 
/// ///////////////////////////////////////


// Represents the Different Types of Vehicles Supported BY the Project 
enum VehicleType 
{
    BIKE,
    CAR,
    TRUCK 
}
// Represents the Different Types of Parking Spots 
enum SpotType 
{
    BIKE,
    CAR,
    TRUCK 
}

// Represents Current State of Parking Ticket 
enum TicketStatus 
{
    ACTIVE,
    CLOSED
}


////////////////////////////////////////////
/// 
///  Step 2 : Create Vehicle Class Hierarchy  
///  Used To Create Multiple Types of Classes 
///  Which Represents the types of Vehicles 
/// 
/// Concepts : Abstraction, INgeritance, Polymorphism, Encapsulation
/// 
/// ///////////////////////////////////////


// Hiding Implementation Details from outside world is abstraction 

// Class Which Represents A generic Vehicle Type
abstract class Vehicle
{

    // Abstracted (Hidden) Characteristics of class 
    private String vehicleNumber;
    private VehicleType vehicleType;

    // Parameterised Constructor 

    public Vehicle(String vehicleNumber, VehicleType vehicleType)
    {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    // Concrete Getter Methods 

    public VehicleType getvehicleType()
    {
        return this.vehicleType;
    }

    public String getvehicleNumber()
    {
        return this.vehicleNumber;
    }

    // Every Concrete Class will provide its own defination
    public abstract void display();
}

// Class which represents the vehicle type as car 

class Bike extends Vehicle
{
    // Parameterised Contructor 
    public Bike (String vehicleNumber )
    {
        // Calls Vehicle class cosntructor 
        super(vehicleNumber,VehicleType.BIKE);
    }

    // Method Overriding 
    @Override 
    public void display()
    {
        System.out.println("Bike : "+ getvehicleNumber());
    }
}

// Class which represents the vehicle type as car 

class Car extends Vehicle
{
    // Parameterised Contructor 
    public Car (String vehicleNumber )
    {
        // Calls Vehicle class cosntructor 
        super(vehicleNumber,VehicleType.CAR);
    }

    // Method Overriding 
    @Override 
    public void display()
    {
        System.out.println("Car : "+ getvehicleNumber());
    }
}

// Class which represents the vehicle type as truck 
class Truck extends Vehicle
{
    // Parameterised Contructor 
    public Truck (String vehicleNumber )
    {
        // Calls Vehicle class cosntructor 
        super(vehicleNumber,VehicleType.TRUCK);
    }

    // Method Overriding 
    @Override 
    public void display()
    {
        System.out.println("Truck : "+ getvehicleNumber());
    }
}


////////////////////////////////////////////
/// 
///  Step 3 : Create Vehicle Factory Class 
///  Used to Centralise the Creation of Vehicle 
///  objects 
/// 
/// Concepts : Factory Design Pattern 
/// 
/// ///////////////////////////////////////



class VehicleFactory 
{
    // Created and Returns the Desired Class Object 
    public static Vehicle creatVehicle(VehicleType type, String number)
    {

        switch (type)
        {
            case BIKE:
                return new Bike(number);
            case CAR:
                return new Car(number);
            case TRUCK:
                return new Truck(number);
            default:
                throw new IllegalArgumentException("Invalid Vehicle Type "); // Do not return, Throw an Exception - because Return argument for the class is vehicle not an exception 
        }
    }
}


////////////////////////////////////////////
/// 
///  Step 4 : Create Parking Spot Hierarchy  
///  Used to create hierarchy of parking spots 
///   
/// 
/// Concepts : Encapsulation, Abstration, Polymorphism, INheritance  
/// 
/// ///////////////////////////////////////

abstract class ParkingSpot 
{
    // Unique Number for Parking Spot (Primary Key) 
    private int spotNumber;

    // Type of parking Spot 
    private SpotType spotType;

    // Indicated wether spot is currently occupied or not 
    private boolean occupied ;

    // Stores Information about the vehicle 

    private Vehicle vehicle ; // Composition : Creating Object of another class inside another class, no extend keyword still composition 


    // Parameterised Consturctor 
    public ParkingSpot(int spotNumber, SpotType spotType )
    {
        this.spotNumber = spotNumber;
        this.spotType = spotType;

        // Initialaised with Default Values 
        this.occupied = false; // false - shows that  spot is not occupied 
        this.vehicle = null; // Null because, we do not know what is the vehicle type 
    }

    public int getSpotNumber ()
    {
        return this.spotNumber;
    }

    public SpotType getsSpotType ()
    {
        return this.spotType;
    }
    public boolean isOccupied()
    {
        return this.occupied;
    }
    public Vehicle getVehicle()
    {
        return this.vehicle;
    }

    // It is used to park the vehicle 
    public void parkVehicle(Vehicle vehicle)
    {
        if(this.occupied== true) // Spot is occumpied 
        {
            throw new RuntimeException("Parking Spot is already Occupied ");
        }
        else // Spot is empty 
        {
            this.vehicle = vehicle;
            this.occupied = true;
        }
    }

    public  Vehicle removeVehicle () // program should specify that Car or bike ( vehicle type ) exited 
    {
        if(this.occupied== true)
        {
            Vehicle  temp = vehicle;
            this.vehicle = null;
            this.occupied = false;

            return temp;

        }
        else 
        {
            throw new RuntimeException("Parking Spot is already empty ");
        }


    }

    // This Method Decides Whether we can park the vehicle in spot or not 
    public abstract boolean canFitVehicle( Vehicle vehicle);

    public void display ()
    {
        System.out.println("Spot : "+ spotNumber + " [ "+ spotType + " ] ");

        if(this.occupied==true)
        {
            System.out.println("Occupied By : "+ vehicle.getvehicleNumber());
        }
        else 
        {
            System.out.println("Spot is Available ");
        }
    }

} // End of ParkingSpot class 

class BikeSpot extends ParkingSpot
{
    public BikeSpot(int spotNumber)
    {
        super(spotNumber, SpotType.BIKE);
    }

    @Override 
    public boolean canFitVehicle( Vehicle vehicle)
    {
        if( vehicle.getvehicleType() == VehicleType.BIKE)
        {
            return true ;
        }
        else 
        {
            return false;
        }
    }
}

class CarSpot extends ParkingSpot
{
    public CarSpot(int spotNumber)
    {
        super(spotNumber, SpotType.CAR);
    }

    @Override 
    public boolean canFitVehicle( Vehicle vehicle)
    {
        if( vehicle.getvehicleType() == VehicleType.CAR)
        {
            return true ;
        }
        else 
        {
            return false;
        }
    }


}

class TruckSpot extends ParkingSpot
{
    public TruckSpot(int spotNumber)
    {
        super(spotNumber, SpotType.TRUCK);
    }

    @Override 
    public boolean canFitVehicle( Vehicle vehicle)
    {
        if( vehicle.getvehicleType() == VehicleType.TRUCK)
        {
            return true ;
        }
        else 
        {
            return false;
        }
    }


}


////////////////////////////////////////////
/// 
///  Step 5 : Parking Observer Class 
///  it is used to automatically update Display board when 
///  The parking Availability changes 
///   
///  Concepts : Observer Design Pattern, Interface 
/// 
/// ///////////////////////////////////////


interface ParkingObserver 
{
    void update();



}

////////////////////////////////////////////
/// 
///  Step 6 : ParkingFloor Class 
///  it is used to Manage Parking floor 
///  
///   
///  Concepts : Composition, Arraylist, Object Management 
/// 
/// ///////////////////////////////////////



class ParkingFloor
{
    //  Unique Floor Number 

    private int floorNumber;

    // Collection of all Parking Spots 

    private List <ParkingSpot> parkingSpots;


    // Collection of Observers registered for floor 

    private List <ParkingObserver> observers;

    public ParkingFloor (int floorNumber)
    {
        this.floorNumber = floorNumber;
        this.parkingSpots = new ArrayList<>();
        this.observers = new ArrayList<>();

    }

    public int getfloorNumber()
    {
        return this.floorNumber;
    }

    public void addParkingSpot(ParkingSpot spot) // Method to add spot and not vehicle 
    {
        parkingSpots.add(spot);
    }

    public  void addObserver ( ParkingObserver observer) // Method to add an observer ( eg display board + Mobile app + Website )
    {
        observers.add(observer);
    }

    private void notifyObservers()
    {
        for (ParkingObserver observer : observers)
        {
            observer.update();
        }
    }

    public ParkingSpot findAvailableSpot()
    {
        return null;
    }

}
///////////////////////////////////////////
/// Main Fucntion 
/// Controller 
/// ////////////////////////////////////////
class program1001
{
    public static void main(String[] args) {
        
    }
}