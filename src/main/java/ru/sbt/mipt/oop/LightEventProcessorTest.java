package ru.sbt.mipt.oop;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Maya on 17.12.2017.
 */
public class LightEventProcessorTest {

    @Test
    public void handle() throws Exception{
        LightEventProcessor lightEventProcessor = new LightEventProcessor();
        SmartHome home =new SmartHome();
        String lightId = "1";
        Light light = new Light(lightId, false);
        home.addRoom(new Room(Arrays.asList(light), Collections.emptyList(), "room"));

        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, lightId);
        lightEventProcessor.processEvent(home, event);
        Assert.assertTrue(light.isOn());
    }

}

