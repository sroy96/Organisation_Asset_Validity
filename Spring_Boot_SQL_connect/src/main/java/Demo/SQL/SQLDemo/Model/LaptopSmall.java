package Demo.SQL.SQLDemo.Model;

import javax.persistence.Column;

public class LaptopSmall {


    private String requested_for_email;


    private String end_date;


    private String requested_by;


    private String requested_date;

    private String requested_for;

    public String getRequested_for() {
        return requested_for;
    }

    public void setRequested_for(String requested_for) {
        this.requested_for = requested_for;
    }

    public String getRequested_for_email() {
        return requested_for_email;
    }

    public void setRequested_for_email(String requested_for_email) {
        this.requested_for_email = requested_for_email;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getRequested_by() {
        return requested_by;
    }

    public void setRequested_by(String requested_by) {
        this.requested_by = requested_by;
    }

    public String getRequested_date() {
        return requested_date;
    }

    public void setRequested_date(String requested_date) {
        this.requested_date = requested_date;
    }
}
