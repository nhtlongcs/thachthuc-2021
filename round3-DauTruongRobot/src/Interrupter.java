import lejos.util.Stopwatch;
import lejos.nxt.Button;

public class Interrupter extends Thread
{
    private DataExchanger de;
    private Stopwatch sw;
    private int timeLimit = 118000;

    public Interrupter(DataExchanger d)
    {
        de = d;
        sw = new Stopwatch();
    }

    public void run()
    {
        sw.reset();

        while(true)
        {
        	int cmd = de.getCMD();
        	
        	if(cmd == DataExchanger.RUN || cmd == DataExchanger.FINAL_ACT)
        	{
        		if(sw.elapsed() > timeLimit - 5000 || Button.ESCAPE.isDown())
        		{
        			de.setCMD(DataExchanger.DROP_ALL);
        		}        		
        	}
        	else
        	{
        		if(sw.elapsed() > timeLimit || Button.ESCAPE.isDown())
        		{
        			de.setCMD(DataExchanger.STOP);
        		}        		
        	}
        }
    }
}
