package at.htlhl.kkm.klassenkassamanagment;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Student {
    private String catalogNumber;
    private String firstName;
    private String lastName;
    private DoubleProperty demand;
    private double alreadyDeposit;
    private double haveToDeposit;

    public Student(String catalogNumber, String firstName, String lastName) {
        this.catalogNumber = catalogNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.demand = new SimpleDoubleProperty(0.0);
        this.alreadyDeposit = 0.0;
        this.haveToDeposit = 0.0;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getDemand() {
        return demand.get();
    }

    public void setDemand(double demand) {
        this.demand.set(demand);
    }

    public DoubleProperty demandProperty() {
        return demand;
    }

    public double getAlreadyDeposit() {
        return alreadyDeposit;
    }

    public void setAlreadyDeposit(double alreadyDeposit) {
        this.alreadyDeposit = alreadyDeposit;
    }

    public double getHaveToDeposit() {
        return haveToDeposit;
    }

    public void setHaveToDeposit(double haveToDeposit) {
        this.haveToDeposit = haveToDeposit;
    }

    public void makeDeposit(double depositAmount) {
        double newAlreadyDeposit = getAlreadyDeposit() + depositAmount;
        setAlreadyDeposit(newAlreadyDeposit);

        double newHaveToDeposit = Math.max(0, getDemand() - newAlreadyDeposit);
        setHaveToDeposit(newHaveToDeposit);
    }

    public void addToDemand(double amount) {
        double newDemand = getDemand() + amount;
        setDemand(newDemand);
    }
}
