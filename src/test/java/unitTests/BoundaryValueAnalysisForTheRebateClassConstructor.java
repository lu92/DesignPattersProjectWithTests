package unitTests;

/**
 * Created by lucjan on 12.06.15.
 */
public class BoundaryValueAnalysisForTheRebateClassConstructor {

    private static final long MINLONG = Long.MAX_VALUE * -1;
    private static final long MAXLONG = Long.MAX_VALUE;

    private static final double MINDOUBLE = Double.MAX_VALUE * -1;
    private static final double MAXDOUBLE = Double.MAX_VALUE;

    private static double epsilon = 0.000001;

//    testowanie wartosci granicznych dla konstruktora klasy Rebate


//      tak wyglada konstruktor klasy Rebate

//    public Rebate(long amount, double percent) throws IllegalArgumentException{
//        if (amount >= 0 && percent >= 0 && percent <= 100) {
//            this.amount = amount;
//            this.percent = percent;
//        } else
//            throw new IllegalArgumentException("amount or percent can't be negative number");
//    }




}
