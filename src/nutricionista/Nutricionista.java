
package nutricionista;

import Data.ComidaData;
import Data.DietaComidaData;
import Data.DietaData;
import Data.PacienteData;
import entidades.Comida;
import entidades.Dieta;
import entidades.DietaComida;
import entidades.Paciente;
import java.sql.Date;
import java.time.LocalDate;


public class Nutricionista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //AGREGA UN PACIENTE
        
//      Paciente paciente1 = new Paciente("Raul",9656,"Cordoba capital","3215646548");
//      PacienteData data = new PacienteData();
//      data.darAlta(paciente1);

       //ELIMINA UN PACIENTE
       
//       PacienteData data1 = new PacienteData();
//       data1.eliminarPaciente(3);

      //MODIFICAR Paciente
      
//      PacienteData dat2 = new PacienteData();
//      Paciente paciente2 = new Paciente();
//      paciente2.setIdPaciente(2);
//      paciente2.setNombre("Roberto");
//      paciente2.setDni(12345);
//      paciente2.setDomicilio("Tierra del Fuego");
//      paciente2.setTelefono("12345");
//      dat2.modificarPaciente(paciente2);
    
    //AGREGAR COMIDA
//    Comida comida1 = new Comida("Ensalada ","de lechuga y tomate ",200);
//    ComidaData cd = new ComidaData();
//    cd.agregarComida(comida1);
//    
//

//PacienteData pd = new PacienteData();
//
//for(Paciente pd1 : pd.listarPacientes()){
//    System.out.println(pd1.getNombre());
//    System.out.println(pd1.getDni());
//    System.out.println("--------");
//    }

//DietaData dd = new DietaData();
//LocalDate fecha1= LocalDate.parse("2023-10-29"); 
//for(Dieta dieta1 : dd.listarDietasTerminadas(fecha1)){
//    System.out.println(dieta1.getNombre());
//  System.out.println(dieta1.getFechaFinal());
//    }

//DietaComidaData dcd = new DietaComidaData();
//for(DietaComida dieta1 : dcd.listarComidasEnDietas("Manzana")){
//    System.out.println(dieta1.getComida().getNombre());
//    }
    
//DietaComidaData dcd2 = new DietaComidaData();
//for(Comida dieta1 : dcd2.obtenerComidasEnDietaPorNombre("Dieta falsa")){
//    System.out.println(dieta1.getNombre());
//  
//   ComidaData cd = new ComidaData();
//   Comida comida = cd.buscarComida(1);
//   DietaData dd = new DietaData();
//   Dieta dieta = dd.buscarDieta(1);
//   DietaComida dc = new DietaComida(comida, dieta);
//   DietaComidaData dcd3 = new DietaComidaData();
//   dcd3.agregarDietaComida(dc);
//   
  
   DietaComidaData dcd4 = new DietaComidaData();
   dcd4.modificarComidaEnDieta("Cereales", "dieta vegana");
    }
    
    
    }

    
    

