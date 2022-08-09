import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    // Тест-дизайн:
    // При разработке тестов применены методы граничных значений и попарное тестирование
    // Границы классов существуют для переменной бонус и равны 0 и 500
    // Каждое из граничных значений сочетается с одним из 2-х возможных значений переменной registered
    // Всего 12 тест-кейсов


    @Test
    void testForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long expected = 499;
        long amount = 16634;
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
        long amount = 34;
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
        long expected = 0;
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
        long expected = -1;
        long amount = -100;
        boolean registered = false;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }
}