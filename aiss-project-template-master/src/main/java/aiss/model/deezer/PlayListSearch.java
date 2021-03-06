package aiss.model.deezer;

public class PlayListSearch{
    private String next;

    private String total;

    private PlayListData[] data;

    public String getNext ()
    {
        return next;
    }

    public void setNext (String next)
    {
        this.next = next;
    }

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public PlayListData[] getData ()
    {
        return data;
    }

    public void setData (PlayListData[] data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [next = "+next+", total = "+total+", data = "+data+"]";
    }
}