package com.itrum.wallet.repository;


import com.itrum.wallet.model.Wallet;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository

public interface WalletRepository extends JpaRepository<Wallet, Long> {

}
