public class W1Problem1 {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove))
            return "Draw";

        boolean playerWins = (playerMove.equalsIgnoreCase("Rock")
                && computerMove.equalsIgnoreCase("Scissors"))
                || (playerMove.equalsIgnoreCase("Paper")
                && computerMove.equalsIgnoreCase("Rock"))
                || (playerMove.equalsIgnoreCase("Scissors")
                && computerMove.equalsIgnoreCase("Paper"));

        return playerWins ? "Player Wins" : "Computer Wins";
    }

    public static void main(String[] args) {
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] computerMoves = new String[5];
        String[] results = new String[5];
        String[] moves = {"Rock", "Paper", "Scissors"};
        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < playerMoves.length; i++) {
            computerMoves[i] = moves[(int) (Math.random() * moves.length)];
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            switch (results[i]) {
                case "Player Wins" -> wins++;
                case "Computer Wins" -> losses++;
                default -> draws++;
            }
        }

        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < playerMoves.length; i++)
            System.out.println((i + 1) + " | " + playerMoves[i] + " | "
                    + computerMoves[i] + " | " + results[i]);

        double winPercentage = wins * 100.0 / playerMoves.length;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
    }
}
