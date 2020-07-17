package com.numericserver.server.controller;

import com.numericserver.server.service.NumericService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/numeric")
@RequiredArgsConstructor
@Validated
public class NumericController {

    private final NumericService numericService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Integer> list(@RequestParam(value = "i", defaultValue = "0", required = false) @Min(0) @Max(10) int leftBound,
                              @RequestParam(value = "i", defaultValue = "10", required = false) @Min(0) @Max(10) int rightBound) {
        return numericService.getNumbers(leftBound, rightBound);
    }

}
