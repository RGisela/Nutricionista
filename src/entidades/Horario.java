/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author pc
 */
public enum Horario {
    DESAYUNO(8),//(constantes)
    ALMUERZO(12),
    MERIENDA(18),
    CENA(22),
    SNACK(00);
    
    private final int valor;

    Horario(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
    // cada elemento del enumerador Horario tiene un valor asociado. Puedes acceder 
    //al valor asociado llamando al método getValor() en una instancia de Horario.
    
    /*  Horario horario = Horario.DESAYUNO;
       int valor = horario.getValor();
       System.out.println("Valor de DESAYUNO: " + valor);
    */
}
