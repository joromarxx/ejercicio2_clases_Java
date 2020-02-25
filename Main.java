class Libro
{
   private String codigo;
   private String titulo;
   private String autor;
   private int numPaginas;
   
   //Constructor
   public Libro(String c, String t, String a, int n)
   {
       codigo=c;
       titulo=t;
       autor=a;
       numPaginas=n;
   }
   //metodos
   public String getCodigo()
    {
        return codigo;
    }
   public void setCodigo(String c)
   {
       codigo=c;
   }
   
      public String getTitulo()
    {
        return titulo;
    }
   public void setTitulo(String t)
   {
       titulo=t;
   }

   public String getAutor()
    {
        return autor;
    }
   public void setAutor(String a)
   {
       autor=a;
   }
   public int getNumPaginas()
    {
        return numPaginas;
    }
   public void setNumPaginas(int n)
   {
       numPaginas=n;
   }
   
   // Nos muestra el libro
   
   public String mostrar()
   {
       return titulo + " ( "+autor+", "+ numPaginas+ " )";
   }
}

class Usuario
{
   private String dni;
   private String nombre;
   private String direccion;
   private int telefono;
   private Libro[] prestados;
   private int contador=0;
   
      //Constructor
   public Usuario(String dn, String n, String d, int t)
   {
       dni=dn;
       nombre=n;
       direccion=d;
       telefono=t;
       prestados=new Libro[5];
       
   }
   //metodos
   public String getDni()
    {
        return dni;
    }
   public void setDni(String dn)
   {
       dni=dn;
   }
   
   public String getNombre()
    {
        return nombre;
    }
   public void setNombre(String n)
   {
       nombre=n;
   }
   
   public String getDireccion()
    {
        return direccion;
    }
   public void setDireccion(String d)
   {
       direccion=d;
   }
   
   public int getTelefono()
    {
        return telefono;
    }
   public void setDireccion(int t)
   {
       telefono=t;
   }
   
   public int getContador()
   {
       return contador;
   }
   public void incContador()
   {
       contador++;
   }
     public void decContador()
   {
       contador--;
   }
   public void anyadeLibros(String c, String t, String a, int n)
   {
       if(this.contador<5)
       {
           this.prestados[this.contador]=new Libro(c,t,a,n);
           this.incContador();
       }
       else
       {
           System.out.println("Esta completo con " +this.contador+ " libros, debes eliminar para poder añadir");
       }
   
   }
     public void eliminaLibro(String nombre)
     {
         if(this.getContador()>0)
         {
         int posicion=-1;
         int anterior;
         for (int i=0;i<this.getContador();i++)
         {
             if (this.prestados[i].getCodigo()==nombre)
             {
                 posicion=i;
                 break;
             }
         }
         this.prestados[posicion]=null;
         this.decContador();
         //Si la posición es menor, deberemos mover los libros
         while(posicion<this.getContador())
         {
             
             this.prestados[posicion]=this.prestados[posicion+1];
             posicion++;    
         }
         }
         else
             System.out.println("No hay libros que eliminar");
         
     }
    public void muestraLibros()
    {
        System.out.println(this.getContador());
        for(int i=0;i<this.contador;i++)
        {
        System.out.println("Libro nº "+i+" Autor: "+this.prestados[i].getAutor()+ " Paginas: "+ this.prestados[i].getNumPaginas() );
        //System.out.println(this.prestados[i].getNumPaginas());
        }
        //for(int i=1;i<this.prestados.length;i++)
        //{
         //System.out.println(this.prestados[i].mostrar());
        //}
    }
}
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Libro libro1=new Libro("111AA", "El juego de ender","Jose Manuel",234);
        Libro libro2=new Libro("111AB", "Tiempo de matar","Alumnos",666);
        
        libro1.setNumPaginas(15);
        System.out.println("Libro 1: "+libro1.mostrar());
        System.out.println("Libro 2: "+libro2.mostrar());
        Usuario u2=new Usuario("73568842F","Jose","Sevilla",121212);
        
        Usuario u1=new Usuario("73568842F","Jose","Sevilla",121212);
        //u1.eliminaLibro("111AA");
        u1.anyadeLibros("111AA", "El juego de ender","Jose Manuel",234);
        u1.anyadeLibros("111AB", "Mi test","Pedro Antonio",124);
        u1.anyadeLibros("111AC", "Mi test","Pedro Antonio",125);
        u1.anyadeLibros("111AD", "Mi test","Pedro Antonio",126);
        u1.anyadeLibros("111AE", "Mi test","Pedro Antonio",127);
        u1.eliminaLibro("111AC");
        u1.anyadeLibros("111AE", "Mi test","Pedro Antonio",128);
      
        u1.muestraLibros();
        
        u1.eliminaLibro("111AA");
        u1.anyadeLibros("3434343", "Mi test","Pedro Antonio",129);
        u1.muestraLibros();
    }   
}