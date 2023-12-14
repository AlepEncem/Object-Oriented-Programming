package cinemaProject;

import java.util.Scanner;

import cinemaProject.Cinema.Hall;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class Admin {
	private String adminNo = "admin";
    private String adminPword = "Admin@010203";

    public String getAdminNo() {
    	return adminNo;
    }
    
    public String getAdminPword() {
    	return adminPword;
    }
    
    public static boolean isAdmin(String input_mobile, String input_pword) {
    	 Admin admin = new Admin();
    	if(input_mobile.equals(admin.getAdminNo()) && input_pword.equals(admin.adminPword))
    		return true;
	    return false;
    }
    
    public void updateCustomer(ArrayList<Customer> custlist, Scanner scan) {
    	System.out.print("Enter the customer name to update: ");
        String name = scan.nextLine();

        Customer customer = null;
        for (Customer c : custlist) {
            if (c.getfName().equalsIgnoreCase(name)) {
                customer = c;
                break;
            }
        }

        if (customer == null) {
            System.out.println("No customer found with name " + name);
            return;
        }

        System.out.print("Enter new name: ");
        String newName = scan.nextLine();
        customer.setfName(newName);

        System.out.print("Enter new mobile number: ");
        String newMobile = scan.nextLine();
        customer.setMobileNo(newMobile);

        System.out.print("Enter new email: ");
        String newEmail = scan.nextLine();
        customer.setEmail(newEmail);

        System.out.print("Enter new password: ");
        String newPassword = scan.nextLine();
        customer.setPassword(newPassword);

        System.out.println("Customer details updated successfully!");
}

    
    public void insertMovie(ArrayList<Cinema> cinema, ArrayList<Movie> movies, ArrayList<SalesReport> sales, Scanner scan) {
        
    	System.out.print("Enter the movie title: ");
        String titleMovie = scan.nextLine();
        
        System.out.print("Enter the movie genre: ");
        String genreMovie = scan.nextLine();
        
        System.out.print("Enter the movie duration: ");
        String durationMovie = scan.nextLine();
        
        System.out.print("Enter the movie language: ");
        String langMovie = scan.nextLine();
        
        System.out.print("Enter the movie classification: ");
        String classifMovie = scan.nextLine();
        
        System.out.print("Enter the number of showtime and showdate: ");
        int numberShowtime = Booking.getValidInt(1,20, scan);
        
        String[] showtime = new String[numberShowtime];
        String[] showdate = new String[numberShowtime];
        for(int i=0;i<numberShowtime;i++) {
	        System.out.print("Enter the movie showtime "+(i+1)+" (hh:mm (AM/PM)): ");
	        showtime[i] = scan.nextLine();
	        System.out.print("Enter the movie showdate "+(i+1)+" (dd month): ");
	        showdate[i] = scan.nextLine();
        }
        
        movies.add(new Movie(titleMovie,genreMovie,durationMovie,langMovie,classifMovie));
        
        System.out.print("Enter the branch name of the cinema that show this movie: ");
        String cinemaName = scan.nextLine();
        Cinema newCinema = new Cinema(cinemaName);
        newCinema.addMovie(new Movie(titleMovie,genreMovie,durationMovie,langMovie,classifMovie), showtime, showdate);
        cinema.add(newCinema);
        
        System.out.print("Enter the hall number that show this movie: ");
        int number = Booking.getValidInt(1,20, scan);
        
        System.out.print("Enter the number of row inside the hall "+number+" : ");
        int row = Booking.getValidInt(1,10, scan);
        
        System.out.print("Enter the number of column inside the hall "+number+" : ");
        int column = Booking.getValidInt(1,10, scan);
        
        System.out.print("Enter the name of the hall "+number+" : ");
        String hallName = scan.nextLine();
        Hall newHall = newCinema.new Hall(cinemaName, number, row, column, hallName);
        newHall.addMovie(newCinema.getMovie(titleMovie));
        newCinema.addHall(newHall);
        
        SalesReport newSales = new SalesReport();
        newSales.addSaleData(cinemaName, titleMovie, 0);
        sales.add(newSales);
    }
    
    public void updateMovie(ArrayList<Cinema> cinema, ArrayList<Movie> movies, Scanner scan) {
        System.out.print("Enter the title of the movie to update: ");
        String title = scan.nextLine();
        int movieIndex = -1;
        int cinemaIndex = -1;

        // search for the movie in the list of movies
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getMovieName().equalsIgnoreCase(title)) {
                movieIndex = i;
                break;
            }
        }

        // if the movie is not found, return
        if (movieIndex == -1) {
            System.out.println("Movie not found!");
            return;
        }

        // search for the cinema that shows the movie
        for(Cinema cinemas: cinema) {
	        for (Map.Entry<Movie, Map<String[], String[]>> entry : cinemas.getMovieAndShowtimes().entrySet()) {
				Movie movie = entry.getKey();
				if (movie.getMovieName().equals(movies.get(movieIndex).getMovieName())) {
					cinemaIndex = cinema.indexOf(cinemas);
		            break;
				}
	        }
        }
        

        // if the cinema is not found, return
        if (cinemaIndex == -1) {
            System.out.println("Cinema not found!");
            return;
        }

        System.out.print("Enter the updated movie genre: ");
        String genreMovie = scan.nextLine();
        movies.get(movieIndex).setMovieGenre(genreMovie);

        System.out.print("Enter the updated movie duration (hh mm): ");
        String durationMovie = scan.nextLine();
        movies.get(movieIndex).setDuration(durationMovie);

        System.out.print("Enter the updated movie language: ");
        String langMovie = scan.nextLine();
        movies.get(movieIndex).setLanguage(langMovie);

        System.out.print("Enter the updated movie classification: ");
        String classifMovie = scan.nextLine();
        movies.get(movieIndex).setClassif(classifMovie);

        // update the showtimes and showdates
        System.out.print("Enter the number of updated showtimes and showdates: ");
        int numberShowtime = Booking.getValidInt(1,20, scan);

        String[] showtime = new String[numberShowtime];
        String[] showdate = new String[numberShowtime];
        for (int i = 0; i < numberShowtime; i++) {
            System.out.print("Enter the updated movie showtime " + (i + 1) + " (hh:mm (AM/PM)): ");
            showtime[i] = scan.nextLine();
            System.out.print("Enter the updated movie showdate " + (i + 1) + " (dd mm): ");
            showdate[i] = scan.nextLine();
        }

        // update the movie details in the cinema
        cinema.get(cinemaIndex).addMovie(movies.get(movieIndex), showtime, showdate);
        
    }

        
    public void deleteMovie(ArrayList<Movie> movieList, Scanner scan) {
        System.out.print("Enter the movie name to delete: ");
        String name = scan.nextLine();
        
        for (Movie movie : movieList) {
          if (movie.getMovieName().equals(name)) {
        	  movieList.remove(movie);
        	  System.out.println("Movie deleted successfully.");
        	  break;
          } else {
        	System.out.println("There is no movie "+ name +" in the system.");  
          }
        }
      }
    
    public void updateCinema(ArrayList<Cinema> cinemaList, Scanner scan) {
        System.out.print("Enter the cinema name to update: ");
        String name = scan.nextLine();
        
        for (Cinema cinema : cinemaList) {
          if (cinema.getBranchName().equals(name)) {
            System.out.println("Updating details for " + cinema.getBranchName());
            System.out.print("Enter new name: ");
            cinema.setBranchName(scan.nextLine());
            System.out.println("Cinema details updated successfully.");
            break;
          } 
        }
      }
    
    public void showReportToday(ArrayList<SalesReport> sales) {
		System.out.println("\n\n");
		System.out.println("--------------------------------------------------------------------------------------------------------");
    	System.out.println("                                             Summary");
		System.out.println("--------------------------------------------------------------------------------------------------------\n");
        for (SalesReport sale : sales) {
            System.out.println("Cinema Name:                   " + sale.getCinemaName());
            System.out.println("Movie Name:                    " + sale.getMovieName());
            System.out.println("Total Sale (RM):               " + sale.getTotalSale());
            System.out.println("Quantity Adult:                " + sale.getQuantityAdult());
            System.out.println("Quantity Child:                " + sale.getQuantityChild());
            System.out.println("Quantity Oku:                  " + sale.getQuantityOku());
            System.out.println("Quantity Senior:               " + sale.getQuantitySenior());
            System.out.println("");
        }
        
        
        System.out.println("--------------------------------------------------------------------------------------------------------");
    	System.out.println("                                              Ranking");
		System.out.println("--------------------------------------------------------------------------------------------------------\n");
		sales.sort(new Comparator<SalesReport>() {
		    public int compare(SalesReport sr1, SalesReport sr2) {
		        return Integer.compare(sr2.getTotalTicket(), sr1.getTotalTicket());
		    }
		});

		for (SalesReport sale : sales) {
		    System.out.println("Movie Name:                    " + sale.getMovieName());
		    System.out.println("Total Ticket Sold:             " + sale.getTotalTicket());
		    System.out.println("");
		}
    }

    
    
}
