package aiss.model.googlecalendar;

public class Summary {
	
	 private String summary;

	    public String getSummary ()
	    {
	        return summary;
	    }

	    public void setSummary (String summary)
	    {
	        this.summary = summary;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [summary = "+summary+"]";
	    }
}
