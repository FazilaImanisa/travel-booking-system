import java.util.Random;

public final class ConfirmationUtil {
    private static Random random = new Random();

    private ConfirmationUtil() {
    }

    public static int generateConfirmationNumber() {
        return 100000 + random.nextInt(900000);
    }
}