/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdf;

import domen.Rezervacija;
import domen.StatusStavke;
import domen.StavkaRezervacije;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/**
 *
 * @author HomePC
 */
public class RezervacijaPDF {
    
    public static void generisi(Rezervacija r, File izlaz) throws Exception {
      //otvaranje šablona kao toka bajtova za popunjavanje
        InputStream sablon = RezervacijaPDF.class.getResourceAsStream("/reports/rezervacija.jasper");
        if (sablon == null) {
            throw new Exception("Šablon rezervacija.jasper nije pronađen.");
        }
        InputStream logo = RezervacijaPDF.class.getResourceAsStream("/reports/logo.png");
        if (logo == null) {
            throw new Exception("Logo nije pronađen.");
        }

        SimpleDateFormat datum = new SimpleDateFormat("dd.MM.yyyy.");
        SimpleDateFormat vreme = new SimpleDateFormat("HH:mm");
//Jasper po imenu upari svaki $P{...} iz šablona sa vrednošću iz mape. Popunjavanje šablona podacima o izabranoj rezervaciji
        Map<String, Object> params = new HashMap<>();
        params.put("idRezervacija", String.valueOf(r.getIdRezervacija()));
        params.put("klijent", r.getKlijent().getIme() + " " + r.getKlijent().getPrezime());
        params.put("emailKlijenta", r.getKlijent().getEmailAdresa());
        params.put("kontaktTelefon", r.getKlijent().getKontaktTelefon());
        params.put("radnik", r.getRadnik().getIme() + " " + r.getRadnik().getPrezime());
        params.put("datumKreiranja", datum.format(r.getDatumKreiranja()));
        params.put("datumTermina", datum.format(r.getDatumTermina()));
        params.put("vreme", vreme.format(r.getDatumTermina()));
        //%,.2f znači: broj sa dve decimale i separatorom hiljada, npr. 12,500.00 RSD
        params.put("ukupanIznos", String.format("%,.2f RSD", r.getUkupanIznos()));
        params.put("logo", logo);

        //Pravi novu listu samo od stavki koje nisu označene za brisanje, da se u PDF-u ne pojavi tretman koji je korisnik uklonio.
        List<StavkaRezervacije> stavke = new ArrayList<>();
        for (StavkaRezervacije s : r.getStavke()) {
            if (s.getStatusStavke() != StatusStavke.OBRISANA) {
                stavke.add(s);
            }
        }
        
        JasperPrint print = JasperFillManager.fillReport(sablon, params, new JRBeanCollectionDataSource(stavke));
      //Pretvara JasperPrint u PDF i upisuje ga na putanju koju je korisnik izabrao u JFileChooser-u. 
        JasperExportManager.exportReportToPdfFile(print, izlaz.getAbsolutePath());
        
    }
}
