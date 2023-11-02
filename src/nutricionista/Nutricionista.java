
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
import java.util.List;

public class Nutricionista {

    public static void main(String[] args) {
        
                                    //PACIENTE
                                    
        //AGREGA UN PACIENTE                            //FUNCIONA
//      PacienteData pData = new PacienteData();
//    Paciente nuevoPaciente = new Paciente("lucas", 94852639, "callao 1500", "1144778855");
//    double pesoInicial = 91.0;
//    LocalDate fechaRegistroInicial = LocalDate.now();// Peso y Fecha para el registro inicial        
//    pData.darAlta(nuevoPaciente, pesoInicial, fechaRegistroInicial);  // Llama al método darAlta

        //ELIMINA UN PACIENTE                           //FUNCIONA
//        PacienteData pData = new PacienteData();       
//        int idPacienteAEliminar = 1; //ID del paciente a eliminar
//        pData.eliminarPaciente(idPacienteAEliminar);// Llama al método eliminarPaciente y su historial

        //MODIFICAR Paciente                            //FUNCIONA
//      PacienteData pacienteData = new PacienteData();        
//    int idPacienteAModificar = 24;// ID del Paciente a modificar 
//    Paciente pacienteAModificar = pacienteData.buscarPacientePorId(idPacienteAModificar);   
//    if (pacienteAModificar != null) {
//        // Modifica los atributos del Paciente
//        pacienteAModificar.setNombre("Micaela");
//        pacienteAModificar.setDni(40122336); // Nuevo DNI
//        pacienteAModificar.setDomicilio("Lizandro de la torre 900");
//        pacienteAModificar.setTelefono("1102325656"); // Nuevo Teléfono
//        double nuevoPeso = 65.0;
//        LocalDate nuevaFechaRegistro = LocalDate.now();// Peso y Fecha para el nuevo registro
//       pacienteData.modificarPaciente(pacienteAModificar, nuevoPeso, nuevaFechaRegistro);// Llama al método modificarPaciente
//    } else {
//        System.out.println("Paciente no encontrado.");
//    }  

        //LISTAR PACIENTES
        PacienteData pacienteData = new PacienteData();
    
    // Llama al método listarPacientes para obtener una lista de todos los Pacientes
    List<Paciente> pacientes = pacienteData.listarPacientes();
    
    // Itera a través de la lista y muestra los detalles de cada Paciente
    for (Paciente paciente : pacientes) {
        System.out.println("Nombre: " + paciente.getNombre());
        System.out.println("DNI: " + paciente.getDni());
        System.out.println("Peso Actual: " + paciente.getPesoActual());
        System.out.println("Dirección: " + paciente.getDomicilio());
        System.out.println("Teléfono: " + paciente.getTelefono());
        System.out.println("-----------------------------------");
    }
        
        
        
                                    //COMIDA
                                    
        //AGREGAR COMIDA                                //FUNCIONA
//    ComidaData cData = new ComidaData();
//    Comida nuevaComida = new Comida("arroz con pollo", "porcion de 300g", 250);
//    cData.agregarComida(nuevaComida); // Llamar al método agregarComida
//    System.out.println("Comida agregada con éxito.");

        //MODIFICAR COMIDA                              //FUNCIONA
//    ComidaData CData = new ComidaData();
//    Comida comidaActualizada = new Comida("Sopa de pollo y verduras", "porcion de 400g", 320);
//    comidaActualizada.setIdComida(4); // ID de la comida a modificar
//    CData.modificarComida(comidaActualizada);// Llamar al método modificarComida
//    System.out.println("Comida modificada con éxito.");

        //ELIMINAR COMIDA                               //FUNCIONA      
//    ComidaData cData = new ComidaData();
//    int idComidaAEliminar = 14; //ID de la comida a eliminar    
//    cData.eliminarComida(idComidaAEliminar); // Llama al método eliminarComida       
//    System.out.println("Comida eliminada con éxito.");
    
        //BUSCAR COMIDA                                 //FUNCIONA  
//     ComidaData cData = new ComidaData();
//    int idComidaABuscar = 1; // ID de la comida a buscar
//    Comida comidaEncontrada = cData.buscarComida(idComidaABuscar);// Llama al método buscarComida
//    if (comidaEncontrada != null) {        
//        System.out.println("Comida encontrada:");
//        System.out.println("ID: " + comidaEncontrada.getIdComida());
//        System.out.println("Nombre: " + comidaEncontrada.getNombre());
//        System.out.println("Detalle: " + comidaEncontrada.getDetalle());
//        System.out.println("Calorías: " + comidaEncontrada.getCantCalorias());
//    } else {
//        System.out.println("La comida no se encontró en la base de datos.");
//    }

        //LISTAR COMIDAS                                //FUNCIONA
//     ComidaData cData = new ComidaData();
//     List<Comida> listaComidas = cData.listarComidas();// Llama al método listarComidas
//    if (!listaComidas.isEmpty()) {
//        System.out.println("Lista de comidas:");
//        for (Comida comida : listaComidas) {
//            System.out.println("ID: " + comida.getIdComida());
//            System.out.println("Nombre: " + comida.getNombre());
//            System.out.println("Detalle: " + comida.getDetalle());
//            System.out.println("Calorías: " + comida.getCantCalorias());
//            System.out.println("-----------------------------------");
//        }
//    } else {
//        System.out.println("No se encontraron comidas en la base de datos.");
//    }   
    
        //BUSCAR COMIDAS CON MENOS CALORIAS             //FUNCIONA
//      ComidaData cData = new ComidaData();    
//    int maxCalorias = 500; // valor maximo de calorias
//            List<Comida> listaComidas = cData.buscarComidasConMenosCalorias(maxCalorias);// Llama al método buscarComidasConMenosCalorias
//    if (!listaComidas.isEmpty()) {
//        System.out.println("Comidas con menos de " + maxCalorias + " calorías:");
//        for (Comida comida : listaComidas) {
//            System.out.println("ID: " + comida.getIdComida());
//            System.out.println("Nombre: " + comida.getNombre());
//            System.out.println("Detalle: " + comida.getDetalle());
//            System.out.println("Calorías: " + comida.getCantCalorias());
//            System.out.println("-----------------------------------");
//        }
//    } else {
//        System.out.println("No se encontraron comidas con menos de " + maxCalorias + " calorías.");
//    }  

        
        
        
        
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
//   DietaComidaData dcd4 = new DietaComidaData();
//   dcd4.modificarPorcionesDeComidaEnDieta("dieta vegana", "Ensalada", 2);
    }

}
