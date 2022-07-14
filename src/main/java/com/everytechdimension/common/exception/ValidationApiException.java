package com.everytechdimension.common.exception;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.List;

public class ValidationApiException extends AppApiException {
    private final List<String> problems;

    public ValidationApiException(List<String> problem) {
        super(AppApiException.ErrorCode.VALIDATION, "Validation Error");
        this.problems = problem;
    }

    public HashMap toJson() {
        HashMap<String, Object> map = super.toJson();
        JSONArray arr = new JSONArray();
        for (String s : problems)
            arr.put(s);
        map.put("problems", arr);
        return map;
    }
}
