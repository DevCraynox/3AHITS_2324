package at.htlhl.vererbungabstract;

public abstract class Aircraft {
    private float speed;
    private float attidude;

    public Aircraft(){
        speed = 0.0f;
        attidude = 0.0f;
    }

    public abstract void fly();

    public void takeoff(){
        System.out.println("An aircraft is taking off!");
    }

    public void land(){
        System.out.println("An aircraft is landing!");
    }
}
