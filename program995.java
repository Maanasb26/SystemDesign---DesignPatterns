import java.util.*;
interface ParkingObserver
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

    private List<ParkingObserver > observers = new ArrayList<>();

    public Parkingfloor(int availablespots)
    {
        this.availablespots = availablespots;
    }

    public void addobserver(ParkingObserver observer){
        observers.add(observer);
    }

    public void removeobserver(ParkingObserver observer){
        observers.remove(observer);
    }

    public void VehicleParket ()
    {
        availablespots--;
        notifyObservers();
    }

    public void vehicleExited ()
    {
        availablespots++;
        notifyObservers();
    }

    private void notifyObservers ()
    {
        for(ParkingObserver observer : observers)
        {
            observer.update(availablespots);

        }
    }


}
public class program995 {
    public static void main(String[] args) {
        Parkingfloor floor = new Parkingfloor(5);

        DisplayBoard board = new DisplayBoard();
        MobileApplication app = new MobileApplication();

        floor.addobserver(app);
        floor.addobserver(board);

        floor.VehicleParket();
        System.out.println("---------------------");
        floor.vehicleExited();




    }
}
