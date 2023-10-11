public class BatAndGorilla {
    public static void main(String[] args) {
        Gorilla gorilla = new Gorilla();
        Bat bat = new Bat();

        gorilla.throwSomething();
        gorilla.eatBananas();
        gorilla.climb();
        gorilla.displayEnergy();

        bat.attackTown();
        bat.eatHumans();
        bat.fly();
        bat.displayEnergy();
    }
}

class Mammal {
    protected int energyLevel;

    public Mammal() {
        this.energyLevel = 100;
    }

    public int displayEnergy() {
        System.out.println("Energy Level: " + energyLevel);
        return energyLevel;
    }
}

class Gorilla extends Mammal {
    public void throwSomething() {
        System.out.println("Gorilla has thrown something!");
        energyLevel -= 5;
    }

    public void eatBananas() {
        System.out.println("Gorilla is satisfied after eating bananas!");
        energyLevel += 10;
    }

    public void climb() {
        System.out.println("Gorilla climbed a tree!");
        energyLevel -= 10;
    }
}

class Bat extends Mammal {
    public Bat() {
        this.energyLevel = 300;
    }

    public void fly() {
        System.out.println("Bat is taking off!");
        energyLevel -= 50;
    }

    public void eatHumans() {
        System.out.println("Bat is satisfied after eating humans!");
        energyLevel += 25;
    }

    public void attackTown() {
        System.out.println("Sound of a town on fire!");
        energyLevel -= 100;
    }
}
