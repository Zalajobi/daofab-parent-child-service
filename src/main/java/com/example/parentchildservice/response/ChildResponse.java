package com.example.parentchildservice.response;

import java.util.List;
import java.util.Map;

public record ChildResponse(List<Map<String, Object>> data, int length, Object parent) {
}
