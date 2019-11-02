package Demo.SQL.SQLDemo.Model;


import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "laptopRequest")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaptopRequest {

    public LaptopRequest() {
    }

    public LaptopRequest(String requestedForEmail, String requestedBy, String requested_Date, String endDate) {
        RequestedForEmail = requestedForEmail; // serial No.
        RequestedBy = requestedBy; // Status
        Requested_Date = requested_Date; // End Date
        EndDate = endDate; // Ext date
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(name="requested_for")
    private String RequestedFor;

    @Column(name="requested_for_email")
    private String RequestedForEmail;

    @Column(name="serial_number")
    private String SerialNumber;

    @Column(name="approving_apple_manager")
    private String ApprovingAppleManager;

    @Column(name="approving_apple_manager_mail")
    private String ApprovingAppleManagerMail;

    @Column(name="vendor")
    private String Vendor;

    @Column(name="requested_by")
    private String RequestedBy;

    @Column(name="requested_date")
    private String Requested_Date;
    @Column(name="start_date")
    private String StartDate;

    @Column(name="end_date")
    private String EndDate;

    @Column(name="extended_date")
    private String ExtendedDate;

    @Column(name="business_reason")
    private String BusinessReason;

    @Column(name="status")
    private String Status;


    @Column(name="expiry_reason")
    private String ExpiryReason;


    @Column(name="gate_pass_disabled")
    private String GatePass;

    @Column(name = "action_by_name")
    private String ActionByName;

    @Column(name="action_date")
    private String Action_Date;

    @Column(name="request_id")
    private String RequestId;

    @Column(name="location")
    private String Location;


    @Column(name="requested_for_dsid")
    private String DSId;

    @Column(name="imt")
    private String IMT;

    @Column(name="imt1")
    private String IMT1;



    @Column(name="imt2")
    private String IMT2;

    public LaptopRequest(String requestedFor, String requestedForEmail, String serialNumber, String approvingAppleManager, String approvingAppleManagerMail, String vendor, String requestedBy, String requested_Date, String startDate, String endDate, String extendedDate, String businessReason, String status, String expiryReason, String gatePass, String actionByName, String action_Date, String requestId, String location, String DSId, String IMT, String IMT1, String IMT2) {
        RequestedFor = requestedFor;
        RequestedForEmail = requestedForEmail;
        SerialNumber = serialNumber;
        ApprovingAppleManager = approvingAppleManager;
        ApprovingAppleManagerMail = approvingAppleManagerMail;
        Vendor = vendor;
        RequestedBy = requestedBy;
        Requested_Date = requested_Date;
        StartDate = startDate;
        EndDate = endDate;
        ExtendedDate = extendedDate;
        BusinessReason = businessReason;
        Status = status;
        ExpiryReason = expiryReason;
        GatePass = gatePass;
        ActionByName = actionByName;
        Action_Date = action_Date;
        RequestId = requestId;
        Location = location;
        this.DSId = DSId;
        this.IMT = IMT;
        this.IMT1 = IMT1;
        this.IMT2 = IMT2;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getRequestedFor() {
        return RequestedFor;
    }

    public void setRequestedFor(String requestedFor) {
        RequestedFor = requestedFor;
    }

    public String getRequestedForEmail() {
        return RequestedForEmail;
    }

    public void setRequestedForEmail(String requestedForEmail) {
        RequestedForEmail = requestedForEmail;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        SerialNumber = serialNumber;
    }

    public String getApprovingAppleManager() {
        return ApprovingAppleManager;
    }

    public void setApprovingAppleManager(String approvingAppleManager) {
        ApprovingAppleManager = approvingAppleManager;
    }

    public String getApprovingAppleManagerMail() {
        return ApprovingAppleManagerMail;
    }

    public void setApprovingAppleManagerMail(String approvingAppleManagerMail) {
        ApprovingAppleManagerMail = approvingAppleManagerMail;
    }

    public String getVendor() {
        return Vendor;
    }

    public void setVendor(String vendor) {
        Vendor = vendor;
    }

    public String getRequestedBy() {
        return RequestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        RequestedBy = requestedBy;
    }

    public String getRequested_Date() {
        return Requested_Date;
    }

    public void setRequested_Date(String requested_Date) {
        Requested_Date = requested_Date;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getExtendedDate() {
        return ExtendedDate;
    }

    public void setExtendedDate(String extendedDate) {
        ExtendedDate = extendedDate;
    }

    public String getBusinessReason() {
        return BusinessReason;
    }

    public void setBusinessReason(String businessReason) {
        BusinessReason = businessReason;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getExpiryReason() {
        return ExpiryReason;
    }

    public void setExpiryReason(String expiryReason) {
        ExpiryReason = expiryReason;
    }

    public String getGatePass() {
        return GatePass;
    }

    public void setGatePass(String gatePass) {
        GatePass = gatePass;
    }

    public String getActionByName() {
        return ActionByName;
    }

    public void setActionByName(String actionByName) {
        ActionByName = actionByName;
    }

    public String getAction_Date() {
        return Action_Date;
    }

    public void setAction_Date(String action_Date) {
        Action_Date = action_Date;
    }

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String requestId) {
        RequestId = requestId;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getDSId() {
        return DSId;
    }

    public void setDSId(String DSId) {
        this.DSId = DSId;
    }

    public String getIMT() {
        return IMT;
    }

    public void setIMT(String IMT) {
        this.IMT = IMT;
    }

    public String getIMT1() {
        return IMT1;
    }

    public void setIMT1(String IMT1) {
        this.IMT1 = IMT1;
    }

    public String getIMT2() {
        return IMT2;
    }

    public void setIMT2(String IMT2) {
        this.IMT2 = IMT2;
    }


    @Override
    public String toString() {
        return "LaptopRequest{" +
                "Id=" + Id +
                ", RequestedFor='" + RequestedFor + '\'' +
                ", RequestedForEmail='" + RequestedForEmail + '\'' +
                ", SerialNumber='" + SerialNumber + '\'' +
                ", ApprovingAppleManager='" + ApprovingAppleManager + '\'' +
                ", ApprovingAppleManagerMail='" + ApprovingAppleManagerMail + '\'' +
                ", Vendor='" + Vendor + '\'' +
                ", RequestedBy='" + RequestedBy + '\'' +
                ", Requested_Date='" + Requested_Date + '\'' +
                ", StartDate='" + StartDate + '\'' +
                ", EndDate='" + EndDate + '\'' +
                ", ExtendedDate='" + ExtendedDate + '\'' +
                ", BusinessReason='" + BusinessReason + '\'' +
                ", Status='" + Status + '\'' +
                ", ExpiryReason='" + ExpiryReason + '\'' +
                ", GatePass='" + GatePass + '\'' +
                ", ActionByName='" + ActionByName + '\'' +
                ", Action_Date='" + Action_Date + '\'' +
                ", RequestId='" + RequestId + '\'' +
                ", Location='" + Location + '\'' +
                ", DSId='" + DSId + '\'' +
                ", IMT='" + IMT + '\'' +
                ", IMT1='" + IMT1 + '\'' +
                ", IMT2='" + IMT2 + '\'' +
                '}';
    }
}
