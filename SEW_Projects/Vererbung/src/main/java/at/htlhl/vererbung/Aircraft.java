package at.htlhl.vererbung;

public class Aircraft {
    private float speed;
    private float attidude;

    public Aircraft(){
        speed = 0.0f;
        attidude = 0.0f;
    }

    public void fly() {
        System.out.println("An aircraft is flying!");
    }

    public void takeoff(){
        System.out.println("An aircraft is taking off!");
    }

    public void land(){
        System.out.println("An aircraft is landing!");
    }
}
