package pe.edu.upeu.piederey;

import pe.edu.upeu.utils.LeerTeclado;
import pe.edu.upeu.usuario.Usuario;
import pe.edu.upeu.usuario.Pro;
import java.util.Date;
import pe.edu.upeu.utils.LeerArchivo;
import java.text.SimpleDateFormat;

public class App {

    public static void main (String[] args){
        
        LeerArchivo archivo;
        AppCrud app;
        int costoP1 = 35, costoP2 = 20, costoP3 = 12, costoP4 = 8;
        int costoB1 = 5, costoB2 = 4;
        int totalP1 = 0, totalP2 = 0, totalP3 = 0, totalP4 = 0;
        int totalB1 = 0, totalB2 = 0;
        int totalFp = 0, totalFb = 0;
        int montoF = 0;
        int var = 0;
        
        LeerTeclado teclado = new LeerTeclado();
        Usuario usuario = new Usuario();
        Pro producto = new Pro();
        String opcion = "";

        System.out.println("--------------------------------------------------------------");
        System.out.println("                          Bienvenidos                         ");
        System.out.println("                          a pollerias                         ");
        System.out.println("                          Pie de Rey                          ");
        System.out.println("--------------------------------------------------------------");

        usuario.setNombreCompletos(teclado.leer("","Ingrese su nombre por favor: "));

        do {
            System.out.print("Pedidos Pie de Rey\n");
            
            System.out.print("1.- Pollo \n"+
            "2.- Bebidas\n");
                    
            var = teclado.leer(0,"Ingrese: ");
                
            if (var == 1) {
                do {
                    System.out.print("Pollo:  \n");
                    System.out.print("1.- 1 pollo entero --> 35$\n"+
                    "2.- 1/2 de pollo   --> 20$\n"+
                    "3.- 1/4 de pollo   --> 12$\n"+
                    "4.- 1/8 de pollo   --> 8$\n");
                        
                        producto.setComida(teclado.leer(0, "Ingrese: "));
                
                        switch (producto.getComida()) {
                        case 1:
                            producto.setCantidad(teclado.leer(0, "¿Cuantos pollos enteros desea?"));
                            totalP1 = costoP1 * producto.getCantidad();
                        break;
                        case 2:
                            producto.setCantidad(teclado.leer(0, "¿Cuantos pollos de 1/2 desea?"));
                            totalP2 = costoP2 * producto.getCantidad();
                        break;
                        case 3:
                            producto.setCantidad(teclado.leer(0, "¿Cuantos pollos de 1/4 desea?"));
                            totalP3 = costoP3 * producto.getCantidad();
                        break;
                        case 4:
                            producto.setCantidad(teclado.leer(0, "¿Cuantos pollos de 1/8 desea?"));
                            totalP4 = costoP4 * producto.getCantidad();
                        break;                            
                        default:
                            System.out.print("El valor que ingresó no existe");
                        break;
                    }
                    totalFp = totalP1 + totalP2 + totalP3 + totalP4;
                    System.out.println("Monto a pagar: " + totalFp + " $");
                    opcion = teclado.leer("", "¿Desea comprar mas pollos? SI/NO");
                } while (opcion.equals("SI"));
        
            } else {
                do {
                    System.out.print("Bebidas:\n");
                    System.out.print("1.- Jarra de un litro de Limonada Frozen\n" +
                    "2.- Jarra de un litro de Chicha Morada\n");
                
                    producto.setBebida(teclado.leer(0, "Ingrese: "));
                
                    switch (producto.getBebida()){
                        case 1:
                            producto.setCantidad(teclado.leer(0, "¿Cuantas Jarras de Limonada Frozen desea?"));
                            totalB1 = costoB1 * producto.getCantidad();
                        break;
                        case 2:
                            producto.setCantidad(teclado.leer(0, "¿Cuantas Jarras de Chicha Morada desea?"));
                            totalB2 = costoB2 * producto.getCantidad();
                        break;
                        default:
                            System.out.print("El valor que ingreso no existe");
                        break;
                    }
                    totalFb = totalB1 + totalB2;
                    System.out.println("Monto a pagar es: " + totalFb + " $");
                    opcion=teclado.leer("","¿Desea comprar alguna bebida mas? SI/NO");
                }while(opcion.equals("SI"));
            }
                
            opcion = teclado.leer("","¿Desea comprar algo mas? SI/NO"); 
        }while(opcion.equals("SI"));
    montoF = totalFb + totalFp;
    System.out.println("Monto total a pagar es: " + montoF + " $");

    Date objDate = new Date();
    
    String [][] Matriz = new String[1][3];
    
    Matriz[0][0] = usuario.getNombreCompletos();
    Matriz[0][1] = String.valueOf(montoF);
    Matriz[0][2] = String.valueOf(new SimpleDateFormat("dd-MM-yyyy").format(objDate));
    
    app = new AppCrud();
    archivo = new LeerArchivo("archivo.txt");
    app.agregarContenidoM(archivo, Matriz); 
    }  
}   
