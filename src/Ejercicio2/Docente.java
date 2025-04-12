package Ejercicio2;

import java.text.DecimalFormat;

public class Docente {

    public static int getContador() {
        return contador;
    }

    public static void setContador(int aContador) {
        contador = aContador;
    }
    //Atributos
    private String codigo;
    private String nombre;
    private String categoria;
    private String estudios;
    private int horaClase;
    static final double porSegu = 0.03;
    private static int contador = 0;
    
    //Constructor
    public Docente(){
        contador++; //Incrementando el contador
        DecimalFormat df = new DecimalFormat("DOC0000");
        codigo = df.format(contador);                
    }

    public String getCodigo() {return codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}
    
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    
    public String getCategoria() {return categoria;}
    public void setCategoria(String categoria) {this.categoria = categoria;}
    
    public String getEstudios() {return estudios;}
    public void setEstudios(String estudios) {this.estudios = estudios;}
    
    public int getHoraClase() {return horaClase;}
    public void setHoraClase(int horaClase) {this.horaClase = horaClase;}
    
    // Metodo
    double PagoHora(){
        if(categoria.equals("Principal")) return 25.00;
        else if(categoria.equals("Asociado")) return 18.00;
        else return 15.00;        
    }
    
    double PagoParcial(){
        return PagoHora() * horaClase;
    }
    
    double Bonificacion(){
       if(categoria.equals("Principal") && estudios.equals("Doctorado")) return 0.20 * PagoParcial();
       if(categoria.equals("Principal") && estudios.equals("Mestria")) return 0.17 * PagoParcial();
         
       if(categoria.equals("Asociado") && estudios.equals("Doctorado")) return 0.15 * PagoParcial();           
       if(categoria.equals("Asociado") && estudios.equals("Mestria")) return 0.10 * PagoParcial();
            
       if(categoria.equals("Auxiliar") && estudios.equals("Doctorado")) return 0.12 * PagoParcial();
       if(categoria.equals("Auxiliar") && estudios.equals("Mestria")) return 0.08 * PagoParcial();
       return 0;
    }
    
    double Descuento(){
        return PagoParcial() * porSegu;
    }
    
    double SueldoFinal(){
        return PagoParcial() + Bonificacion() - Descuento();
    }
    
    String Mostrar(){
        return "\n **********DOCENTE*********\n"+
                "\nCodigo: "+codigo+
                "\nNombre: "+nombre+
                "\ncategoria: " + categoria+
                "\nEstudios: "+estudios+
                "\nHoras de Clase: "+horaClase+
                "\nPago Parcial: "+PagoParcial()+
                "\nBonificacion:" + Bonificacion()+
                "\nSueldo Final:" +SueldoFinal();                
    }
}

