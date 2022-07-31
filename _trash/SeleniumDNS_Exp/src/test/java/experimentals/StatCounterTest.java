package experimentals;

import com.instance.DrvManager;
import com.instance.DrvManager_interface;
import com.utils.SingleForInterface;
import com.utils.StatCounter;

public class StatCounterTest {
    public static void main(String[] args) {
//        abstractTest();
//        interfaceTest1();
//        interfaceTest2();
//        interfaceTest3();

    }

    private static void interfaceTest3() {
        SingleForInterface singleForInterface0 = DrvManager_interface.singleForInterface;
        SingleForInterface singleForInterface1 = DrvManager_interface.singleForInterface;
        SingleForInterface singleForInterface2 = DrvManager_interface.singleForInterface;
    }

    private static void interfaceTest2() {
        // interface run all methods what him contains _ because him contains CONSTANTS for invoke methods
        StatCounter alwaysNewStatCounter0 = DrvManager_interface.alwaysNewStatCounter;
        StatCounter alwaysNewStatCounter1 = DrvManager_interface.alwaysNewStatCounter;
        StatCounter alwaysNewStatCounter2 = DrvManager_interface.alwaysNewStatCounter;
        StatCounter alwaysNewStatCounter3 = DrvManager_interface.alwaysNewStatCounter;
        StatCounter alwaysNewStatCounter4 = DrvManager_interface.alwaysNewStatCounter;

        System.out.println(StatCounter.get()); // always 3
    }

    private static void interfaceTest1() {
        // interface run all methods what him contains _ because him contains CONSTANTS for invoke methods
        StatCounter statCounter0 = DrvManager_interface.statCounter;
        StatCounter statCounter1 = DrvManager_interface.statCounter;
        StatCounter statCounter2 = DrvManager_interface.statCounter;
        StatCounter statCounter3 = DrvManager_interface.statCounter;
        StatCounter statCounter4 = DrvManager_interface.statCounter;
        StatCounter statCounter5 = DrvManager_interface.statCounter;

        System.out.println(StatCounter.get()); // always 3
    }

    private static void abstractTest() {
        // Bed = 3 invoke
        DrvManager.getAlwaysNewInstance_statCounter();
        DrvManager.getAlwaysNewInstance_statCounter();
        DrvManager.getAlwaysNewInstance_statCounter();

        // Good = 1 invoke
//        DrvManager.getStatCounter();
//        DrvManager.getStatCounter();
//        DrvManager.getStatCounter();

        System.out.println(StatCounter.get());
        System.out.println(StatCounter.get());
        System.out.println(StatCounter.get());
    }
}
