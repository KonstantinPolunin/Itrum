package com.itrum.wallet.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "wallets")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@OptimisticLocking(type = OptimisticLockType.VERSION)
public class Wallet {

    @Id
    private Long id;


    @Column(name = "amount")
    private Integer amount;

    public enum Operation {
        DEPOSIT, WITHDRAW
    }

    @Transient
    private Operation operation;

    /*@Version
    private Long version;*/

}
