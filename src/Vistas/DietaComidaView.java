
package Vistas;

import Data.PacienteData;
import entidades.Paciente;
import java.util.ArrayList;


public class DietaComidaView extends javax.swing.JInternalFrame {

    private Paciente paciente = new Paciente();
    private ArrayList<Paciente>listaP;
    PacienteData pd = new PacienteData();
    
    public DietaComidaView() {
        initComponents();
         listaP = (ArrayList<Paciente>)pd.listarPacientes();
        cargaPaciente();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCbPaciente = new javax.swing.JComboBox<>();
        jRDesayuno = new javax.swing.JRadioButton();
        jRAlmuerzo = new javax.swing.JRadioButton();
        jRMerienda = new javax.swing.JRadioButton();
        jRCena = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTComida = new javax.swing.JTable();
        jBQuitar = new javax.swing.JButton();
        jBAgregar = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Dieta Comida");

        jLabel2.setText("Paciente");

        jRDesayuno.setText("Desayuno");

        jRAlmuerzo.setText("Almuerzo");

        jRMerienda.setText("Merienda");

        jRCena.setText("Cena");

        jTComida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTComida);

        jBQuitar.setText("Quitar");

        jBAgregar.setText("Agregar");

        jBModificar.setText("Modificar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRDesayuno))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRAlmuerzo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRMerienda)
                        .addGap(48, 48, 48)
                        .addComponent(jRCena)
                        .addGap(63, 63, 63))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(jCbPaciente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jBAgregar)
                        .addGap(37, 37, 37)
                        .addComponent(jBQuitar)
                        .addGap(37, 37, 37)
                        .addComponent(jBModificar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCbPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRDesayuno)
                    .addComponent(jRCena)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRMerienda)
                        .addComponent(jRAlmuerzo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregar)
                    .addComponent(jBQuitar)
                    .addComponent(jBModificar))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JButton jBQuitar;
    private javax.swing.JComboBox<Paciente> jCbPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRAlmuerzo;
    private javax.swing.JRadioButton jRCena;
    private javax.swing.JRadioButton jRDesayuno;
    private javax.swing.JRadioButton jRMerienda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTComida;
    // End of variables declaration//GEN-END:variables
private void cargaPaciente() {
        for (Paciente item : listaP) {
            jCbPaciente.addItem(item);
           
        }
    }

}
