public class SecurityCompany {
    //we declare the values for our class, being the cost that the company implies and the name of the company
    public double charge;
    public String name;
    
    //we need the constructor for the object security company
    public SecurityCompany(String name, double charge){
        this.name = name;
        this.charge = charge;
    }
    //setter of charge
    public void setCharge(double charge){
        this.charge = charge;
    }
    //getter of chargew
    public double getCharge() {
        return charge;
    }
    //setter of name
    public void setName(String name) {
        this.name = name;
    }
    //getter of name
    public String getName() {
        return name;
    }
    //the method toString to put every value as a string for printing later
    public String toString(){
        return "charge: " + charge + " name: " + name;
    }
    //we do not put here the method calculateCharge because it is in the main (the class festival)
    
}
