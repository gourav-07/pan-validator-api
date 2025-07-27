package com.example.pan_validator.controller;

import com.example.pan_validator.utils.PanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/pan")
public class PanController {

    @GetMapping("/validate")
    public ResponseEntity<Map<String, Object>> validatePan(
            @RequestParam String pan,
            @RequestParam(required = false) boolean verifyGovt) {

        boolean isValidFormat = PanUtils.isValidPanFormat(pan);
        boolean isVerified = verifyGovt && PanUtils.isGovtVerified(pan);

        Map<String, Object> response = new HashMap<>();
        response.put("pan", pan);
        response.put("is_valid_format", isValidFormat);
        response.put("is_govt_verified", verifyGovt ? isVerified : null);

        return ResponseEntity.ok(response);
    }
}

