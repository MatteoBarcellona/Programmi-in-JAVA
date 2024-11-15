public class SalaCinema {
    private Posto[][] posti;

    public SalaCinema(int file, int postiPerFila) {
        posti = new Posto[file][postiPerFila];
        for (int i = 0; i < file; i++) {
            for (int j = 0; j < postiPerFila; j++) {
                posti[i][j] = new Posto(i + 1, j + 1);
            }
        }
    }

    public void prenotaPosto(int fila, int numero) {
        if (isValidPosto(fila, numero)) {
            Posto posto = posti[fila - 1][numero - 1];
            if (!posto.isOccupato()) {
                posto.prenota();
                System.out.println("prenotazione fatto");
            } else {
                System.out.println("errore: il posto è già occupato.");
            }
        }
    }

    public void annullaPrenotazionePosto(int fila, int numero) {
        if (isValidPosto(fila, numero)) {
            Posto posto = posti[fila - 1][numero - 1];
            if (posto.isOccupato()) {
                posto.annullaPrenotazione();
                System.out.println("prenotazione annullata");
            } else {
                System.out.println("errore: il posto è già libero.");
            }
        }
    }

    public void visualizzaSala() {
        System.out.println("stato della sala:");
        for (int i = 0; i < posti.length; i++) {
            System.out.print("Fila " + (i + 1) + ": ");
            for (int j = 0; j < posti[i].length; j++) {
                System.out.print(posti[i][j].toString() + " ");
            }
            System.out.println();
        }
    }

    private boolean isValidPosto(int fila, int numero) {
        if (fila <= 0 || fila > posti.length || numero <= 0 || numero > posti[0].length) {
            System.out.println("er  rore: fila o numero del posto non valido.");
            return false;
        }
        return true;
    }
}
