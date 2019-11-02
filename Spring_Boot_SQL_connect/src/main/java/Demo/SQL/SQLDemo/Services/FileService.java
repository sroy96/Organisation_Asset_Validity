package Demo.SQL.SQLDemo.Services;

import Demo.SQL.SQLDemo.Model.LaptopRequest;
import Demo.SQL.SQLDemo.Repository.LaptopRequestRepository;
import Demo.SQL.SQLDemo.Utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class FileService{

    @Autowired
    LaptopRequestRepository laptopRequestRepository;

    // Store File Data to Database
    public void store(MultipartFile file){

        try {
            List<LaptopRequest> lstCustomers = ExcelUtils.parseExcelFile(file.getInputStream());
            // Save requestData to DataBase
            for(LaptopRequest laptopRequests : lstCustomers){
                System.out.print(laptopRequests);
            }
            laptopRequestRepository.saveAll(lstCustomers);
        } catch (IOException e) {
            throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
    }

    // Load Data to Excel File
    public ByteArrayInputStream loadFile() {
        List<LaptopRequest> laptopRequestList = (List<LaptopRequest>) laptopRequestRepository.findAll();

        try {
            ByteArrayInputStream in = ExcelUtils.LaptopRequestToExcel(laptopRequestList);
            return in;
        } catch (IOException e) {}

        return null;
    }
}
