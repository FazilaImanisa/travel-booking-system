public class ReservationNotFoundException extends Exception {
    public ReservationNotFoundException(String confirmationNumber) {
        super("Reservasi dengan nomor konfirmasi \"" + confirmationNumber + "\" tidak ditemukan.");
    }
}