import java.util.Scanner;

public class menu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CarRentalSystem system = new CarRentalSystem();

        // Add Cars
        Car c1 = new Car("C01", "Mercedes", "C-Class", 50.0, true);
        Car c2 = new Car("C02", "BMW", "3 Series", 45.0, true);
        Car c3 = new Car("C03", "Audi", "A4", 55.0, true);
        Car c4 = new Car("C04", "Toyota", "Camry", 30.0, true);

        system.addCar(c1);
        system.addCar(c2);
        system.addCar(c3);
        system.addCar(c4);

        while (true) {

            System.out.println("\n===== CAR RENTAL SYSTEM =====");
            System.out.println("1. Show Available Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return a Car");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\n===== AVAILABLE CARS =====");

                    Car[] cars = {c1, c2, c3, c4};

                    for (Car car : cars) {

                        if (car.isAvailable()) {

                            System.out.println(
                                    car.getCarId() + " | "
                                            + car.getBrand() + " "
                                            + car.getModel()
                                            + " | $" +
                                            car.getBasePriceperDay(1)
                                            + " per day");
                        }
                    }

                    break;

                case 2:

                    System.out.println("\n===== RENT A CAR =====");

                    System.out.print("Enter Customer ID: ");
                    String customerId = sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String customerName = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    Customer customer =
                            new Customer(customerId, customerName, phone);

                    system.addCustomer(customer);

                    System.out.print("Enter Car ID: ");
                    String rentCarId = sc.nextLine();

                    Car selectedCar = null;

                    Car[] rentCars = {c1, c2, c3, c4};

                    for (Car car : rentCars) {

                        if (car.getCarId().equalsIgnoreCase(rentCarId)
                                && car.isAvailable()) {

                            selectedCar = car;
                            break;
                        }
                    }

                    if (selectedCar == null) {

                        System.out.println("Car not available.");

                    } else {

                        System.out.print("Enter Rental Days: ");
                        int days = sc.nextInt();
                        sc.nextLine();

                        double totalPrice =
                                selectedCar.getBasePriceperDay(days);

                        System.out.println("\n===== RENTAL DETAILS =====");
                        System.out.println("Customer : "
                                + customer.getName());

                        System.out.println("Car : "
                                + selectedCar.getBrand()
                                + " "
                                + selectedCar.getModel());

                        System.out.println("Days : " + days);

                        System.out.println("Total Price : $"
                                + totalPrice);

                        System.out.print("Confirm Rental? (y/n): ");

                        String confirm = sc.nextLine();

                        if (confirm.equalsIgnoreCase("y")) {

                            system.rentCar(
                                    selectedCar,
                                    customer,
                                    days);

                            System.out.println(
                                    "Car Rented Successfully!");

                        } else {

                            System.out.println(
                                    "Rental Cancelled.");
                        }
                    }

                    break;

                case 3:

                    System.out.println("\n===== RETURN A CAR =====");

                    System.out.print("Enter Car ID: ");

                    String returnCarId = sc.nextLine();

                    Car returnCar = null;

                    Car[] returnCars = {c1, c2, c3, c4};

                    for (Car car : returnCars) {

                        if (car.getCarId()
                                .equalsIgnoreCase(returnCarId)
                                && !car.isAvailable()) {

                            returnCar = car;
                            break;
                        }
                    }

                    if (returnCar == null) {

                        System.out.println(
                                "This car is not rented.");

                    } else {

                        system.returnCar(returnCar);

                        System.out.println(
                                "Car Returned Successfully!");
                    }

                    break;

                case 4:

                    System.out.println(
                            "Thank You For Using Our System!");

                    sc.close();

                    return;

                default:

                    System.out.println(
                            "Invalid Choice. Try Again.");
            }
        }
    }
}