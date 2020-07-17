package com.numericserver.server.service.impl;

import com.numericserver.server.service.NumericService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class NumericServiceImpl implements NumericService {

    @Override
    public List<Integer> getNumbers(int leftBound, int rightBound) {
        int firstNumber = leftBound + (int) (Math.random() * rightBound);
        int secondNumber = leftBound +  (int) (Math.random() * rightBound);

        return Stream.of(firstNumber, secondNumber)
                .collect(Collectors.toList());
    }


}
