public class Driver extends Car {
    public void drive() {
        if (getGas() > 0) {
            System.out.println("You drive the car.");
            setGas(getGas() - 1);
        } else {
            System.out.println("Out of gas. Cannot drive.");
        }
    }

    public void boost() {
        if (getGas() >= 3) {
            System.out.println("You use boosters.");
            setGas(getGas() - 3);
        } else {
            System.out.println("Not enough gas to use boosters.");
        }
    }

    public void refuel() {
        if (getGas() < 10) {
            System.out.println("You refuel the car.");
            setGas(getGas() + 2);
        } else {
            System.out.println("Gas tank is full. No need to refuel.");
        }
    }
}
