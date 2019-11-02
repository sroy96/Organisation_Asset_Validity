package Demo.SQL.SQLDemo.Services;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Service
public class ValidityPipelineService {
  boolean result=true;
    public boolean decision(String status, String enddate, String extendedDate) throws ParseException {

        if(status.equals("Approved")){
            result=true;
        }
        else if(status.equals("Expired")){
            result=false;
        }
        else if(status.equals("Pending")){
            System.out.print("Pending");
            SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
            Date today= new Date();
            try{
                Date EndDate= formatter.parse(enddate);
                System.out.println("len"+extendedDate.length());
                if(today.compareTo(EndDate)>0){
                    result=true;
                }
                else if(extendedDate.length()>0){
                    Date Extended_Date= formatter.parse(extendedDate);
                    System.out.print("Extended Date:"+Extended_Date);
                    if(today.compareTo(Extended_Date)>0){
                        result=false;
                    }
                    else{
                        result=true;
                    }
                }
                else{
                    result=false;
                }
            }
            catch(ParseException e){
                throw new RuntimeException("Parsing Exception=>"+e.getMessage());
            }

        }
        return result;
    }
}
