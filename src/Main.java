import documents.DiagnosisReport;
import documents.Invoice;
import documents.Printable;
import documents.StandardWarrantyPolicy;
import service.*;
import vehicle.Car;
import vehicle.FuelType;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // add final to fields in classes
        Scanner scanner = new Scanner(System.in);

        System.out.println("Car repairing service welcomes you!");

        System.out.print("Enter customer full name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter customer phone: ");
        String customerPhone = scanner.nextLine();

        Customer customer = new Customer(customerName, customerPhone);

        System.out.print("Enter car plate number: ");
        String plateNumber = scanner.nextLine();

        System.out.print("Enter car model: ");
        String model = scanner.nextLine();

        System.out.print("Enter car year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter car mileage (km): ");
        int mileage = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter fuel type: PETROL, DIESEL, ELECTRIC, HYBRID : ");
        FuelType fuelType = FuelType.valueOf(scanner.nextLine().trim().toUpperCase());

        Car car = new Car(plateNumber, model, year, mileage, fuelType);

        System.out.print("Describe the problem: ");
        String problemDescription = scanner.nextLine();

        int requestId = (int) (System.currentTimeMillis() % 100000);

        ServiceRequest request = new ServiceRequest(requestId, customer, car, problemDescription);

        System.out.println("\nYour initial request:");
        System.out.println(request);

        ServiceAdvisor advisor = new ServiceAdvisor("Olena");
        Mechanic mechanic = new Mechanic("Mykola", 450.0);

        CarRepairService service = new CarRepairService(advisor, mechanic);
        Invoice invoice = service.process(request);

        System.out.println("\nYour request after processing: ");
        System.out.println(request);

        // POLYMORPHISM
        List<Printable> documents = List.of(
                invoice, new DiagnosisReport("some issue", 16, false, "required name"),
                new StandardWarrantyPolicy());


        System.out.println("\nYour documents:");
        for (Printable doc : documents) {
            System.out.println("--------------------------------");
            System.out.println(doc.toPrint());
        }

        System.out.print("\nChoose payment method : CARD, CASH: ");
        String paymentMethod = scanner.nextLine().trim().toUpperCase();

        Payment payment = new Payment(paymentMethod);

        System.out.print("Enter payment amount: ");
        double amountPaid = Double.parseDouble(scanner.nextLine());
        double invoiceTotal = invoice.getTotal();

        payment.pay(invoiceTotal, amountPaid);

        if (payment.isSuccessful() && payment.getAmountPaid() >= invoiceTotal) {
            advisor.notifyCustomer(
                    customer,
                    "service.Payment received in full. Thank you and have a nice day!"
            );
            advisor.close(request);
        } else if (payment.isSuccessful()) {
            advisor.notifyCustomer(
                    customer,
                    "Partial payment received. Remaining amount: "
                            + (invoiceTotal - payment.getAmountPaid())
            );
        } else {
            advisor.notifyCustomer(customer, "service.Payment failed. Please retry.");
        }

    }
}
