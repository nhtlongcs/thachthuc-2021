public class Robot
{
    private static DataExchanger de;
    private static RobotMotor rm;
    private static Interrupter interrupter;
    private static Deliver deliver;

    public static void main(String[] args) throws Exception
    {
        de = new DataExchanger();
        rm = new RobotMotor(de);
        deliver = new Deliver(de);
        interrupter = new Interrupter(de);

        rm.start();
        deliver.start();
        interrupter.start();

        while(de.getCMD() != DataExchanger.STOP);

        System.exit(0);
    }
}
