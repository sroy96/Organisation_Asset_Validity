package Demo.SQL.SQLDemo.Controller;


import Demo.SQL.SQLDemo.Model.LaptopRequest;
import Demo.SQL.SQLDemo.Model.LaptopSmall;
import Demo.SQL.SQLDemo.Model.Outputmodel;
import Demo.SQL.SQLDemo.Services.AppService;
import Demo.SQL.SQLDemo.Services.ValidityPipelineService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/wipro/valid")
public class AppController {
    //Javascript Config

    @Autowired
    AppService appService;

    @Autowired
    ValidityPipelineService validityPipelineService;
    @GetMapping("/{RequestedForEmail}")
    public ResponseEntity<LaptopRequest> data(@PathVariable("RequestedForEmail") String RequestedForEmail) throws JsonProcessingException {
        List<List<String>> res=appService.result(RequestedForEmail);
        LaptopRequest laptopRequest = new LaptopRequest();
        List<String> v = res.get(0);
        laptopRequest.setRequestedForEmail(v.get(0));
        laptopRequest.setEndDate(v.get(1));
        laptopRequest.setRequestedBy(v.get(2));
        laptopRequest.setRequested_Date(v.get(3));
        laptopRequest.setRequestedFor(v.get(4));

        Outputmodel outputmodel = new Outputmodel();
        outputmodel.setName(v.get(4));
        outputmodel.setResult(validityPipelineService.decision(v.get(1),v.get(2),v.get(3)));

        return new ResponseEntity(outputmodel,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LaptopRequest>> alldata(){
        List<LaptopRequest> list = new ArrayList<>();
        Iterable<LaptopRequest>laptopRequests=appService.alldata();
        for(LaptopRequest laptopRequest: laptopRequests){
            list.add(laptopRequest);
        }
            return new ResponseEntity(list, HttpStatus.OK);

    }


}
