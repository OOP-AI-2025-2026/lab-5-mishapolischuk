package ua.opnu;

public class TimeSpan {

    private int hours;
    private int minutes;

    private void normalize() {
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes %= 60;
        }

    }


    public TimeSpan() {
        this(0, 0);
    }
    public TimeSpan(int minutes) {
        this.hours = 0;
        this.minutes = minutes;
        normalize();
    }

    public TimeSpan(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        normalize();
    }

    public TimeSpan(TimeSpan other) {
        this(other.hours, other.minutes);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }


    public void add(int hours, int minutes) {
        this.hours += hours;
        this.minutes += minutes;
        normalize();
    }

    public void add(int minutes) {
        this.add(0, minutes);
    }

    public void add(TimeSpan other) {
        this.add(other.hours, other.minutes);
    }


    public void subtract(int hours, int minutes) {
        int totalMinutesThis = this.hours * 60 + this.minutes;
        int totalMinutesToSubtract = hours * 60 + minutes;
        int resultMinutes = totalMinutesThis - totalMinutesToSubtract;

        this.hours = resultMinutes / 60;
        this.minutes = resultMinutes % 60;
    }

    public void subtract(int minutes) {
        this.subtract(0, minutes);
    }

    public void subtract(TimeSpan other) {
        this.subtract(other.hours, other.minutes);
    }

    @Override
    public String toString() {
        return hours + "h " + minutes + "m";
    }
}