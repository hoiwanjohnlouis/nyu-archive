// Sol 4
/**
* A Tester for Bus.
*
* @version 1.0
* @author Mohammed Ashequr Rahman
* @see Bus
* @see Vehicle
* @see Rentable
*/
public class TestBus
{
    public static void main(String[] args)
    {
        // create name objects.
        Name myName=new Name("Mohammed", "A", "Rahman");
        Name yourName = new Name("John", "P", "Smith");

        Name thirdName = new Name("Barbara","O", "Anderson");

        // create bus object and calls methods.
        Bus oldBus = new Bus();
        oldBus.setOwner(yourName);
        oldBus.setRent(300);
        oldBus.setSpeed(55);
        oldBus.setCapacity(46);
        oldBus.addPassenger();
        oldBus.addPassenger(2);
        oldBus.dropPassenger();
        oldBus.dropPassenger(1);


        // create another bus object and call methods.
        Bus newBus= new Bus(myName);
        newBus.setRent(500);
        newBus.setSpeed(20);
        newBus.setSpeed(Vehicle.MAX_SPEED);
        newBus.setCapacity(50);
        newBus.addPassenger();
        newBus.addPassenger(5);
        newBus.dropPassenger();
        newBus.dropPassenger(2);


        // create another bus object and call methods.
        Bus new2Bus= new Bus();
        new2Bus.setOwner(thirdName);
        new2Bus.setRent(300);
        new2Bus.setSpeed(40);
        new2Bus.setSpeed(60);
        new2Bus.setCapacity(80);
        new2Bus.addPassenger();
        new2Bus.addPassenger(10);
        new2Bus.dropPassenger();
        new2Bus.dropPassenger(5);


        // print the new bus info.
        System.out.println("New Bus: " + new2Bus.toString());
        System.out.println("Rent: " + new2Bus.getRent());
        System.out.println("Speed: " + new2Bus.getSpeed());
        System.out.println("Capacity: " + new2Bus.getCapacity());
        System.out.println("Passengers: " + new2Bus.countPassengers());
        System.out.println("Available Seats: " + new2Bus.getAvailableSeats());

        System.out.println();

        // stop the bus and print speed.
        new2Bus.stop();
        System.out.println("Speed after Stop: " + new2Bus.getSpeed());
        System.out.println();


        // print the new bus info.
        System.out.println("New Bus: " + newBus.toString());
        System.out.println("Rent: " + newBus.getRent());
        System.out.println("Speed: " + newBus.getSpeed());
        System.out.println("Capacity: " + newBus.getCapacity());
        System.out.println("Passengers: " + newBus.countPassengers());
        System.out.println("Available Seats: " + newBus.getAvailableSeats());

        System.out.println();

        // stop the bus and print speed.
        newBus.stop();
        System.out.println("Speed after Stop: " + newBus.getSpeed());
        System.out.println();


        // print old bus info.
        System.out.println("Old Bus: "+ oldBus.toString());
        System.out.println("Rent: " + oldBus.getRent());
        System.out.println("Speed: " + oldBus.getSpeed());
        System.out.println("Capacity: " + oldBus.getCapacity());
        System.out.println("Passengers: " + oldBus.countPassengers());
        System.out.println("Available Seats: " + oldBus.getAvailableSeats());

        System.out.println();

        // print static info.
        System.out.println("Number of Vehicles Instantiated: " + Vehicle.countVehicles());


        // print constant
        System.out.println();
        System.out.println("Maximux Vehicle Speed: " + Vehicle.MAX_SPEED);

    }
}
