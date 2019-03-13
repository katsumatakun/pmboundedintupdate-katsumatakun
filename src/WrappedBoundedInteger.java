public class WrappedBoundedInteger extends BoundedInteger {


/*
    A WrappedBoundedInteger is similar to the BoundedInteger.
    However, instead of generating exceptions for illegal values,
    this class "wraps around".

    For example, suppose that we have a WrappedBoundedInteger "minutes"
    with bounds of 0 to 59 and whose value is 52.
    Adding 10 to this object gives it a value of 2.
 */



    public WrappedBoundedInteger(int value, int lower, int upper) {
        super(value, lower, upper);
    }

    @Override
    public void setValue(int num){
        while (num > upper){
            num = num - upper + lower -1;
        }
        while (num < lower){
            num = upper - (lower - num) + 1;
        }

        value = num;
    }


}
