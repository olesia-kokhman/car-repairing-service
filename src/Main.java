public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Ivan Petrenko", "+380501112233");
        Car car = new Car("AA1234BB", "Toyota Corolla", 2012, 180000);

        ServiceRequest request = new ServiceRequest(101, customer, car, "Brake noise while driving");

        ServiceAdvisor advisor = new ServiceAdvisor("Olena");
        Mechanic mechanic = new Mechanic("Mykola", 450.0);

        CarRepairService service = new CarRepairService(advisor, mechanic);
        System.out.println(request);

        Invoice invoice = service.process(request);
        System.out.println(request);

        System.out.println(invoice.print());

        Payment payment = new Payment("CARD");
        payment.pay(invoice.getTotal(), invoice.getTotal());

        System.out.println(payment);

        if (payment.isSuccessful()) {
            advisor.notifyCustomer(customer, "Payment received. Thank you!");
            advisor.close(request);
        } else {
            advisor.notifyCustomer(customer, "Payment failed. Please retry.");
        }

        System.out.println(request);
    }
}
