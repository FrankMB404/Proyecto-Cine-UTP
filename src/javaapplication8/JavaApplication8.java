package javaapplication8;
import java.util.Scanner;
public class JavaApplication8 {
    public static void cine(String array [][]){
        char letra = 'G';
        System.out.printf("\n%20s\n", "PANTALLA");
        System.out.print("   |");
        for(int i = 1; i<25; i++){
            System.out.print("-");
        }
        System.out.print("|");
        System.out.println("");
        System.out.println("");
        
        for(int i = 0; i<7; i++){
            for(int j = 0; j<10; j++){
                System.out.printf(array[i][j] + "  ");
            }
            letra = (char)('G' - i);
            System.out.print(letra);
            System.out.println("");
        }
        for(int i = 10; i>0; i--){
            if(i>=10){
                System.out.print(i + " ");
            } else{
                System.out.print("0" + i + " ");
            }
        }
        System.out.println("\nX = Seleccionada    O = Libre");
        System.out.println("");
    }
    
    public static void menuPreview(){
        System.out.println("""
                           |---------- CINESTAR ---------|
                           |                             |
                           |    1. Reservar Asiento      | 
                           |    2. Finalizar             |
                           |-----------------------------|
                           """);
    }
    
    public static void menu(){
        System.out.println("""
                           |---------- CINESTAR ---------|
                           |                             |
                           |    1. Vista Previa          | 
                           |    2. Reservar Asiento      | 
                           |    3. Finalizar             |
                           |-----------------------------|
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
        boolean aux = true, checkPreview = true, check = true;
        int fila, columna, option;
        String[][] array = new String[7][10];
        for(int i = 0; i<7; i++){
            for(int j = 0; j<10; j++){
                array[i][j] = "O";
            }
        }
        menuPreview();
        while(checkPreview){
            System.out.print("Ingrese opcion: ");
            option = in.nextInt();
            switch(option){
                case 1:
                    cine(array);
                    do{
                        System.out.print("Ingrese numero de fila: ");
                        fila = in.nextInt();
                        if(fila<0 || fila>6)System.out.println("Dato Invalido");
                    }while(fila<0 || fila>6);
                    do{
                        System.out.print("Ingrese numero de columna: ");
                        columna = in.nextInt();
                        if(columna<0 || columna>9)System.out.println("Dato Invalido");
                    }while(columna<0 || columna>9);
                    in.nextLine();
                    array [fila][columna] = "X";
                    System.out.println("");
                    checkPreview = false;
                    enter(in);
                    break;
                case 2:
                    checkPreview = false;
                    check = false;
                    System.out.println("Gracias por elegir Cinestar!!");break;
                default: 
                    System.out.println("Por favor, ingrese una opcion del menu"); break;
            }
        }
        while(check){
            menu();
            System.out.print("Ingrese opcion: ");
            option = in.nextInt();
            in.nextLine();
            switch(option){
                case 1: 
                    cine(array);
                    enter(in);
                    break;
                case 2:
                    cine(array);
                    do{
                        System.out.print("Ingrese numero de fila: ");
                        fila = in.nextInt();
                        if(fila<0 || fila>6)System.out.println("Dato Invalido");
                    }while(fila<0 || fila>6);
                    do{
                        System.out.print("Ingrese numero de columna: ");
                        columna = in.nextInt();
                        if(columna<0 || columna>9){
                            System.out.println("Dato Invalido");
                        }else if (array[fila][columna].equals("X")){
                            System.out.println("Asiento Ocupado!!");
                        }
                    }while((columna<0 || columna>9));
                    in.nextLine();
                    array [fila][columna] = "X";
                    System.out.println("");
                    enter(in);
                    break;
                case 3:
                    check = false;
                    System.out.println("Gracias por elegir Cinestar!!");break;
                default: 
                    System.out.println("Por favor, ingrese una opcion del menu"); break;
            }
        }
    }
}