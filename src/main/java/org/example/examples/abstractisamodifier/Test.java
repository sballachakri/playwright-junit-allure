package org.example.examples.abstractisamodifier;
//abstract is modifier
//applicable to methods and class
//abstract method - is declaration contains no implementations
//child class are responsible for implementation
//if a class contains at least one abstract method should be abstract class
//
//abstract class - object creation is not possible
//abstract class method's can not be called directly because there is no implementation.
//we create a class as abstract even though it do not contain abstract method.
//HttpServlet - is an example of abstract class

public class Test extends Loan{


    @Override
    public int getInterestRate() {
        return 0;
    }

    @Override
    public void getAccountType() {

    }
}
