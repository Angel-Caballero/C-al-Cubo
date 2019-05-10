package aiss.model.deezer;

public class TrackSearch {
	
	private String prev;
	
    private String next;

    private String total;

    private TrackData[] data;

    private String checksum;

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

    public TrackData[] getData ()
    {
        return data;
    }

    public void setData (TrackData[] data)
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
        return "ClassPojo [next = "+next+", prev = "+prev+", total = "+total+", data = "+data+", checksum = "+checksum+"]";
    }

	public String getPrev() {
		return prev;
	}

	public void setPrev(String prev) {
		this.prev = prev;
	}
}