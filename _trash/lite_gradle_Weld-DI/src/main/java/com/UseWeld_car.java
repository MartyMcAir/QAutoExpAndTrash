package com;

import com.cars.Car;
import com.cars.JustCar;
import com.cars.SuperCar;
import com.eangieans.E_Engine;
import com.eangieans.Engine;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class UseWeld_car {
    // https://www.udemy.com/course/java-oop-prof/learn/lecture/29836016#notes
    // http://weld.cdi-spec.org/
    public static void main(String[] args) {
        WeldContainer container = getContainer();

        Engine eEngine = container.select(E_Engine.class).get();
        Car justCar = container.select(JustCar.class).get();
        //
        eEngine.runEngine();
        runMethodsFromCar(justCar);

        //
        Car superCar = container.select(SuperCar.class).get();
        runMethodsFromCar(superCar);

        closeContainer(container);
    }

    private static void runMethodsFromCar(Car car) {
        car.engineOn();
        car.runMethodFromEngine();
        System.out.println(car);
        System.out.println("----------------------");
    }

    private static void closeContainer(WeldContainer container) {
        container.shutdown(); // close container
    }

    private static WeldContainer getContainer() {
        Weld weld = new Weld(); // create container
        WeldContainer container = weld.initialize(); // start container (it look in beans.xml and find @Inject)
        return container;
    }

}
