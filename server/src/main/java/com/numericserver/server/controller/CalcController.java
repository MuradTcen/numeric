package com.numericserver.server.controller;

import com.numericserver.server.service.CalcService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/calc")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000", "localhost:3000"})
public class CalcController {

    private final CalcService calcServiceImpl;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public int sum() {
        return calcServiceImpl.calcNumbers().orElse(0);
    }

}
