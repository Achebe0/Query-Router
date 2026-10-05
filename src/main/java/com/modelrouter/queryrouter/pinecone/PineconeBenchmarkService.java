package com.modelrouter.queryrouter.pinecone;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PineconeBenchmarkService {

    public Map<String, Object> routeWithMmluBenchmark(String query) {
        String normalized = query.toLowerCase();

        String queryType = normalized.contains("code") || normalized.contains("debug")
                ? "code_reasoning"
                : "general_reasoning";

        String recommendedModel = "gpt-4o-mini";
        double confidence = 0.78;

        return Map.of(
                "query", query,
                "benchmarkSource", "MMLU",
                "queryType", queryType,
                "recommendedModel", recommendedModel,
                "confidence", confidence
        );
    }
}
