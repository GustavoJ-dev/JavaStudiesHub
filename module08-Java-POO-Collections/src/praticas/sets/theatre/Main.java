package praticas.sets.theatre;



public class Main {
    public static void main(String[] args) {

        int rows = 10;
        int totalSeats = 100;

        Theatre municipalSP = new Theatre(
                "Theatro Municipal de São Paulo",
                rows,
                totalSeats
        );

        municipalSP.printSeatMap();

        System.out.println("\n========== Testes do método reserveSeat ==========\n");

        // Reserva válida
        BookingAgent.bookSeat(municipalSP, 'A', 3);

        // Tentativa de reservar o mesmo assento
        BookingAgent.bookSeat(municipalSP, 'A', 3);

        // Reserva válida
        BookingAgent.bookSeat(municipalSP, 'B', 1);

        // Número de assento inexistente
        BookingAgent.bookSeat(municipalSP, 'B', 11);

        // Fileira inexistente
        BookingAgent.bookSeat(municipalSP, 'M', 1);

        System.out.println("\n========== Testes do método reserveSeats ==========\n");

        // Reserva de 4 assentos na mesma fileira
        BookingAgent.bookSeats(municipalSP, 4, 'B', 3, 10);

        // Reserva de 6 assentos entre as fileiras B e C
        BookingAgent.bookSeats(municipalSP, 6, 'B', 'C', 3, 10);

        // Reserva de 4 assentos na fileira B
        BookingAgent.bookSeats(municipalSP, 4, 'B', 1, 10);

        // Reserva de 4 assentos entre B e C
        BookingAgent.bookSeats(municipalSP, 4, 'B', 'C', 1, 10);

        // Reserva de apenas 1 assento
        BookingAgent.bookSeats(municipalSP, 1, 'B', 'C', 1, 10);

        // Intervalo de fileiras inválido
        BookingAgent.bookSeats(municipalSP, 4, 'M', 'Z', 1, 10);

        // Reserva de uma fileira inteira
        BookingAgent.bookSeats(municipalSP, 10, 'A', 'E', 1, 10);    }
}