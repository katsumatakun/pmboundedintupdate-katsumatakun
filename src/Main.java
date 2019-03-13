

public class Main {

    public static void main(String[] args) {

        // Your code must work
        // (i.e. not print false) with the following test cases
        // uncomment to test


        BoundedInteger b;
        ////////////////////////////////////////////////////////////
        //Initialize
        b = new BoundedInteger(5, 1, 10);
        System.out.println("Passed Initialize: " + (b.getValue() == 5));

        try {
            b = new BoundedInteger(150, 1, 10);
            System.out.println("Passed Bad Initialize (Too High): " + false);
        } catch (OutOfBoundsException e) {
            System.out.println("Passed Bad Initialize (Too High): " + true);
        }

        try {
            b = new BoundedInteger(-5, 1, 10);
            System.out.println("Passed Bad Initialize (Too Low): " + false);
        } catch (OutOfBoundsException e) {
            System.out.println("Passed Bad Initialize (Too Low: " + true);
        }

        ////////////////////////////////////////////////////////////
        //setValue
        b = new BoundedInteger(5, 1, 10);
        b.setValue(3);
        System.out.println("Passed setValue: " + (b.getValue() == 3));

        try {
            b = new BoundedInteger(5, 1, 10);
            b.setValue(150);
            System.out.println("Passed Bad Set (High): " + false);
        } catch (OutOfBoundsException e) {
            System.out.println("Passed Bad Set (High): " + true);
        }

        try {
            b = new BoundedInteger(5, 1, 10);
            b.setValue(-10);
            System.out.println("Passed Bad Set (Low): " + false);
        } catch (OutOfBoundsException e) {
            System.out.println("Passed Bad Set (Low): " + true);
        }
        ////////////////////////////////////////////////////////////
        //addWidth
        b = new BoundedInteger(5, 1, 10);
        b.addWith(2);
        System.out.println("Passed addWith(+): " + (b.getValue() == 7));
        b = new BoundedInteger(5, 1, 10);
        b.addWith(-2);
        System.out.println("Passed addWith(-): " + (b.getValue() == 3));

        try {
            b = new BoundedInteger(5, 1, 10);
            b.addWith(100);
            System.out.println("Passed Bad Add (High): " + false);
        } catch (OutOfBoundsException e) {
            System.out.println("Passed Bad Add (High): " + true);
        }

        try {
            b = new BoundedInteger(5, 1, 10);
            b.addWith(-10);
            System.out.println("Passed Bad Add (Low): " + false);
        } catch (OutOfBoundsException e) {
            System.out.println("Passed Bad Add (Low): " + true);
        }


        //Add the appropriate test cases for WrappedBoundedInteger.
        // Do not feel (too) bad about using copy-paste.
        // Caution:  Do not get too complacent.

        System.out.println("=================================================");

        WrappedBoundedInteger w;
        //formula for wrapping: <actual value> = <wrapped value> + <interval> * <integer>
        //                    : (<actual value> - <wrapped value>) % <interval> should be 0
        //                    : interval = (upper - lower + 1)
        ////////////////////////////////////////////////////////////
        //Initialize
        w = new WrappedBoundedInteger(5, 1, 10);
        System.out.println("Passed Initialize: " + checkWrapped(1, 10, 5, w.getValue()));


        //Interval from negative to positive
        w = new WrappedBoundedInteger(150, -100, 50);
        System.out.println("Passed Bad Initialize (Too High): " + checkWrapped(50, -100, 150, w.getValue()));


        //Interval from negative to negative
        w = new WrappedBoundedInteger(-284, -100, -42);
        System.out.println("Passed Bad Initialize (Too Low): " + checkWrapped(-42, -100, -284, w.getValue()));

        //Interval accepts ony one integer
        w = new WrappedBoundedInteger(0, 0, 0);
        System.out.println("Passed Bad Initialize (One Possible Value): " + checkWrapped(0, 0, 0, w.getValue()));


        ////////////////////////////////////////////////////////////
        //setValue
        w = new WrappedBoundedInteger(-10, 1, 10);
        w.setValue(3);
        System.out.println("Passed setValue: " + checkWrapped(10, -10, 3, w.getValue()));


        w = new WrappedBoundedInteger(5, -8, 0);
        w.setValue(23);
        System.out.println("Passed Bad Set (High): " + checkWrapped(0, -8, 23, w.getValue()));


        w = new WrappedBoundedInteger(5, -10, -6);
        w.setValue(-15);
        System.out.println("Passed Bad Set (Low): " + checkWrapped(-6, -10, -15, w.getValue()));

        ////////////////////////////////////////////////////////////
        //addWidth
        w = new WrappedBoundedInteger(5, -1, 10);
        w.addWith(2);
        System.out.println("Passed addWith(+): " + checkWrapped(10, -1, 5 + 2, w.getValue()));
        w = new WrappedBoundedInteger(5, 1, 10);
        w.addWith(-2);
        System.out.println("Passed addWith(-): " + checkWrapped(10, 1, 5 - 2, w.getValue()));


        w = new WrappedBoundedInteger(5, 1, 10);
        w.addWith(100);
        System.out.println("Passed Bad Add (High): " + checkWrapped(10, 1, 100 + 5, w.getValue()));


        w = new WrappedBoundedInteger(5, 1, 10);
        w.addWith(-100);
        System.out.println("Passed Bad Add (Low): " + checkWrapped(10, 1, 5 - 100, w.getValue()));

        w = new WrappedBoundedInteger(100, -200, -100);
        //System.out.println(w);
        int value = w.getValue();
        w.addWith(1000);
        System.out.println("Passed Create Bad Input and then Add Bad Value: " + checkWrapped(-100, -200, value + 1000, w.getValue()));


    }



    private static boolean checkWrapped(int upper, int lower, int actual, int wrapped){

        return (actual-wrapped) % (upper-lower+1) == 0;


    }
}