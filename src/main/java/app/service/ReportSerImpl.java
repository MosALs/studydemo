package app.service;

import app.entity.Report;

import app.exception.CustomException;
import app.repository.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ReportSerImpl implements ReportSer{

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Autowired
    private ReportRepo reportRepo;

    @Override
    public List<Report> getReports() {
        return reportRepo.findAll();
    }

    @Override
    public Report getReport(int reportId) {
        Optional<Report> report = reportRepo.findById(reportId);

        if(report.isPresent()){
            return report.get();
        }
        else {
            CustomException.throwExceptio("Not found!!!");
            return null;
        }
    }

    @Override
    public void addReport(Report report) {
        String reason = report.getReason();
        if(reason == null){
            CustomException.throwExceptio("reason is mandatory field, it cannot be null");
        }
        else {
            reportRepo.save(report);
        }

    }

    @Override
    public void deleteReport(int id) {
        List<Integer> ids = reportRepo.getReportsIds();
        System.out.println(ids);
        if(ids.contains(id)){
            reportRepo.deleteById(id);
        }
        else {
            CustomException.throwExceptio("report not found");
        }
    }

    @Override
    public int getReportsCount() {
        return (int)reportRepo.count();
    }

    @Override
    public List<Report> getReportsLike(String reason) {
        if(reason != null){
            return reportRepo.findByReason(reason);
        }else {
            CustomException.throwExceptio("no reason");
            return null;
        }
    }

    @Override
    public List<Report> getReportsByReasonAndAction(String r1, String a1) {
        return reportRepo.findByReasonAndAction(r1,a1);
    }

    @Override
    public void upladFile(MultipartFile file) throws IOException {


        Path copyLoaction = Paths.get(uploadDir +  File.separator + StringUtils.cleanPath(
                file.getOriginalFilename()
        ));
        Files.copy(file.getInputStream(),copyLoaction, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("uploaded ...");

    }

    @Override
    public List<Report> getReportBy(String reason, String action) {
        List<Report> reports = reportRepo.findByReasonAndAction(reason,action);
        return reports;
    }
}
