public class Car
{
    int maxSpeed = 100;
    int minSpeed = 0;
    double weight = 4079;
    boolean isTheCarOn = false;
    char condition = 'A';
    String nameOfCar = "Bentley";

    public void printVariables()
    {
        System.out.println("This is the max speed: " + maxSpeed);
        System.out.println("This is the min speed: " + minSpeed);
        System.out.println("This is the Car weight: " + weight);
        System.out.println("This is the Car state: " + isTheCarOn);
        System.out.println("This is the Car condition: " + condition);
        System.out.println("This is the Car name: " + nameOfCar);
    }

    public void changeCondition() // Or we can call this function -
                                  // public void wreckCar()
    {
        condition = 'C';
    }

    public void upgradeMinSpeed()
    {
        minSpeed = maxSpeed;
        maxSpeed = maxSpeed + 1;
    }

    public void setTheCarOn()
    {
        isTheCarOn = true;
    }

    public void changeTheCarWeight()
    {
        weight = 8005.88;
    }

    public void setCarName()
    {
        nameOfCar = "Range Rover";
    }

    public static void main(String args[])
    {
        Car familyCar = new Car();
        System.out.println("Family's Car: ");
        familyCar.printVariables();
        Car indieCar = familyCar;
        familyCar.changeCondition();
        familyCar.upgradeMinSpeed();
        familyCar.setTheCarOn();
        familyCar.changeTheCarWeight();
        familyCar.setCarName();
        System.out.println("\nIndie's Car: ");
        indieCar.printVariables();
    }
}