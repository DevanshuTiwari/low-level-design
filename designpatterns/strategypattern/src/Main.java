public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new SportsVehicle(new SportsDrive());
        vehicle.drive();
    }
}