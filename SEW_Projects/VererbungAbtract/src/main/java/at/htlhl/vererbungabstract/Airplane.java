package at.htlhl.vererbungabstract;

public class Airplane extends Aircraft {
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
}
