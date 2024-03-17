package com.itrum.wallet.controller;

import com.itrum.wallet.model.Wallet;
import com.itrum.wallet.repository.WalletRepository;
import com.itrum.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class WalletController {

    private final WalletRepository walletRepository;
    private final WalletService walletService;

    @Autowired
    public WalletController(WalletRepository walletRepository, WalletService walletService) {
        this.walletRepository = walletRepository;
        this.walletService = walletService;
    }


    @GetMapping("/wallets/{id}")
    public ResponseEntity<Wallet> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(walletService.findById(id));
    }


    @PostMapping("/wallet")
    public ResponseEntity<Wallet> update(@RequestBody String json) {
        return ResponseEntity.ok(walletService.update(json));
    }

}
