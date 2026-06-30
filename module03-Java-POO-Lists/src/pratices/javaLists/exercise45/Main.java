package pratices.javaLists.exercise45;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Aplicação de gerenciamento de álbuns e músicas.
 *
 * Esta classe demonstra o uso de coleções (ArrayList e LinkedList) para
 * gerenciar álbuns de música, adicionar canções e criar listas de reprodução.
 */
public class Main {
    /**
     * Ponto de entrada principal da aplicação.
     *
     * Cria exemplos de álbuns de diferentes gêneros e demonstra
     * as operações de adição de canções e gerenciamento de listas de reprodução.
     */
    public static void main(String[] args) {

        Album album = new Album("Internacionais", "Kate Parry", new ArrayList<>(List.of(
                new Song("fire Work", 5.00)
        )));

        LinkedList<Song> songs = new LinkedList<>(List.of(
                new Song("California girls", 3.00),
                new Song("Bad girl", 4.00)
        ));

        album.addSong("Last Friday night", 6.00);
        album.addToPlayList("FireWork",  songs);

        System.out.println(songs);
        System.out.println(album);
        printAlbums("rap");



    }

    /**
     * Exibe um álbum de acordo com o tipo especificado.
     *
     * Suporta três tipos de álbum: "GOSPEL", "RAP" e "HINO".
     * Cada tipo contém um álbum pré-carregado com canções.
     *
     * @param type O tipo de álbum a exibir (gospel, rap ou hino)
     */
    public static void printAlbums(String type){
        Song hino1 = new Song("Hino Nacional Brasileiro", 1.5);
        Song hino2 = new Song("Hino da Independência", 2.0);
        Song hino3 = new Song("Hino à Bandeira", 2.3);
        Song hino4 = new Song("Hino da Proclamação da República", 2.1);
        Song hino5 = new Song("Hino da Bahia", 2.4);

        Album hinoshalbum = new Album("Hinos Brasileiros", "Diversos", new ArrayList<>(
                List.of(hino1, hino2, hino3, hino4, hino5)
        ));


        Song rap1 = new Song("Godzilla", 3.5);
        Song rap2 = new Song("Lose Yourself", 5.2);
        Song rap3 = new Song("Rap God", 6.0);
        Song rap4 = new Song("SICKO MODE", 5.1);
        Song rap5 = new Song("HUMBLE.", 2.9);

        Album rapAlbum = new Album("Raps", "Eminem", new ArrayList<>(
                List.of(rap1,rap2, rap3, rap4, rap5)
        ));


        Song gospel1 = new Song("Galileu", 3.5);
        Song gospel2 = new Song("Ninguém Explica Deus", 4.8);
        Song gospel3 = new Song("Lugar Secreto", 4.5);
        Song gospel4 = new Song("A Casa é Sua", 6.2);
        Song gospel5 = new Song("Porque Ele Vive", 3.8);

        Album gospelAlbum = new Album("Gospel", "Fernandinho", new ArrayList<>(
                List.of(gospel1, gospel2, gospel3, gospel4, gospel5)
        ));

        switch (type.toUpperCase()){

            case "GOSPEL" -> {
                System.out.println(gospelAlbum);
            }
            case "RAP" -> {
                System.out.println(rapAlbum);
            }
            case "HINO" -> {
                System.out.println(hinoshalbum);
            }

            default -> {
                System.out.println("Invalid type");
            }
        }
    }
}
