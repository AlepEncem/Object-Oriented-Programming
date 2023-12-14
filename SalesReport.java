package cinemaProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SalesReport {
//    private Map<Movie, Map<String[], Double>> salesData;
	private String cinemaName;
	private String movieName;
	private double totalSale;
    private int quantityChild;
    private int quantityAdult;
    private int quantityOku;
    private int quantitySenior;
    
    public SalesReport() {
    	this.quantityChild = 0;
        this.quantityAdult = 0;
        this.quantityOku = 0;
        this.quantitySenior = 0;
    }
    
    public void addSaleData(String cinemaName, String movieName, double totalAmount) {
        this.cinemaName = cinemaName;
        this.movieName = movieName;
    	this.totalSale = totalAmount;
    }
    
    public void addTicketData(int qttAdult, int qttChild, int qttOku, int qttSenior) {
    	this.quantityAdult += qttAdult;
    	this.quantityChild += qttChild;
    	this.quantityOku += qttOku;
    	this.quantitySenior += qttSenior;
    }
    
    public double getTotalSale() {
        return totalSale;
    }

    public int getQuantityChild() {
        return quantityChild;
    }

    public int getQuantityAdult() {
        return quantityAdult;
    }

    public int getQuantityOku() {
        return quantityOku;
    }

    public int getQuantitySenior() {
        return quantitySenior;
    }
    
    public int getTotalTicket() {
    	return quantityAdult+quantityChild+quantityOku+quantitySenior;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale += totalSale;
    }

    public void setQuantityChild(int quantityChild) {
        this.quantityChild = quantityChild;
    }

    public void setQuantityAdult(int quantityAdult) {
        this.quantityAdult = quantityAdult;
    }

    public void setQuantityOku(int quantityOku) {
        this.quantityOku = quantityOku;
    }

    public void setQuantitySenior(int quantitySenior) {
        this.quantitySenior = quantitySenior;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

}

