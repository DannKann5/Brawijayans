
import java.util.Scanner;

public class smartbraw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mobil = 0, motor = 0;
        int kendaraan;
        int tarif, tarifMax1 = 0, tarifMax2 = 0, tarifMotor = 0, tarifMobil = 0;
        int jam;
        int durasiMotor = 0, durasiMobil = 0;
        int durasiMaks1 = 0, durasiMaks2 = 0;
        
        do {
            System.out.println("==========Sistem Parkir Kendaraan==========");
            System.out.print("Masukkan jenis kendaraan (Motor [1] / Mobil [2] / Keluar [0]): ");
            kendaraan = sc.nextInt();
            
            switch (kendaraan) {
                case 1 -> {
                    motor++;
                }
                
                case 2 -> {
                    mobil++;
                }
            }
            
            if (kendaraan == 0) {
                System.out.println("Program dihentikan!");
                break;
            } else if (kendaraan != 1 && kendaraan != 2) {
                System.out.println("Kendaraan invalid, harap masukkan ulang!");
                continue;
            }
            
            System.out.print("Masukkan durasi parkir (jam): ");
            jam = sc.nextInt();
            
            switch (kendaraan) {
                case 1 -> {
                    tarif = 2000;
                    if (jam == 0) {
                        motor--;
                        System.out.println("Durasi invalid!\n");
                    } else if (jam > 0) {
                        tarif = tarif + ((jam - 1) * 1000);
                        System.out.println("Tarif parkir anda: " + tarif + "\n");
                    } else if (jam > 24) {
                        System.out.printf("Anda mendapat denda karena parkir lebih dari 1 hari!");
                        tarif = tarif + ((jam - 1) * 1000 + 50000);
                        System.out.println("Tarif parkir anda: " + tarif + "\n");
                    }
                    tarifMotor += tarif;
                    durasiMotor += jam;
                }
                
                case 2 -> {
                    tarif = 5000;
                    if (jam == 0) {
                        System.out.println("Durasi invalid!\n");
                        mobil--;
                    } else if (jam > 24) {
                        System.out.printf("Anda mendapat denda karena parkir lebih dari 1 hari!");
                        tarif = tarif + ((jam - 1) * 2000 + 50000);
                        System.out.println("Tarif parkir anda: " + tarif + "\n");
                    } else if (jam > 0) {
                        tarif = tarif + ((jam - 1) * 2000);
                        System.out.println("Tarif parkir anda: " + tarif + "\n");
                    }
                    tarifMobil += tarif;
                    durasiMobil += jam;
                }
                
                default -> {
                    System.out.println("Kendaraan invalid!\n");
                }
            }

            switch (kendaraan) {
                case 1 -> {
                    if (jam > durasiMaks1) {
                        durasiMaks1 = jam;
                        tarifMax1 = 2000 + ((durasiMaks1 - 1) * 1000);
                    }

                }

                case 2 -> {
                    if (jam > durasiMaks2) {
                        durasiMaks2 = jam;
                        tarifMax2 = 5000 + ((durasiMaks2 - 1) * 2000);
                    }
                }
            }


            System.out.println("==========Jumlah Kendaraan Terparkir==========");
            System.out.printf("Jumlah Kendaraan: Motor - %d\n", motor);
            System.out.println("Total biaya parkir motor keseluruhan: " + tarifMotor);
            System.out.printf("Jumlah Kendaraan: Mobil - %d\n", mobil);
            System.out.println("Total biaya parkir mobil keseluruhan: " + tarifMobil);
            
            System.out.println("==========Durasi Rata-rata Parkir==========");
            System.out.printf("Durasi rata-rata parkir motor: %.2f jam\n", ((float)durasiMotor /(float) motor));
            System.out.printf("Durasi rata-rata parkir mobil: %.2f jam\n", ((float)durasiMobil /(float) mobil));

            System.out.println("===========Durasi Paling Lama==========");
            System.out.printf("Durasi motor paling lama: %d jam, dengan biaya parkir: %d\n", durasiMaks1, tarifMax1);
            System.out.printf("Durasi mobil paling lama: %d jam, dengan biaya parkir: %d\n", durasiMaks2, tarifMax2);            

        } while (kendaraan != 0);
    }   
}