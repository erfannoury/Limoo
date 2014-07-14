package model;

/**
 * Created by Erfan on 7/8/2014.
 */
public enum ActivityType {
    LIGHT("سبک"),
    NORMAL("متوسط"),
    HEAVY("سنگین"),
    UNKNOWN("نامشخص");
    
    private String value;
    
    private ActivityType(String s) {
		this.value = s;
	}
    
    @Override
    public String toString() {
    	return this.value;
    }
}
