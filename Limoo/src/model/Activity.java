package model;

import java.util.Random;

/**
 * Created by Erfan on 7/8/2014.
 */
public class Activity {
    private double duration;
    private ActivityType actype;
    private double mass;

    /*
    constructor for Activity class
     */
    public Activity(double duration, ActivityType type, double mass) {
        this.duration = duration;
        this.actype = type;
        this.mass = mass;
    }
    /*
     constructor for Activity class, without determining the mass, so mass's value will be defaulted as -1
     */
    public Activity(double duration, ActivityType type)
    {
        this(duration, type, -1);
    }

    public double getDuration()
    {
        return this.duration;
    }

    /*
     get the total amount of energy consumed during this activity.
     currently this function is not implemented and instead it will return random double values
     */
    public double getEnergyConsumed()
    {
        return new Random().nextDouble();
    }
}

