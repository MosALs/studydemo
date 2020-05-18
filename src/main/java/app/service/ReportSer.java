package app.service;

import app.entity.Report;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ReportSer {

    public List<Report> getReports();

    Report getReport(int reportId);

    void addReport(Report report);

    void deleteReport(int id);

    int getReportsCount();

    List<Report> getReportsLike(String reason);

    List<Report> getReportsByReasonAndAction(String r1, String a1);

    void upladFile(MultipartFile file) throws IOException;

    List<Report> getReportBy(String reason, String action);
}
