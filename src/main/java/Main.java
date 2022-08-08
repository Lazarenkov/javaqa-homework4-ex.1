public class Main {

    public static void main(String[] args) {
        BonusService service=new BonusService();
        //long amount =200;
        //boolean registered = true;
       // long bonus = service.calculate(amount, registered);
        System.out.println(service.calculate(200,false));
    }
}
