package Demo.SQL.SQLDemo.Services;


import Demo.SQL.SQLDemo.Model.LaptopRequest;
import Demo.SQL.SQLDemo.Model.LaptopSmall;
import Demo.SQL.SQLDemo.Repository.LaptopRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {
    @Autowired
    LaptopRequestRepository laptopRequestRepository;

    public class RequiredData{
        private String requested_for_email; //serial
        private String end_date; // status
        private String requested_by ; //end date
        private String requested_date; //extended date

        public RequiredData() {
        }

        public RequiredData(String requested_for_email, String end_date, String requested_by, String requested_date) {
            this.requested_for_email = requested_for_email;
            this.end_date = end_date;
            this.requested_by = requested_by;
            this.requested_date = requested_date;
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



    public List<List<String>> result(String serialNumber){

        return laptopRequestRepository.findByRequestedForEmail(serialNumber);

}


public Iterable<LaptopRequest> alldata(){
       return laptopRequestRepository.findAllLaptop();
}

}
