package javaapplication8;
import java.util.Scanner;
public class JavaApplication8 {
    //impresion de la interfaz del cine
    public static void cine(String array [][]){
        char letra = 'G';
        System.out.printf("\n%20s\n", "PANTALLA");
        System.out.print("   |");
        for(int i = 1; i<25; i++){
            System.out.print("_");
        }
        System.out.print("|");
        System.out.println("");
        System.out.println("");
        //Impresion de asientos vacios y asignación de letras a las columnas
        for(int i = 0; i<7; i++){
            for(int j = 0; j<10; j++){
                System.out.print(array[i][j] + "  ");
            }
            letra = (char)('G' - i);
            System.out.print(letra);
            System.out.println("");
        }
        //Numero de columna
        for(int i = 10; i>0; i--){
            if(i>=10){
                System.out.print(i + " ");
            } else{
                System.out.print("0" + i + " ");
            }
        }
        System.out.println("\nX = Seleccionada    O = Libre");
        System.out.println("\tEntrada: S/15");
        System.out.println("");
    }
    
    public static void menu(){
        System.out.println("""
                            __________ CINESTAR _________
                           |                             |
                           |    1. Ver Sala de Asientos  |
                           |    2. Ver Mi Carrito        |   
                           |    3. Finalizar             |
                           |_____________________________|
                           """);
    }
    
    public static void menu2(){
        System.out.println("""
                            __________ CINESTAR _________
                           |                             |
                           |    1. Reservar Asientos     |
                           |    0. Menu Principal        |   
                           |_____________________________|
                           """);
    }
    public static void enter(Scanner in){
        String entrada;
        do {
            System.out.print("Presione ENTER para continuar... ");
            entrada = in.nextLine();
            if (entrada.length() > 0) {
                System.out.println("Error!! Solo presionar la tecla ENTER.");
            }
        }while(entrada.length() > 0);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean check = true;
        //checkPreview = Controla la salida del menu previo con 2 opciones
        //check = Controla la salida del menu principal
        int fila, columna, option;
        //option = opciones del menu
        String[][] array = new String[7][10];
        //Asignación de O como espacio vacío, 7*10
        for(int i = 0; i<7; i++){
            for(int j = 0; j<10; j++){
                array[i][j] = "O";
            }
        }
        while(check){
            boolean escoger = true;
            menu();
            System.out.print("Ingrese opcion: ");
            option = in.nextInt();
            in.nextLine();
            switch(option){
                case 1: 
                    cine(array);
                    enter(in);
                    do{
                        menu2();
                        System.out.print("Ingrese opcion: ");
                        option = in.nextInt();
                        switch(option){
                            case 0: System.out.println(); break;
                            case 1:
                                cine(array);
                                while(escoger){
                                    do{
                                        System.out.print("Ingrese numero de fila: ");
                                        fila = in.nextInt();
                                        if(fila<0 || fila>6)System.out.println("Dato Invalido");
                                    }while(fila<0 || fila>6);
                                    do{
                                        System.out.print("Ingrese numero de columna: ");
                                        columna = in.nextInt();
                                        if(columna<0 || columna>9)System.out.println("Dato Invalido");
                                    }while((columna<0 || columna>9));
                                    if (array[fila][columna].equals("X")){
                                        System.out.println("Asiento Ocupado!!");
                                    }else{
                                        array[fila][columna] = "X";
                                        escoger = false;
                                        System.out.println("");
                                        enter(in);
                                        in.nextLine();
                                    }
                                }
                                break;
                            default: System.out.println("Por favor, ingrese una opcion valida..."); break;
                        }
                    }while(option>1 || option <0);
                    break;
                case 2:
                    System.out.println("Viendo carrito..."); break;
                case 3:
                    check = false;
                    System.out.println("Vuelve Pronto!!"); break;
                default: 
                    System.out.println("Por favor, ingrese una opcion valida..."); break;
            }
        }
    }
}