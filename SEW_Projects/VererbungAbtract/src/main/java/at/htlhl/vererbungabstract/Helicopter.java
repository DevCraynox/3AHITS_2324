package at.htlhl.vererbungabstract;

public class Helicopter extends Aircraft {
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
}
