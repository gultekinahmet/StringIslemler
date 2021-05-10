package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

/***
 *
 * @author ahmetabidingültekin
 *
 */

public class StringIslemler {
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static boolean sadeceHarfMi(String str)
    {
        return ((!str.equals(""))  && (str.matches("^[a-zA-Z]*$")));
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        char kullaniciHarfGiris;
        int menuSecim;
        System.out.println("Lütfen kelime girişi yapınız: ");
        String kullaniciKelimeGiris = sc.next().toLowerCase();

        while(!sadeceHarfMi(kullaniciKelimeGiris)) {
            if (!sadeceHarfMi(kullaniciKelimeGiris)) {
                System.out.println(ANSI_RED + "[!]Hatalı Giriş... Lütfen kelime girişini tekrar yapınız[!]" + ANSI_RESET);
                kullaniciKelimeGiris = sc.next().toLowerCase();
            }
        }

        do {
            System.out.println("""
                            \nYapmak istediğiniz işlemi seçiniz :\s
                            [1]Kelime içinde belirtilen harfin karşılaşılan ilk yerini bulma
                            [2]Kelime içinde belirtilen harfin karşılaşılan son yerini bulma
                            [3]Kelime içinde belirtilen harften kaç adet olduğunu bulma
                            [4]Kelimenin belirtilen aralıktaki(x-y) parçasını yazdırma
                            [0]Çıkış
                            """
                    );

            menuSecim = sc.nextInt();
            switch(menuSecim) {

                case 1:
                    System.out.println("Karşılaşılan ilk yerinin bulunmasını istediğiniz harfi giriniz : ");
                    kullaniciHarfGiris = sc.next().charAt(0);
                    if(kullaniciKelimeGiris.indexOf(kullaniciHarfGiris) == -1)
                        System.out.println("Girdiğiniz harf kelime içerisinde bulunamamıştır.");
                    System.out.println("Girdiğiniz harfin karşılaşılan ilk yeri : " + (1 + (kullaniciKelimeGiris.indexOf(kullaniciHarfGiris)))); // yer sorulduğu için +1 ekliyoruz.
                    break;

                case 2:
                    System.out.println("Karşılaşılan son yerinin bulunmasını istediğiniz harfi giriniz : ");
                    kullaniciHarfGiris = sc.next().charAt(0);
                    if(kullaniciKelimeGiris.lastIndexOf(kullaniciHarfGiris) == -1)
                        System.out.println("Girdiğiniz harf kelime içerisinde bulunamamıştır.");
                    System.out.println("Girdiğiniz harfin karşılaşılan son yeri : " + (1 + (kullaniciKelimeGiris.lastIndexOf(kullaniciHarfGiris)))); // yer sorulduğu için +1 ekliyoruz.
                    break;

                case 3:
                    System.out.println("Kelime içerisinde kaç adet olduğunu bulunmasını istediğiniz harfi giriniz: ");
                    kullaniciHarfGiris = sc.next().charAt(0);
                    int sayac = 0;
                    char[] kullaniciKelimeGirisDizisi = kullaniciKelimeGiris.toCharArray();
                    for (int i = 0; i < kullaniciKelimeGiris.length(); i++) {
                        if (kullaniciHarfGiris == kullaniciKelimeGirisDizisi[i]) {
                            sayac++;
                        }
                    }
                    if(sayac == 0)
                        System.out.println("Girilen kelime içerisinde girilen harf bulunamamıştır.");
                    System.out.println("Girilen kelime içerisinde '" + kullaniciHarfGiris + "' harfi " + sayac + " tane vardır");
                    break;

                case 4:
                    System.out.println("Yazılmasını istediğiniz aralığı giriniz (x başlangıç, y bitiş olacak biçimde giriş yapılacaktır) \n" +
                            "x: ");
                    int x = sc.nextInt();
                    System.out.println("y: ");
                    int y = sc.nextInt();

                    if (y == 0) {
                        y = kullaniciKelimeGiris.length();
                    }
                    if (x == 0)
                        x++; // print komutunda indeksi bir azaltıp kullanıcıya yer vermek
                    // için kullandığımızdan dolayı x = -1 olmayacağı için değerini bir arttırıp aşağıda azaltıyoruz.

                    System.out.println(kullaniciKelimeGiris.substring((x - 1), y));
                    break;

                case 0:
                    System.out.println(ANSI_YELLOW_BACKGROUND + "UYGULAMADAN ÇIKILIYOR..." + ANSI_RESET);
                    Thread.sleep(650);
                    System.exit(0);
                default:
                    System.out.println(ANSI_RED + "Lütfen seçiminizi yukarıda belirtilen rakamlara göre yapınız" + ANSI_RESET);
                    break;
                }

            }while(menuSecim != 0);
    }
}
