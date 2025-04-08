package lesson2.CarExe;

public class Car {
    private String carNumber;
    private int currentSpeed;

    public String getCarNumber(){
        return carNumber;
    }
    public int getCurrentSpeed(){
        return currentSpeed;
    }
    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
    public void setCarNumber(String carNumber) {
        if (Util.validateCarNumber(carNumber)){
            this.carNumber = carNumber;
        }
    }
    public void speedUp() {
        currentSpeed++;
    }
    public void speedDown() {
        currentSpeed--;
    }
    public void stop() {
        currentSpeed = 0;
    }
    public void carData() {

    }

    @Override
    public String toString() {
        return carNumber + "speed" + currentSpeed;
    }
}
