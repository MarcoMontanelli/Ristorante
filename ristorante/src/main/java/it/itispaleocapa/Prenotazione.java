package it.itispaleocapa;

import java.time.LocalDate;

public class Prenotazione{
    private Cliente cliente;
    private LocalDate dataprenotazione;
    private LocalDate dataPrenotata;
    private int numeroPersone;
    private int identificativo;

    Prenotazione(Cliente cliente, LocalDate dp, int nc, int i){
        this.cliente = cliente;
        this.dataprenotazione = LocalDate.now();
        this.dataPrenotata = dp;
        this.numeroPersone = nc;
        this.identificativo = i;
    }
 
    public int getIdentificativo() {
        return identificativo;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public LocalDate getDataPrenotazione() {
        return dataprenotazione;
    }
    public LocalDate getDataPrenotata() {
        return dataPrenotata;
    }
    public int getNumeroPersone() {
        return numeroPersone;
    }
    public void setCliente(Cliente cliente) {
        if(cliente == null){
            return;
        }
        this.cliente = cliente;
    }
    public void setDataPrenotazione(LocalDate d) {
        this.dataprenotazione=d;
    }
    public void setDataPrenotata(LocalDate dataPrenotata) throws invalidDateException {
        if(dataPrenotata == null){
            throw new invalidDateException();
        }
        this.dataPrenotata = dataPrenotata;
    }
    public void setNumeroPersone(int numeroPersone) throws invalidPeopleNumberException{
        if(numeroPersone <= 0){
            throw new invalidPeopleNumberException();
        }
        this.numeroPersone = numeroPersone;
    }
 
}