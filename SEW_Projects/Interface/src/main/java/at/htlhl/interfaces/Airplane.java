package at.htlhl.interfaces;

public class Airplane extends Aircraft implements Rentable {
    private float wingSpan;

    public Airplane(){
        wingSpan = 15.7f;
    }

    public void fly(){
        System.out.println("An airplane is flying!");
    }

    public void takeoff(){
        System.out.println("An airplane is taking off!");
    }

    public void land() {
        System.out.println("An airplane is landing!");
    }

    @Override
    public boolean isRentable() {
        System.out.println("An airplane is not rentable!");
        return false;
    }
}
