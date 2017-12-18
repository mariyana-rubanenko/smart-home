package ru.sbt.mipt.oop;

/**
 *     Created by Maya on 17.12.2017.
 */
public interface EventProcessor {
    void processEvent(SmartHome smartHome, SensorEvent event);
}
