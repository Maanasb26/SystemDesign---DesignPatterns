class ParkingTicket
{
    private  int ticketnumber;
    private  String vehicleNumber;
    private  int floorNumber;
    private  int spotNumber;
    private  String entryTime;

    /*public ParkingTicket (int a, String b, int c, int d, String e)
    {
        this.ticketnumber = a;
        this.vehicleNumber = b;
        this.floorNumber = c;
        this.spotNumber = d;
        this.entryTime = e;
    }
    */

    public ParkingTicket (Builder builder)
    {
        this.ticketnumber = builder.ticketnumber;
        this.vehicleNumber = builder.vehicleNumber;
        this.floorNumber = builder.floorNumber;
        this.spotNumber = builder.spotNumber;
        this.entryTime = builder.entryTime;
    }

    public  void display ()
    {
        System.out.println("Ticket Number :"+this.ticketnumber);
        System.out.println("Vehical Number :"+this.vehicleNumber);
        System.out.println("Floor Number :"+this.floorNumber);
        System.out.println("Spot Number :"+this.spotNumber);
        System.out.println("Entry Time :"+this.entryTime);
    }

}


  class Builder
{
    public   int ticketnumber;
    public   String vehicleNumber;
    public   int floorNumber;
    public   int spotNumber;
    public   String entryTime;

    public Builder setTicketNumber(int ticketnumber)
    {
        this.ticketnumber = ticketnumber;
        return this ; // Kamal vakya --> Returns exactly the self object  

    }

    public Builder setVehicleNumber(String vehiclenumber)
    {
        this.vehicleNumber = vehiclenumber;
        return this ;
        
    }

    public Builder setFloorNumber(int floorNumber)
    {
        this.floorNumber = floorNumber;
        return this ;
        
    }

    public Builder setSpotNumber(int spotNumber)
    {
        this.spotNumber = spotNumber;
        return this ;
        
    }

    public Builder setEntrytime(String entryTime)
    {
        this.entryTime = entryTime;
        return this ;
        
    }

    public ParkingTicket build()
    {
        return  new ParkingTicket(this);
    }
}

  class program987 {
    public static void main(String[] args) {
       
        ParkingTicket pobj = new Builder()
        .setTicketNumber(11)
        .setVehicleNumber("MH12VL9080")
        .setFloorNumber(4)
        .setSpotNumber(89)
        .setEntrytime("10:30 AM")
        .build();
      

        pobj.display();
    }
}
