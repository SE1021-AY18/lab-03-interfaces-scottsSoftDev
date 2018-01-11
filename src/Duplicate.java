import java.text.DecimalFormat;

public class Duplicate implements Part{

    public static int USD_THRESHOLD1 = 5;
    public static int USD_THRESHOLD2 = 10;
    public static double REDUCTION_FACTOR1 = .95;
    public static double REDUCTION_FACTOR2 = .9;

    private DecimalFormat costFormat = new DecimalFormat("$0.00");
    private DecimalFormat weightFormat = new DecimalFormat("0.0 lbs");
    private Part identicalPart;
    private int numDuplicates;

    public Duplicate(Part part, int numDuplicates)
    {
        identicalPart = part;
        this.numDuplicates = numDuplicates;
    }
    public double getCost() {
        double cost = 0;
        if(numDuplicates < USD_THRESHOLD1)
        {
            cost = identicalPart.getCost() * numDuplicates;
        }
        else if(numDuplicates < USD_THRESHOLD2)
        {
            cost = REDUCTION_FACTOR1*identicalPart.getCost() * numDuplicates;
        }
        else
        {
            cost = REDUCTION_FACTOR2*identicalPart.getCost() * numDuplicates;
        }
        return cost;
    }
    public String getName() {
        return numDuplicates +  " " + identicalPart.getName() + "s";
    }
    public double getWeight() {
        return numDuplicates + identicalPart.getWeight();
    }
    public void printBillOfMaterials() {
        System.out.println(
                "==========================\n" +
                this.getName() + "\n" +
                "==========================\n" +
                "Duplicate Part: "+ identicalPart.getName()+ "\n" +
                "Copies: " + numDuplicates +"\n" +
                "Individual cost: " + costFormat.format(identicalPart.getCost())+"\n" +
                "Individual weight: " + weightFormat.format(identicalPart.getWeight())+ "\n\n" +
                "Total cost: " + costFormat.format(this.getCost()) + "\n" +
                "Total weight: "+ weightFormat.format(this.getWeight())+ "\n");
        identicalPart.printBillOfMaterials();
    }

}
