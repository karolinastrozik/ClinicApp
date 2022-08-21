package clinicapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("-----Klinika weterynaryjna-----");
        Owner karolina = new Owner("Karolina", "Strózik");
        Owner piotr = new Owner("Piotr", "Kowalski");
        Owner marcin = new Owner("Marcin", "Nowak");

        Patients kira = new Patients("Kira", karolina, Species.DOG);
        Patients pantera = new Patients("Pantera", piotr, Species.CAT);
        Patients prince = new Patients("Black Prince", marcin, Species.HORSE);

        List<Owner> owners = new ArrayList<>();
        owners.add(karolina);
        owners.add(piotr);
        owners.add(marcin);

        List <Patients> patients = new ArrayList<>();
        patients.add(kira);
        patients.add(pantera);
        patients.add(prince);

        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");

        while (true) {
            try {
                showMainMenu();
                System.out.println("Wybierz opcje: ");
                int option = scanner.nextInt();
               
                if (option ==1) {
                    addOwner(owners, scanner);

                } else if (option == 2) {
                    showOwners(owners);
                } else if (option == 3) {
                    showPatients(patients);
                }else if(option == 4) {
                    addPatient(patients,scanner,owners);

                } else if (option == 0) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Podaj liczbę");
                scanner.next();
            }
        }
    }

    private static void addPatient(List<Patients> patients, Scanner scanner, List<Owner> owners) {
        try{
            System.out.println("Imię pacjenta:  ");
            String name = scanner.next();
            System.out.println("Właściciel (Imię, Nazwisko):  ");
            String owner = scanner.next();
            String[] splited =  owner.split( " ");
            for(Owner o : owners) {
                if (o.getFirstName().equalsIgnoreCase(splited[0]) && o.getLastName().equalsIgnoreCase(splited[1])) {
                    System.out.println("Podaj gatunek pacjenta : (DOG, CAT,HORSE, HAMSTER): ");
                    String species = scanner.next();
                   Species speciesAsEnum =  Species.valueOf(species);
                    Patients b = new Patients(name,o,speciesAsEnum);
                    patients.add(b);
                    return;
                }
            }
            System.out.println("Nie istnieje w bazie taki właściciel, dodaj go najpierw");
        }catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("Niepoprawne dane właściciela");
        }catch(IllegalArgumentException ex) {
            System.out.println("Niepoprawna nazwa gatunku");
        }


        {

        }


    }

    private static void showPatients(List<Patients> patients) {
        System.out.println("Pacjenci:");
        for (Patients b : patients) {
            System.out.println(b.getInfo());
        }
    }

    private static void showOwners(List<Owner> owners) {
        System.out.println("Właściciele:");
        for (Owner a : owners) {
            System.out.println(a.getInfo());
        }
    }

    private static void addOwner(List<Owner> owners, Scanner scanner) {
        System.out.println("Podaj imie właściciela:");
        String firstName = scanner.next();
        System.out.println("Podaj nazwisko właściciela:");
        String lastName = scanner.next();
        Owner at = new Owner(firstName,lastName);
        owners.add(at);
    }

    private static void showMainMenu() {
        System.out.println("1.Dodaj właściciela");
        System.out.println("2. Wypisz właścicieli");
        System.out.println("3.Wypisz pacjentów");
        System.out.println("4.Dodaj pacjenta");
        System.out.println("0. Wyjdź z programu");
    }
}