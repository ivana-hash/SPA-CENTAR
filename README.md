# Prirodni mir, sistem za rezervacije spa centra

Klijent-server aplikacija u Javi za rezervaciju termina u spa centru „Prirodni mir" (Beograd). Diplomski rad, razvijen po uprošćenoj Larmanovoj metodi.

## Demo

https://github.com/user-attachments/assets/0fbec12c-c9ac-48ea-87e8-15bb0a1ddedf

## Struktura repozitorijuma

| Folder | Sadržaj |
|---|---|
| `PROJEKAT_KLIJENT/` | NetBeans projekat klijentske aplikacije (korisnički interfejs) |
| `PROJEKAT_SERVER/` | NetBeans projekat serverske aplikacije (poslovna logika, rad sa bazom) |
| `PROJEKAT_ZAJEDNICKI/` | Zajedničke klase koje koriste i klijent i server |
| `pssem_spa.sql` | Skripta za kreiranje baze i početnih podataka |

## Tehnologije

- Java (JDK 17)
- Apache NetBeans 15
- Baza podataka: MySQL (baza kreirana u alatu SQLyog)
- Komunikacija klijenta i servera: soketi

## Pokretanje

1. Kreirati MySQL bazu izvršavanjem skripte `pssem_spa.sql`.
2. U fajlu `config.properties` u projektu `PROJEKAT_SERVER` proveriti podatke za konekciju na bazu. Podrazumevano: `url=jdbc:mysql://localhost:3306/pssem_spa`, `username=root`, `password` prazan.
3. U NetBeansu otvoriti sva tri projekta (File, Open Project).
4. Pokrenuti projekat `PROJEKAT_SERVER` i sačekati da se server podigne na portu 9000.
5. Pokrenuti projekat `PROJEKAT_KLIJENT`.
6. Prijaviti se test nalogom: korisničko ime `ivana`, šifra `ika2002`.

## Funkcionalnosti

- Zakazivanje termina
- Otkazivanje termina
- Promena termina
- Celokupno praćenje rada spa centra

## Autor

Ivana Đorđević, Fakultet organizacionih nauka (upis 2021), 2026.
