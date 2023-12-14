package cinemaProject;
import java.util.ArrayList;

public class Movie {
	private String movieName, movieGenre, duration, language, classification;
	
	Movie(String title, String genre, String timeDuration, String movieLang, String classif){
		this.movieName = title;
		this.movieGenre = genre;
		this.duration = timeDuration;
		this.language = movieLang;
		this.classification = classif;
	}
	
	public static Movie getMovie(ArrayList<Movie> movie, int index) {
		if(index < movie.size() && index >= 0){
	        return movie.get(index);
	    }
	    return null;
	}
	
	public String getMovieName() {
        return movieName;
    }
	
    public String getMovieGenre() {
        return movieGenre;
    }
    
    public String getDuration() {
        return duration;
    }
    
    public String getLanguage() {
        return language;
    }
    
    public String getClassif() {
        return classification;
    }
    
    public void setMovieName(String name) {
        this.movieName = name;
    }
	
    public void setMovieGenre(String genre) {
        this.movieGenre = genre;
    }
    
    public void setDuration(String time) {
    	this.duration = time;
    }
    
    public void setLanguage(String lang) {
        this.language = lang;
    }
    
    public void setClassif(String classif) {
        this.classification = classif;
    }
    
    @Override
    public String toString() {
    	return movieName+"\n"+movieGenre+" | "+duration+" | "+language+" | "+classification;
    }
	
	public static void displayMovie(ArrayList<Movie> movie) {
	    System.out.println("--------------------------------------------- Now Showing ---------------------------------------------");
	    System.out.printf("%-5s%-48s%-12s%-13s%-10s%-5s\n", "No", "Name", "Genre", "Duration", "Language", "Classification");
	    int i = 0;
	    for(Movie list: movie) {
	        System.out.printf("%-5s%-48s%-12s%-16s%-10s%-5s\n", "["+(i+1)+"]", list.movieName, list.movieGenre, list.duration, list.language, list.classification);
	        i++;
	    }
	    System.out.print("Enter any movie number: ");
	}

}

