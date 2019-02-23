
package arraylist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayList {
    BufferedReader br;
    Grafo g;
    public ArrayList(){

        g = new Grafo();
    }
    //MENU PARA AGREGAR,MOSTRAR Y ELIMINAR
    public void Menu() throws IOException{
        
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(flujo, 1000);
        
        
        int op = 0;
        
        do{
            System.out.println("1. Agregar vertice");
            System.out.println("2. Agregar Arista");
            System.out.println("3. Eliminar Arista");
            System.out.println("4. Eliminar Vertice");
            System.out.println("5. Mostrar Grafo");
            System.out.println("6. Mostrar Matriz");
            System.out.println("0. Salir");
            System.out.println("Elige una Opcion: ");
            op = Integer.parseInt(br.readLine());
            switch(op){
                case 1:
                    g.insertarVertice();
                    break;
                case 2:
                    g.insertarArista();
                    break;
                case 3:
                    g.eliminarArista();
                    break;
                case 4:
                    g.eliminarVertice();
                    break;
                case 5:
                    g.mostrar();
                    break;
                case 6:
                    g.mostrarMatriz();
                    break;
                case 0:
                    System.out.println("Saliendo del Programa...");
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    break;
            }
        }while(op != 0);
    }
    public static void main(String[] args) throws IOException {
        ArrayList al = new ArrayList();
        al.Menu();
    }
    
}
