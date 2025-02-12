package kz.tenko.solva.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client_account")
@Data
@NoArgsConstructor
public class ClientAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "num")
    private String num;

    @Column(name = "currency")
    private String currency;

    public ClientAccount(String num, String currency) {
        this.num = num;
        this.currency = currency;
    }

}
