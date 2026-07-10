package praticas.javaLists.exercise45;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Representa um álbum de música contendo uma coleção de canções.
 *
 * Esta classe gerencia um álbum com nome, artista e uma lista de canções.
 * Fornece operações para adicionar canções e criar listas de reprodução.
 */
public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    /**
     * Constrói um novo álbum com nome, artista e lista de canções.
     *
     * @param name   O nome do álbum
     * @param artist O artista ou compositor do álbum
     * @param songs  Uma lista de canções que pertencem ao álbum
     */
    public Album(String name, String artist, ArrayList<Song> songs) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>(songs);
    }

    /**
     * Adiciona uma nova canção ao álbum.
     *
     * A canção será adicionada apenas se não existir uma canção com o mesmo título.
     *
     * @param title    O título da nova canção
     * @param duration A duração da canção em minutos
     * @return {@code true} se a canção foi adicionada com sucesso, {@code false} se já existe
     */
    public boolean addSong(String title, double duration){
        if (findSong(title) == null){
            Song song = new Song(title, duration);
            songs.add(song);
            return true;
        }
        return false;
    }

    /**
     * Procura uma canção no álbum pelo título.
     *
     * @param title O título da canção a procurar
     * @return A canção encontrada ou {@code null} se não existir
     */
    private Song findSong(String title){
        for(int i = 0; i < songs.size(); i++){
            Song song = songs.get(i);
            if (song.getTitle().equals(title)){
                return song;
            }
        }
        return null;
    }

    /**
     * Adiciona uma canção do álbum a uma lista de reprodução pelo título.
     *
     * @param title    O título da canção a adicionar
     * @param playList A lista de reprodução à qual a canção será adicionada
     * @return {@code true} se a canção foi encontrada e adicionada, {@code false} caso contrário
     */
    public boolean addToPlayList(String title, LinkedList<Song> playList){
        Song checkSound = findSong(title);
        if (checkSound != null){
            playList.add(checkSound);
            return true;
        }
        return false;
    }

    /**
     * Adiciona uma canção do álbum a uma lista de reprodução pelo número da faixa.
     *
     * O número da faixa é 1-indexado (a primeira música tem número 1).
     *
     * @param trackNumber O número da faixa (1-indexado)
     * @param playList    A lista de reprodução à qual a canção será adicionada
     * @return {@code true} se a faixa era válida e foi adicionada, {@code false} caso contrário
     */
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber - 1;
        if (index >= 0 && index < songs.size()){
            playList.add(songs.get(index));
            return true;
        }
        return false;
    }

    /**
     * Retorna uma representação em string do álbum.
     *
     * @return Uma string contendo nome, artista e lista de canções
     */
    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", songs=" + songs +
                '}';
    }
}
