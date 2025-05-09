package at.htlhl.kkm.klassenkassamanagment;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Student {
    private String catalogNumber;
    private String firstName;
    private String lastName;
    private DoubleProperty demand;
    private DoubleProperty alreadyDeposit;
    private DoubleProperty haveToDeposit;
    private DoubleProperty status;

    public Student(String catalogNumber, String firstName, String lastName) {
        this.catalogNumber = catalogNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.demand = new SimpleDoubleProperty(0.0);
        this.alreadyDeposit = new SimpleDoubleProperty(0.0);
        this.haveToDeposit = new SimpleDoubleProperty(0.0);
        this.status = new SimpleDoubleProperty(0.0);
        // Initialberechnung des offenen Betrags
        recalculateHaveToDeposit();
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
        recalculateHaveToDeposit();
    }

    public DoubleProperty demandProperty() {
        return demand;
    }

    public double getAlreadyDeposit() {
        return alreadyDeposit.get();
    }

    public DoubleProperty alreadyDepositProperty() {
        return alreadyDeposit;
    }

    public void setAlreadyDeposit(double alreadyDeposit) {
        this.alreadyDeposit.set(alreadyDeposit);
        recalculateHaveToDeposit();
    }

    public double getHaveToDeposit() {
        return haveToDeposit.get();
    }

    public DoubleProperty haveToDepositProperty() {
        return haveToDeposit;
    }

    public double getStatus() {
        return status.get();
    }

    public DoubleProperty statusProperty() {
        return status;
    }

    public void setStatus(double status) {
        this.status.set(status);
    }

    public void makeDeposit(double depositAmount) {
        double newAlreadyDeposit = getAlreadyDeposit() + depositAmount;
        setAlreadyDeposit(newAlreadyDeposit);
    }

    public void addToDemand(double amount) {
        double newDemand = getDemand() + amount;
        setDemand(newDemand);
    }

    private void recalculateHaveToDeposit() {
        double newHaveToDeposit = Math.max(0, getDemand() - getAlreadyDeposit());
        setHaveToDeposit(newHaveToDeposit);
    }

    public void setHaveToDeposit(double haveToDeposit) {
        this.haveToDeposit.set(haveToDeposit);
    }
}