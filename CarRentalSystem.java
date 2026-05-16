
import java.util.ArrayList;
import java.util.List;

public class CarRentalSystem {
  private List<Car> cars;
  private List<Customer> customers;
  private List<Rental> rentals;
 public CarRentalSystem(){
  cars = new ArrayList<>();
  customers = new ArrayList<>();
  rentals = new ArrayList<>();
 }
 public void addCar(Car car){
  cars.add(car);
 }
  public void addCustomer(Customer customer){
    customers.add(customer);
  }
  public void rentCar(Car car, Customer customer, int rentalDays){
      if(car.isAvailable()){
          car.rentCar();
          rentals.add(new Rental(car, customer, rentalDays));
          System.out.println("Car rented successfully to " + customer.getName()); 
      }else{
          System.out.println("Sorry, the car is not available for rent.");
      }
  } 
  public void returnCar(Car car){
    Rental removalOfThisCarRental = null;
    for(Rental rental : rentals){
       if(rental.getCar().equals(car)){
        removalOfThisCarRental = rental;
        break;
       }
    }
    if(removalOfThisCarRental!=null){
      rentals.remove(removalOfThisCarRental);
     System.out.println("Car returned successfully by " + removalOfThisCarRental.getCustomer().getName());
    }else{
      System.out.println("This car was not rented from our system.");
    }
    }
}
