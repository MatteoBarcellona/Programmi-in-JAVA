import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Calendar;

public class Prestito {
    private Libro libro;
    private Utente utente;
    private Date dataPrestito;
    private Date dataRestituzione;

    public Prestito(Libro libro, Utente utente) {
        this.libro = libro;
        this.utente = utente;
        this.dataPrestito = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.dataPrestito);
        cal.add(Calendar.DAY_OF_YEAR, 14);
        this.dataRestituzione = cal.getTime();
        libro.incrementaPrestiti();
    }

    public Temporal getDataRestituzione() {
        return (Temporal) dataRestituzione;
    }

    @Override
    public String toString() {
        return libro.getTitolo() + " preso da " + utente.getNome() + " il " + dataPrestito.toString();
    }

    public boolean isInRitardo() {
        return dataPrestito.after(dataRestituzione);
    }
}
