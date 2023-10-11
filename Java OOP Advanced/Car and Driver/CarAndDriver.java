public class CarAndDriver {
    public static void main(String[] args) {
        Driver driver = new Driver();

        driver.status(); // Initial gas level

        // Call the drive method four times
        driver.drive();
        driver.drive();
        driver.drive();
        driver.drive();

        // Call the boost method once
        driver.boost();

        // Call the refuel method three times 
        driver.refuel();
        driver.refuel();
        driver.refuel();

        driver.status(); // Gas level after actions
    }
}
