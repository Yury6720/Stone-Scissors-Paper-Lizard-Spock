public enum Move {
    ROCK, SCISSORS, PAPER, LIZARD, SPOCK;

    /**
     * Сравнивает текущий ход с переданным в параметре otherMove и определяет
     * победу, поражение или ничью.
     *
     * @param otherMove ход, с которым сравнивается текущий
     * @return 1 если текущий ход бьет другой, -1 если другой ход бьет текущий,
     * 0 в случае ничьей
     */
    public int compareMoves(Move otherMove) {
        // Ничья
        if (this == otherMove)
            return 0;


        switch (this) {
            case ROCK:
                return ((otherMove == SCISSORS)||(otherMove == LIZARD) ? 1 : -1);
            case PAPER:
                return ((otherMove == ROCK)||(otherMove == SPOCK) ? 1 : -1);
            case SCISSORS:
                return ((otherMove == PAPER)||(otherMove == LIZARD) ? 1 : -1);
            case LIZARD:
                return ((otherMove == SPOCK)||(otherMove == PAPER) ? 1 : -1);
            case SPOCK:
                return ((otherMove == SCISSORS)||(otherMove == ROCK)  ? 1 : -1);
        }

        // Этот код не должен выполняться никогда
        return 0;
    }
}
