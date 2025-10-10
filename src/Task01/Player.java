package Task01;

import java.util.*;

public class Player {
    private String nickname;
    private Set<String> games;
    private Map<String, Integer> ratings; // Игра -> рейтинг

    public Player(String nickname) {
        if (nickname == null || nickname.trim().isEmpty()) {
            throw new IllegalArgumentException("Никнейм не может быть пустым");
        }
        this.nickname = nickname.trim();
        this.games = new HashSet<>();
        this.ratings = new HashMap<>();
    }

    // Геттеры
    public String getNickname() { return nickname; }
    public Set<String> getGames() { return new HashSet<>(games); }
    public int getRating(String game) { return ratings.getOrDefault(game, 0); }
    public Map<String, Integer> getAllRatings() { return new HashMap<>(ratings); }

    // Добавление игры
    public void addGame(String game) {
        if (game != null && !game.trim().isEmpty()) {
            games.add(game.trim());
        }
    }

    // Добавление рейтинга
    public void addRating(String game, int points) {
        if (game != null && !game.trim().isEmpty() && points > 0) {
            String gameName = game.trim();
            games.add(gameName);
            ratings.put(gameName, ratings.getOrDefault(gameName, 0) + points);
        }
    }

    // Общий рейтинг по всем играм
    public int getTotalRating() {
        return ratings.values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(nickname, player.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }

    @Override
    public String toString() {
        return String.format("Игрок: %s, Игры: %s, Рейтинг: %d",
                nickname, games, getTotalRating());
    }
}
