package cinemaProject;

import cinemaProject.Cinema.Hall;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Map;
import java.util.Random;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Booking {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
			
		ArrayList<Customer> custList = new ArrayList<Customer>();
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		ArrayList<Cinema> cinemaList = new ArrayList<Cinema>();
		ArrayList<SalesReport> salesCinema = new ArrayList<SalesReport>();

		//initialize existed customer
		custList.add(new Customer("Wan Zarin Wan Nizam","0192891001","wanzarin@gmail.com","001122_Aa"));
		
		//add movie to array movie list
		movieList.add(new Movie("Megan","Horror","1 h 42 mins","ENG","P13"));
		movieList.add(new Movie("Puss In Boots: The Last Wish","Animation","1 h 29 mins","ENG","P13"));
		movieList.add(new Movie("Avatar: The Way of Water","Action","3 h 12 mins","ENG","P13"));
		movieList.add(new Movie("Mechamato Movie","Animation","2 h 2 mins","ENG","P13"));
		movieList.add(new Movie("Sword Art Online The Movie – Progressive - SODN","Animation","1 h 40 mins","JPN","P13"));
		
		//initialize the cinema object
		Cinema cinemaMidV = new Cinema("Johor Bahru - The Mall, Mid Valley Southkey");
	    Cinema cinemaKluang = new Cinema("Kluang -Kluang Mall");
	    Cinema cinemaParadigm = new Cinema("Johor Bahru – Paradigm Mall");
	    
	    //add movie to cinema object
	    cinemaMidV.addMovie(new Movie("Megan","Horror","1 h 42 mins","ENG","P13"), new String[]{"02:45 PM","02:45 PM"}, new String[] {"28 Jan","29 Jan"});
	    cinemaMidV.addMovie(new Movie("Puss In Boots: The Last Wish","Animation","1 h 29 mins","ENG","P13"), new String[]{"05:30 PM","05:30 PM"}, new String[] {"27 Jan","28 Jan"});
	    cinemaKluang.addMovie(new Movie("Avatar: The Way of Water","Action","3 h 12 mins","ENG","P13"), new String[]{"11:15 AM","11:15 AM"}, new String[] {"29 Jan","30 Jan"});
	    cinemaKluang.addMovie(new Movie("Mechamato Movie","Animation","2 h 2 mins","ENG","P13"), new String[]{"10:30 AM","10:30 AM"}, new String[] {"27 Jan","28 Jan"});
	    cinemaParadigm.addMovie(new Movie("Sword Art Online The Movie – Progressive - SODN","Animation","1 h 40 mins","JPN","P13"), new String[]{"12:25 PM","12:25 PM"}, new String[] {"26 Jan","27 Jan"});
	    
	    //initialize hall in each cinema
	    Hall hallMidv1 = cinemaMidV.new Hall("Johor Bahru - The Mall, Mid Valley Southkey",1, 10, 10, "Play Plus");
	    hallMidv1.addMovie(cinemaMidV.getMovie("Megan"));
	    Pricing megan = new Pricing(21.00,10.00,10.00,10.00);
	    cinemaMidV.setPrice(megan);
	    cinemaMidV.addHall(hallMidv1);
	    
	    Hall hallMidv2 = cinemaMidV.new Hall("Johor Bahru - The Mall, Mid Valley Southkey",2, 10, 10, "2D Digital");
	    hallMidv2.addMovie(cinemaMidV.getMovie("Puss In Boots: The Last Wish"));
	    Pricing pussInBoot = new Pricing(22.00,13.00,13.00,13.00);
	    cinemaMidV.setPrice(pussInBoot);
	    cinemaMidV.addHall(hallMidv2);
	    
	    Hall hallKluang1 = cinemaKluang.new Hall("Kluang -Kluang Mall",1, 10, 10, "2D Digital");
	    hallKluang1.addMovie(cinemaKluang.getMovie("Avatar: The Way of Water"));
	    Pricing avatar = new Pricing(12.00,9.00,9.00,9.00);
	    cinemaKluang.setPrice(avatar);
	    cinemaKluang.addHall(hallKluang1);
		
	    Hall hallKluang2 = cinemaKluang.new Hall("Kluang -Kluang Mall",2, 10, 10, "2D Digital");
	    hallKluang2.addMovie(cinemaKluang.getMovie("Mechamato Movie"));
	    Pricing mechamato = new Pricing(12.00,9.00,9.00,9.00);
	    cinemaKluang.setPrice(mechamato);
	    cinemaKluang.addHall(hallKluang2);
		
	    Hall hallPara1 = cinemaParadigm.new Hall("Johor Bahru - The Mall, Mid Valley Southkey",1, 10, 10, "2D Digital");
	    hallPara1.addMovie(cinemaParadigm.getMovie("Sword Art Online The Movie – Progressive - SODN"));
	    Pricing sword = new Pricing(20.00,9.00,9.00,9.00);
	    cinemaParadigm.setPrice(sword);
	    cinemaParadigm.addHall(hallPara1);
	    
	    //add cinema to array cinema list
	    cinemaList.add(cinemaMidV);
	    cinemaList.add(cinemaKluang);
	    cinemaList.add(cinemaParadigm);
	   
	    //create SalesReport object for each cinema
    	SalesReport salesMidv1 = new SalesReport();
    	salesMidv1.addSaleData(cinemaMidV.getBranchName(), cinemaMidV.getMovie("Megan").getMovieName(), 0);    	
    	salesCinema.add(salesMidv1);
    	
    	SalesReport salesMidv2 = new SalesReport();
    	salesMidv2.addSaleData(cinemaMidV.getBranchName(), cinemaMidV.getMovie("Puss In Boots: The Last Wish").getMovieName(), 0);
    	salesCinema.add(salesMidv2);
    	
    	SalesReport salesKluang1 = new SalesReport();
    	salesKluang1.addSaleData(cinemaKluang.getBranchName(), cinemaKluang.getMovie("Avatar: The Way of Water").getMovieName(), 0);
    	salesCinema.add(salesKluang1);
    	
    	SalesReport salesKluang2 = new SalesReport();
    	salesKluang2.addSaleData(cinemaKluang.getBranchName(), cinemaKluang.getMovie("Mechamato Movie").getMovieName(), 0);
    	salesCinema.add(salesKluang2);
    	
    	SalesReport salesParadigm = new SalesReport();
    	salesParadigm.addSaleData(cinemaParadigm.getBranchName(), cinemaParadigm.getMovie("Sword Art Online The Movie – Progressive - SODN").getMovieName(), 0);
	    salesCinema.add(salesParadigm);
	    
	    int next;
	    do {
			int loop;
			
			do {
								
				//main menu
				System.out.println("------------------------------------Welcome to Golden Screen Cinema------------------------------------\n");
				System.out.print("[1]-Log in\n[2]-Sign up\n[3]-Show available Movies\n[4]-Quit the program\nSelect an option: ");
				int option = getValidInt(1,4,scan);
				
				//instantiate related object for the booking process
				Customer cust = null;
				ArrayList<String> selectedSeats = new ArrayList<>();
			    Movie selectedMovie = null;
			    Cinema selectedCinema = null;
		    	Hall selectedHall = null;
				
		    	//log in for existed customer
				if(option == 1) {
					Admin admin = new Admin();
					Customer existedCust = Customer.log_in(custList,scan,admin);
					
					//check if admin is logging in
					if(existedCust.getMobileNo().equals(admin.getAdminNo()) && existedCust.getPassword().equals(admin.getAdminPword())) {
						
						int adminChoice;
						
						do {
						System.out.println("\nWelcome Admin!\n1.Update the customer detail\n2.Update movie detail\n3.Delete Movie\n4.Update cinema detail\n5.Show report today");
						System.out.print("Select an option: ");
						adminChoice = getValidInt(1,5,scan);
						
						if(adminChoice == 1)
							admin.updateCustomer(custList, scan);
						
						else if(adminChoice == 2)
							admin.updateMovie(cinemaList, movieList, scan);
						
						else if(adminChoice == 3)
							admin.deleteMovie(movieList, scan);
						
						else if(adminChoice == 4)
							admin.updateCinema(cinemaList, scan);
						
						else 
							admin.showReportToday(salesCinema);
						
						System.out.print("Back to menu? (1-Yes 2-No): ");
						adminChoice = getValidInt(1, 2, scan);
						
						if(adminChoice == 2)
							break;
						
						}while(adminChoice == 1);
					}
					
					cust = existedCust;
				}
				
				//sign in for new customer
				if(option == 2) {
					//sign in for new customer
					Customer newCust = Customer.sign_in(custList,scan);
					cust = newCust;
				}
				
				//continue to booking process for existed customer, new customer or unknown customer
				if(option == 3 || cust != null){
					
					//display available movie that contained in movieList
					System.out.println("\n\n");
					Movie.displayMovie(movieList);
					option = getValidInt(1,movieList.size(), scan);
					
					//instantiate selected movie
					selectedMovie = Movie.getMovie(movieList,(option-1));
			    	
				    for(Cinema cinemas: cinemaList) {
				    	//get each movie and showtime that contained inside the cinema
				    	for (Map.Entry<Movie, Map<String[], String[]>> entry : cinemas.getMovieAndShowtimes().entrySet()) {
							Map<String[], String[]> showtimes = entry.getValue();
							Movie movie = entry.getKey();
							
							//search cinema that contained the selected movie
							if (movie.getMovieName().equals(selectedMovie.getMovieName())) {
								System.out.println("\n\n");
								System.out.println("\n"+cinemas.getBranchName());
								System.out.println(movie.getMovieName());
								System.out.println("Showtimes and dates:");
								
								for (Map.Entry<String[], String[]> showtime : showtimes.entrySet()) {
									
									//get showtime and date for that particular movie inside the cinema
									String[] time = showtime.getKey();
									String[] date = showtime.getValue();
									
									for(int i=0; i<time.length; i++ ) {
										System.out.println((i+1) + ". " + time[i] + " " + date[i]);
									}
									
									//get selected showtime and date from user
									System.out.print("Enter the showtime number: ");
								    option = getValidInt(1,time.length, scan);
								    selectedCinema = new Cinema(cinemas.getBranchName());
								    
								    //instantiate and initialize selected cinema
								    selectedHall = cinemas.getHall(selectedMovie);
							    	selectedCinema.addMovie(movie, new String[] {"time: ",time[option-1]}, new String[] {"Date: ",date[option-1]});
								    selectedHall.addMovie(movie);
							    	selectedCinema.addHall(selectedHall);
							    	selectedCinema.setPrice(cinemas.getPrice());
								}
							    							
							}
						}
				    }
				    
				    //check if selected cinema object instantiated successfully
				    if (selectedCinema != null) {
			    		System.out.println("\n\n");
				    	System.out.println(selectedCinema.toString());
				    } else {
				        System.out.println("Invalid option!");
				    }
				    
				    //declare related variable to booking seat process 
				    int child=0, adult=0, senior=0, oku=0;
				    int numberOfSeat=0;
				    
				    //check if selected hall instantiated successfully
				    if(selectedHall != null) {
				    	do {
				    		System.out.println("\n\n\n");
				    		System.out.println("-------------------------------");
				    		System.out.println("          S C R E E N");
					    	selectedHall.displaySeats();
					    	
					    	//declare row and column that would be entered by user
			    			int row, column;
			    			char rowChar;
			    			String rowInput;
			    			
					    	do {
				    			
				    			do {
						            System.out.print("\nEnter seat row (e.g. A): ");			            
						            rowInput = scan.next();
						            
						            //check if row is not a single character
						            if (rowInput.length() != 1) {
						                System.out.println("Invalid input. Please enter a single character.");
						            } else {
						            	//convert string row to int
						                rowChar = rowInput.charAt(0);
						                row = rowChar - 'A';
						                
						                //check if the row within the row range
						                if(row < 0 || row >= selectedHall.getSeatRow().length ) {
						                    System.out.println("Invalid row selected. Please choose a valid row.");
						                } else {
						                	break;
						                }
						            }
						            
				    			}while(true);
			
						        System.out.print("\nEnter seat column (e.g. 0): ");
						        column = getValidInt(0,selectedHall.getSeatColumn().length, scan);
						        
						        //check if the seat was booked or not
					            if (selectedHall.getSeat(row, column) != 1) {
					            	selectedHall.setSeat(row, column, 1);
					            	
					            	Cinema.setSeatInCinemaArray(cinemaList,selectedMovie.getMovieName(),row,column,1);
	
					            	//collect the entered seat by concatinating row and column
					            	String userSeat = rowInput+""+column;
					            	selectedSeats.add(userSeat);
					            	numberOfSeat ++;
					            	
						            System.out.print("Do you want to add more seats (1-Yes 2-No): ");
						            option = getValidInt(1,2, scan);
								} else {
									System.out.println("Selected seat is booked. Please enter the available seat only.");
								}
					            
					    	}while(option == 1);
					    	
					    	//display selected seats
						    Hall.displaySelectedSeat(selectedSeats);
					    	
					    	System.out.print("\n\nConfirm the selected seat(s) (1-Yes 2-No): ");
				            option = getValidInt(1,2, scan);
		
				            if(option == 1 ) {
				            	break;
				            } else {
				            	//Loop through all the selected seats and set their value back to 0 (i.e. not booked)
				            	for(String seat : selectedSeats) {
				            		int rowToDel = seat.charAt(0) - 'A';
				            		int columnToDel = Integer.parseInt(seat.substring(1));
				            		selectedHall.setSeat(rowToDel, columnToDel, 0);
					            	Cinema.setSeatInCinemaArray(cinemaList,selectedMovie.getMovieName(),rowToDel,columnToDel,0);
				            		
				            	}
				            	
				            	//Clear the selected seats list
				            	selectedSeats.clear();
				            	
				            	//Reset the number of selected seats to 0
				            	numberOfSeat = 0;
				            	
				            	System.out.print("Seats have been unbooked. Do you want to book the seat again (1-Yes 2-No): ");
					            option = getValidInt(1,2, scan);
					            if(option == 2)
					            	selectedSeats = null;
				            }
					    
				    	}while(option == 1);
				    
				    }
				    
				    if(selectedSeats != null) {
					    //display selected seats
					    Hall.displaySelectedSeat(selectedSeats);
				    	
					    do {
					    	System.out.print("\n\nHow many adults (13+): ");
					    	adult = getValidInt(0,numberOfSeat,scan);
					    	
					    	System.out.print("\nHow many Children (3-12): ");
					    	child = getValidInt(0,numberOfSeat-adult,scan);
					    	
					    	System.out.print("\nHow many have disabilities (OKU): ");
					    	oku = getValidInt(0,numberOfSeat-adult-child,scan);
					    	
					    	System.out.print("\nHow many seniors (55+): ");
					    	senior = getValidInt(0,numberOfSeat-adult-child-oku,scan);
					    	
					    	//check if number of people equals
					    	if(adult+child+oku+senior != numberOfSeat)
					    		System.out.print("The total of people is not corresponds to the number of selected seats.\nPlease ensure that the total number of each category corresponds to the number of selected seats.");
					    
					    }while(adult+child+oku+senior != numberOfSeat);
				    	
					    //display selected cinema, movie and seats
				    	System.out.println(selectedCinema.toString());		    	
					    Hall.displaySelectedSeat(selectedSeats);
					    
					    double childPrice = child*selectedCinema.getPrice().getChildPrice();
					    double adultPrice = adult*selectedCinema.getPrice().getAdultPrice();
					    double okuPrice = oku*selectedCinema.getPrice().getOkuPrice();
					    double seniorPrice = senior*selectedCinema.getPrice().getSeniorPrice();
	
					    System.out.println("");
					    
					    if(adultPrice > 0)
					    	System.out.println("Adult:     "+adult+" x RM"+selectedCinema.getPrice().getAdultPrice());
				    	
					    if(childPrice > 0)
					    	System.out.println("Children:  "+child+" x RM"+selectedCinema.getPrice().getChildPrice());
				    	
					    if(okuPrice > 0)
					    	System.out.println("OKU:       "+oku+" x RM"+selectedCinema.getPrice().getOkuPrice());
				    	
					    if(seniorPrice > 0)
					    	System.out.println("Senior:    "+senior+" x RM"+selectedCinema.getPrice().getSeniorPrice());
		
				    	System.out.print("\nWould you like to proceed with the payment process? (1-Yes 2-No): ");
				    	option = getValidInt(1,2,scan);
				    	
				    	Payment pay = null;
				    	
				    	if(option == 1) {
				    		if(cust == null) {
				    			System.out.print("Please sign in/log in to proceed with the payment process (1-Sign in 2-Log in): ");
				    			option = getValidInt(1,2,scan);
				    			
				    			if(option == 1)
				    				cust = Customer.sign_in(custList,scan);
				    			else
				    				cust = Customer.log_in(custList, scan, null);
				    		}
				    			
				    		double amount = senior*selectedCinema.getPrice().getSeniorPrice()+oku*selectedCinema.getPrice().getOkuPrice()+child*selectedCinema.getPrice().getChildPrice()+adult*selectedCinema.getPrice().getAdultPrice();
				    		
				    		LocalDateTime currentTime = LocalDateTime.now();
				    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
				    		String formattedTime = currentTime.format(formatter);
				    		Random random = new Random();
				    	    long rand_int = System.currentTimeMillis() + random.nextInt(1000000000);
				    	    
				    		System.out.println("\n\n\n");
				    		System.out.println("**************************************************");
				    		System.out.println("                 Transcation Detail\n");
				    		System.out.println(selectedCinema.toString());
						    Hall.displaySelectedSeat(selectedSeats);
				    		System.out.println("\nTrans Date and Time: " + formattedTime);
				    		System.out.println("Trans ID: " + rand_int*999999);
						    System.out.println("Transaction amount(RM): "+amount);
						    System.out.println("Name: "+cust.getfName());
						    System.out.println("Email: "+cust.getEmail());
				    		System.out.println("**************************************************");
		
				    		System.out.print("\nEnter the payment method (1-Credit Card/Debit Card 2-Online Banking): ");
				    		option = getValidInt(1,2,scan);
				    		
				    		pay = new Payment(cust.getfName(),cust.getEmail(),cust.getMobileNo(),amount,option);
				    		System.out.println("\n\n\n");
				    		pay.makePayment();
				    		
				    		if(option == 1) {
				    			
				    			String cardNumber, expiryDate, nameCard, cvv;
				    			boolean valid;
				    			
				    			do {
				    				do {
				    					System.out.print("Enter your card number:");
						                cardNumber = scan.nextLine();
						                
						                if(!Customer.validateStringNumber(16, 16, cardNumber))
						                	System.out.println("Invalid card number. The card number must contains 16 number.");
						                
				    				}while(!Customer.validateStringNumber(16, 16, cardNumber));
					                
				    				do {
						                System.out.print("Enter the expiry date (MM/YY):");
						                expiryDate = scan.nextLine();
						                
						                valid = Payment.isValidExpirationDate(expiryDate);
						                if(valid)
						                	break;
						            
				    				}while(!valid);
					                
					                do {
						                System.out.print("Enter your name on card: ");
						                nameCard = scan.nextLine();
						                
						                if (!Customer.validateString(nameCard))
						    			    System.out.println("Invalid name. The name must contains alphabet only.");
						                
					                }while(!Customer.validateString(nameCard));
					                
					                do {
						                System.out.print("Enter the CVC/CVV2: ");
						                cvv = scan.nextLine();
						                
						                valid = Payment.isValidCvv(cvv);
						                if(valid)
						                	break;
						                
					                }while(!valid);
					                
					                if(pay.cardPayment(scan)) {
							    		System.out.println("\n\n\n");
							    		System.out.println("**************************************************");
							    		System.out.println("");
							    		System.out.println("                       RECEIPT\n");
					                	System.out.println("Reference number:    "+rand_int);
					                	System.out.println("Transaction status:  Successful");
							    		System.out.println("Trans Date and Time: " + formattedTime);
							    		System.out.println("Name:                " + nameCard);
							    		System.out.println("From:                " + cardNumber);
							    		System.out.println("To:                  Golden Screen Cinema Sdn Bhd\n");
							    		System.out.println("--------------------------------------------------");
							    		System.out.println("Total (RM):                        " + amount);
							    		System.out.println("--------------------------------------------------");
							    		System.out.println("\n\n**************************************************");
	
					                	break;
					                }
					                else {
					                	System.out.print("Try again or cancel the transaction (1-Try again 2-Cancel): ");
					                	option = getValidInt(1, 2, scan);
					                }
					                
				    			}while(option == 1);
				                
				    		} else {
				    			do {
					    			String accNumb, username, password;
					    			
					    			System.out.println("Transfer to: Golden Screen Cinema Sdn Bhd\n");
					    			System.out.println("[1]-Maybank\r\n"
					    					+ "[2]-CIMB Bank\r\n"
					    					+ "[3]-Public Bank\r\n"
					    					+ "[4]-Hong Leong Bank\r\n"
					    					+ "[5]-RHB Bank\r\n"
					    					+ "[6]-AmBank\r\n"
					    					+ "[7]-Alliance Bank\r\n"
					    					+ "[8]-Bank Islam\r\n"
					    					+ "[9]-Bank Rakyat\r\n"
					    					+ "[10]-Affin Bank");
					    			System.out.print("Select your bank (1-10): ");
					    			int bank = getValidInt(1,10,scan);
					    			
					    			do {
					    				System.out.print("\nEnter username: ");
					    				username = scan.nextLine();
					    				
					    				if(username == null)
					    					System.out.println("Invalid username. Please enter valid username.");
					    				
					    			}while(username == null);
					    			
					    			do {
					    				System.out.print("Enter password: ");
					    				password = scan.nextLine();
					    				
					    				if(!Customer.validatePassword(password)) {
					    					System.out.println("Invalid password.");
							  				System.out.println("Password must contain:");
							  			    System.out.println("- At least 1 digit (0-9)");
							  			    System.out.println("- At least 1 lowercase letter (a-z)");
							  			    System.out.println("- At least 1 uppercase letter (A-Z)");
							  			    System.out.println("- At least 1 special character");
							  			    System.out.println("- No whitespace characters");
							  			    System.out.println("- Length between 6 and 20 characters");
					    				}
					    			}while(!Customer.validatePassword(password));
					    			
					    			if(rand_int < 0)
						            	rand_int*=-99999999;
					    			if(pay.onlinePayment(username, password, scan)) {
							    		System.out.println("\n\n\n");
					    				System.out.println("**************************************************");
							    		System.out.println("");
							    		System.out.println("                       RECEIPT\n");
					                	System.out.println("Reference number:    "+rand_int);
					                	System.out.println("Transaction status:  Successful");
							    		System.out.println("Trans Date and Time: " + formattedTime);
							    		System.out.println("From:                " + rand_int*999 + " Saving account");
							    		System.out.println("To:                  Golden Screen Cinema Sdn Bhd\n");
							    		System.out.println("--------------------------------------------------");
							    		System.out.println("Total (RM):                        " + amount);
							    		System.out.println("--------------------------------------------------");
							    		System.out.println("\n\n**************************************************");
							    		System.out.println("\n\n\n\n\n\n\n");
		
					    			}
					                else {
					                	System.out.print("Try again or cancel the transaction (1-Try again 2-Cancel): ");
					                	option = getValidInt(1, 2, scan);
					                }
				    			}while(option == 1);
				    		}
				    		
				    		//display the transaction details and order details
				    		pay.paymentSucceed(selectedCinema, selectedSeats);
				    		
				    		//assignment for each customer category quantity to object salesReport
				    		SalesReport chosenCinema = new SalesReport();
				    		chosenCinema.addSaleData(selectedCinema.getBranchName(), selectedMovie.getMovieName(), amount);
				    		chosenCinema.addTicketData(adult, child, oku, senior);
				    		
				    		for(SalesReport sales: salesCinema) {
				    			if(sales.getCinemaName().equals(chosenCinema.getCinemaName())) {
				    				if(sales.getMovieName().equals(chosenCinema.getMovieName())) {
							    		sales.addTicketData(adult, child, oku, senior);
							    		sales.setTotalSale(amount);
				    				}
				    			}
				    				
				    		}
				    		
		                	
				    	}
					}
				} else
					break;
				
				System.out.print("Back to main menu? (1-Yes 2-No): ");
				loop = getValidInt(1,2,scan);
				
	    		System.out.println("\n\n\n");
			}while(loop == 1);
			
			System.out.print("Next customer? (1-Yes 2-No): ");
			next = getValidInt(1,2,scan);
		
	    }while(next == 1);	
		
	}
	
	public static int getValidInt(int min, int max, Scanner scan) {
	        int number;
	        while (true) {
	            try {
	                number = scan.nextInt();
	                if (number >= min && number <= max) {
	                    scan.nextLine();
	                    return number;
	                } else {
	                	if(min != max) {
	                		System.out.print("Invalid input. Please enter within the range ("+ min +"-" + max+"): ");
	                		scan.nextLine();
	                	} else if(min == max) {
	                		System.out.print("Invalid input. Please enter within the range ("+ min +"): ");
	                		scan.nextLine();
	                	}
	                }
	            } catch (InputMismatchException e) {
	                if(min != max) {
		            	System.out.print("Invalid input. Please enter an integer ("+min+"-"+max+"): ");
		                scan.nextLine();
	            	} else if(min == max) {
                		System.out.print("Invalid input. Please enter this integer ("+ min +"): ");
                		scan.nextLine();
                	}
	            }
	        }
	}

	

}

