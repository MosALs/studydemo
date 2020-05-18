package app.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name="transactions")
@Table(schema = "dbo")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="trans_no")
    private String transNo;

    @Column(name="trans_type")
    private String transType;

    @Column(name="trans_date")
    private String transDate;


    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "report_id")
    @JsonBackReference
    private Report report;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

//    @JsonIgnore
    public Report getReport() {

        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

//    public int getReportId(){
//        return report.getId();
//    }

}

