package com.digi.pay.view_models;

public class TransactionData {

    String Name;
    String time;
    String credit;
    String debit;

    public TransactionData(String Name,String time,String credit,String debit)
    {
        this.Name = Name;
        this.time = time;
        this.credit = credit;
        this.debit = debit;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }
}
