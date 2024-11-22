public class SalaCinema {
    private Posto[][] posti;

    public SalaCinema(int numFile, int numPostiPerFila) {
        posti = new Posto[numFile][numPostiPerFila];
        for (int i = 0; i < numFile; i++) {
            for (int j = 0; j < numPostiPerFila; j++) {
                posti[i][j] = new Posto(i + 1, j + 1); // Fila e posto partono da 1
            }
        }
    }

    public void prenotaPosto(int fila, int numero) {
        if (fila <= 0 || fila > posti.length || numero <= 0 || numero > posti[0].length) {
            System.out.println("errore: il posto specificato non esiste.");
            return;
        }

        Posto posto = posti[fila - 1][numero - 1];
        if (posto.isOccupato()) {
            System.out.println("errore: il posto fila " + fila + " posto " + numero + " è già prenotato.");
        } else {
            posto.prenota();
            System.out.println("posto fila " + fila + " posto " + numero + " prenotato con successo!");
        }
    }

    public void annullaPrenotazionePosto(int fila, int numero) {
        if (fila <= 0 || fila > posti.length || numero <= 0 || numero > posti[0].length) {
            System.out.println("errore: il posto specificato non esiste.");
            return;
        }

        Posto posto = posti[fila - 1][numero - 1];
        if (!posto.isOccupato()) {
            System.out.println("errore: il posto fila " + fila + " posto " + numero + " è già libero.");
        } else {
            posto.annullaPrenotazione();
            System.out.println("prenotazione del posto fila " + fila + " posto " + numero + " annullata con successo!");
        }
    }

    public void visualizzaSala() {
        System.out.println("stato della sala:");
        for (int i = 0; i < posti.length; i++) {
            System.out.print("Fila " + (i + 1) + ": ");
            for (int j = 0; j < posti[i].length; j++) {
                System.out.print(posti[i][j].isOccupato() ? "X " : "O ");
            }
            System.out.println();
        }
    }
}
