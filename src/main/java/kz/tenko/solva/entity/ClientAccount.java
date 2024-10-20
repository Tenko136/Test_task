package kz.tenko.solva.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "client_account")
public class ClientAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "num")
    private String num;

    @Column(name = "currency")
    private String currency;


    public ClientAccount() {
    }

    public ClientAccount(String num, String currency) {
        this.num = num;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
