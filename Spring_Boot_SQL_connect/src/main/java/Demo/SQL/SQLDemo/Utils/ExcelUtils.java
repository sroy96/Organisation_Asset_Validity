package Demo.SQL.SQLDemo.Utils;

import Demo.SQL.SQLDemo.Model.LaptopRequest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {
    public static ByteArrayInputStream LaptopRequestToExcel(List<LaptopRequest> laptopRequests) throws IOException{
        String[] COLUMNs = {"id","requested_for","requested_for_email","serial_number","approving_apple_manager","approving_apple_manager_mail","vendor","requested_by","requested_date","start_date","end_date","business_reason","status","expiry_reason","gate_pass_disabled","action_by_name","action_Date","request_id","location","requested_for_dsid","imt","imt1","imt2"};
        try(
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
        ){
            CreationHelper createHelper = workbook.getCreationHelper();

            Sheet sheet = workbook.createSheet("Laptop_Request_Report");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            Row headerRow = sheet.createRow(0);

            for(int col=0;col<COLUMNs.length;col++){
                Cell cell= headerRow.createCell(col);
                cell.setCellValue(COLUMNs[col]);
                cell.setCellStyle(headerCellStyle);
            }

            int rowIdx =1;
            for(LaptopRequest laptopRequest: laptopRequests){
                Row row= sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(laptopRequest.getId());
                row.createCell(1).setCellValue(laptopRequest.getRequestedFor());
                row.createCell(2).setCellValue(laptopRequest.getRequestedForEmail());
                row.createCell(3).setCellValue(laptopRequest.getSerialNumber());
                row.createCell(4).setCellValue(laptopRequest.getApprovingAppleManager());
                row.createCell(5).setCellValue(laptopRequest.getApprovingAppleManagerMail());
                row.createCell(6).setCellValue(laptopRequest.getVendor());
                row.createCell(7).setCellValue(laptopRequest.getRequestedBy());
                row.createCell(8).setCellValue(laptopRequest.getRequested_Date()); //Dates are set as String Value in Database
                row.createCell(9).setCellValue(laptopRequest.getStartDate());
                row.createCell(10).setCellValue(laptopRequest.getEndDate());
                row.createCell(11).setCellValue(laptopRequest.getExtendedDate());
                row.createCell(12).setCellValue(laptopRequest.getBusinessReason());
                row.createCell(13).setCellValue(laptopRequest.getStatus());
                row.createCell(14).setCellValue(laptopRequest.getExpiryReason());
                row.createCell(15).setCellValue(laptopRequest.getAction_Date());
                row.createCell(16).setCellValue(laptopRequest.getGatePass());
                row.createCell(17).setCellValue(laptopRequest.getActionByName());
                row.createCell(18).setCellValue(laptopRequest.getRequestId());
                row.createCell(19).setCellValue(laptopRequest.getLocation());
                row.createCell(20).setCellValue(laptopRequest.getDSId());
                row.createCell(21).setCellValue(laptopRequest.getIMT());
                row.createCell(22).setCellValue(laptopRequest.getIMT1());
                row.createCell(23).setCellValue(laptopRequest.getIMT2());
            }
            workbook.write(out);
            return new  ByteArrayInputStream(out.toByteArray());

        }
    }

    public static List<LaptopRequest> parseExcelFile(InputStream is) {
        try{
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet("Laptop"); //Sheet Name
         //   System.out.println("Sheet name="+sheet.getSheetName());
            Iterator<Row> rows= sheet.iterator();
            List<LaptopRequest> laptopRequestList = new ArrayList<LaptopRequest>();

            int rowNumber = 0;

            while(rows.hasNext()){
                Row currentRow =  rows.next();

                //skip header
                if(rowNumber == 0){
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                LaptopRequest laptopRequest = new LaptopRequest();

                int cellIndex=0;
                while(cellsInRow.hasNext()){
                    Cell currentCell = cellsInRow.next();

                    if(cellIndex == 0){ //ID
                        laptopRequest.setId((int)currentCell.getNumericCellValue());
                    }
                    else if(cellIndex == 1) { //Requested_for
                        laptopRequest.setRequestedFor(currentCell.getStringCellValue());
                    }
                    else if( cellIndex == 2){
                        laptopRequest.setRequestedForEmail(currentCell.getStringCellValue());
                    }
                    else if(cellIndex == 3){
                        laptopRequest.setSerialNumber(currentCell.getStringCellValue());
                    }
                    else if(cellIndex == 4){
                        laptopRequest.setApprovingAppleManager(currentCell.getStringCellValue());

                    }
                    else if(cellIndex == 5){
                        laptopRequest.setApprovingAppleManagerMail(currentCell.getStringCellValue());
                    }
                    else if( cellIndex == 6){
                        laptopRequest.setVendor(currentCell.getStringCellValue());

                    }
                    else if(cellIndex == 7){
                        laptopRequest.setRequestedBy(currentCell.getStringCellValue());

                    }
                    else if(cellIndex == 8){
                        laptopRequest.setRequested_Date(currentCell.getStringCellValue());
                    }
                    else if( cellIndex ==9){
                        laptopRequest.setStartDate(currentCell.getStringCellValue());
                    }
                    else if (cellIndex == 10 ){
                        laptopRequest.setEndDate(currentCell.getStringCellValue());
                    }
                    else if (cellIndex == 11){
                        laptopRequest.setExtendedDate(currentCell.getStringCellValue());
                    }
                    else if(cellIndex ==  12){
                        laptopRequest.setBusinessReason(currentCell.getStringCellValue());
                    }
                    else if( cellIndex == 13 ){
                        laptopRequest.setStatus(currentCell.getStringCellValue());
                    }
                    else if( cellIndex ==14){ //add gate Pass and Action by name
                        laptopRequest.setExpiryReason(currentCell.getStringCellValue());
                    }
                    else if(cellIndex ==15){
                        laptopRequest.setGatePass(currentCell.getStringCellValue());
                    }
                    else if(cellIndex ==16){
                        laptopRequest.setActionByName(currentCell.getStringCellValue());
                    }
                    else if(cellIndex == 17){
                        laptopRequest.setAction_Date(currentCell.getStringCellValue());
                    }
                    else if( cellIndex == 18){
                        laptopRequest.setRequestId(currentCell.getStringCellValue());
                    }
                    else if(cellIndex ==  19){
                        laptopRequest.setLocation(currentCell.getStringCellValue());
                    }
                    else if(cellIndex == 20){
                        laptopRequest.setDSId(currentCell.getStringCellValue());
                    }
                    else if(cellIndex ==  21){
                        laptopRequest.setIMT(currentCell.getStringCellValue());
                    }
                    else if(cellIndex ==  22){
                        laptopRequest.setIMT1(currentCell.getStringCellValue());
                    }
                    else if( cellIndex == 23 ){
                        laptopRequest.setIMT2(currentCell.getStringCellValue());
                    }

                    cellIndex++;


                }
                laptopRequestList.add(laptopRequest);

            }
            workbook.close();
            return  laptopRequestList;
        } catch (IOException e) {
            throw new RuntimeException("FAIL -> message ="+e.getMessage());
        }
    }
}
