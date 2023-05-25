package it.itispaleocapa;

import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDate;

public class App {
    private HashMap<Integer, Prenotazione> prenotazioni;
    private HashMap<String, Cliente>clienti;
    private Cliente maxPersone;
    private int numeroPersone;
    private int prenotazioniTotali;
    private int maxPrenotazioni;
    private int maxCl;
    private LocalDate giornoConPiuPersone;
    App(int numeroPersone){
        prenotazioni = new HashMap<>();
        clienti = new HashMap<>();
        this.numeroPersone = numeroPersone;
        prenotazioniTotali = 0;
    }
    public App aggiungiCliente(String nome){
        Cliente c = new Cliente(nome);
        clienti.put(nome, c);
        return this;
    }
    public void cambiaCliente(String nome, String nuovoNome){
        clienti.get(nome).setNome(nuovoNome);
    }
    public void rimuoviCliente(String nome){
        Cliente c = clienti.get(nome);
        clienti.remove(nome, c);
    }
    public App aggiungiPrenotazione(Cliente c,LocalDate dp, int numeroPersone){
        Prenotazione p = new Prenotazione(c, dp, numeroPersone, prenotazioniTotali);
        prenotazioni.put(prenotazioniTotali, p);
        prenotazioniTotali++;
        c.setnumeroPersone(numeroPersone);
        c.setNp();
        return this;
    }
    public void cambiaPrenotazione(int idPr, Cliente c, LocalDate dataprenotazione, LocalDate dataprenotata, int numeroPersone) throws invalidDateException, invalidPeopleNumberException{
        Prenotazione p = prenotazioni.get(idPr);
        p.setCliente(c);
        p.setDataPrenotazione(dataprenotazione);;
        p.setDataPrenotata(dataprenotata);
        p.setNumeroPersone(numeroPersone);
    }
    public void removePrenotazione(int idPrenotazione){
        Prenotazione p = prenotazioni.get(idPrenotazione);
        prenotazioni.remove(idPrenotazione, p);
        prenotazioniTotali--;
    }
    public Cliente cercaCliente(String nome){
        return clienti.get(nome);
    }
    public ArrayList<Prenotazione> cercaPrenotazioniCliente(Cliente c){
        ArrayList<Prenotazione> p = new ArrayList<>();
        prenotazioni.values().stream().filter(e -> e.getCliente().equals(c)).forEach(p::add);
        return p;
    }
    public ArrayList<Prenotazione> cercaPrenotazioniCreateInGiorno(LocalDate d){
        ArrayList<Prenotazione> p = new ArrayList<>();
        prenotazioni.values().stream().filter(e -> e.getDataPrenotazione().equals(d)).forEach(p::add);
        return p;
    }
    public ArrayList<Prenotazione> cercaPrenotazioniPerGiorno(LocalDate d){
        ArrayList<Prenotazione> p = new ArrayList<>();
        prenotazioni.values().stream().filter(e -> e.getDataPrenotata().equals(d)).forEach(p::add);
        return p;
    }
    public int cercaNumeroPersoneInData(LocalDate d){
        ArrayList<Integer> inters = new ArrayList<>();
        prenotazioni.values().stream().filter(e -> e.getDataPrenotazione().equals(d)).forEach(e -> inters.add(e.getNumeroPersone()));
        int personeTot = inters.stream().mapToInt(Integer::intValue).sum();
        return personeTot;
    }
    public int cercaNumeroPersoneInIntervallo(LocalDate da, LocalDate a){
        ArrayList<Integer> inters = new ArrayList<>();
        prenotazioni.values().stream().filter(e -> e.getDataPrenotazione().isAfter(da) && e.getDataPrenotazione().isBefore(a)).forEach(e -> inters.add(e.getNumeroPersone()));
        int copertiTot = inters.stream().mapToInt(Integer::intValue).sum();
        return copertiTot;
    }
    public LocalDate cercaMaxPersoneInGiornata(){
        maxPrenotazioni = prenotazioni.get(0).getNumeroPersone();
        prenotazioni.values().stream().forEach(e -> {
                                if (e.getNumeroPersone()>maxPrenotazioni) {
                                    maxPrenotazioni = e.getNumeroPersone();
                                    giornoConPiuPersone = e.getDataPrenotazione();        
                                }
                             }
                             );
                             
        return giornoConPiuPersone;
    }
    public Cliente cercaMaxPersone(){
        maxCl = 0;
        clienti.values().stream().forEach(e ->{
                            if(e.getnumeroPersone()>maxCl){
                                maxCl = e.getnumeroPersone();
                                maxPersone = e;
                            }
                        });
        return maxPersone;
    }
    public ArrayList<Cliente> listaClienti(){
        ArrayList<Cliente> c = new ArrayList<>(clienti.values());
        Collections.sort(c);
        return c;
    }
}