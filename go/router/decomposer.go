package router

// BenchmarkRoutingResult represents the recommendation payload from the semantic router.
type BenchmarkRoutingResult struct {
	Query            string
	BenchmarkSource  string
	QueryType        string
	RecommendedModel string
	Confidence       float64
}

// AcceptPineconeRoutingOutput receives the semantic router output and returns it for now.
func AcceptPineconeRoutingOutput(result BenchmarkRoutingResult) BenchmarkRoutingResult {
	return result
}

// DecomposePrompt breaks a complex prompt into simpler prompts (placeholder implementation).
func DecomposePrompt(prompt string) []string {
	if prompt == "" {
		return []string{}
	}

	return []string{prompt}
}
