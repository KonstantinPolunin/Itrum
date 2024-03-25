package com.itrum.wallet.repository;


import com.itrum.wallet.model.Wallet;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository

public interface WalletRepository extends JpaRepository<Wallet, Long> {

}
