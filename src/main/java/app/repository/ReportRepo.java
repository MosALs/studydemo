package app.repository;

import app.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepo extends JpaRepository<Report,Integer> {
    @Query("select r.id from report r")
    List<Integer> getReportsIds();

    List<Report> findByReason(String reason);

    List<Report> findByReasonAndAction(String reason,String action);

//    Report findByReasonAndAction(String reason,String action);
}
