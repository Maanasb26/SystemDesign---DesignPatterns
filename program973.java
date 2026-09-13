class ParkingLot 
{
    private  static ParkingLot instance ;
   private  ParkingLot ()
   {
    System.out.println("Parking lot object gets created ");
   }

   public static ParkingLot getInstance() //  Get isntance is a method which accepts nothing, which returns object of parking lot type which can be created publically 
   {
    if(instance == null)
    {
        instance = new ParkingLot();
    }
    return instance;
   }
}

public class program973 {
    public static void main(String[] args) {
       // ParkingLot pobj1 = new ParkingLot(); --> Error 

       ParkingLot pobj1 = ParkingLot.getInstance();
       ParkingLot pobj2 = ParkingLot.getInstance();
       ParkingLot pobj3 = ParkingLot.getInstance();
        

    }
}
