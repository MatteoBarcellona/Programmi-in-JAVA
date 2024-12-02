import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SistemaPenalità {
    public static double calcolaPenalità(Prestito prestito) {
        if (prestito.isInRitardo()) {
            long giorniInRitardo = ChronoUnit.DAYS.between(prestito.getDataRestituzione(), LocalDate.now());
            return giorniInRitardo * 0.5;
        }
        return 0;
    }
}
