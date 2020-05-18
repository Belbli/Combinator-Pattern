package combinatorPattern;

import java.time.LocalDate;

import static combinatorPattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer(
          "Alice",
                "alice@gmail.com",
                "+04324234324",
                LocalDate.of(2000, 1, 1)
        );

        /*System.out.println(
                new CustomerValidatorService()
                        .isValid(customer)
        );*/


        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }

    }

}
