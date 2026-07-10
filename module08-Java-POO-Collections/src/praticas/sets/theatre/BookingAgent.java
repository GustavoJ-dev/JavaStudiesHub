package praticas.sets.theatre;


/**
 * Classe utilitária responsável por realizar reservas de assentos.
 * <p>
 * Fornece métodos estáticos para reservar um único assento ou um grupo
 * de assentos contíguos em um teatro, exibindo o resultado da operação
 * no console.
 *
 */
public class BookingAgent {

    /**
     * Tenta reservar um único assento no teatro informado.
     *
     * @param theatre teatro onde a reserva será realizada.
     * @param row fileira do assento desejado.
     * @param seatNo número do assento desejado.
     */
    public static void bookSeat(Theatre theatre, char row, int seatNo) {

        String seat = theatre.reserveSeat(row, seatNo);
        if (seat != null) {

            System.out.println("Parabéns! Seu assento reservado é " + seat);
            theatre.printSeatMap();

        } else {

            System.out.println("Desculpe! Não foi possível reservar. " + row + seatNo);
        }
    }

    /**
     * Tenta reservar um grupo de assentos contíguos em uma única fileira.
     * <p>
     * Este metodo delega a reserva para a versão sobrecarregada,
     * utilizando a mesma fileira como início e fim da busca.
     *
     * @param theatre teatro onde a reserva será realizada.
     * @param tickets quantidade de assentos a serem reservados.
     * @param minRow fileira onde a busca será realizada.
     * @param minSeat menor número de assento considerado.
     * @param maxSeat maior número de assento considerado.
     */
    public static void bookSeats(Theatre theatre, int tickets, char minRow,
                                 int minSeat, int maxSeat) {

        bookSeats(theatre, tickets, minRow, minRow, minSeat, maxSeat);
    }

    /**
     * Tenta reservar um grupo de assentos contíguos dentro do intervalo
     * de fileiras e assentos informado.
     *
     * @param theatre teatro onde a reserva será realizada.
     * @param tickets quantidade de assentos a serem reservados.
     * @param minRow primeira fileira a ser considerada.
     * @param maxRow última fileira a ser considerada.
     * @param minSeat menor número de assento considerado.
     * @param maxSeat maior número de assento considerado.
     */
    public static void bookSeats(Theatre theatre, int tickets,
                                 char minRow, char maxRow,
                                 int minSeat, int maxSeat) {

        var seats =
                theatre.reserveSeats(tickets, minRow, maxRow, minSeat, maxSeat);

        if (seats != null) {

            System.out.println("Parabéns! Seus assentos reservados são: " + seats);
            theatre.printSeatMap();

        } else {

            System.out.println("Desculpe! Não há assentos contíguos disponíveis nas mesmas fileiras: "
                    + minRow + " - " + maxRow);
        }
    }
}