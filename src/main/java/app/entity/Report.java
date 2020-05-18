package app.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(schema = "dbo")

public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(name="action")
    private String action;

    @Column(name="reason")
    private String reason ;


    @OneToMany(mappedBy = "report" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @Column(nullable = true)
    @JsonManagedReference
    private List<Transactions> transactions;



    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }




}
