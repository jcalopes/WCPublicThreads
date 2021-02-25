

//import enumerations.EstadoPorta;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Semaphore;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Porta extends javax.swing.JFrame implements Runnable {
    SharedInfo sharedObj;
    Semaphore semMainPorta,semPortaMain;
    Logs logSystem;   
    String imagePathFechada,imagePathAberta;
    BufferedImage bufferImageFechada,bufferImageAberta;
    Image imagePortaFechada,imagePortaAberta;
    
    public Porta(SharedInfo sharedObj,Semaphore semMainPorta,Semaphore portaMain,Logs log) {
        initComponents();
        this.sharedObj=sharedObj;
        this.semMainPorta=semMainPorta;
        this.logSystem=log;
        this.semPortaMain=portaMain;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        JRadioAberto = new javax.swing.JRadioButton();
        JRadioFechado = new javax.swing.JRadioButton();
        jlabelporta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Porta");

        JRadioAberto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JRadioAberto.setText("Aberta");
        JRadioAberto.setEnabled(false);

        JRadioFechado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JRadioFechado.setText("Fechada");
        JRadioFechado.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(JRadioAberto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(JRadioFechado)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jlabelporta, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JRadioAberto)
                    .addComponent(JRadioFechado))
                .addGap(18, 18, 18)
                .addComponent(jlabelporta, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        imagePathFechada = "images/portafechada.png";
        try {
            bufferImageFechada = ImageIO.read(new File(imagePathFechada));
        } catch (IOException ex) {
        }
        imagePortaFechada = bufferImageFechada.getScaledInstance(this.jlabelporta.getWidth(),
                this.jlabelporta.getHeight(), Image.SCALE_DEFAULT);
        this.jlabelporta.setIcon(new ImageIcon(imagePortaFechada));

        imagePathAberta = "images/portaaberta.png";
        try {
            bufferImageAberta = ImageIO.read(new File(imagePathAberta));
        } catch (IOException ex) {
        }
        imagePortaAberta = bufferImageAberta.getScaledInstance(this.jlabelporta.getWidth(),
                this.jlabelporta.getHeight(), Image.SCALE_DEFAULT);
        
        this.setVisible(true);
        this.setSize(400, 350);
        this.setLocation(10, 400);
        this.JRadioFechado.setSelected(true);
        while(true){
            try {
                semMainPorta.acquire();
            } catch (InterruptedException ex) {}
            
            //Abre a porta
            if(this.sharedObj.getPorta()==EstadoPorta.ABERTA){ 
                this.JRadioFechado.setSelected(false);
                this.JRadioAberto.setSelected(true);   
                this.jlabelporta.setIcon(new ImageIcon(imagePortaAberta));
                semPortaMain.release();
            }
            //Fecha a porta
            else {
                this.JRadioFechado.setSelected(true);
                this.JRadioAberto.setSelected(false);
                this.jlabelporta.setIcon(new ImageIcon(imagePortaFechada));
                semPortaMain.release();
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton JRadioAberto;
    private javax.swing.JRadioButton JRadioFechado;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlabelporta;
    // End of variables declaration//GEN-END:variables
}
