package model;

public interface Playable extends Cloneable {
    
    double fraction();
    int duration();
    int velocity();
    void setDuration(int duration);
    void setDurationFromPace(int pace);
    void setVelocity(int velocity);
    public Playable transposed(int value);
    public Playable clone();
}
