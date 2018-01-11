import java.text.DecimalFormat;

public class Bolt implements Part{

    public static double LBS_MULTIPLIER = .05;
    public static double USD_MULTIPLIER = 1;

    private double diameterInches;
    private double lengthInches;

    public Bolt(double diameterInches, double lengthInches) {
        this.diameterInches = diameterInches;
        this.lengthInches = lengthInches;
    }
    public double getCost() {
        return USD_MULTIPLIER*diameterInches*lengthInches;
    }
    public String getName() {
        return diameterInches + "x" + lengthInches + " bolt";
    }
    public double getWeight() {
        return LBS_MULTIPLIER*diameterInches*diameterInches*lengthInches;
    }
    public void printBillOfMaterials() {
        DecimalFormat costFormat = new DecimalFormat("$0.00");
        DecimalFormat weightFormat = new DecimalFormat("0.0 lbs");
        System.out.println(
                "==========================\n" +
                this.getName() + "\n" +
                "==========================\n" +
                "Diameter: " + diameterInches +" inches\n"+
                "Length: " + lengthInches + " inches\n" +
                "Cost: " + costFormat.format(getCost()) + "\n" +
                "Weight: " + weightFormat.format(getWeight()));
    }
}
