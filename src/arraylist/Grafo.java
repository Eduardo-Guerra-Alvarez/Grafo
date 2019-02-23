
package arraylist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Grafo {
    private String [] vertice = new String[100];//SE INICIALIZA UN ARREGLO
    private int [][] matriz = new int[100][100];//SE INICIALIZA UNA MATRIZ
    private int size;
    
    BufferedReader br;//PARA LEER DESDE CONSOLA
    
    //SE INSERTA LA CANTIDAD DE VERTICES
    public void setSize(int size){
        this.size = size;
    }
    //RETORNA LA CANTIDAD DE VERTICES
    public int getSize(){
        return size;
    }
    
    //INSERTA VERTICES AL ARREGLO
    public void insertarVertice() throws IOException{
        int i = 0;
        String nombre;
        //FUNCION DE BUFFEREDREADER PARA LEER DESDE CONSOLA
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(flujo, 1000);
        int numVertice;
        System.out.println("Iniacializar numero de Vertices: ");
        numVertice = Integer.parseInt(br.readLine());//LEE EL DATO DE CONSOLA
        setSize(numVertice);//SE AGREGA EL NUMERO DE VERTICES A AGREGAR
        while(i < getSize()){//MIENTRAS SEA MENOR A EL TAMAÑO SE REPITE
            System.out.println(i+1+". Nombre del Vertice: ");
            nombre = br.readLine();//SE LEE EL NOMBRE DEL VERTICE
            if(obtenerVertice(nombre) == -1){//SI EL VERTICE NO EXISTE
                vertice[i] = nombre;//SE AGREGA EL NOMBRE AL ARREGLO EN LA POSICION I
                i++;
            }
            else{
                System.out.println("Vertice ya existe");//SI NO MANDA UN MENSAJE
            }
        }
    }
    //FUNCION PARA AGREGAR ARISTAS
    public void insertarArista() throws IOException{
        int numArista, i = 0;
        String origen, destino;
        //PARA LEER DESDE CONSOLA
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(flujo, 1000);
        System.out.println("Ingrese numero de Aristas: ");
        numArista = Integer.parseInt(br.readLine());//LEE EL NUMERO DE ARISTAS A INGRESAR
        while(i < numArista){//MIENTRAS SEA MENOR QUE EL NUMERO DE ARISTAS
            System.out.println("Origen: ");
            origen = br.readLine();//SE LEE EL ORIGEN
            System.out.println("Destino: ");
            destino = br.readLine();//SE LEE EL DESTINO
            //COMPRUEBA QUE EXISTA LOS DOS VERTICES INGRESADOS
            if(obtenerVertice(origen) != -1 && obtenerVertice(destino) != -1){
                //COMPRUEBA QUE NO EXISTA LA MATRIZ EN ESA POSICION
                if(obtenerMatriz(origen,destino) == true){
                    /*
                    lA FUNCION OBTENERVERTICE, RETORNA LA POSICON DE I SI LA ENCUENTRA
                    SI NO RETORNARA -1
                    AL SER UN GRAFO NO DIRIGIDO, SE PONE ORIGEN,DESTINO Y DESTINO,ORIGEN
                    */
                    matriz[obtenerVertice(origen)][obtenerVertice(destino)] = 1;//SE AGREGA EN ESA POSICION 1
                    matriz[obtenerVertice(destino)][obtenerVertice(origen)] = 1;//EN LA POSICION CONTRARIA SE AGREGA 1
                    i++;
                }
                else{
                    System.out.println("Ya existe la Arista");//SI DA FALSE YA EXISTE LA ARISTA
                }
            }
            else{
                System.out.println("El vertice no existe");//SI DA -1 ES PORQUE NO EXISTE EL VERTICE
            }
        }
    }
    //ELIMINA UN ARISTA, SIMILAR A AGREGAR LA ARISTA
    public void eliminarArista() throws IOException{
        String origen,destino;
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(flujo, 1000);
        System.out.println("Eliminar Arista");
        System.out.println("Origen: ");
        origen = br.readLine();//SE PIDE ORIGEN
        System.out.println("Destino: ");
        destino = br.readLine();//SE PIDE DESTINO
        //COMPRUEBA QUE EXISTA EL VERTICE
        if(obtenerVertice(origen) != -1 && obtenerVertice(destino) != -1){
            //COMPRUEBA QUE EXISTA LA ARISTA
            if(obtenerMatriz(origen,destino) == false){
                matriz[obtenerVertice(origen)][obtenerVertice(destino)] = 0;//SE SOBRE ESCRIBE 0
                matriz[obtenerVertice(destino)][obtenerVertice(origen)] = 0;
                System.out.println("Matriz Eliminada...");
            }
            else{
                System.out.println("No existe la matriz");
            }
        }
        else{
            System.out.println("No existen los vertices");
        }
        
        

    }
    //BUSCA SI EXISTE EL VERTICE POR MEDIO DE SU NOMBRE
    public int obtenerVertice(String nombre){
        //RECORRERA TODO EL ARREGLO
        for (int i = 0; i < getSize(); i++) {
            //SI EN LA POSICION I = AL NOMBRE RETORNA I
            if(vertice[i] == null ? nombre == null : vertice[i].equals(nombre))
                /*
                NORMALMENTE SE PONE VERTICE[I] == NOMBRE, PERO EN ESTE CASO, NETBEANS
                MARCO ESTA SUGERENCIA Y SOLO ASI PUDO FUNCIONAR, SI NO OCACIONA BUGS
                */
                return i;
        }
        return -1;//SI NO RETORA -1
    }
    //BUSCA QUE EXISTA LA MATRIZ EN LA POSICION ORIGEN Y DESTINO
    public boolean obtenerMatriz(String origen, String destino){
        //COMPRUEBA SI EXISTE LA MATRIZ EN LA POSICION CON LA AYUDA DE LA FUNCION OBTENERVERTICE
        if(matriz[obtenerVertice(origen)][obtenerVertice(destino)] == 0 && matriz [obtenerVertice(destino)][obtenerVertice(origen)] == 0)
            return true;//SI NO EXISTE RETORNA TRUE
        return false;//SI EXISTE RETORNA FALSE
    }
    //ELIMINA UN VERTICE
    public void eliminarVertice() throws IOException{
        String nombre;
        boolean encontrado = false;
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(flujo, 1000);
        System.out.println("Eliminar Vertice: ");
        nombre = br.readLine();//LEE EL NOMBRE DEL VERTICE
        //sE RECORRE EL ARREGLO
        for (int i = 0; i < getSize(); i++) {
            if(vertice[i].equals(nombre)){//SI LO ENCUENTRA
                vertice[i] = "0";//EN LA POSICION I PASARA UN 0
                System.out.println("Eliminado");
                encontrado = true;//ENCONTRADO PASA A SER TRUE
            }
        }
        if(encontrado == false)//SI ES FALSE ES PORQUE NO SE ENCONTRO
            System.out.println("No se encontro el vertice");
    }
    //MUESTRA LOS VERTICES CON SUS UNIONES
    public void mostrar(){
        //RECORRE EL ARREGLO
        for (int i = 0; i < getSize(); i++) {
            //MIENTRAS SEA DIFERENTE DE 0 LO MOSTRARA
            if(vertice[i] != "0"){
                System.out.print(vertice[i]+"--");//SE MUESTRA EN LA POSICION I
                //SE RECORRE EL ARREGLO EN LA POSICION J
                for (int j = 0; j < getSize(); j++) {
                    //MIENTRAS SI HAYA UNA CONEXCION EN LA MATRZ SE MOSTARA
                    if(matriz[i][j] != 0 && matriz[j][i] != 0){
                        if(vertice[j] != "0")//MIENTRAS SEA DIFERENTE DE 0 LO MOSTRARA
                            System.out.print(vertice[j]+"--");//MUESTRA EN LA POSICION J
                    }
                }
                System.out.println("");//SALTO DE LINEA PARA CADA VERTICE
            }
        }
    }
    //SE MUESTRA LA MATRIZ DE ADYACENCIA
    public void mostrarMatriz(){
        System.out.print("  ");
        //SE RECORRE EL ARREGLO
        for (int i = 0; i < getSize(); i++) {
            if(vertice[i] != "0"){//MIENTRAS SEA DIFERENTE DE 0 SE MOSTRARA
                System.out.print(vertice[i]);//SE MUESTRA EN LA POSICION I
            }
        }
        System.out.println("");
        for (int i = 0; i < getSize(); i++) {
            if(vertice[i] != "0"){
                System.out.print(vertice[i]+" ");//SE MUESTRA EL VERTICE EN LA POSICION I
            
                for (int j = 0; j < getSize(); j++) {
                    if(vertice[j] != "0")
                        System.out.print(matriz[i][j]);//SE MUESTRA LA MATRIZ EN LA POSICION I,J MOSTRANDO SU PESO
                }
                System.out.println("");
            }
        }
    }
}