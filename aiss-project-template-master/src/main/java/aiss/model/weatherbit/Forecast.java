package aiss.model.weatherbit;
public class Forecast
{
    private Data[] data;

    private String count;

    public Data[] getData ()
    {
        return data;
    }

    public void setData (Data[] data)
    {
        this.data = data;
    }

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", count = "+count+"]";
    }
}