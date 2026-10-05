package com.modelrouter.queryrouter.input;

import com.modelrouter.queryrouter.pinecone.PineconeBenchmarkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/query")
public class QueryInputController {

    private final PineconeBenchmarkService pineconeBenchmarkService;

    public QueryInputController(PineconeBenchmarkService pineconeBenchmarkService) {
        this.pineconeBenchmarkService = pineconeBenchmarkService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> captureQuery(@RequestBody Map<String, String> payload) {
        String query = payload.get("query");
        if (query == null || query.isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "query is required"));
        }

        return ResponseEntity.ok(pineconeBenchmarkService.routeWithMmluBenchmark(query));
    }
}
