public class WrappedBoundedInteger{

    private int value;
    private int lower;
    private int upper;
    public WrappedBoundedInteger(int value, int lower, int upper) {

        while (value > upper) {
            value = (value - upper) + lower - 1;
        }
        while (value < lower) {
            value = upper - (lower - value) + 1;
        }
        this.value = value;
        this.lower = lower;
        this.upper = upper;

    }

    public void setValue(int num){
        while (num > upper){
            num = num - upper + lower -1;
        }
        while (num < lower){
            num = upper - (lower - num) + 1;
        }

        value = num;
    }

    public int getValue(){
        return value;
    }

    public void addWith(int num){
        value += num;
        while(value > upper){
            value = (value) - upper + lower -1;
        }

        while (value < lower){
            value = upper - (lower - value + num) +1;
        }

    }


/*
A WrappedBoundedInteger is similar to the BoundedInteger.
However, instead of generating exceptions for illegal values,
this class "wraps around".

For example, suppose that we have a WrappedBoundedInteger "minutes"
with bounds of 0 to 59 and whose value is 52.
Adding 10 to this object gives it a value of 2.
 */

}
