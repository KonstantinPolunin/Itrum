package com.itrum.wallet.service;

import com.itrum.wallet.model.Wallet;

public interface WalletService {
    Wallet findById(Long id);
    Wallet update(String json);
}
