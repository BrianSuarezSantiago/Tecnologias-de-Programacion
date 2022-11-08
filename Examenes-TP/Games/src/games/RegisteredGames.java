package games;

import java.util.*;
import java.util.stream.Collectors;

public class RegisteredGames {
    private Set<Game> games = new HashSet<>();
    private int order;

    /**
     * Añade un nuevo juego no repetido y devuelve verdadero.
     * Si ya existe, no lo añade y devuelve falso.
     *
     * @param game Juego a añadir.
     * @return Verdadero si
     */
    public boolean add(Game game) {
        /*
        Cannot check if the collection contains the object "game"
        passed as argument because it will only check if there is
        an object in the set whose attributes are all the same.
         */
        for (Game i : this.games) {
            if (i.getTitle().equalsIgnoreCase(game.getTitle()) && i.getPlatform().equalsIgnoreCase(game.getPlatform())) {
                return false;
            }
        }
        this.games.add(game);
        return true;
    }

    /**
     * Elimina el juego que tenga el título y la plataforma
     * pasados por parámetros. Devuelve verdadero si lo
     * elimina y falso si no se encuentra.
     *
     * @param gameTitle    Título del juego a eliminar.
     * @param gamePlatform Plataforma en la que se distribuye el juego a eliminar.
     * @return
     */
    public boolean remove(String gameTitle, String gamePlatform) {
        return this.games.removeIf(i -> i.getTitle().equalsIgnoreCase(gameTitle) && i.getPlatform().equalsIgnoreCase(gamePlatform));
//        for(Game i : this.games) {
//            if(i.getTitle().equalsIgnoreCase(gameTitle) && i.getPlatform().equalsIgnoreCase(gamePlatform)) {
//                this.games.remove(i);
//                return true;
//            }
//        }
//        return false;
    }

    /**
     * Establece el orden en que se genera el listado de
     * juegos con el método getList().
     * <p>
     * order=0: Por título y plataforma
     * order=1: Por edad, título y plataforma
     *
     * @param order Orden a establecer.
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * Devuelve la lista de juegos en el orden establecido
     * por el método setOrder().
     *
     * @return Lista de juegos en el orden establecido por setOrder().
     */
    public List<Game> getList() {
        List<Game> sortedGames = new ArrayList<>(this.games);

        if(this.order == 0) {
            return sortedGames.stream().sorted(Comparator.comparing(Game::getTitle)
                            .thenComparing(Game::getPlatform))
                    .collect(Collectors.toList());
        } else {
            return sortedGames.stream().sorted(Comparator.comparing(Game::getRecommendedAge)
                            .thenComparing(Game::getTitle)
                            .thenComparing(Game::getPlatform))
                    .collect(Collectors.toList());
        }
    }

    /**
     * Devuelve un conjunto de ristras en orden alfabético.
     * Cada ristra es la concatenación del nombre de la
     * plataforma seguido del carácter dos puntos (":")
     * y seguido del número de juegos para dicha plataforma.
     *
     * @return Conjunto de ristras con el formato especificado.
     */
    public Set<String> getListPlatforms() {
        Set<String> sortedPlatforms = new HashSet<>();

        for (Game i : this.games) {
            sortedPlatforms.add(i.getPlatform() + ":" +
                    this.games.stream().filter(x -> x.getPlatform().equals(i.getPlatform())).count());  // TODO: equalIgnoreCase
        }
        return sortedPlatforms;
    }

    /**
     * Devuelve la lista de juegos en el orden establecido y
     * separados por saltos de línea. La información que se
     * muestra de cada juego es su método toString().
     *
     * @return String con el formato especificado.
     */
    @Override
    public String toString() {
        return this.games.stream().map(Game::toString).collect(Collectors.joining("\n"));
    }
}

/*
 ALTERNATIVA AL MÉTODO getList()
    public List<Game> getList() {
        List<Game> sortedGames = new ArrayList<>(this.games);

        if (this.order == 0) {
            Collections.sort(sortedGames, new Comparator<Game>() {
                @Override
                public int compare(Game o1, Game o2) {
                    if (o1.getTitle().equalsIgnoreCase(o2.getTitle())) {
                        return o1.getPlatform().compareToIgnoreCase(o2.getPlatform());
                    } else {
                        return o1.getTitle().compareToIgnoreCase(o2.getTitle());
                    }
                }
            });
            return sortedGames;
        } else {
            Collections.sort(sortedGames, new Comparator<Game>() {
                @Override
                public int compare(Game o1, Game o2) {
                    if(o1.getPlatform().equalsIgnoreCase(o2.getPlatform())) {
                        return o1.getTitle().compareToIgnoreCase(o2.getTitle());
                    } else {
                        return o1.getRecommendedAge() - o2.getRecommendedAge();
                    }
                }
            });
            return sortedGames;
        }
    }
*/