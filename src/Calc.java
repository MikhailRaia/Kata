import java.util.Scanner;

public class Calc {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String prim = sc.nextLine(); //Считываем строку
        char[] ch = new char[prim.length()];

        String arb2 ="I,II,III,IV,V,VI,VII,VIII,IX,X";
        String [] arb = arb2.split(",");

        String arb3 ="X,XX,XXX,XL,L,LX,LXX,LXXX,XC,C";
        String [] arbs = arb3.split(",");

        String st = "-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10";

        int l = 0, z = 0, ar1 = 0, ar2 =0;
        int s = 0, ts=0, os=0;

        char[] znak = {'+','-','/','*'}; // Объявляем знаки

        //Проверка если меньше двух символов
        if (prim.length()<3) {
            System.out.println("В значении меньше трех символов");
        }

        else {
            // Преобразуем prim в char в новом массиве
            for (int i = 0; i < prim.length(); i++) {
                ch[i] = prim.charAt(i);
            }

            // Поиск знака в строке и определение самого знака
            for (int i = 0; i < znak.length; i++) {
                for (int j = 1; j < ch.length; j++) {
                    if (znak[i] == ch[j]) {
                        z = i; // z - сам знак +-/*
                        l = j; // l - порядок знака
                    }
                }
            }
            if (l == 0) {
                System.out.println("Отсутствует мат. знак + - / * ");
            } else {


                // Строка с1 - значение до знака, с2 - после знака.
                String c1 = prim.substring(0, l);
                String c2 = prim.substring((l + 1), prim.length());

                if (arb2.contains(c1) & arb2.contains(c2)) {
                    // Здесь нужна проверка на римские или арабские


                    // Действия с римскими числами

                    // Проверка на совпадение с римскими цифрами заданной строки и вычисление числа
                    for (int i = 0; i < arb.length; i++) {
                        for (int j = 0; j < arb.length; j++) {
                            if ((c1.equals(arb[i])) & c2.equals(arb[j])) {
                                ar1 = i;
                                ar2 = j;
                            }
                        }
                    }

                    // Мат. операция и вывод римских цифр

                    // "+"
                    if (z == 0 ) {
                        System.out.println((arb[ar1]) + (arb[ar2]));
                    }
                    // "-"
                    if (z == 1) {
                        s = ar1 - ar2;
                            if (s <= 0) {
                                System.out.println("Римское число не может быть отрицательным и равняться нулю");
                            } else {
                                System.out.println((arb[s - 1]));
                            }

                    }
                    // "/"
                    if (z == 2) {
                        s = (ar1 + 1) / (ar2 + 1);
                        System.out.println((arb[s - 1]));
                    }
                    // "*"
                    if (z == 3) {
                        s = (ar1 + 1) * (ar2 + 1);

                        if (s <= 10) {
                            System.out.println((arb[s - 1]));
                        }

                        if (s > 10) {
                            ts = s / 10;
                            os = s % 10;
                            // Проверка на кратность 10
                            if (os == 0) {
                                System.out.println(arbs[ts - 1]);
                            } else {
                                System.out.println((arbs[ts - 1]) + (arb[os - 1]));
                            }
                        }
                    }
                }


                    // Действия с Арабскими числами

                    //преобразуем char в int до знака
                    Integer num1 = Integer.valueOf(c1);
                    //преобразуем char в int после знака
                    Integer num2 = Integer.valueOf(c2);

                    if ((num1 > 10) || (num2 > 10) || (num1 < -10) || (num2 < -10)) {
                        System.out.println("Вводимые числа больше 10 и меньше -10");
                    }

                    // Проверка диапазона арабских чисел
                    if (num1 <= 10 & num1 >= -10) {
                        if (num2 <= 10 & num2 >= -10) {

                            // Мат. операция и вывод
                            // "+"
                            if (z == 0) {
                                System.out.println(num1 + num2);
                            }
                            // "-"
                            if (z == 1) {
                                System.out.println(num1 - num2);
                            }
                            // "/"
                            if (z == 2) {
                                System.out.println(num1 / num2);
                            }
                            // "*"
                            if (z == 3) {
                                System.out.println(num1 * num2);
                            }
                        }
                    }




            }
        }






    }
}