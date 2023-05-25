package it.itispaleocapa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class AppTest {
    @Test
    public void testAggiungiCliente() {
        App app = new App(4);
        app.aggiungiCliente("Cliente1");
        assertEquals("Cliente1", app.cercaCliente("Cliente1").getNome());
    }

    @Test
    public void testRimuoviCliente() {
        App app = new App(4);
        app.aggiungiCliente("Cliente1");
        app.rimuoviCliente("Cliente1");
        assertNull(app.cercaCliente("Cliente1"));
    }

    @Test
    public void testAggiungiPrenotazione() {
        App app = new App(4);
        Cliente cliente = new Cliente("Cliente1");
        LocalDate dataPrenotazione = LocalDate.of(2023, 5, 1);
        int numeroPersone = 4;

        app.aggiungiPrenotazione(cliente, dataPrenotazione, numeroPersone);
        ArrayList<Prenotazione> prenotazioni = app.cercaPrenotazioniCliente(cliente);
        assertEquals(1, prenotazioni.size());
        assertEquals(numeroPersone, prenotazioni.get(0).getNumeroPersone());
    }

    @Test
    public void testCambiaPrenotazione() throws invalidDateException, invalidPeopleNumberException {
        App app = new App(4);
        Cliente cliente = new Cliente("Cliente1");
        LocalDate dataPrenotazione = LocalDate.of(2023, 5, 1);
        int numeroPersone = 4;

        app.aggiungiPrenotazione(cliente, dataPrenotazione, numeroPersone);
        Prenotazione prenotazione = app.cercaPrenotazioniCliente(cliente).get(0);

        Cliente nuovoCliente = new Cliente("NuovoCliente");
        LocalDate nuovaDataPrenotazione = LocalDate.of(2023, 5, 2);
        int nuovoNumeroPersone = 3;

        app.cambiaPrenotazione(prenotazione.getIdentificativo(), nuovoCliente, nuovaDataPrenotazione, nuovaDataPrenotazione, nuovoNumeroPersone);
        assertEquals(nuovoCliente, prenotazione.getCliente());
        assertEquals(nuovaDataPrenotazione, prenotazione.getDataPrenotazione());
        assertEquals(nuovoNumeroPersone, prenotazione.getNumeroPersone());
    }

    @Test
    public void testRemovePrenotazione() {
        App app = new App(4);
        Cliente cliente = new Cliente("Cliente1");
        LocalDate dataPrenotazione = LocalDate.of(2023, 5, 1);
        int numeroPersone = 4;

        app.aggiungiPrenotazione(cliente, dataPrenotazione, numeroPersone);
        Prenotazione prenotazione = app.cercaPrenotazioniCliente(cliente).get(0);

        app.removePrenotazione(prenotazione.getIdentificativo());
        assertEquals(0, app.cercaPrenotazioniCliente(cliente).size());
    }

    // Altri metodi di test...

}

