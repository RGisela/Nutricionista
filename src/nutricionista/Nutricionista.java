/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutricionista;

import Data.PacienteData;
import entidades.Paciente;

/**
 *
 * @author gisela
 */
public class Nutricionista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Paciente paciente1 = new Paciente("Raul",9656,"Cordoba capital","3215646548");
      PacienteData data = new PacienteData();
      data.darAlta(paciente1);
    }
    
}
