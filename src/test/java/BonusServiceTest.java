import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    //Тест-дизайн:
    //При разработке тестов применены методы граничных значений и попарное тестирование
    //Границы классов существуют для переменной бонус и равны 0 и 500
    //Каждое из граничных значений сочетается с одним из 2-х возможных значений переменной registered/
    //Всего 12 тест-кейсов
    //13-й и 14-й кейс - значение value из класса эквивалентных, но не круглое
    //3 теста падают - оставил их специально - все они связанны с округлением дробных чисел, возникающих при расчетах с некоторыми значениями параметров

    @Test
    void testForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long expected = 499; // здесь по правилам математического округления должно быть 499 (фактически тест упадет со значением actual=498)
        long amount = 16633;
        boolean registered = true;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testForRegisteredAndEqualLimit() {
        BonusService service = new BonusService();
        long expected = 500;
        long amount = 16667;
        boolean registered = true;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testForRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        long expected = 500;
        long amount = 16700;
        boolean registered = true;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testForRegisteredAndOne() {
        BonusService service = new BonusService();
        long expected = 1; // здесь по правилам математического округления должно быть 1 (фактически тест упадет со значением actual = 0)
        long amount = 33;
        boolean registered = true;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testForRegisteredAndZero() {
        BonusService service = new BonusService();
        long expected = 0;
        long amount = 0;
        boolean registered = true;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testForRegisteredAndNegative() {
        BonusService service = new BonusService();
        long expected = 0;//по правилам математического округления здесь должно быть -1, но с точки зрения здравого смысла, отрицательные баллы как и отрицательная сумма покупки существовать не могут.
        long amount = -33;
        boolean registered = true;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }




    @Test
    void testForUnregisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long expected = 499;
        long amount = 49900;
        boolean registered = false;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testForUnregisteredAndEqualLimit() {
        BonusService service = new BonusService();
        long expected = 500;
        long amount = 50000;
        boolean registered = false;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testForUnregisteredAndOverLimit() {
        BonusService service = new BonusService();
        long expected = 500;
        long amount = 50100;
        boolean registered = false;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testForUnregisteredAndOne() {
        BonusService service = new BonusService();
        long expected = 1;
        long amount = 100;
        boolean registered = false;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testForUnregisteredAndZero() {
        BonusService service = new BonusService();
        long expected = 0;
        long amount = 0;
        boolean registered = false;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testForUnregisteredAndNegative() {
        BonusService service = new BonusService();
        long expected = 0; //тест падает т.к. программа считатет отрицательные баллы, что с точки зрения здравого смысла быть не может как и отрицательной суммы покупки
        long amount = -100;
        boolean registered = false;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testForRegisteredAndNotRound() {
        BonusService service = new BonusService();
        long expected = 439;
        long amount = 14641;
        boolean registered = true;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testForUnegisteredAndNotRound() {
        BonusService service = new BonusService();
        long expected = 355;
        long amount = 35545;
        boolean registered = false;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }
}
