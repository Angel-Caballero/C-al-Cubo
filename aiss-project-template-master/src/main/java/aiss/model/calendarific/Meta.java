package aiss.model.calendarific;

public class Meta
{
    private String code;

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [code = "+code+"]";
    }
}
