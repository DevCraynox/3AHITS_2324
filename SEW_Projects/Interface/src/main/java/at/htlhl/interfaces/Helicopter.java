package at.htlhl.interfaces;

public class Helicopter extends Aircraft implements Rentable {
    private float rotorBladeSize;

    public Helicopter(){
        rotorBladeSize = 8.3f;
    }

    public void fly() {
        System.out.println("An helicopter is flying!");
    }

    public void takeoff() {
        System.out.println("An helicopter is taking off!");
    }

    public void land() {
        System.out.println("An helicopter is landing!");
    }

    @Override
    public boolean isRentable() {
        System.out.println("An helicopter is rentable!");
        return true;
    }
}
