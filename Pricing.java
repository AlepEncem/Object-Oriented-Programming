package cinemaProject;

public class Pricing {
	private double childPrice;
    private double adultPrice;
    private double seniorPrice;
    private double okuPrice;
    
    public Pricing(double adultPrice, double childPrice, double seniorPrice, double okuPrice) {
        this.childPrice = childPrice;
        this.adultPrice = adultPrice;
        this.seniorPrice = seniorPrice;
        this.okuPrice = okuPrice;
    }
    
    public double getChildPrice() {
        return childPrice;
    }
    
    public double getAdultPrice() {
        return adultPrice;
    }
    
    public double getSeniorPrice() {
        return seniorPrice;
    }
    
    public double getOkuPrice() {
        return okuPrice;
    }
}
