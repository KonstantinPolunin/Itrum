package com.itrum.wallet.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itrum.wallet.model.Wallet;
import com.itrum.wallet.repository.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    @Autowired
    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }


    @Override
    public Wallet findById(Long id) {
        Optional<Wallet> foundWallet = walletRepository.findById(id);
        return foundWallet.orElse(null);
    }


    private Wallet jsonParsing(String json) {
        Wallet wallet = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            wallet = objectMapper.readValue(json, Wallet.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return wallet;
    }


    @Override
    @Transactional
    public Wallet update(String json) {
        Wallet walletUpdate = jsonParsing(json);
        Wallet wallet = findById(walletUpdate.getId());
        switch (walletUpdate.getOperation()) {
            case DEPOSIT -> wallet.setAmount(wallet.getAmount() + walletUpdate.getAmount());
            case WITHDRAW -> wallet.setAmount(wallet.getAmount() - walletUpdate.getAmount());
        }
        walletRepository.save(wallet);
        return wallet;
    }

}
