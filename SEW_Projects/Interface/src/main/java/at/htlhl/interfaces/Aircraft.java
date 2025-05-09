package at.htlhl.interfaces;

public abstract class Aircraft {
    protected float speed;
    protected float attidude;

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
