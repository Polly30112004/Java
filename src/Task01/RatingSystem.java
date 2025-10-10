package Task01;

import java.util.*;

public class RatingSystem {
    private Map<String, Player> players; // ник -> игрок
    private Set<String> allGames;

    public RatingSystem() {
        this.players = new HashMap<>();
        this.allGames = new HashSet<>();
    }

    // Регистрация игрока
    public boolean registerPlayer(String nickname) {
        if (nickname == null || nickname.trim().isEmpty()) {
            throw new IllegalArgumentException("Никнейм не может быть пустым");
        }
        String nick = nickname.trim();
        if (players.containsKey(nick)) {
            return false; // Ник занят
        }
        players.put(nick, new Player(nick));
        return true;
    }

    // Добавление рейтинга
    public boolean addRating(String nickname, String game, int points) {
        Player player = players.get(nickname);
        if (player == null) {
            return false; // Игрок не найден
        }
        player.addRating(game, points);
        allGames.add(game);
        return true;
    }

    // Получение списка всех игр
    public Set<String> getAllGames() {
        return new HashSet<>(allGames);
    }

    // Получение рейтинга игрока по игре
    public int getPlayerRating(String nickname, String game) {
        Player player = players.get(nickname);
        return player != null ? player.getRating(game) : -1;
    }

    // Топ-10 игроков в конкретной игре
    public List<Player> getTopPlayersByGame(String game, int limit) {
        return players.values().stream()
                .filter(p -> p.getRating(game) > 0)
                .sorted((p1, p2) -> Integer.compare(p2.getRating(game), p1.getRating(game)))
                .limit(limit)
                .toList();
    }

    // Топ-10 игроков по общему рейтингу
    public List<Player> getTopPlayersOverall(int limit) {
        return players.values().stream()
                .sorted((p1, p2) -> Integer.compare(p2.getTotalRating(), p1.getTotalRating()))
                .limit(limit)
                .toList();
    }

    // Проверка занятости ника
    public boolean isNicknameTaken(String nickname) {
        return players.containsKey(nickname);
    }

    // Получение игрока
    public Player getPlayer(String nickname) {
        return players.get(nickname);
    }

    // Получение всех игроков
    public Collection<Player> getAllPlayers() {
        return new ArrayList<>(players.values());
    }
}