package ex01;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import junit.framework.Assert;
import java.io.IOException;
import ex01.Calc;
/** Виконує тестування розроблених класів.
* @author xone
* @version 1.0
*/
public class MainTest {
    /** Перевірка основної функціональності класу {@linkplain Calc} */
    @Test
    public void testCalc() {
        Calc calc = new Calc();
        calc.init(0.0, 0.0, 0.0);
        assertEquals(0.0, calc.getResult().getP(), .1e-10);
        calc.init(1.0, 1.0, 1.0);
        assertEquals(12.0, calc.getResult().getP(), .1e-10);
        calc.init(2.0, 2.0, 2.0);
        assertEquals(18.0, calc.getResult().getP(), .1e-10);
        calc.init(3.0, 3.0, 3.0);
        assertEquals(36.0, calc.getResult().getP(), .1e-10);
        calc.init(4.0, 4.0, 4.0);
        assertEquals(48.0, calc.getResult().getP(), .1e-10);
    }
    /** Перевірка серіалізації. Коректність відновлення даних. */
    @Test
    public void testRestore() {
        Calc calc = new Calc();
        double leng, widt, heig, p, s, v;
        for(int ctr = 0; ctr < 1000; ctr++) {
            leng = Math.random() * 100.0;
            widt = Math.random() * 100.0;
            heig = Math.random() * 100.0;
            p = calc.init(leng, widt, heig);
            try {
                calc.save();
            } catch (IOException e) {
                Assert.fail(e.getMessage());
            }
            calc.init(Math.random() * 100, Math.random() * 100,Math.random() * 100);
            try {
                calc.restore();
            } catch (Exception e) {
                Assert.fail(e.getMessage());
            }
            assertEquals(leng, calc.getResult().getL(), .1e-10);
            assertEquals(widt, calc.getResult().getW(), .1e-10);
            assertEquals(heig, calc.getResult().getH(), .1e-10);
            assertEquals(p, calc.getResult().getP(), .1e-10);
            assertEquals(p, calc.getResult().getS(), .1e-10);
            assertEquals(p, calc.getResult().getV(), .1e-10);
        }
    }
}