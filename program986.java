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

    private   ParkingTicket (Builder builder)
    {
        this.ticketnumber = builder.ticketNumber;
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


public static class Builder
{
    private  int ticketnumber;
    private  String vehicleNumber;
    private  int floorNumber;
    private  int spotNumber;
    private  String entryTime;

    public Builder setTicketNumber(int ticketnumber)
    {
        this.ticketnumber = ticketnumber;
        return this ; // Kamal vakya --> Returns exactly this 

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

 class program986 {
    public static void main(String[] args) {
       
    
    }
}
