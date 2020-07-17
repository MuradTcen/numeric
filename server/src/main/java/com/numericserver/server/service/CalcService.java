package com.numericserver.server.service;

import java.util.List;
import java.util.Optional;

public interface CalcService {

    List<Integer> getNumbers();

    Optional<Integer> calcNumbers();
}
