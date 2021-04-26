public class DataExchanger
{

    static final int STOP = 0;
    static final int RUN = 1;
    static final int DROP_ALL = 2;
    static final int FINAL_ACT = 3; 

    private int cmd;
    private boolean deliver;
    private int deliverDur = 5000;

    static DataExchanger instance;

    public DataExchanger()
    {
        cmd = DataExchanger.RUN;
        deliver = false;
    }

    public int getCMD()
    {
        return cmd;
    }

    public void setCMD(int c)
    {
        cmd = c;
    }

    public boolean getDeliver()
    {
        return deliver;
    }

    public void setDeliver(boolean d)
    {
        deliver = d;
    }

    public int getDeliverDur()
    {
        return deliverDur;
    }

    public void setDeliverDur(int d)
    {
        deliverDur = d;
    }
}
