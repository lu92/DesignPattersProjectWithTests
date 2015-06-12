package unitTests;

import DesignPatternsProject.strategies.discounts.Rebate;
import org.junit.Test;

/**
 * Created by lucjan on 12.06.15.
 */
public class MultipleConditionOfTheRebateClassContructor {

//    testowanie wielokrotnych warunkow logicznych instrukcji if ... else ...
//    dla konstruktora klasy Rebate


//      tak wyglada konstruktor klasy Rebate

//    public Rebate(long amount, double percent) throws IllegalArgumentException{
//        if (amount >= 0 && percent >= 0 && percent <= 100) {
//            this.amount = amount;
//            this.percent = percent;
//        } else
//            throw new IllegalArgumentException("amount or percent can't be negative number");
//    }


    @Test(expected = IllegalArgumentException.class)
    public void PT1() {
        Rebate rebate = new Rebate(-1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void PT2() {
        Rebate rebate = new Rebate(-1, 0);
    }

    @Test
    public void PT3() {
        Rebate rebate = new Rebate(1, 0);
    }

    @Test
    public void PT4() {
        Rebate rebate = new Rebate(1, 100);
    }
    
}
