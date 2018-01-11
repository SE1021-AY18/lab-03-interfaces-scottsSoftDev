import java.text.DecimalFormat;

public class Nut implements Part{

    public static double LBS_MULTIPLIER = .01;
    public static double USD_MULTIPLIER = .5;

    private double diameterInches;

    public Nut(double diameterInches) {
        this.diameterInches = diameterInches;
    }
    public double getCost() {
        return USD_MULTIPLIER*diameterInches;
    }
    public String getName() {
        return diameterInches + " inch nut";
    }
    public double getWeight() {
        return LBS_MULTIPLIER*(20 + LBS_MULTIPLIER)*
                diameterInches*diameterInches*diameterInches;
    }
    public void printBillOfMaterials() {
        DecimalFormat costFormat = new DecimalFormat("$0.00");
        DecimalFormat weightFormat = new DecimalFormat("0.0 lbs");
        System.out.println(
                "==========================\n" +
                this.getName() + "\n" +
                "==========================\n" +
                "Diameter: " + diameterInches +" inches\n"+
                "Cost: " + costFormat.format(getCost()) + "\n" +
                "Weight: " + weightFormat.format(getWeight()));
    }
}
