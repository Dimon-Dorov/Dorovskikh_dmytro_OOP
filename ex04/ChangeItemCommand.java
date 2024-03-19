package ex04;
import ex01.Item2d;
/** Команда
* Change item;
* шаблон Command
* @author xone
* @version 1.0
*/
public class ChangeItemCommand implements Command {
    /** Обробляє об'єкт; шаблон Command */
    private Item2d item;
    /** Параметр команди; шаблон Command */
    private double offset;
    public Item2d setItem(Item2d item) {
        return this.item = item;
    }

    public Item2d getItem() {
        return item;
    }

    public double setOffset(double offset) {
        return this.offset = offset;
    }

    public double getOffset() {
        return offset;
    }
    @Override
    public void execute() {
        item.setP(item.getP() * offset);
        item.setS(item.getS() * offset);
        item.setV(item.getV() * offset);
    }
}