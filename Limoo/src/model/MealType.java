package model;

/**
 * Created by Erfan on 7/8/2014.
 */
public enum MealType
{
    // sobhaneh
    BREAKFAST("صبحانه"),
    // nahar
    LUNCH("نهار"),
    // shaam
    DINNER("شام"),
    // asraneh
    AFTERNOON("عصرانه"),
    UNKNOWN("هله هوله!");
    
    private String value;
    
    MealType( String string) {
		this.value = string;
	}
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return this.value;
    }
}
