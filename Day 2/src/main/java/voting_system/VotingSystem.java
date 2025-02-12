package voting_system;


import java.util.*;
class VotingSystem {
    private Map<String, Integer> votes = new HashMap<>();
    private Map<String, Integer> orderedVotes = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedVotes = new TreeMap<>();

    public void castVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        orderedVotes.put(candidate, orderedVotes.getOrDefault(candidate, 0) + 1);
        sortedVotes.put(candidate, sortedVotes.getOrDefault(candidate, 0) + 1);
    }

    public void displayResults() {
        System.out.println("Unordered Votes: " + votes);
        System.out.println("Ordered Votes: " + orderedVotes);
        System.out.println("Sorted Votes: " + sortedVotes);
    }

    public static void main(String[] args) {
        VotingSystem voting = new VotingSystem();
        voting.castVote("Alice");
        voting.castVote("Bob");
        voting.castVote("Alice");

        voting.displayResults();
    }
}
