
import Ventanas.VentanaPrincipal;
import Datos.Heap;
import Datos.Ingreso;


public class main {
    public static void main(String[] args) 
    { 
        Ingreso persona = new Ingreso("Lucia",  "555",4564, "Tico","pOrigen", "pDestino", "Oro",'v');
        
        Ingreso persona1 = new Ingreso("Jepeto",  "555",4564, "Tico","pOrigen", "pDestino", "Especial",'v');
        
         Ingreso persona2 = new Ingreso("Sofia",  "555",4564, "Tico","pOrigen", "pDestino", "Especial",'v');
        
        Heap arbol =  new Heap(persona);
        
        arbol.addNodo(persona1);
        arbol.addNodo(persona2);
        
        System.out.println("La raiz es: "+arbol.getRaiz().getValor().getNombre());
        System.out.println("El hijo izquierdo es: "+arbol.getRaiz().getHojaIzquierda().getValor().getNombre());
        System.out.println("El hijo izquierdo del hijo izquierdo es: "+arbol.getRaiz().getHojaIzquierda().getHojaIzquierda().getValor().getNombre());
        
        arbol.delete(2);
        
       
        System.out.println("La raiz es: "+arbol.getRaiz().getValor().getNombre());
        System.out.println("El hijo izquierdo es: "+arbol.getRaiz().getHojaIzquierda().getValor().getNombre());
//        System.out.println(arbol.getRaiz().getHojaIzquierda().getHojaIzquierda().getValor().getNombre());
        

        
       
    
        
    }
}
