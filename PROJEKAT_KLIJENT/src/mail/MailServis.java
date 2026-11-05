/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mail;

import java.io.File;
import java.util.Properties;
import jakarta.activation.DataHandler;
import jakarta.activation.FileDataSource;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
/**
 *
 * @author HomePC
 */
public class MailServis {
    //tehnika slanja uopšteno
    private static final String POSILJALAC = "prirodnimir.spa@gmail.com";// nalog sa kog se šalju mejlovi
    private static final String APP_LOZINKA = "xnjy qqmu ayee kaar";//aplikaciona lozinka za taj mejl izgenerisana preko apps password
    private static final String NAZIV_SALONA = "Prirodni mir";// ime koje primalac vidi kao pošiljaoca
//staticka metoda koja podešava SMTP servera
     public static void posalji(String primalac, String naslov, String tekst, File prilog) throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");//gmail server,port 587
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");// obavezna prijava
        props.put("mail.smtp.starttls.enable", "true");//prebacivanje na šifrovanu vezu

    //Sesija je "veza sa serverom" po tim podešavanjima.
    //Authenticator je objekat koji serveru daje korisničko ime i lozinku kad ih zatraži.
        Session sesija = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(POSILJALAC, APP_LOZINKA);
            }
        });
//Prazna poruka vezana za sesiju; od koga (adresa + prikazano ime), kome (TO), naslov.
//UTF-8 je zbog naših slova u imenu i naslovu.
        MimeMessage poruka = new MimeMessage(sesija);
        poruka.setFrom(new InternetAddress(POSILJALAC, NAZIV_SALONA, "UTF-8"));
        poruka.setRecipients(Message.RecipientType.TO, InternetAddress.parse(primalac));
        poruka.setSubject(naslov, "UTF-8");
//Mejl sa prilogom je "višedelni": prvi deo je tekst. Multipart je kontejner delova.
        MimeBodyPart tekstDeo = new MimeBodyPart();
        tekstDeo.setText(tekst, "UTF-8");

        Multipart sadrzaj = new MimeMultipart();
        sadrzaj.addBodyPart(tekstDeo);
//Drugi deo je fajl: FileDataSource čita fajl sa diska,
//DataHandler ga pakuje u format za mejl, setFileName je ime koje primalac vidi.
        if (prilog != null) {
            MimeBodyPart prilogDeo = new MimeBodyPart();
            prilogDeo.setDataHandler(new DataHandler(new FileDataSource(prilog)));
            prilogDeo.setFileName(prilog.getName());
            sadrzaj.addBodyPart(prilogDeo);
        }
//Kontejner se stavi u poruku i Transport.send se poveže na server,
//prijavi se preko Authenticator-a i pošalje.
        poruka.setContent(sadrzaj);
        Transport.send(poruka);
    }
    
    
    
}
