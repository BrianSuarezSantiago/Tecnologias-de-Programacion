package games;

public class Game {
    private final String gameTitle, gameDeveloper, gamePlatform;
    private final int gameRecommendedAge;

    /**
     * Constructor que inicializa un objeto de la
     * clase Game el cual representa un juego.
     *
     * @param gameTitle Título del juego.
     * @param gameDeveloper Desarrollador del juego.
     * @param gamePlatform Plataforma en la que se distribuye el juego.
     * @param gameRecommendedAge Edad recomendad para jugar al juego.
     */
    public Game(String gameTitle, String gameDeveloper, String gamePlatform, int gameRecommendedAge) {
        this.gameTitle = gameTitle;
        this.gameDeveloper = gameDeveloper;
        this.gamePlatform = gamePlatform;
        this.gameRecommendedAge = gameRecommendedAge;
    }

    /**
     * Devuelve el título de un juego.
     *
     * @return Título del juego.
     */
    public String getTitle() {
        return this.gameTitle;
    }

    /**
     * Devuelve el desarrollador del juego.
     *
     * @return Desarrollador del juego.
     */
    public String getDeveloper() {
        return this.gameDeveloper;
    }

    /**
     * Devuelve la plataforma en la
     * que se distribuye el juego.
     *
     * @return Plataforma en la que se distribuye el juego.
     */
    public String getPlatform() {
        return this.gamePlatform;
    }

    /**
     * Devuelve la edad recomendada
     * para jugar al juego.
     *
     * @return Edad recomendada para jugar.
     */
    public int getRecommendedAge() {
        return this.gameRecommendedAge;
    }

    /**
     * Devuelve una string con
     * un formato determinado.
     *
     * @return String formada por la concatenación del título del juego,
     * el desarrollador, la plataforma y la edad separados entre ellos
     * por el carácter espacio seguido de una barra vertical y de otro
     * espacio, (" | ").
     */
    @Override
    public String toString() {
        return this.gameTitle + " | " + this.gameDeveloper + " | " + this.gamePlatform + " | " + this.gameRecommendedAge;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Game))  {
            return false;
        } else {
            return ((Game) obj).getTitle().equalsIgnoreCase(this.gameTitle);
//            && ((Game)obj).getPlatform().equalsIgnoreCase(this.gamePlatform);
        }
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        return PRIME * this.gameTitle.hashCode() * this.gamePlatform.hashCode();
    }
}