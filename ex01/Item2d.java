package ex01;
import java.io.Serializable;
/** Хранит исходные данные и результат вычислений.
* @author xone
* @version 1.0
*/
public class Item2d implements Serializable {
/** Аргумент вычисляемой функции. */
// transient
private double leng;
private double widt;
private double heig;
/** Результат вычисления функции. */
private double p;
private double s;
private double v;
/** Автоматически сгенерированная константа */
private static final long serialVersionUID = 1L;
/** Инициализирует поля {@linkplain Item2d#x}, {@linkplain Item2d#y} */
public Item2d() {
leng = .0;
widt = .0;
heig = .0;
p = .0;
s = .0;
v = .0;
}
/** Устанавливает значения полей: аргумента
* и результата вычисления функции.
* @param x - значение для инициализации поля {@linkplain Item2d#x}
* @param y - значение для инициализации поля {@linkplain Item2d#y}
*/
public Item2d(double leng, double widt, double heig, double p, double s, double v) {
this.leng = leng;
this.widt = widt;
this.heig = heig;
this.p = p;
this.s = s;
this.v = v;
}
/** Установка значения поля {@linkplain Item2d#x}
* @param x - значение для {@linkplain Item2d#x}
* @return Значение {@linkplain Item2d#x}
*/
public double setL(double leng) {
return this.leng = leng;
}
public double setW(double widt) {
return this.widt = widt;
}
public double setH(double heig) {
return this.heig = heig;
}
/** Получение значения поля {@linkplain Item2d#x}
* @return Значение {@linkplain Item2d#x}
*/
public double getL() {
return leng;
}
public double getW() {
return widt;
}
public double getH() {
return heig;
}
/** Установка значения поля {@linkplain Item2d#y}
* @param y - значение для {@linkplain Item2d#y}
* @return Значение {@linkplain Item2d#y}
*/
public double setP(double p) {
return this.p = p;
}
public double setS(double s) {
return this.s = s;
}
public double setV(double v) {
return this.v = v;
}
/** Получение значения поля {@linkplain Item2d#y}
* @return значение {@linkplain Item2d#y}
*/
public double getP() {
return p;
}
public double getS() {
return s;
}
public double getV() {
return v;
}
/** Установка значений {@linkplain Item2d#x} и {@linkplain Item2d#y}
* @param x - значение для {@linkplain Item2d#x}
* @param y - значение для {@linkplain Item2d#y}
* @return this
*/
public Item2d setLHWPSV(double leng, double heig, double widt, double p, double s, double v) {
this.leng = leng;
this.heig = heig;
this.widt = widt;
this.p = p;
this.s = s;
this.v = v;
return this;
}
/** Представляет результат вычислений в виде строки.<br>{@inheritDoc} */
@Override
public String toString() {
return "leng = " + leng + ", heig = " + heig + ", widt = " + widt + ", perimetr = " + p + ", Plosha = " + s + ", Obyem = " + v;
}
/** Автоматически сгенерированный метод.<br>{@inheritDoc} */
@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Item2d other = (Item2d) obj;
    if (Double.doubleToLongBits(leng) != Double.doubleToLongBits(other.leng))
        return false;
    if (Double.doubleToLongBits(widt) != Double.doubleToLongBits(other.widt))
        return false;
    if (Double.doubleToLongBits(heig) != Double.doubleToLongBits(other.heig))
        return false;
    if (Double.doubleToLongBits(p) != Double.doubleToLongBits(other.p))
        return false;
    if (Double.doubleToLongBits(s) != Double.doubleToLongBits(other.s))
        return false;
    if (Double.doubleToLongBits(v) != Double.doubleToLongBits(other.v))
        return false;
    return true;
}
}