package aiss.model.calendarific;

public class Timezone
{
    private String offset;

    private String zoneoffset;

    private String zonedst;

    private String zonetotaloffset;

    private String zoneabb;

    public String getOffset ()
    {
        return offset;
    }

    public void setOffset (String offset)
    {
        this.offset = offset;
    }

    public String getZoneoffset ()
    {
        return zoneoffset;
    }

    public void setZoneoffset (String zoneoffset)
    {
        this.zoneoffset = zoneoffset;
    }

    public String getZonedst ()
    {
        return zonedst;
    }

    public void setZonedst (String zonedst)
    {
        this.zonedst = zonedst;
    }

    public String getZonetotaloffset ()
    {
        return zonetotaloffset;
    }

    public void setZonetotaloffset (String zonetotaloffset)
    {
        this.zonetotaloffset = zonetotaloffset;
    }

    public String getZoneabb ()
    {
        return zoneabb;
    }

    public void setZoneabb (String zoneabb)
    {
        this.zoneabb = zoneabb;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [offset = "+offset+", zoneoffset = "+zoneoffset+", zonedst = "+zonedst+", zonetotaloffset = "+zonetotaloffset+", zoneabb = "+zoneabb+"]";
    }
}