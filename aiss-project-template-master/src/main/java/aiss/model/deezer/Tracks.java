package aiss.model.deezer;

public class Tracks
{
    private Data[] data;

    private String checksum;

    public Data[] getData ()
    {
        return data;
    }

    public void setData (Data[] data)
    {
        this.data = data;
    }

    public String getChecksum ()
    {
        return checksum;
    }

    public void setChecksum (String checksum)
    {
        this.checksum = checksum;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", checksum = "+checksum+"]";
    }
}
