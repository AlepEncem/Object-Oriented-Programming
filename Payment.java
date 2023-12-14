package cinemaProject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import cinemaProject.Cinema.Hall;

public class Payment {
	private String name;
	private String email;
	private String mobile;
	private double amount;
    private int paymentMethod;

    public Payment(String name, String email, String mobile, double amount, int paymentMethod) {
       this.name = name;
       this.email = email;
       this.mobile = mobile;
       this.amount = amount;
       this.paymentMethod = paymentMethod;
    }

    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void makePayment() {
    	if(paymentMethod == 1) {
            System.out.println("Making payment of RM" + amount + " using credit card/debit card");
    	} else {
            System.out.println("Making payment of RM" + amount + " using online banking");
    	}
    }
    
    public boolean cardPayment(Scanner scan) {

    	double amountUser;
    	
    	do {
	    	System.out.print("Enter payment amount: RM");
	    	amountUser = scan.nextDouble();
	    	
	    	if(amountUser < amount)
	    		System.out.println("Insufficient amount. Please enter RM"+amount);
	    	
	    	if(amountUser > amount)
	    		System.out.println("Excessive amount. Please enter RM"+amount);
    	
    	}while(amountUser != amount);
    	
        return true;
        
    }
    
    public boolean onlinePayment(String username, String password, Scanner scan) {
        
        double amountUser;
        
        do {
            System.out.print("Enter payment amount: RM");
            amountUser = scan.nextDouble();
            
            if(amountUser < amount)
                System.out.println("Insufficient amount. Please enter RM"+amount);
            
            if(amountUser > amount)
                System.out.println("Excessive amount. Please enter RM"+amount);
        
        }while(amountUser != amount);
        
        if (username != null && password != null) {
            return true;
        } else {
            System.out.println("Transaction failed. Please check your email and password and try again.");
            return false;
        }
    }

    
    public void paymentSucceed(Cinema cinema, ArrayList<String> seats) {
		System.out.println("**************************************************");
    	System.out.println("Transaction status: Successful");
    	System.out.println("Name:               " + name);
    	System.out.println("Email:              " + email);
    	System.out.println("Mobile:             " + mobile);
    	System.out.println("Amount Paid(RM):    " + amount);
    	if(paymentMethod == 1)
    		System.out.println("Payment Method:     Credit card/ Debit card");
    	else
    		System.out.println("Payment Method:     Online banking");
    	System.out.println("--------------------------------------------------");
    	System.out.println("                Order details:");
    	System.out.println("--------------------------------------------------");
    	System.out.println(cinema.toString());
    	Hall.displaySelectedSeat(seats);
    	System.out.println("\n      You can show this receipt at the\n          counter to enter the cinema.\n");
		System.out.println("**************************************************");

    }
    
    public static boolean isValidCvv(String cvv) {
        if (cvv.length() == 3 || cvv.length() == 4) {
            try {
                int cvvValue = Integer.parseInt(cvv);
                return true;
            } catch (NumberFormatException e) {
                System.out.println("Error: CVV must be a number.");
                return false;
            }
        } else {
            System.out.println("Error: CVV must contains 3 or 4 digits.");
            return false;
        }
    }


    public static boolean isValidExpirationDate(String expirationDate) {
    	// Check if the length of the expiration date is not 5 or 7 characters
    	if (expirationDate.length() != 5 && expirationDate.length() != 7) {
    		return false;
    	}
    	
    	// Split the expiration date by "/" character
    	String[] dateParts = expirationDate.split("/");
    	
    	// Check if the split array is not of length 2
    	if (dateParts.length != 2) {
    		System.out.println("Error: Invalid format. Expiration date should be in the format of MM/YY or MM/YYYY.");
    		return false;
    	}
    	
    	int month;
    	int year;
    	
    	try {
	    	// Try to parse the first part of the split array as integer for month
	    	month = Integer.parseInt(dateParts[0]);
	    	// Try to parse the second part of the split array as integer for year
	    	year = Integer.parseInt(dateParts[1]);
    	} catch (NumberFormatException e) {
	    	System.out.println("Error: Invalid format. Month and year should be numbers.");
	    	return false;
    	}
    	
    	// Check if the month is less than 1 or greater than 12
    	if (month < 1 || month > 12) {
    		System.out.println("Error: Invalid month. Month should be between 1 and 12.");
    		return false;
    	}
    	
    	// If the length of the expiration date is 5 characters, add 2000 to year
    	if (expirationDate.length() == 5)
    		year += 2000;
    	
    	// Get the current date
    	Calendar currentDate = Calendar.getInstance();
    	int currentYear = currentDate.get(Calendar.YEAR);
    	
    	// Check if the year is less than the current year
    	if (year < currentYear) {
    		System.out.println("Error: Your card has been expired.");
    		return false;
    	}
    	
    	int currentMonth = currentDate.get(Calendar.MONTH) + 1;
    	
    	// Check if the year is same as the current year and the month is less than the current month
    	if (year == currentYear && month < currentMonth) {
	    	System.out.println("Error: Your card has been expired.");
	    	return false;
    	}
    	
    	// If all checks pass, return true
    	return true;
    	}

}

