import java.util.*;
public class Principal {
    public static void main(String[] args) throws Exception {
        IRadio radio = new Radio();
        int opc = 0;
        int op;
        int boton;
        Scanner in = new Scanner(System.in);
        while (opc != 7) {
            System.out.println("on: " + radio.isOn());
            if(radio.isOn()){
                System.out.println("frecuencia: " + radio.getFrequence());
            }
            else {
                System.out.println("frecuencia: -- ");
            }

            System.out.println("*************************************************************\n"
                    + "*                         Menu                              *\n"
                    + "*************************************************************\n"
                    + "* 1.  Prende el radio                                       *\n"
                    + "* 2.  Cambia AM / FM                                        *\n"
                    + "* 3.  Avanzar en el dial de las emisoras                    *\n"
                    + "* 4.  Guardar una emisora en un boton                       *\n"
                    + "* 5.  Seleccionar emisora puesta en un botón                *\n"
                    + "* 6.  Apagar el radio                                       *\n"
                    + "* 7.  salir                                                 *\n"
                    + "*************************************************************\n");
            opc = Integer.parseInt(getNumber(in));
            switch (opc) {

                case 1: //Prende el radio
                    radio.on();
                break;

                case 2:// Cambia AM / FM
                    System.out.println("**************\n"
                            + "* 1.  FM     *\n"
                            + "* 2.  AM     *\n"
                            + "**************\n");
                    op = Integer.parseInt(getNumber(in));
                    if (op == 2) {
                        radio.setFrequence("AM" + radio.getAMActualStation());
                    } else {
                        radio.setFrequence("FM" + radio.getFMActualStation());
                    }
                    break;

                case 3:// Avanzar en el dial de las emisoras
                    System.out.println("**************\n"
                            + "* 1.  -      *\n"
                            + "* 2.  +      *\n"
                            + "**************\n");
                    op = Integer.parseInt(getNumber(in));
                    if (op == 1) {
                        radio.Backward();
                    } else {
                        radio.Forward();
                    }


                    break;

                case 4:// Permite guardar una emisora en un boton

                    System.out.println("Ingrese el boton a reprogramar:\n 1-2-3-4-5-6-7-8-9-10-11-12\n");
                    boton = Integer.parseInt(getNumber(in));
                    while (boton < 1 || boton > 12) {
                        System.out.println("Ingrese un valor valido:");
                        boton = Integer.parseInt(getNumber(in));
                    }
                    System.out.println("**************\n"
                            + "* 1.  FM     *\n"
                            + "* 2.  AM     *\n"
                            + "**************\n");
                    op = Integer.parseInt(getNumber(in));
                    if (op == 2) {

                        int am = 0;
                        while (!((am % 10 == 0) && (530 <= am) && (am <= 1610))) {
                            System.out.println("Ingrese la frecuencia: ");
                            am = Integer.parseInt(getNumber(in));
                        }
                        radio.saveAMStation(am, boton);
                    } else {
                        double fm = 0;
                        while (!( ((fm*5+1) % 1 == 0) && (87.9 <= fm) && (fm <= 107.9))){
                            System.out.println("Ingrese la frecuencia: ");
                            fm = Double.parseDouble(in.nextLine());
                        }
                        radio.saveFMStation(fm, boton);

                    }
                    break;

                case 5:// Seleccionar emisora puesta en un botón
                    System.out.println("**************\n"
                            + "* 1.  FM     *\n"
                            + "* 2.  AM     *\n"
                            + "**************\n");
                    op = Integer.parseInt(getNumber(in));
                    boton = 0;
                    while (boton < 1 || boton > 12) {
                        System.out.println("Ingrese un valor valido:");
                        boton = Integer.parseInt(getNumber(in));
                    }

                    if (op == 2) {
                        int am = radio.getAMSlot(boton);
                        radio.setAMActualStation(am);
                    } else {
                        double fm = radio.getFMSlot(boton);
                        radio.setFMActualStation(fm);
                    }

                    break;

                case 6://  Apagar el radio
                    radio.off();
                    break;

                case 7: // salir
                    System.out.println("gracias por su tiempo");
                    break;

                default:
                    System.out.println("Opcion invalida vuelva a intentars");
            }

        }

    }
    public static String getNumber (Scanner keyboard){
        String number = keyboard.nextLine(); // Obtiene el input
        boolean isNumber = false;

        while (!isNumber) { // Vuelve a pedir input hasta que este sea un número
            try {
                int nm = Integer.parseInt(number); // Verifica que el input sea un número
                isNumber = true;
            } catch (NumberFormatException nft) {
                System.out.println("ERROR. Verifique que el valor ingresado sea numérico e intente de nuevo.");
                number = keyboard.nextLine();
            }
        }

        return number;
    }
}