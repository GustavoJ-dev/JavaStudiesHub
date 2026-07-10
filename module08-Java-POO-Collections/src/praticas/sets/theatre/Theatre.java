package praticas.sets.theatre;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Representa um teatro contendo um conjunto de assentos organizados
 * por fileiras.
 *
 * A classe permite visualizar o mapa de assentos, reservar um único
 * assento ou reservar um grupo de assentos contíguos dentro de um
 * intervalo especificado.
 *
 */
public class Theatre {

    /**
     * Representa um assento do teatro.
     *
     * Cada assento possui um identificador único formado pela fileira
     * e pelo número do assento, além de armazenar seu estado de reserva.
     */
    class Seat implements Comparable<Seat> {

        /** Identificador único do assento. */
        private String seatNum;

        /** Indica se o assento está reservado. */
        private boolean reserved;

        /**
         * Cria um novo assento.
         *
         * @param rowChar letra da fileira.
         * @param seatNo número do assento.
         */
        public Seat(char rowChar, int seatNo) {
            this.seatNum = "%c%03d".formatted(rowChar, seatNo).toUpperCase();
        }

        /**
         * Retorna a identificação do assento.
         *
         * @return identificação do assento.
         */
        @Override
        public String toString() {
            return seatNum;
        }

        /**
         * Compara dois assentos com base em sua identificação.
         *
         * @param o assento a ser comparado.
         * @return valor negativo, zero ou positivo conforme a ordenação.
         */
        @Override
        public int compareTo(Seat o) {
            return seatNum.compareTo(o.seatNum);
        }
    }

    /** Nome do teatro. */
    private String theatreName;

    /** Quantidade de assentos por fileira. */
    private int seatsPerRow;

    /** Conjunto ordenado de assentos do teatro. */
    private NavigableSet<Seat> seats;

    /**
     * Cria um teatro com a quantidade de fileiras e assentos informada.
     *
     * @param theatreName nome do teatro.
     * @param rows quantidade de fileiras.
     * @param totalSeats quantidade total de assentos.
     */
    public Theatre(String theatreName, int rows, int totalSeats) {

        this.theatreName = theatreName;
        this.seatsPerRow = totalSeats / rows;

        seats = new TreeSet<>();

        for (int i = 0; i < totalSeats; i++) {

            char rowChar = (char) (i / seatsPerRow + (int) 'A');
            int seatInRow = i % seatsPerRow + 1;
            seats.add(new Seat(rowChar, seatInRow));
        }
    }

    /**
     * Exibe no console o mapa completo de assentos do teatro,
     * indicando quais estão reservados.
     */
    public void printSeatMap() {

        String separatorLine = "-".repeat(90);
        System.out.printf("%1$s%n%2$s Mapa de assento%n%1$s%n",
                separatorLine, theatreName);

        int index = 0;
        for (Seat s : seats) {

            System.out.printf("%-8s%s",
                    s.seatNum + ((s.reserved) ? "(●)" : ""),
                    ((index++ + 1) % seatsPerRow == 0) ? "\n" : "");
        }
        System.out.println(separatorLine);
    }

    /**
     * Tenta reservar um único assento.
     *
     * @param row fileira desejada.
     * @param seat número do assento.
     * @return a identificação do assento reservado ou {@code null}
     * caso a reserva não seja realizada.
     */
    public String reserveSeat(char row, int seat) {

        Seat requestedSeat = new Seat(row, seat);
        Seat requested = seats.ceiling(requestedSeat);

        if (requested == null || !requested.seatNum
                .equals(requestedSeat.seatNum)) {

            System.out.printf("--> Assento inexistente: " + requestedSeat);
            System.out.printf(": O assento deve estar entre %s e %s%n",
                    seats.first().seatNum, seats.last().seatNum);

        } else {

            if (!requested.reserved) {

                requested.reserved = true;
                return requested.seatNum;

            } else {

                System.out.println("Assento já foi reservado!");
            }
        }
        return null;
    }

    /**
     * Valida os parâmetros utilizados na reserva de múltiplos assentos.
     *
     * @param count quantidade de assentos desejada.
     * @param first primeira fileira considerada.
     * @param last última fileira considerada.
     * @param min menor número de assento permitido.
     * @param max maior número de assento permitido.
     * @return {@code true} se os parâmetros forem válidos;
     * {@code false} caso contrário.
     */
    public boolean validate(int count, char first, char last,
                            int min, int max) {

        boolean result = (min > 0 || seatsPerRow >= count || (max - min + 1) >= count);
        result = result && seats.contains(new Seat(first, min));

        if (!result) {

            System.out.printf("Inválido! %1$d assentos entre " +
                            "%2$c[%3$d-%4$d]-%5$c[%3$d-%4$d] Tente de novo ",
                    count, first, min, max, last);

            System.out.printf(": O assento deve estar entre %s e %s%n",
                    seats.first().seatNum, seats.last().seatNum);
        }

        return result;
    }

    /**
     * Procura e reserva um grupo de assentos contíguos dentro do
     * intervalo informado.
     *
     * @param count quantidade de assentos desejada.
     * @param minRow primeira fileira da busca.
     * @param maxRow última fileira da busca.
     * @param minSeat menor número de assento considerado.
     * @param maxSeat maior número de assento considerado.
     * @return um conjunto contendo os assentos reservados ou
     * {@code null} caso não seja possível realizar a reserva.
     */
    public Set<Seat> reserveSeats(int count, char minRow, char maxRow,
                                  int minSeat, int maxSeat) {

        char lastValid = seats.last().seatNum.charAt(0);
        maxRow = (maxRow < lastValid) ? minRow : lastValid;

        if (!validate(count, minRow, maxRow, minSeat, maxSeat)) {
            return null;
        }

        NavigableSet<Seat> selected = null;

        for (char letter = minRow; letter <= maxRow; letter++) {

            NavigableSet<Seat> contiguous = seats.subSet(
                    new Seat(letter, minSeat), true,
                    new Seat(letter, maxSeat), true);

            int index = 0;
            Seat first = null;

            for (Seat current : contiguous) {

                if (current.reserved) {
                    index = 0;
                    continue;
                }

                first = (index == 0) ? current : first;

                if (++index == count) {

                    selected = contiguous.subSet(first, true,
                            current, true);
                    break;
                }
            }

            if (selected != null) {
                break;
            }
        }

        Set<Seat> reservedSeats = null;

        if (selected != null) {

            selected.forEach(s -> s.reserved = true);
            reservedSeats = new TreeSet<>(selected);
        }

        return reservedSeats;
    }
}
