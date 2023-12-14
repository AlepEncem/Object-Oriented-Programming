package cinemaProject;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Cinema {
    private String branchName;
    private Map<Movie, Map<String[], String[]>> showtime;
    private ArrayList<Hall> hall;
    private Pricing price;
    
    public Cinema(String branchName) {
        this.branchName = branchName;
        this.showtime = new HashMap<>();
        this.hall = new ArrayList<>();
    }

    public void addMovie(Movie movie, String[] showtime, String[] showDate) {
    	if (showtime.length != showDate.length) {
            System.out.println("The number of showtime and date should be the same");
            return;
        }
    	
    	Map<String[], String[]> movieShowtimes = new HashMap<>();
        movieShowtimes.put(showtime, showDate);

        this.showtime.put(movie, movieShowtimes);
    }
    
    public Movie getMovie(String movieTitle) {
		for(Map.Entry<Movie, Map<String[],String[]>> entry : showtime.entrySet()) {
			Movie movie = entry.getKey();
			if (movie.getMovieName().equals(movieTitle)) {
	            return movie;
	        }
		}
		return null;
	}
    
    public String getBranchName() {
        return branchName;
    }
    
	public Map<Movie, Map<String[], String[]>> getMovieAndShowtimes() {
	    return showtime;
	}

	public void setBranchName(String name) {
		this.branchName = name;
	}
	
	public void addHall(Hall halls) {
	    this.hall.add(halls);
	  }
	
	public Hall getHall(Movie movie) {
		for(Map.Entry<Movie, Map<String[],String[]>> entry : showtime.entrySet()) {
			Movie movies = entry.getKey();
			if(movies.getMovieName().equals(movie.getMovieName())) {
				for (Hall halls : hall) {
					if (halls.getMovie().getMovieName().equals(movie.getMovieName())) {
						return halls;
					}
			    }
			}
		}
		return null;
	}
	
	public static void setSeatInCinemaArray(ArrayList<Cinema> cinema, String movieTitle, int rows, int columns, int value) {
		for(Cinema cinemalist: cinema) {
			Movie movie = cinemalist.getMovie(movieTitle);
			if (movie != null && movie.getMovieName().equals(movieTitle)) {
				cinemalist.getHall(movie).setSeat(rows, columns, value);
			}
		}

	}
	
	public void setPrice(Pricing price) {
		this.price = price;
	}
	
	public Pricing getPrice() {
		return price;
	}
	
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    for(Map.Entry<Movie, Map<String[],String[]>> entry : showtime.entrySet()) {
	        Map<String[], String[]> show = entry.getValue();
	        Movie movie = entry.getKey();
	        
	        for (Map.Entry<String[], String[]> entryShow : show.entrySet()) {
	            String[] movieShowtimes = entryShow.getKey();
	            String[] movieDate = entryShow.getValue();
	            String time = movieShowtimes[1], date = movieDate[1];
	            result.append("\nCinema: ").append(branchName);
	            result.append("\nMovie Title: ").append(movie.getMovieName());
	            result.append("\nShowtime and date: ").append(time).append(" ").append(date).append("\n");
	            for(Hall halls: hall) {
	                result.append("Hall: ").append(halls.getNumber()).append("  - ").append(halls.getName());
	            }
	        }
	    }
	    return result.toString();
	}


	class Hall extends Cinema {
		  private int number;
		  private String name;
		  private int[][] seats;
		  private Movie movie;
		  
		  public Hall(String branchName, int number, int rows, int columns, String name) {
			  super(branchName);
			  this.number = number;
			  this.name = name;
			  this.seats = new int[rows][columns];
		  }
		  
		  public int getNumber() {
			  return this.number;
		  }
		  
		  public String getName() {
			  return this.name;
		  }
		  
		  public Movie getMovie() {
			  return this.movie;
		  }
		  
		  public int[][] getSeatRow(){
			  return this.seats;
		  }
		  
		  public int[] getSeatColumn(){
			  int[] column = this.seats[0];
			  return column;
		  }
		  
		  public int getSeat(int row, int column) {
			  return this.seats[row][column];
		  }
		  
		  public void setNumber(int number) {
			  this.number = number;
		  }
		  
		  public void setName(String name) {
			  this.name = name;
		  }
		  
		  public void setMovie(Movie movie) {
			  this.movie = movie;
		  }
		  
		  public void addMovie(Movie movie) {
		        this.movie = movie;
		  }

		  public void displaySeats() {
						
			  System.out.print("  ");
			  for (int i = 0; i < seats.length; i++) {
				  System.out.print(i + "  ");
			  }
			  System.out.println();
			
			  for (int i = 0; i < seats[0].length; i++) {
				  System.out.print((char)('A' + i) + " ");
				  for (int j = 0; j < seats.length; j++) {
					  if (seats[i][j] == 1) {
						  System.out.print("X  ");
				      } else {
				    	  System.out.print((char)('A' + i) + "" + j + " ");
					  }
				  }
				  System.out.println();
			  }
		  }
		  
		  public void setSeat(int row, int column, int value) {
				if (row >= 0 && row < seats.length && column >= 0 && column < seats[0].length) {
				    seats[row][column] = value;
				} else {
				    System.out.println("Invalid seat. Please enter available seats only.");
				}
		  }
		  
		  public static void displaySelectedSeat(ArrayList<String> selectedSeats) {
			  System.out.print("\nSeat(s): ");
			  for(int i = 0; i < selectedSeats.size(); i++) {
			    System.out.print(selectedSeats.get(i) + " ");
			  }
			}

		}

}


