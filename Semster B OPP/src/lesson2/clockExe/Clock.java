package lesson2.clockExe;

public class Clock {
    private int hours;
    private int minutes;
    private int seconds;

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes >= 0 && minutes <=59){
            this.minutes = minutes;
        }

    }

    public int getHours() {

        return hours;
    }

    public void setHours(int hours) {
        if (hours >= 0 && hours <=23){
            this.hours = hours;
        }

    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (hours < 10){
            sb.append("0");
        }
        sb.append(hours).append(":");
        if (minutes < 10){
            sb.append("0");
        }
        sb.append(minutes).append(":");
        if (seconds < 10){
            sb.append("0");
        }
        sb.append(seconds);


        return sb.toString();
    }

    public void tick() {
        seconds ++;
        if (seconds == 60){
        }
    }
}
