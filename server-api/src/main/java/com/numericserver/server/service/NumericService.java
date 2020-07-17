package com.numericserver.server.service;

import java.util.List;

public interface NumericService {

    List<Integer> getNumbers(int rightBound, int leftBound);
}
