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

///////////////////////////////////////////
/// Main Fucntion 
/// Controller 
/// ////////////////////////////////////////
class program998
{
    public static void main(String[] args) {
        
    }
}