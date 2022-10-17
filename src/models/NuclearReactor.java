package models;

import api.Observable;
import api.Observer;

import java.util.ArrayList;
import java.util.List;

public class NuclearReactor implements Observable {

    private List<Observer> observers = new ArrayList<Observer>();
    private double temperature;
    private double backgroundRad;
    private boolean rodUp;
    private static int count = 0;
    private int currentNumber;

    public NuclearReactor(){
        count++;
        currentNumber = count;
    }

    public int getCount() {
        return currentNumber;
    }

    @Override
    public void registerPersonel(Observer o){
        observers.add(o);
    }

    @Override
    public void removePersonel(Observer o){
        observers.remove(o);
    }

    @Override
    public void notifyPersonel(){
        for (Observer observer: observers) {
            observer.update();
        }
    }

    public void setMeasurements(double temp, double bgRad, boolean rodUp){
        this.backgroundRad = bgRad;
        this.rodUp = rodUp;
        this.temperature = temp;

        notifyPersonel();
    }

    public double getTemperature() {
        return temperature;
    }

    public double getBackgroundRad() {
        return backgroundRad;
    }

    public boolean isRodUp() {
        return rodUp;
    }
}
