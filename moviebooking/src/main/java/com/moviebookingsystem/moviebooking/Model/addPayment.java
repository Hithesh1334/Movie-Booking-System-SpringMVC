package com.moviebookingsystem.moviebooking.Model;

import jakarta.persistence.*;

@Entity
@Table(name="transaction")
public class addPayment {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String cardno;

    private String expirydate;

    private int cvv;

    private String cardtype;

    private String nameoncard;
    
    

    public addPayment(){

    }

    public addPayment(String cardno, String expirydate, int cvv, String cardtype, String nameoncard, int id) {
        this.cardno = cardno;
        this.expirydate = expirydate;
        this.cvv = cvv;
        this.cardtype = cardtype;
        this.nameoncard = nameoncard;
        this.id = id;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getNameoncard() {
        return nameoncard;
    }

    public void setNameoncard(String nameoncard) {
        this.nameoncard = nameoncard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
