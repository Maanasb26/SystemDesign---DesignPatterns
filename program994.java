import java.util.*;
interface ParkingObserver // Not everything in interface is by default public 
{
    void update(int availablespots);

}

class DisplayBoard implements ParkingObserver

{
    public void update(int availablespots)
    {
        System.out.println("Display Board : "+ availablespots);
    }
}

class MobileApplication implements ParkingObserver

{
    public void update(int availablespots)
    {
        System.out.println("Mobile Application: "+ availablespots);
    }
}

class Parkingfloor 
{
    private int availablespots;
    public Parkingfloor(int availablespots)
    {
        this.availablespots = availablespots;
    }
}
public class program994 {
    public static void main(String[] args) {
        Parkingfloor floor = new Parkingfloor(5);
    }
}
