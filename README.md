# Prirodni mir, sistem za rezervacije spa centra

Klijent-server aplikacija u Javi za rezervaciju termina u spa centru „Prirodni mir" (Beograd). Diplomski rad, razvijen po uprošćenoj Larmanovoj metodi.

## Demo

URL_VIDEA

## Struktura repozitorijuma

| Folder | Sadržaj |
|---|---|
| `PROJEKAT_KLIJENT/` | NetBeans projekat klijentske aplikacije (korisnički interfejs) |
| `PROJEKAT_SERVER/` | NetBeans projekat serverske aplikacije (poslovna logika, rad sa bazom) |
| `PROJEKAT_ZAJEDNICKI/` | Zajedničke klase koje koriste i klijent i server |
| `pssem_spa.sql` | Skripta za kreiranje baze i početnih podataka |

## Tehnologije

- Java JAVA_VERZIJA
- NetBeans NETBEANS_VERZIJA
- Baza podataka: NAZIV_BAZE
- Komunikacija klijenta i servera: NACIN_KOMUNIKACIJE

## Pokretanje

1. Kreirati bazu izvršavanjem skripte `pssem_spa.sql`.
2. U fajlu `PUTANJA_DO_KONFIGURACIJE` upisati adresu baze, korisničko ime i lozinku.
3. U NetBeansu otvoriti sva tri projekta (File, Open Project).
4. Pokrenuti projekat `PROJEKAT_SERVER` i sačekati da se server podigne na portu PORT.
5. Pokrenuti projekat `PROJEKAT_KLIJENT`.
6. Prijaviti se test nalogom: korisničko ime `TEST_KORISNIK`, lozinka `TEST_LOZINKA`.

## Funkcionalnosti

- FUNKCIONALNOST_1
- FUNKCIONALNOST_2
- FUNKCIONALNOST_3

## Autor

IME_I_PREZIME, FAKULTET, GODINA
