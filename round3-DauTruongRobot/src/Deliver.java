import lejos.nxt.*;
import lejos.robotics.Color;
import lejos.util.Stopwatch;

public class Deliver extends Thread
{
    static private final int deliverDeg = -125;

    private DataExchanger de;
    private int teamColor;
    private ColorSensor color;
    private Stopwatch sw;
    private int lastTime;

    public Deliver(DataExchanger d)
    {
        de = d;
        teamColor = -1;
        color = new ColorSensor(SensorPort.S4);
        sw = new Stopwatch();
        lastTime = -1;
    }

    public void run()
    {
        sw.reset();
        
        Motor.B.setSpeed(270);

        while(true)
        {
        	int currentColor = color.getColorID();
        	int cmd = de.getCMD();
        	if(cmd == DataExchanger.RUN)
        	{	
        		if(teamColor == -1 && currentColor != Color.BLACK && currentColor != Color.WHITE)
        		{
        			teamColor = currentColor;
        		}
        		
        		if(de.getDeliver() && sw.elapsed() > de.getDeliverDur() && currentColor == teamColor)
        		{
        			if(lastTime == -1)
        			{
        				lastTime = sw.elapsed();
        			}
        			if(sw.elapsed() - lastTime > 300)
        			{
        				Motor.B.rotate(deliverDeg);
        				lastTime = -1;
        				sw.reset();
        			}
        		}        		
        	}
        	else if(cmd == DataExchanger.DROP_ALL)
        	{
        		for(int i = 0; i < 5 ; ++i)
        		{
        			currentColor = color.getColorID();
        			if(currentColor == Color.WHITE || currentColor == teamColor)
            		{
            			Motor.B.rotate(deliverDeg);
            		}
        			else break;
        		}
        		de.setCMD(DataExchanger.STOP);
        	}
        	else if(cmd == DataExchanger.FINAL_ACT)
        	{
        		if(currentColor == teamColor)
        		{
        			de.setCMD(DataExchanger.DROP_ALL);
        		}
        	}
        }
    }
}
