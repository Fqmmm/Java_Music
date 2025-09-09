package model;

public interface Playable {
    
    double fraction();
    int duration();
    int velocity();
    void setDuration(int duration);
    void setDurationFromPace(int pace);
}
