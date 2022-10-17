package models;

import api.Observer;

import java.util.ArrayList;
import java.util.List;

public class Monitor implements Observer {

    private final double maxTemperature = 2000d;
    private final double maxBgRadiation = 50d;

    List<NuclearReactor> reactors = new ArrayList<>();


    public Monitor(NuclearReactor reactor) {
        this.reactors.add(reactor);
        this.reactors.get(0).registerPersonel(this);
    }

    public Monitor(List<NuclearReactor> reactors) {
        this.reactors.addAll(reactors);
        for (NuclearReactor reactor : reactors){
            reactor.registerPersonel(this);
        }
    }


    @Override
    public void update() {
        displayInfo();
    }

    public void displayInfo() {
        int i = 1;

        for (NuclearReactor reactor : reactors) {
            System.out.println("Энергоблок № " + i);
            if (reactor.getTemperature() > maxTemperature) {
                System.out.println("Температура превышает критическую отметку, мы все умрем!");
            } else {
                System.out.println("Температура в пределах нормы (" + reactor.getTemperature() + " цельсий)");
            }
            if (reactor.getBackgroundRad() > maxBgRadiation) {
                System.out.println("Внимание повышен уровень фоновой радиации," +
                        " возможна утечка радиоактивного топлива!");
            } else {
                System.out.println("Радиационый фон в пределах нормы (" + reactor.getBackgroundRad() +
                        " микрорентген в час)");
            }
            if (reactor.isRodUp()) {
                System.out.println("Стержни подняты, идет нагрев реактора");
            } else {
                System.out.println("Стержни опущены, идет охлаждение реактора");
            }

            i++;
        }
    }
}
