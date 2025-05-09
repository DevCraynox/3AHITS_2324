package at.htlhl.interfaces;

/**
 * Bike
 * @Author Marcel Frischauf
 * @Schule HTL Hollabrunn
 * @Klasse 3AHITS
 */

public class Bike implements Rentable {
    @Override
    public boolean isRentable() {
        System.out.println("A bike is rentable");
        return true;
    }
}
