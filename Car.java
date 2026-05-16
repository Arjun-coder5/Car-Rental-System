public class Car{
    private String CarId;
    private String brand;
    private String model;
    private double basePriceperDay;
    private boolean isAvailable;
    public Car(String carId, String brand, String model, double basePriceperDay,boolean isAvailable) {
        CarId = carId;
        this.brand = brand;
        this.model = model;
        this.basePriceperDay = basePriceperDay;
        this.isAvailable = isAvailable;
    }
    public String getCarId() {
        return CarId;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public double getBasePriceperDay(int rentalDays) {
        return basePriceperDay * rentalDays;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void rentCar() {
        isAvailable = false;
    }
    public void returnCar() {
        isAvailable = true;
    }   




}