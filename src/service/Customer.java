package service;

import exceptions.ValidationException;

import java.util.Objects;

public class Customer implements Validatable {

    private final String fullName;
    private final String phone;

    public Customer(String fullName, String phone) {
        this.fullName = fullName;
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }
    public String getPhone() {
        return phone;
    }

    @Override
    public void validate() {
        if (fullName == null || fullName.isBlank()) {
            throw new ValidationException("Customer full name is empty");
        }
        if (phone == null || phone.isBlank()) {
            throw new ValidationException("Customer phone is empty");
        }
    }


    @Override
    public String toString() {
        return "service.Customer{" +
                "fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(fullName, customer.fullName) && Objects.equals(phone, customer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, phone);
    }
}
