package grafos;

import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
        GrafoMatriz grafo = new GrafoMatriz();
        menu(grafo);
	}
	
    public static void menu(GrafoMatriz grafo) {
    	int contV= 0;
        String nombre;
        
        Scanner sc = new Scanner(System.in);
        caratula();
        int opcion = sc.nextInt();
        sc.nextLine();
        
        switch (opcion) {
        
            case 1:
                System.out.println("***CREACION DE NODOS***");
                System.out.println("Ingrese los nodos a crear");
                int nVertices = sc.nextInt();
                sc.nextLine();
                int totalVertices = nVertices + contV;
                
                if (nVertices < 1) {
                    System.out.println("Error, ingrese numeros validos:");                    
                } else {
                    if (totalVertices > 20) {
                        System.out.println("Error, ingrese la cantidad de nodos permitidos");                       
                    } else {
                        for (int i = 0; i < nVertices; i++) {
                        	int e=i+1;
                            System.out.println("Ingrese el nombre del vertice "+ e +" :");
                            nombre = sc.nextLine();
                            grafo.nuevoVertice(nombre.trim());
                            contV = contV + 1;
                        }                        
                    }
                }
                
                menu(grafo);
                
                break;
            case 2:
                System.out.println("***CONEXION DE VERTICES***");
                System.out.println("Ingrese el nombre del vertice origen:");
                String origen = sc.nextLine();
                System.out.println("Ingrese el nombre del vertice destino " );
                String destino = sc.nextLine();
                
                try {
                    grafo.nuevoArco(origen, destino);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                menu(grafo);
                
                break;
            case 3:
                System.out.println("***VERIFICADOR DE ADYACENCIA DE VERTICES***");
                System.out.println("Ingrese el nombre del vertice origen :");
                String vertice = sc.nextLine();
                System.out.println("Ingrese el nombre del vertice a destino: ");
                String verticeVerificar = sc.nextLine();
                
                try {
                    System.out.println(grafo.adyacente(vertice, verticeVerificar));                  
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                menu(grafo);
                
                break;
            case 4:
                System.out.println("***MOSTRAR ADYCENCIAS DE VERTICES***");
                System.out.println("Ingrese el nombre del vertice a buscar:");
                String verticeBuscar = sc.nextLine();
                
                try {
                    List<Vertice> nodosConectadosA = grafo.nodosConectados(verticeBuscar);
                    System.out.println("Nodos conectados a ("+verticeBuscar+")");
                    for (Vertice v : nodosConectadosA) {
                        System.out.println(v.nomVertice());
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
                
                menu(grafo);
                
            	break;
            case 5:
                System.out.println("***ACABA DE SALIR DEL MENU***");
            	break;
        }
    }
    
    public static void caratula () {
        System.out.println("------------------------------------------------");
        System.out.println("1) INGRESO DE NODOS");
        System.out.println("2) CONEXION DE VERTICES");
        System.out.println("3) VERIFICADOR DE ADYACENCIA DE VERTICES");
        System.out.println("4) MOSTRAR ADYCENCIAS DE VERTICES");        
        System.out.println("5) Salir");
        System.out.println("------------------------------------------------");
    }
}
