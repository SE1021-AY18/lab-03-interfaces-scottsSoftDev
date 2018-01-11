import java.text.DecimalFormat;

public class SheetMetal implements Part{
    public static double LBS_MULTIPLIER = .1;
    public static double USD_MULTIPLIER =.5;

    private double widthInches;
    private double lengthInches;
    private double thicknessInches;

    public SheetMetal(double lengthInches, double widthInches,
                      double thicknessInches) {
        this.lengthInches = lengthInches;
        this.widthInches = widthInches;
        this.thicknessInches = thicknessInches;
    }
    public double getCost() {
        return USD_MULTIPLIER*thicknessInches*widthInches*lengthInches;
    }
    public String getName() {
        return lengthInches+"x"+widthInches+"x"+thicknessInches+" sheet";
    }
    public double getWeight() {
        return LBS_MULTIPLIER*thicknessInches*widthInches*lengthInches;
    }
    public void printBillOfMaterials() {
        DecimalFormat costFormat = new DecimalFormat("$0.00");
        DecimalFormat weightFormat = new DecimalFormat("0.0 lbs");
        System.out.println(
                "==========================\n" +
                this.getName() + "\n" +
                "==========================\n" +
                "Length: " + lengthInches + " inches\n"+
                "Width: " + widthInches  + " inches\n"+
                "Thickness: " + thicknessInches + " inches\n" +
                "Cost: " + costFormat.format(getCost()) + "\n" +
                "Weight: " + weightFormat.format(getWeight()));
    }

}
