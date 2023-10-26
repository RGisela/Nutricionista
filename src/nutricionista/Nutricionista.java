
package nutricionista;

import Data.ComidaData;
import Data.PacienteData;
import entidades.Comida;
import entidades.Paciente;


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

PacienteData pd = new PacienteData();

for(Paciente pd1 : pd.listarPacientes()){
    System.out.println(pd1.getNombre());
    System.out.println(pd1.getDni());
    System.out.println("--------");
    }
}
}
