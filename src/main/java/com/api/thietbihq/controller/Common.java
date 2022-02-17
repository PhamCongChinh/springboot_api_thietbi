package com.api.thietbihq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class Common {

    @GetMapping("/home")
    public ResponseEntity<?> home(){
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyAuthority('USER_READ')")
    public ResponseEntity<?> user(){
        return ResponseEntity.ok("Hello User");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('USER_READ')")
    public ResponseEntity<?> admin(){
        return ResponseEntity.ok("Hello Admin");
    }
}
