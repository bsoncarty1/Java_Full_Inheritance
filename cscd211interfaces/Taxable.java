//Brandon Soncarty

package lab9.cscd211interfaces;

public interface Taxable {

    //static base tax rate
    static final double BASE_TAX_RATE = 0.09;

    //abstract method
    abstract double calculateTaxes();
}
