class ParkingTicket
{
    private  int ticketnumber;
    private  String vehicleNumber;
    private  int floorNumber;
    private  int spotNumber;
    private  String entryTime;

    public ParkingTicket (int a, String b, int c, int d, String e)
    {
        this.ticketnumber = a;
        this.vehicleNumber = b;
        this.floorNumber = c;
        this.spotNumber = d;
        this.entryTime = e;
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


 class program985 {
    public static void main(String[] args) {
        ParkingTicket p1 = new ParkingTicket(11,"MH12VL7172" , 3, 89, "9:30AM");
        ParkingTicket p2 = new ParkingTicket(12,"MH14VL7020" , 4, 32, "9:50AM");
        System.out.println();
        p1.display();
        System.out.println();
        System.out.println();
        p2.display();
    
    }
}
