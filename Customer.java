package cinemaProject;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Customer {
	private String fName, mobileNo, email, password;
	
	Customer(String value_fName, String value_mobileNo, String value_email, String value_pword)
	{
		this.fName = value_fName;
		this.mobileNo = value_mobileNo;
		this.email = value_email;
		this.password = value_pword;
	}
	
	public String getfName() {
        return fName;
    }
    public String getMobileNo() {
        return mobileNo;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    
    public void setfName(String name) {
    	this.fName = name;
    }
    public void setMobileNo(String mobile) {
        this.mobileNo = mobile;
    }
    public void setEmail(String mail) {
        this.email = mail;
    }
    public void setPassword(String pword) {
        this.password = pword;
    }

	public static Customer sign_in(ArrayList<Customer> custList, Scanner scan)
	{
		String input_fName, input_mobileNo, input_email, input_pword;
		
		System.out.println("\n\n\n\n\n\n\n");
		System.out.println("--------------------------------------------------------------------------------------------------------");
		System.out.println("                                             Sign up");
		System.out.println("--------------------------------------------------------------------------------------------------------");
		
		do {
			System.out.print("\nEnter your full name: ");
			input_fName = scan.nextLine();
			
			if (validateString(input_fName) == false) {
			    System.out.println("Invalid name. Name must contains alphabet only.");
			}
		} while(validateString(input_fName) == false);
		
		do {
			System.out.print("\nEnter mobile number: ");
			input_mobileNo = scan.nextLine();
			if (validateStringNumber(10,11,input_mobileNo) == false) {
			    System.out.println("Invalid mobile number. Mobile number must contain 10-11 digits.");
			}
		}while(validateStringNumber(10,11,input_mobileNo) == false);
		
		do {
			System.out.print("\nEnter your email: ");
			input_email = scan.nextLine();
			if(validateEmail(input_email) == false) {
				  System.out.println("Invalid email address. Please enter a valid email address in the format example@domain.com.");
			}
		}while(validateEmail(input_email) == false);
		
		Admin admin = new Admin();
		do {
			System.out.print("\nEnter your password: ");
			input_pword = scan.nextLine();
			if(validatePassword(input_pword) == false || input_pword.equals(admin.getAdminPword())) {
				  System.out.println("Invalid password.");
				  System.out.println("Password must contain:");
			      System.out.println("- At least 1 digit (0-9)");
			      System.out.println("- At least 1 lowercase letter (a-z)");
			      System.out.println("- At least 1 uppercase letter (A-Z)");
			      System.out.println("- At least 1 special character");
			      System.out.println("- No whitespace characters");
			      System.out.println("- Length between 6 and 20 characters");
			}
		}while(validatePassword(input_pword) == false || input_pword.equals(admin.getAdminPword()));

		
		Customer custInfo = new Customer(input_fName,input_mobileNo,input_email,input_pword);
		custList.add(custInfo);
		return custInfo;
	}
	
	public static Customer log_in(ArrayList<Customer> custList, Scanner scan, Admin admin) {
		int ans;
		do {
			String input_mobileNo, input_pword;
			
			System.out.println("\n\n\n\n\n\n\n");
			System.out.println("--------------------------------------------------------------------------------------------------------");
    		System.out.println("                                              Log in");
    		System.out.println("--------------------------------------------------------------------------------------------------------");

	
			do {
				System.out.print("\nEnter mobile number: ");
				input_mobileNo = scan.nextLine();
				if (validateStringNumber(10,11,input_mobileNo) == false && !input_mobileNo.equals(admin.getAdminNo())) {
				    System.out.println("Invalid mobile number. Mobile number must contain 10-11 digits.");
				}
			}while(validateStringNumber(10,11,input_mobileNo) == false && !input_mobileNo.equals(admin.getAdminNo()));
	
			do {
				System.out.print("\nEnter your password: ");
				input_pword = scan.nextLine();
				if(validatePassword(input_pword) == false) {
					System.out.println("Invalid password.");
					  System.out.println("Password must contain:");
				      System.out.println("- At least 1 digit (0-9)");
				      System.out.println("- At least 1 lowercase letter (a-z)");
				      System.out.println("- At least 1 uppercase letter (A-Z)");
				      System.out.println("- At least 1 special character");
				      System.out.println("- No whitespace characters");
				      System.out.println("- Length between 6 and 20 characters");
				}
			}while(validatePassword(input_pword) == false);

			for (Customer c : custList) {
		        if (c.mobileNo.equals(input_mobileNo) && c.password.equals(input_pword)) {
		        	 Customer cust = new Customer(c.getfName(),c.getMobileNo(),c.getEmail(),c.getPassword());
		        	 return cust;
		        }
		    }
			if(Admin.isAdmin(input_mobileNo, input_pword)) {
				Customer cust = new Customer("Admin",input_mobileNo,"admin@dmin.com",input_pword);
				return cust;
			}
			
			System.out.print("Incorrect mobile number or password. (1-try again or 2-sign up): ");
		    ans = Booking.getValidInt(1,2, scan);
		    
		    if(ans == 2) {
		    	Customer cust = Customer.sign_in(custList,scan);
		    	return cust;
		    }
		    
		}while(ans == 1);
	    return null;
	}
	
	public static boolean validateEmail(String email) {
	    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
	                        "[a-zA-Z0-9_+&*-]+)*@" + 
	                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
	                        "A-Z]{2,7}$"; 
	                          
	    Pattern pat = Pattern.compile(emailRegex); 
	    if (email == null) 
	        return false; 
	    return pat.matcher(email).matches(); 
	}

	public static boolean validatePassword(String password) {
	    String passwordRegex = "^(?=.*[0-9])"
				                + "(?=.*[a-z])(?=.*[A-Z])"
				                + "(?=.*[~!@#$%^&*-_+=])"
				                + "(?=\\S+$).{6,20}$";
	    Pattern pat = Pattern.compile(passwordRegex);
	    if (password == null) 
	        return false;
	    return pat.matcher(password).matches();
	}

	public static boolean validateStringNumber(int min, int max, String number) {
	    if (number == null)
	        return false;
	    
	    if (number.length() == 0)
	    	return false;
	    
	    if (number.length() < min || number.length() > max ) 
	        return false;

	    for (int i = 0; i < number.length(); i++) {
	        if (!Character.isDigit(number.charAt(i))) 
	            return false;
	    }
	    return true;
	}
	
	public static boolean validateString(String string) {
	    if (string == null) {
	        return false;
	    }
	    
	    if (string.length() == 0)
	    	return false;
	    
	    for (int i = 0; i < string.length(); i++) {
	        if (!Character.isLetter(string.charAt(i)) && string.charAt(i) != ' ') {
	            return false;
	        }
	    }
	    return true;
	}



}