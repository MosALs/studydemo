package app.controller;

import app.entity.Report;
import app.exception.CustomException;
import app.fileconfig.FileService;
import app.repository.ReportRepo;
import app.service.ReportSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class DemoController {

    @Autowired(required = true)
    private ReportSer reportSer;

//    @Autowired(required = true)
//    private ReportRepo reportRepo;
//
    @Autowired(required = true)
    private FileService fileService;

    @RequestMapping(value = "/test")
    public ResponseEntity<List<Report>> test(){

        try{
            System.out.println("hello from test");
            Set<String> s1 = new HashSet<>();
            s1.add("a");
            s1.add("c");
            s1.add("b");
            s1.add("f");
            s1.add(null);
            s1.add("e");
            System.out.println("s1 hash set=>" + s1);


            Set<String> s2 = new LinkedHashSet<>();
            s2.add("a");
            s2.add("c");
            s2.add("b");
            s2.add("f");
            s2.add(null);
            s2.add("e");
            System.out.println("s2 linked hash set=>" + s2);

            Set<String> s3 = new TreeSet<>();
            s3.add("a");
            s3.add("c");
            s3.add("b");
            s3.add("f");
            s3.add("e");
            System.out.println("s3=> tree set" + s3);

//            return new ResponseEntity<List<Report>>( reportSer.getReportsLike("r5"), HttpStatus.OK);
            return new ResponseEntity<List<Report>>( reportSer.getReportsByReasonAndAction("r1","a1"), HttpStatus.OK);

        }catch (CustomException exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR , exception.getMessage());
        }

    }

    @GetMapping(value="/reports")
    public List<Report> getReports(){
        System.out.println("get all reports");
        return reportSer.getReports();
    }

    @GetMapping(value="/report/{reportId}")
    public ResponseEntity<Report> getReport(@PathVariable int reportId){

        try {
            System.out.println("successfullllllllllll");
            return new ResponseEntity<Report>(reportSer.getReport(reportId), HttpStatus.OK);
        }
        catch  (CustomException exception){
            System.out.println("faildddddddddddddddd");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }


    }

//    @PostMapping(value = "/report")
//    public Report addReport(@RequestBody Report report){
//        try{
//            reportSer.addReport(report);
//            return report;
//        }
//        catch (CustomException exception){
//            throw new  ResponseStatusException(HttpStatus.BAD_REQUEST , exception.getMessage());
//        }
//    }

    @PutMapping(value = "/report")
    public ResponseEntity<Report> updateReport(@RequestBody Report report){
        try{
            reportSer.addReport(report);
            return new ResponseEntity<Report>(report,HttpStatus.OK);
        }
        catch (CustomException exception){
            throw new  ResponseStatusException(HttpStatus.BAD_REQUEST , exception.getMessage());
        }
    }

    @DeleteMapping(value = "/report/{id}")
    public ResponseEntity<Integer> deleteReport(@PathVariable int id){
        try{
            reportSer.deleteReport(id);
            int count = reportSer.getReportsCount();
            return new ResponseEntity<Integer>(count, HttpStatus.OK);
        }catch (CustomException exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR , exception.getMessage());
        }
    }


    @PostMapping(value = "/report")
    public List<Report> getReportBy(@RequestParam("reason") String reason,@RequestParam("action") String action){
        try{
            return reportSer.getReportBy(reason ,action);
//            int count = reportSer.getReportsCount();
//            return new ResponseEntity<Integer>(count, HttpStatus.OK);
        }catch (CustomException exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR , exception.getMessage());
        }
    }


    @PostMapping(value ="upload")
    public void upload(@RequestParam("file") MultipartFile file){
        try {
           fileService.upladFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
