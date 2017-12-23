package ru.sbt.mipt.oop;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;

/**
 * Created by Maya on 17.12.2017.
 */
public class DoorScenarioRunnerTest {

    @Test
    public void testProcessLightEvent() {
        SmartHome smartHome = new SmartHome();
        Light light = new Light("1", true);
        String hallDoorId = "1";
        Room hall = new Room(
                Collections.singletonList(light),
                Collections.singletonList(new Door(true, hallDoorId)),
                "hall");
        smartHome.addRoom(hall);
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, hallDoorId);

        DoorScenarioRunner scenarioRunner = new DoorScenarioRunner();
        scenarioRunner.processEvent(smartHome, event);

        Assert.assertFalse(light.isOn());
    }
}
