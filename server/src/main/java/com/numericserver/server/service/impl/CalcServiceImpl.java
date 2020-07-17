package com.numericserver.server.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.numericserver.server.service.CalcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class CalcServiceImpl implements CalcService {

    @Value(value = "${api.numeric.url}")
    private String url;

    private final ObjectMapper mapper;

    @Override
    public List<Integer> getNumbers() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        log.info("Received numbers " + response);

        List<Integer> numbers = null;

        try {
            numbers = mapper.readValue(response, new TypeReference<List<Integer>>() {
            });
        } catch (JsonProcessingException e) {
            log.error("An error occurred while reading numbers " + e.getMessage());
        }

        if (numbers == null) {
            throw new ArithmeticException();
        }
        return numbers;
    }

    @Override
    public Optional<Integer> calcNumbers() {
        List<Integer> numbers = getNumbers();

        return numbers == null ? Optional.empty() :
                Optional.of(numbers.stream()
                        .mapToInt(Integer::intValue)
                        .sum()
                );
    }
}
