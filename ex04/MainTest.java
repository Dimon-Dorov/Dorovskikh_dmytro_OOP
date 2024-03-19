package ex04;
import static org.junit.Assert.*;
import org.junit.Test;
import ex01.Item2d;
import ex02.ViewResult;
/** Тестування класу ChangeItemCommand
* @author xone
* @version 4.0
* @see ChangeItemCommand
*/
public class MainTest {
    /** Перевірка методу {@linkplain ChangeItemCommand#execute()} */
    @Test
    public void testExecute() {
        ChangeItemCommand cmd = new ChangeItemCommand();
        cmd.setItem(new Item2d());
        double leng, widt, heig, p, s, v, offset;
        for (int ctr = 0; ctr < 1000; ctr++) {
            cmd.getItem().setLHWPSV(leng = Math.random() * 100.0, widt = Math.random() * 100.0, 
            heig = Math.random() * 100.0, p = Math.random() * 100.0, s = Math.random() * 100.0, v = Math.random() * 100.0,);
            cmd.setOffset(offset = Math.random() * 100.0);
            cmd.execute();
            assertEquals(leng, cmd.getItem().getL(), .1e-10);
            assertEquals(widt, cmd.getItem().getW(), .1e-10);
            assertEquals(heig, cmd.getItem().getH(), .1e-10);
            assertEquals(p * offset, cmd.getItem().getP(), .1e-10);
            assertEquals(s * offset, cmd.getItem().getS(), .1e-10);
            assertEquals(v * offset, cmd.getItem().getV(), .1e-10);
        }
    }
    /** Перевірка класу {@linkplain ChangeConsoleCommand} */
    @Test
    public void testChangeConsoleCommand() {
        ChangeConsoleCommand cmd = new ChangeConsoleCommand(new ViewResult());
        cmd.getView().viewInit();
        cmd.execute();
        assertEquals("'c'hange", cmd.toString());
        assertEquals('c', cmd.getKey());
    }
}