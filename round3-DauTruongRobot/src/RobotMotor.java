import lejos.nxt.Motor;
import lejos.util.Delay;

public class RobotMotor extends Thread
{
    private DataExchanger de;

    static private int normalSpeed = 640;
    static private int fastSpeed = 640;
    static private int deliverSpeed = 480;

    static public double lengthToDegree(double length)
    {
        return length / Math.PI / 4 * 360;
    }

    static public void forward(int length)
    {
        double deg = lengthToDegree(length);

        Motor.A.rotate((int)deg, true);
        Motor.C.rotate((int)deg, true);

        while(Motor.A.isMoving() || Motor.C.isMoving());
    }

    static public void forward(int length, boolean deliver)
    {
        double deg = lengthToDegree(length);

        if(deliver) setSpeed(deliverSpeed);

        Motor.A.rotate((int)deg, true);
        Motor.C.rotate((int)deg, true);

        while(Motor.A.isMoving() || Motor.C.isMoving());
    }

    static public void rotateRight()
    {
    	int eps = 100;

        Motor.A.rotate(410 + eps, true);
        Motor.C.rotate(-410 - eps, true);

        while(Motor.A.isMoving() || Motor.C.isMoving());
    }

    static public void rotateRight(int eps)
    {
        Motor.A.rotate(410 + eps, true);
        Motor.C.rotate(-410 - eps, true);

        while(Motor.A.isMoving() || Motor.C.isMoving());
    }

    static public void rotateLeft()
    {
    	int eps = 150;

        Motor.A.rotate(-410 - eps, true);
        Motor.C.rotate(410 + eps, true);

        while(Motor.A.isMoving() || Motor.C.isMoving());
    }

    static public void rotateLeft(int eps)
    {
        Motor.A.rotate(-410 - eps, true);
        Motor.C.rotate(410 + eps, true);

        while(Motor.A.isMoving() || Motor.C.isMoving());
    }

    static public void setSpeed(int rotateSpeed)
    {
    	Motor.A.setSpeed(rotateSpeed);
        Motor.C.setSpeed(rotateSpeed);
    }

    static public void steerRight(int direction)
    {
    	if(direction < 0) Motor.A.rotate(-1230);
    	else Motor.A.rotate(1230);
    }

    static public void steerLeft(int direction)
    {
    	if(direction < 0) Motor.C.rotate(-1230);
    	else Motor.C.rotate(1230);
    }

    static public void steerRight(int direction, int eps)
    {
    	if(direction < 0) Motor.A.rotate(-1230 - eps);
    	else Motor.A.rotate(1230 + eps);
    }

    static public void steerLeft(int direction, int eps)
    {
    	if(direction < 0) Motor.C.rotate(-1230 - eps);
    	else Motor.C.rotate(1230 + eps);
    }

    public RobotMotor(DataExchanger d)
    {
        de = d;
    }

    public void run()
    {
        setSpeed(normalSpeed);

        while(true)
        {
            if(de.getCMD() == DataExchanger.RUN)
            {

            	{
//            		Go to opponent start box
            		setSpeed(fastSpeed);

            		forward(250);

            		setSpeed(normalSpeed);

            		steerLeft(-1, -800);
            		forward(-30);


            		setSpeed(720);
            		steerRight(1, -500);
            		forward(25);
            		steerLeft(1);
            		steerRight(1);

            		setSpeed(normalSpeed);
            		forward(-130);

            		setSpeed(normalSpeed);
            		forward(-7);
            		setSpeed(normalSpeed);

            		forward(5);
            		rotateRight();
            	}

            	de.setDeliverDur(2000);

            	{
            		setSpeed(normalSpeed);
            		forward(-50);
            		setSpeed(normalSpeed);
            		steerLeft(1, -1000);

            		de.setDeliver(true);
            		forward(66 + 3, true);
            		de.setDeliver(false);
            		rotateRight();
            	}

            	{
            		setSpeed(720);
            		forward(50);
            		setSpeed(normalSpeed);

            		forward(-100);

            		setSpeed(720);
            		forward(-50);
            		setSpeed(normalSpeed);

            		de.setDeliver(true);
            		de.setDeliverDur(1000);
            		forward(100, true);
            		de.setDeliver(false);
            		de.setDeliverDur(2000);
            	}

            	{
            		setSpeed(720);
            		forward(50);
            		setSpeed(normalSpeed);

            		forward(-3);
            		rotateLeft();
            		forward(22);
            		de.setDeliver(true);
            		forward(66, true);
            		de.setDeliver(false);
            	}

            	{
//            		Go back to team's start
            		setSpeed(720);
            		forward(100);
            		setSpeed(normalSpeed);

            		steerLeft(-1, -800);
            		forward(-30);

            		setSpeed(720);
            		steerRight(1);
            		forward(25);
            		steerLeft(1);
            		steerRight(1);

            		setSpeed(fastSpeed);
            		forward(-150);

            		setSpeed(720);
            		forward(-7);
            		setSpeed(normalSpeed);

            		forward(5);
            		rotateRight();
            	}


            	{
            		setSpeed(720);
            		forward(-70);
            		setSpeed(normalSpeed);

            		steerLeft(1, -1000);

            		forward(44 + 7);
            		rotateRight();

            		setSpeed(720);
            		forward(50);
            		setSpeed(normalSpeed);

            		forward(-66);
            	}

            	{
            		de.setDeliver(true);
            		forward(66 + 7, true);
            		de.setDeliver(false);
            	}

            	{
            		setSpeed(720);
            		forward(50);
            		setSpeed(normalSpeed);

            		forward(-2);
            		rotateLeft();

            		de.setDeliver(true);
            		forward(22 * 3, true);
            		de.setDeliver(false);

            		setSpeed(normalSpeed);
            		forward(22 * 5);
            	}

            	{
            		forward(-66);
            	}


            	{
            		de.setCMD(DataExchanger.DROP_ALL);
            	}

            }
            else if(de.getCMD() == DataExchanger.DROP_ALL)
            {
            	setSpeed(deliverSpeed);
            	Motor.A.forward();
            	Motor.C.forward();
            }
            else
            {
                Motor.A.stop();
                Motor.C.stop();
            }
        }
    }

}
