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


class program996
{
    public static void main(String[] args) {
        
    }
}