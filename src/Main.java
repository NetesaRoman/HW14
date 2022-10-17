import models.Monitor;
import models.NuclearReactor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NuclearReactor reactor1 = new NuclearReactor();
        NuclearReactor reactor2 = new NuclearReactor();
        NuclearReactor reactor3 = new NuclearReactor();
        NuclearReactor reactor4 = new NuclearReactor();

        List<NuclearReactor> powerPlant = new ArrayList<>();

        powerPlant.add(reactor1);
        powerPlant.add(reactor2);
        powerPlant.add(reactor3);
        powerPlant.add(reactor4);

        Monitor mon1 = new Monitor(powerPlant);

        reactor1.setMeasurements(12, 333, true);
        reactor2.setMeasurements(4444, 14, false);
        reactor3.setMeasurements(444, 14, false);

    }
}