/*
*
* @author David León Galisteo
* Crud - Ratonleon versión array list
*
*/

import java.util.ArrayList;
import java.util.Scanner; //importamos la clase Scanner con la que poder introucir datos

public class RatonleonArrayList {
  public static void main(String[] args) {
    System.out.println("Bienvenido al programa de gestión de ratones, \"Ratonleon\".");
    System.out.println();
    
    int option = 0; //en ésta variable guardamos la opción escogida por el usuario.
    Scanner n = new Scanner(System.in);
    
    ArrayList<Raton> r = new ArrayList<>();
    
    r.add(new Raton("Razer", "Laser", 60));
    r.add(new Raton("Logitech", "Óptico", 30));
    r.add(new Raton("Sharkoon", "Inalámbrico", 25));
    
    
      //////////////////////////////////////////////////////////////////////////////////
    boolean exit = false;
    while (!exit) {
      System.out.println("┌───────────────────────────────────────────────────────────────┐");
      System.out.println("│                       Elija una opción                        │");
      System.out.println("└───────────────────────────────────────────────────────────────┘");
      System.out.println("[1]: Visualizar los productos.");
      System.out.println("[2]: Añadir nuevos datos.");
      System.out.println("[3]: Modificar datos existentes.");
      System.out.println("[4]: Eliminar datos.");
      System.out.println("[5]: Salir.");
      System.out.println("────────────────────────────────────────────────────────────────┘");
      System.out.println();
      
      boolean opcionCorrecta = false; //comprueba si la opción escogida por el usuario es correcta
      while (!opcionCorrecta) {
        System.out.print("Opción: ");
        option = Integer.parseInt(n.nextLine());
        System.out.println();
        
        switch (option) {
          case 1:
            visualizar(r);
            opcionCorrecta = true;
            break;
            
          case 2:
            nuevosDatos(r);
            opcionCorrecta = true;
            break;
            
          case 3:
            modificaDatos(r);
            opcionCorrecta = true;
            break;
            
          case 4:
            eliminaDatos(r);
            opcionCorrecta = true;
            break;
            
          case 5:
            opcionCorrecta = true;
            exit = true;
            break;
            
          default:
            System.out.println("La opción elegida no existe, vuelva a introducir un número.");
        }
      }// while
    }//while  39
  }
  
  //////////////////////////////FUNCIONES////////////////////////////////////
  
   /**
  * Visualiza los productos que tenemos guardados
  * @param ArrayList<Raton> arraylist de la clase Raton
  */
  public static void visualizar(ArrayList<Raton> r) {
    int i = 0;      //lo usaremos como índice
    
    System.out.println("┌──────┬─────────────────┬─────────────────┬────────────────┐");
    System.out.println("│Índice│      Marca      │       Tipo      │    Precio      │");
    System.out.println("├──────┼─────────────────┼─────────────────┼────────────────┤");
    
    for (Raton raton : r) {
      System.out.printf("│%6d│ %-15s │ %-15s │ %14.2f │", 
      (i + 1), raton.getMarca(), raton.getTipo(), raton.getPrecio());
      System.out.println();
      i++;
    }
    
    System.out.println("└──────┴─────────────────┴─────────────────┴────────────────┘");
    System.out.println();
    System.out.println();
    
  }
  
  
    /**
  * Añade al ArrayList <code>marca, tipo y precio</code> nuevos valores
  * @param ArrayList<Raton> arraylist de la clase Raton
  */
  
  public static void nuevosDatos(ArrayList<Raton> r) {
    Scanner n = new Scanner(System.in);
    String marca = "";
    String tipo = "";
    int precio = 0;
    
    System.out.print("Por favor introduzc la nueva marca: ");
    marca = n.nextLine();
    System.out.println();
    
    System.out.print("Por favor introduzca el nuevo tipo: ");
    tipo = n.nextLine();
    System.out.println();
    
    System.out.print("Por favor introduzca el precio: ");
    precio = Integer.parseInt(n.nextLine());
    System.out.println();
    
    r.add(new Raton(marca, tipo, precio));
        
    System.out.println();
    System.out.println("Se han añadido correctamente los nuevos valores.");
    System.out.println("Puede usted elegir la opción 1 del menú si desea visualiarlos.");
    System.out.println();
    System.out.println();
  
  }
  
  
  /**
  * Modifica valores ya existentes de un registro.
  * @param <code>i</code> es el índice introducido por el usuario
  * @param <code>ArrayList<Raton> r</code> es el ArrayList de la clase Raton
  */
    
    
  public static void modificaDatos(ArrayList<Raton> r) {
    Scanner f = new Scanner(System.in);
    int indice = 0;
    
    System.out.print("Por favor, introduzca el número de registro que desee modificar: ");
    indice = Integer.parseInt(f.nextLine()) - 1;
    System.out.println();
    
    String marcaIntroducida = "";
    String tipoIntroducido = "";
    String precioIntroducido = "";
    
          
    if (indice < r.size()) {
      System.out.println("Marca actual: " + r.get(indice).getMarca());
      System.out.print("Por favor introduzca la nueva marca (pulse INTRO para NO modificar datos): ");
      marcaIntroducida = f.nextLine();
      if (!marcaIntroducida.equals("")) {
        r.get(indice).setMarca(marcaIntroducida);
      }
      
      System.out.println();
      System.out.println("Tipo actual: " + r.get(indice).getTipo());
      System.out.print("Por favor introduzca el nuevo tipo (pulse INTRO para NO modificar datos): ");
      tipoIntroducido = f.nextLine();
      if (!tipoIntroducido.equals("")) {
        r.get(indice).setTipo(tipoIntroducido);
      }
      
      System.out.println();
      System.out.println("Precio actual: " + r.get(indice).getPrecio());
      System.out.print("Por favor introduzca el precio (pulse INTRO para NO modificar datos): ");
      precioIntroducido = (f.nextLine());
      if (!precioIntroducido.equals("")) {
        r.get(indice).setPrecio(Double.parseDouble(precioIntroducido));
      }
      
      System.out.println();
      
      System.out.println();
      System.out.println("Se han añadido correctamente los nuevos valores.");
      System.out.println("Puede usted elegir la opción 1 del menú si desea visualiarlos.");
      System.out.println();
      System.out.println();
    } else {
      System.out.println("Lo siento, ese índice no existe. Vuelva a elegir la opción 2 del menú.");
    }
        
  }
  
  
  
  /**
  * Elimina / reinicializa los datos de un registro
  * @param <code>ArrayLsit<Raton></code> es el ArrayList de la clase Raton
  */
  
  public static void eliminaDatos(ArrayList<Raton> r) {
    Scanner f = new Scanner(System.in);
      
    System.out.print("Por favor, introduzca el número de registro que desee eliminar: ");
    int indice = Integer.parseInt(f.nextLine());
      
    if (indice < r.size()) {
      r.remove(indice);
          
      System.out.println();
      System.out.println("Se han eliminado correctamente los datos señalados.");
      System.out.println();
      System.out.println();
    } else {
      System.out.println();
      System.out.println("Lo siento, el registro introducido no existe.");
      System.out.println("Vuelva a elegir la opción 2 en el menú.");
      System.out.println();
      System.out.println();
    }
        
  }
}
