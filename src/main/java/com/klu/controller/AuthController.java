package com.klu.controller;

import com.klu.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> user) {

        String email = user.get("email");
        String password = user.get("password");

        // 🔍 Debug logs
        System.out.println("EMAIL: " + email);
        System.out.println("PASSWORD: " + password);

        Map<String, String> res = new HashMap<>();

        // ✅ ADMIN
        if ("admin@gmail.com".equals(email) && "1234".equals(password)) {
            String token = jwtUtil.generateToken(email);
            res.put("token", token);
            res.put("role", "admin");
            return res;
        }

        // ✅ ANALYST
        if ("analyst@gmail.com".equals(email) && "1234".equals(password)) {
            String token = jwtUtil.generateToken(email);
            res.put("token", token);
            res.put("role", "analyst");
            return res;
        }

        // ✅ OBSERVER
        if ("observer@gmail.com".equals(email) && "1234".equals(password)) {
            String token = jwtUtil.generateToken(email);
            res.put("token", token);
            res.put("role", "observer");
            return res;
        }

        // ✅ CITIZEN (DEFAULT ROLE)
        if (email != null && email.endsWith("@gmail.com") && "1234".equals(password)) {
            String token = jwtUtil.generateToken(email);
            res.put("token", token);
            res.put("role", "citizen");
            return res;
        }

        // ❌ INVALID LOGIN
        throw new RuntimeException("Invalid credentials");
    }
}