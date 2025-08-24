class Main
{
    public static void main(String[] args) {

        RentalSystem rentalSystem = new RentalSystem();

        Car c1 = new Car("C001","Toyota","Supra",3000);
        Car c2 = new Car("C002","Ferrari","Ferrari LaFerrari", 2000);
        Car c3 = new Car("C003","McLaren","McLaren P1",1500);

        rentalSystem.addCar(c1);
        rentalSystem.addCar(c2);
        rentalSystem.addCar(c3);

        rentalSystem.menu();
    }
}