package at.htlhl.carconf;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Car {

    // Constnats **************************************************************

    public static final int MAX_POWER = 200;
    public static final int MAX_RANGE = 1000;

    // Fields *****************************************************************

    private final StringProperty manufacturerProperty = new SimpleStringProperty(this, "manufacturer");
    private final StringProperty typeProperty = new SimpleStringProperty(this, "typ");
    final IntegerProperty powerProperty = new SimpleIntegerProperty(this, "power");
    final IntegerProperty rangeProperty = new SimpleIntegerProperty(this, "range");

    // Instanz creation *******************************************************

    public Car(){

    }

    // Accessors **************************************************************


    public void setManufacturer(String manufacturer) {
        manufacturerProperty.set(manufacturer);
    }

    public String getManufacturer() {
        return manufacturerProperty.get();
    }

    public StringProperty manufacturerProperty(){
        return manufacturerProperty;
    }

    public void setType(String typ) {
        typeProperty.set(typ);
    }

    public String getType() {
        return typeProperty.get();
    }

    public StringProperty typeProperty(){
        return typeProperty;
    }

    public void setPower(int power) {
        if (power > MAX_POWER) {
             powerProperty.set(MAX_POWER);
        } else {
            powerProperty.set(power);
        }
    }

    public int getPower() {
        return powerProperty.get();
    }

    public void setRange(int range) {
        if (range > MAX_RANGE){
            rangeProperty.set(MAX_RANGE);
        } else {
            rangeProperty.set(range);
        }
    }

    public int getRange() {
        return rangeProperty.get();
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + getManufacturer() + '\'' +
                ", type='" + getType() + '\'' +
                ", power=" + getPower() +
                ", range=" + getRange() +
                '}';
    }
}
