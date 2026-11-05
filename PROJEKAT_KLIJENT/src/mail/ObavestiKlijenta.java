/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mail;


import domen.Rezervacija;
import java.awt.Component;
import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import static mail.ObavestiKlijenta.TipPoruke.KREIRANA;
import pdf.RezervacijaPDF;

/**
 *
 * @author HomePC
 */
public class ObavestiKlijenta {
    //ova klasa zna šta šalje, kada i kome
    //Tri situacije u kojima se klijent obaveštava; od tipa zavise naslov i tekst
       public enum TipPoruke { KREIRANA, IZMENJENA, OTKAZANA }

        public static void ponudiSlanje(Component roditelj, Rezervacija r, TipPoruke tip) {
        String email = r.getKlijent().getEmailAdresa();
        if (email == null || email.trim().isEmpty()) {
            return;
        }
        int odgovor = JOptionPane.showConfirmDialog(roditelj,
                "Da li želite da obavestite klijenta " + r.getKlijent().getIme() + " "
                + r.getKlijent().getPrezime() + " mejlom (" + email + ")?",
                "OBAVEŠTENJE KLIJENTU", JOptionPane.YES_NO_OPTION);
        if (odgovor != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            //Pravi se privremeni fajl u sistemskom temp folderu (ime npr. rezervacija_12_48213.pdf), 
            //obeleži se da se obriše kad se aplikacija zatvori, i u njega se generiše isti PDF kao za dugme Odštampaj.
            //Korisnik ne bira lokaciju jer fajl služi samo za prilog.
            File pdf = File.createTempFile("rezervacija_" + r.getIdRezervacija() + "_", ".pdf");
            pdf.deleteOnExit();
            RezervacijaPDF.generisi(r, pdf);

            MailServis.posalji(email, naslov(tip, r), tekst(tip, r), pdf);

            JOptionPane.showMessageDialog(roditelj, "Sistem je poslao obaveštenje klijentu.",
                    "USPEH!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(roditelj,
                    "Sistem ne može da pošalje obaveštenje klijentu.\n" + ex.getMessage(),
                    "NEUSPEŠNO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static String naslov(TipPoruke tip, Rezervacija r) {
        switch (tip) {
            case KREIRANA:  return "Potvrda rezervacije br. " + r.getIdRezervacija() + " - Prirodni mir";
            case IZMENJENA: return "Izmena rezervacije br. " + r.getIdRezervacija() + " - Prirodni mir";
            default:        return "Otkazivanje rezervacije br. " + r.getIdRezervacija() + " - Prirodni mir";
        }
    }

    private static String tekst(TipPoruke tip, Rezervacija r) {
        String termin = new SimpleDateFormat("dd.MM.yyyy. 'u' HH:mm").format(r.getDatumTermina());
        String pozdrav = "Poštovani/a " + r.getKlijent().getIme() + ",\n\n";
        String potpis = "\n\nSrdačan pozdrav,\nSpa centar Prirodni mir";

        switch (tip) {
            case KREIRANA:
                return pozdrav + "Vaša rezervacija br. " + r.getIdRezervacija()
                        + " je uspešno kreirana za " + termin + ".\n"
                        + "Potvrdu rezervacije sa detaljima tretmana šaljemo u prilogu.\n"
                        + "Molimo Vas da dođete 10 minuta pre termina." + potpis;
            case IZMENJENA:
                return pozdrav + "Vaša rezervacija br. " + r.getIdRezervacija()
                        + " je izmenjena. Novi termin je " + termin + ".\n"
                        + "Ažuriranu potvrdu sa detaljima tretmana šaljemo u prilogu." + potpis;
            default:
                return pozdrav + "Vaša rezervacija br. " + r.getIdRezervacija()
                        + " zakazana za " + termin + " je otkazana.\n"
                        + "Detalje otkazane rezervacije šaljemo u prilogu. "
                        + "Za novi termin nas kontaktirajte." + potpis;
        }
    }
}
