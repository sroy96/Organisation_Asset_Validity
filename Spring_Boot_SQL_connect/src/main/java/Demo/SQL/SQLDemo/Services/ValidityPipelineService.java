package Demo.SQL.SQLDemo.Services;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Service
public class ValidityPipelineService {
static  boolean result=true;
    public boolean decision(String status, String enddate, String extendedDate)  {

        if(status.equals("Approved")){
            result=true;
        }
        else if(status.equals("Expired")){
            result=false;
        }
        else if(status.equals("Pending")){
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
            String today= LocalDate.now().toString();
            try{
                if((dateFormat.parse(today).after(dateFormat.parse(enddate)))){
                    result=true;
                }
                else{
                    if((dateFormat.parse(today).after(dateFormat.parse(extendedDate)))){
                        result=false;
                    }
                    else{
                        result=true;
                    }
                }
            }
            catch(ParseException e){
                throw new RuntimeException("Parsing Exception=>"+e.getMessage());
            }

        }
        return result;
    }
}
