/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COVID_AgentBasedSimulation.GUI;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ContactRateDialog extends javax.swing.JDialog {

    public int data[][];

    /**
     * Creates new form ContactRateDialog
     */
    public ContactRateDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        detectFiles();
    }

    public void detectFiles() {
        File directory = new File(".");
        File[] fileList = directory.listFiles();
        ArrayList<String> files = new ArrayList();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].getName().contains("_agentPairContact_") == true) {
                files.add(fileList[i].getName());
            }
        }
        jList1.setModel(new javax.swing.AbstractListModel() {
            @Override
            public int getSize() {
                return files.size();
            }

            @Override
            public Object getElementAt(int index) {
                return files.get(index);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Load");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Write stats");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Dataset read:");

        jLabel2.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addGap(0, 461, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            FileReader filereader = new FileReader(jList1.getSelectedValue());

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(0)
                    .build();
            List<String[]> allData_1 = csvReader.readAll();
            //System.out.println(allData_1.getClass().getTypeName());
            ArrayList<String[]> allData = new ArrayList(allData_1);
            data = new int[allData.size()][allData.size()];
            for (int i = 0; i < allData.size(); i++) {
                for (int j = 0; j < allData.get(i).length; j++) {
                    data[i][j] = Integer.valueOf(allData.get(i)[j]);
                }
                //System.out.println(i);
            }
            jLabel2.setText(jList1.getSelectedValue());
        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            CsvReader cSVReader = new CsvReader();
//            cSVReader.setContainsHeader(false);
//            CsvContainer dataRead;
//            dataRead = cSVReader.read(new File(jList1.getSelectedValue()), StandardCharsets.UTF_8);
//            data = new int[dataRead.getRowCount()][dataRead.getRowCount()];
//            for (int i = 0; i < dataRead.getRows().size(); i++) {
//                for (int j = 0; j < dataRead.getRows().size(); j++) {
//                    data[i][j] = Integer.valueOf(dataRead.getRow(i).getField(j));
//                }
//            }
//            jLabel2.setText(jList1.getSelectedValue());
//        } catch (IOException ex) {
//            Logger.getLogger(ContactRateDialog.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        double averageContactInMinutes=0;
        int averageContactInMinutesCounter=0;
        double averageContactProbabilityIn55DaysAtLeastOnce=0;
        
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data.length;j++){
                if(data[i][j]!=0){
                    averageContactInMinutes=averageContactInMinutes+data[i][j];
                    averageContactProbabilityIn55DaysAtLeastOnce=averageContactProbabilityIn55DaysAtLeastOnce+1;
                    averageContactInMinutesCounter=averageContactInMinutesCounter+1;
                }
            }
        }
        averageContactInMinutes=averageContactInMinutes/((double)averageContactInMinutesCounter);
        averageContactProbabilityIn55DaysAtLeastOnce=averageContactProbabilityIn55DaysAtLeastOnce/((double)(data.length*data.length));
        System.out.println("averageContactInMinutes: "+averageContactInMinutes);
        System.out.println("averageContactProbabilityIn55DaysAtLeastOnce: "+averageContactProbabilityIn55DaysAtLeastOnce);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
