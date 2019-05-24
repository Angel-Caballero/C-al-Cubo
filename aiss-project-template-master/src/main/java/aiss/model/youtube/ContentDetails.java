package aiss.model.youtube;

public class ContentDetails
{
    private String itemCount;

    public String getItemCount ()
    {
        return itemCount;
    }

    public void setItemCount (String itemCount)
    {
        this.itemCount = itemCount;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [itemCount = "+itemCount+"]";
    }
}
