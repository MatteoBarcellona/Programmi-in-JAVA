// Classe Prenotazione
class Prenotazione {
    private Cliente cliente;
    private int numerob;
    private Evento evento;

    public Prenotazione(Cliente cliente, int numerob, Evento evento) {
        this.cliente = cliente;
        this.numerob = numerob;
        this.evento = evento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNumeroBiglietti() {
        return numerob;
    }

    public Evento getEvento() {
        return evento;
    }

    @Override
    public String toString() {
        return "Prenotazione cliente:" + cliente + ", numero biglietti:" + numerob + ", evento:" + evento.getNome();
    }
}