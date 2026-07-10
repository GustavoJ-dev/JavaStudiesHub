package praticas.exercise49;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        songMenu(new LinkedList<>(List.of(
                new Song("Song 1", 3.5),
                new Song("Song 2", 4.0),
                new Song("Song 3", 2.8),
                new Song("Song 4", 5.2))));


    }

    public static void songMenu(LinkedList<Song> playList) {
        boolean quit = false;
        boolean goingForward = true;

        ListIterator<Song> iterator = playList.listIterator();

        if (playList.isEmpty()) {
            System.out.println("Nenhuma música na playlist.");
            return;
        } else {
            System.out.println("Tocando agora " + iterator.next());
        }

        printMenu();

        while (!quit) {

            System.out.print("\nEscolha uma opção: ");
            int action = scanner.nextInt();

            switch (action) {

                case 0 -> {
                    System.out.println("Playlist completa.");
                    quit = true;
                }

                case 1 -> { // Next song

                    if (!goingForward) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        goingForward = true;
                    }

                    if (iterator.hasNext()) {
                        System.out.println("Tocando agora " + iterator.next());
                    } else {
                        System.out.println("Você chegou ao fim da playList.");
                        goingForward = false;
                    }
                }

                case 2 -> { // Previous song

                    if (goingForward) {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        goingForward = false;
                    }

                    if (iterator.hasPrevious()) {
                        System.out.println("Tocando agora " + iterator.previous());
                    } else {
                        System.out.println("Você está no início da playlist.");
                        goingForward = true;
                    }
                }

                case 3 -> { // Replay current song

                    if (goingForward) {
                        if (iterator.hasPrevious()) {
                            System.out.println("Reproduzindo " + iterator.previous());
                            goingForward = false;
                        } else {
                            System.out.println("Você está no início da playlist.");
                        }
                    } else {
                        if (iterator.hasNext()) {
                            System.out.println("Reproduzindo " + iterator.next());
                            goingForward = true;
                        } else {
                            System.out.println("Você chegou ao fim da playlist.");
                        }
                    }
                }

                case 4 -> { // List songs

                    System.out.println("\nPlaylist:");
                    for (Song song : playList) {
                        System.out.println(song);
                    }
                }

                case 5 -> printMenu();

                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void printMenu() {

        System.out.println("""
            Available actions:
            0 - Sair
            1 - Pular para a próxima música
            2 - Pular para a música anterior
            3 - Repetir a música atual
            4 - Listar as músicas na playlist
            5 - Imprimir ações disponíveis
            """);
    }
}
