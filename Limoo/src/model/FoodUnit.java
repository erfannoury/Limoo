package model;

/**
 * Created by Erfan on 7/8/2014.
 */
public class FoodUnit
{
    private double energy;
    private String unitName;
    private double multiplier;

    /*
     Constructor for FoodUnit
     */
    public FoodUnit(String name, double energy, double multiplier)
    {
        this.unitName = name;
        this.energy = energy;
        this.multiplier = 0 < multiplier? multiplier : 0.0;
    }

    /*
     Constructor for base units
     */
    public FoodUnit(String name, double energy)
    {
        this(name, energy, 1.0);
    }

    /*
     * Get energy in kCal
     */
    public double getEnergy()
    {
        return this.energy;
    }

    public String getUnitName()
    {
        return this.unitName;
    }

    public double getMultiplier()
    {
        return this.multiplier;
    }


    /*
     amount entered is assumed to be in this unit
     */
    public double totalEnergy(double amount)
    {
        return this.energy * amount;
    }

    /*
     amount entered is assumed to be in this unit
     */
    public double getAmountInAnotherUnit(double amount, FoodUnit unit)
    {
        return amount/this.multiplier*unit.getMultiplier();
    }

}
