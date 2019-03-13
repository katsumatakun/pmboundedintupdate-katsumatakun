public class BoundedInteger {

	/*

	Implements the functionality of a whole number (an integer)
	with a limited by the upper and lower bound;
	Attempts to illegally assign a value to a number should generate
	an OutOfBoundsException.


	BoundedInteger(int value, int lower, int upper)
	void setValue(int)
	int getValue()
	String toString()   // Should display the Value of the Bounded Integer
	void addWith(int)
		// Note this should update the value of the BoundedInteger by adding the input parameter to the current value
	 */

	protected int value;
	protected int lower;
	protected int upper;

	public BoundedInteger(int value, int lower, int upper){

	    this.lower = lower;
	    this.upper = upper;
		setValue(value);
    }

    public void setValue(int value){
		if (value > upper || value < lower ){
			throw new OutOfBoundsException(" Value Out of Bounds");
		}
	    this.value = value;
    }

    public int getValue(){
	    return value;
    }


	public String toString(){
		return Integer.toString(value);
	}

    public void addWith(int num){

	    setValue(value + num);

    }





}
