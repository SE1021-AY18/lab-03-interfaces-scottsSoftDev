import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Assembly implements Part{
    private DecimalFormat costFormat = new DecimalFormat("$0.00"); //read-only
    private DecimalFormat weightFormat = new DecimalFormat("0.0 lbs"); //read-only
    private String name;
    private List<Part> subParts = new ArrayList<>();

    public static final double USD_PER_SUB_PART = .25; //read only


    public Assembly(String name) {
        this.name = name;
    }
    public void addPart(Part part) {
        subParts.add(part);
    }
    public double getCost() {
        double cost = 0;
        for(int i = 0; i < subParts.size(); i++)
        {
            cost += subParts.get(i).getCost() ;
        }
        if(subParts.size() > 1)
        {
            cost += USD_PER_SUB_PART * (subParts.size() - 1);
        }
        return cost;
    }
    public String getName() {
        return name;
    }
    public double getWeight() {
        double weight = 0;
        for(int i = 0; i < subParts.size(); i++)
        {
            weight += subParts.get(i).getWeight() ;
        }
        return weight;
    }
    public void printBillOfMaterials() {
        System.out.println(
                "==========================\n" +
                this.getName() + "\n" +
                "==========================");
        for(int i = 0; i < subParts.size(); i++)
        {
            System.out.println(
                    "Part: " + subParts.get(i).getName()+ "\n" +
                    "Cost: " + costFormat.format(subParts.get(i).getCost())+ "\n" +
                    "Weight: " + weightFormat.format(subParts.get(i).getWeight()));
        }
        System.out.println("Total Cost: " + costFormat.format(this.getCost()) + "\n" +
                           "Total Weight: " + weightFormat.format(this.getWeight()));
        for(int i = 0; i < subParts.size(); i++)
        {
            subParts.get(i).printBillOfMaterials();
        }

    }

}
