

//import enumerations.EstadoPorta;
//import enumerations.EstadoWC;
//import enumerations.ModoUtilizacaoWC;
//import enumerations.PosicaoChave;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main extends javax.swing.JFrame implements Runnable {

    Thread moedeiro, porta, teclado;
    SharedInfo sharedInfo;
    Semaphore semMainTeclado, semMainPorta, semMoedeiroMain, semPortaMain, semMainMoedeiro;
    Logs logsystem;
    
    public Main(SharedInfo sharedObj) {
        initComponents();
        this.logsystem = new Logs();
        this.sharedInfo = sharedObj;
        this.semMainTeclado = new Semaphore(0);
        this.semMainPorta = new Semaphore(0);
        this.semMoedeiroMain = new Semaphore(0);
        this.semPortaMain = new Semaphore(0);
        this.semMainMoedeiro = new Semaphore(0);
        this.moedeiro = new Thread(new Moedeiro(this.sharedInfo,
                this.semMoedeiroMain, this.semMainMoedeiro, this.logsystem), "Thread Moedeiro");
        this.porta = new Thread(new Porta(this.sharedInfo, this.semMainPorta,
                this.semPortaMain, this.logsystem), "Thread Porta");
        this.teclado = new Thread(new Teclado(this.sharedInfo, this.semMainTeclado), "Thread Teclado");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jradioLivre = new javax.swing.JRadioButton();
        jradioOcupado = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jradioUsar = new javax.swing.JRadioButton();
        jradioDesinfetar = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jlabelAvisos = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlabelDinheiroAtual = new javax.swing.JLabel();
        jradioManutencao = new javax.swing.JRadioButton();
        jprogressbar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Estado:");

        jradioLivre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jradioLivre.setText("Livre");
        jradioLivre.setEnabled(false);

        jradioOcupado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jradioOcupado.setText("Ocupado");
        jradioOcupado.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Modo:");

        jradioUsar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jradioUsar.setText("Usar");
        jradioUsar.setEnabled(false);

        jradioDesinfetar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jradioDesinfetar.setText("Desinfetar");
        jradioDesinfetar.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Avisos:");

        jlabelAvisos.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Dinheiro Introduzido:");

        jradioManutencao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jradioManutencao.setText("Em manutencao");
        jradioManutencao.setEnabled(false);

        jprogressbar.setOpaque(true);
        jprogressbar.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jradioLivre)
                            .addComponent(jradioOcupado)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jlabelAvisos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(31, 31, 31)
                                .addComponent(jlabelDinheiroAtual)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jradioManutencao)
                    .addComponent(jradioDesinfetar)
                    .addComponent(jradioUsar)
                    .addComponent(jLabel2))
                .addContainerGap(153, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jprogressbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jradioLivre)
                    .addComponent(jradioUsar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jradioOcupado)
                    .addComponent(jradioDesinfetar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jradioManutencao)
                    .addComponent(jLabel3))
                .addGap(8, 8, 8)
                .addComponent(jlabelAvisos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jprogressbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jlabelDinheiroAtual))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {     
        float preco=0;
        int tempo=0;
            
        try {
            File file=new File("config/config.txt");
            Scanner scanner=new Scanner(file);
            preco=Float.valueOf(scanner.nextLine());
            sharedInfo.setPreco(preco);
            tempo=Integer.valueOf(scanner.nextLine());
            sharedInfo.setTempo(tempo);
            this.jlabelAvisos.setText("Valores do ficheiro carregados com sucesso."
                    + " Preco: "+preco+" Tempo Desinfecao: "+(tempo/1000)+"s"); 
        } catch (FileNotFoundException | NumberFormatException ex) {
            sharedInfo.setPreco(0.50f);
            sharedInfo.setTempo(10000);
            this.jlabelAvisos.setText("Valores do ficheiro invalidos! Foram definidos Preco:0.50 Tempo Desinfecao:10s");
            
        }
        
        this.jprogressbar.setVisible(false);
        this.setVisible(true);
        this.setLocation(300, 75);
        this.moedeiro.start();
        this.porta.start();
        this.teclado.start();
        synchronized (logsystem) {
            this.logsystem.registaAcao("Thread:Main", "Thread Moedeiro:Started");
            this.logsystem.registaAcao("Thread:Main", "Thread Porta:Started");
            this.logsystem.registaAcao("Thread:Main", "Thread Teclado:Started");
        }
        this.jradioLivre.setSelected(true);
        this.jradioUsar.setSelected(true);

        while (true) {
            try {
                while (semMainTeclado.availablePermits() == 0) {
                    this.jlabelDinheiroAtual.setText(this.sharedInfo.getDinheiroInserido()+"");
                }
                semMainTeclado.acquire();
            } catch (InterruptedException ex) {
            }

            switch (sharedInfo.getBotao()) {
                case "A": {
                    if (this.sharedInfo.getPosicao() != PosicaoChave.NEUTRA) {
                        this.jlabelAvisos.setText("A casa de banho está em manutencao!");
                        synchronized (logsystem) {
                            this.logsystem.registaAcao("Thread:Main", "Acesso Negado à abertura de porta:WC em estado de manutencao!");
                        }
                    }else if (this.sharedInfo.getPorta() == EstadoPorta.ABERTA) {
                        this.jlabelAvisos.setText("A casa de banho está aberta.Aguarde!");
                        synchronized (logsystem) {
                            this.logsystem.registaAcao("Thread:Main", "Acesso Negado a abertura de porta:A porta ja esta aberta.Aguarde!");
                        }
                    } else if (this.sharedInfo.getModo().equals(ModoUtilizacaoWC.DESINFETAR)) {
                        this.jlabelAvisos.setText("A casa de banho esta em desinfecao!");
                        synchronized (logsystem) {
                            this.logsystem.registaAcao("Thread:Main", "Acesso Negado a abertura de porta:WC em estado de desinfecao!");
                        }
                    } else if (this.sharedInfo.getEstado() == EstadoWC.LIVRE && this.sharedInfo.getDinheiroInserido() < this.sharedInfo.preco) {
                        this.jlabelAvisos.setText("Faltam" + (this.sharedInfo.preco
                                - this.sharedInfo.dinheiroInserido) + "");
                        synchronized (logsystem) {
                            this.logsystem.registaAcao("Thread:Main", "Acesso Negado a abertura de porta:Dinheiro Insuficiente!");
                        }
                        //abre para entrar na casa de banho
                    } else if (this.sharedInfo.getEstado() == EstadoWC.LIVRE) {
                        this.sharedInfo.setPorta(EstadoPorta.ABERTA);
                        synchronized (logsystem) {
                            this.logsystem.registaAcao("Thread:Main", "Porta Aberta");
                        }
                        this.jlabelAvisos.setText("Porta aberta");
                         //ativar a thread porta
                       
                        try {
                            this.semMainPorta.release();
                            this.semPortaMain.acquire();
                            this.sharedInfo.setTroco(true);
                            this.semMainMoedeiro.release();
                            this.semMoedeiroMain.acquire();
                            //imprimir troco
                            this.jlabelAvisos.setText(this.sharedInfo.getAvisos());
                        } catch (InterruptedException ex) {}
                        
                    } //sair da casa de banho
                    else if (this.sharedInfo.getEstado() == EstadoWC.OCUPADO) {
                        this.sharedInfo.setPorta(EstadoPorta.ABERTA);
                        synchronized (logsystem) {
                            this.logsystem.registaAcao("Thread:Main", "Saida da casa de banho");
                        }
                        this.jlabelAvisos.setText("Porta aberta");
                        this.semMainPorta.release();
                        try {
                            this.semPortaMain.acquire();
                            this.jprogressbar.setStringPainted(true);
                            this.jprogressbar.setVisible(true);
                            for (int i = 0; i < 5; i++) {
                                this.jprogressbar.setValue(i * 20);
                                Thread.sleep(1000);
                            }
                            this.jprogressbar.setVisible(false);
                        } catch (InterruptedException ex) {
                        }
                        this.sharedInfo.setPorta(EstadoPorta.FECHADA);
                        this.semMainPorta.release();
                        try {
                            this.semPortaMain.acquire();
                            this.jlabelAvisos.setText("Porta fechada");
                        } catch (InterruptedException ex) {
                        }
                        synchronized (logsystem) {
                            this.logsystem.registaAcao("Thread:Main", "Porta Fechada");
                        }
                        this.sharedInfo.setModo(ModoUtilizacaoWC.DESINFETAR);
                        this.jradioDesinfetar.setSelected(true);
                        this.jradioUsar.setSelected(false);
                         this.jlabelAvisos.setText("A desinfetar...");
                        try {
                            this.jprogressbar.setStringPainted(true);
                            this.jprogressbar.setVisible(true);
                            for (int i = 0; i<10; i++) {
                                int t = this.sharedInfo.getTempo() / 10;
                                this.jprogressbar.setValue(i * 10);
                                Thread.sleep(t);
                            }
                            this.jprogressbar.setVisible(false);                       
                       
                        } catch (InterruptedException ex) {
                        }
                        this.sharedInfo.setModo(ModoUtilizacaoWC.USAR);
                        this.jradioDesinfetar.setSelected(false);
                        this.jradioUsar.setSelected(true);
                        this.sharedInfo.setEstado(EstadoWC.LIVRE);
                        this.jradioOcupado.setSelected(false);
                        this.jradioLivre.setSelected(true);
                        this.jlabelAvisos.setText("WC Disponivel");
                    }
                    break;
                }
                case "F": {

                    if (this.sharedInfo.getEstado() == EstadoWC.LIVRE && this.sharedInfo.getPorta() == EstadoPorta.ABERTA) {
                        this.sharedInfo.setPorta(EstadoPorta.FECHADA);
                       
                        try {
                            semMainPorta.release();
                            semPortaMain.acquire();
                            this.sharedInfo.setDinheiroInserido(0);
                            this.sharedInfo.setEstado(EstadoWC.OCUPADO);
                            this.jradioOcupado.setSelected(true);
                            this.jradioLivre.setSelected(false);
                            this.jlabelAvisos.setText("Porta Fechada : WC ocupado");
                            synchronized (logsystem) {
                                this.logsystem.registaAcao("Thread:Main", "Porta Fechada");
                            }
                        } catch (InterruptedException ex) {}
                    } else {
                        this.jlabelAvisos.setText("Nao e permitido o fecho da porta");
                    }
                    break;
                }
                case "C": {
                    if (this.sharedInfo.getPorta() == EstadoPorta.ABERTA && this.sharedInfo.getEstado() == EstadoWC.LIVRE) {
                        try {
                            this.sharedInfo.setPorta(EstadoPorta.FECHADA);
                            this.semMainPorta.release();
                            this.semPortaMain.acquire();    
                            this.semMainMoedeiro.release();          
                            this.semMoedeiroMain.acquire();
                            //Devolve o dinheiro
                            this.jlabelAvisos.setText(this.sharedInfo.getAvisos());
                            this.sharedInfo.setDinheiroInserido(0);
                        } catch (InterruptedException ex) {
                        }
                    } else {
                        this.jlabelAvisos.setText("Nao e permitido cancelar a operacao");
                    }
                    break;
                }
                case "CA": {
                    if (this.sharedInfo.getPosicao() == PosicaoChave.FECHADA || (this.sharedInfo.getEstado() == EstadoWC.LIVRE
                            && this.sharedInfo.getPorta() == EstadoPorta.FECHADA)) {
                        this.sharedInfo.setPorta(EstadoPorta.ABERTA);
                        this.sharedInfo.setEstado(EstadoWC.OCUPADO);
                        this.sharedInfo.setPosicao(PosicaoChave.ABERTA);
                        this.jradioOcupado.setSelected(true);
                        this.jradioLivre.setSelected(false);
                        this.sharedInfo.setModo(ModoUtilizacaoWC.MANUTENCAO);
                        this.jradioManutencao.setSelected(true);
                        this.jradioUsar.setSelected(false);
                        this.jradioDesinfetar.setSelected(false);
                        this.jlabelAvisos.setText("Porta aberta para manutencao");
                    
                        try {
                            this.semMainPorta.release();
                            this.semPortaMain.acquire();
                             synchronized (logsystem) {
                                this.logsystem.registaAcao("Thread:Main", "Porta aberta para manutencao");
                            }
                        } catch (InterruptedException ex) {}                     
                    }
                    else{
                        this.jlabelAvisos.setText("Nao é possivel abrir porta para manutencao");
                    }
                    break;
                }
                case "CN": {
                    if (this.sharedInfo.getModo() == ModoUtilizacaoWC.MANUTENCAO) {
                        this.sharedInfo.setPorta(EstadoPorta.FECHADA);
                        this.sharedInfo.setPosicao(PosicaoChave.NEUTRA);
                        this.sharedInfo.setModo(ModoUtilizacaoWC.USAR);
                        this.jradioUsar.setSelected(true);
                        this.jradioDesinfetar.setSelected(false);
                        this.jradioManutencao.setSelected(false);
                        this.sharedInfo.setEstado(EstadoWC.LIVRE);
                        this.jradioLivre.setSelected(true);
                        this.jradioOcupado.setSelected(false);

                        this.jlabelAvisos.setText("Casa de banho operacional");

                        try {
                            this.semMainPorta.release();
                            this.semPortaMain.acquire();
                            synchronized (logsystem) {
                                this.logsystem.registaAcao("Thread:Main", "Casa de banho operacional");
                            }
                        } catch (InterruptedException ex) {
                        }
                    }
                    else{
                        this.jlabelAvisos.setText("A chave ja se encontra numa posicao neutra");
                    }
                    break;
                }
                case "CF": {
                    if (this.sharedInfo.getPosicao() == PosicaoChave.ABERTA || (this.sharedInfo.getEstado() == EstadoWC.LIVRE
                            && this.sharedInfo.getPorta() == EstadoPorta.FECHADA)) {
                        this.sharedInfo.setPorta(EstadoPorta.FECHADA);
                        this.sharedInfo.setPosicao(PosicaoChave.FECHADA);
                        this.sharedInfo.setModo(ModoUtilizacaoWC.MANUTENCAO);
                        this.jradioManutencao.setSelected(true);
                        this.jradioUsar.setSelected(false);
                        this.jradioDesinfetar.setSelected(false);
                        this.jlabelAvisos.setText("Porta fechada para manutencao");
                    
                        try {
                            this.semMainPorta.release();
                            this.semPortaMain.acquire();
                             synchronized (logsystem) {
                                this.logsystem.registaAcao("Thread:Main", "Porta Fechada para manutencao...");
                            }
                        } catch (InterruptedException ex) {}
                    }
                    else{
                         this.jlabelAvisos.setText("Nao e possivel fechar porta para manutencao");
                    }
                    break;
                }
                case "R": {
                    try {
                        this.sharedInfo.setPorta(EstadoPorta.FECHADA);
                        this.semMainPorta.release();
                        this.semPortaMain.acquire();
                        this.sharedInfo.setDinheiroInserido(0);
                    } catch (InterruptedException ex) {
                    }

                    this.sharedInfo.setModo(ModoUtilizacaoWC.USAR);
                    this.jradioUsar.setSelected(true);
                    this.jradioDesinfetar.setSelected(false);
                    this.jradioManutencao.setSelected(false);
                    this.sharedInfo.setEstado(EstadoWC.LIVRE);
                    this.jradioLivre.setSelected(true);
                    this.jradioOcupado.setSelected(false);
                    this.sharedInfo.setPosicao(PosicaoChave.NEUTRA);
                    this.jlabelAvisos.setText("Sistema reiniciado");
                    synchronized (logsystem) {
                                this.logsystem.registaAcao("Thread:Main", "Sistema reiniciado");
                            }
                    break;
                }
                case "L": {
               
                     if (this.sharedInfo.getEstado() == EstadoWC.LIVRE && this.sharedInfo.getPorta() == EstadoPorta.FECHADA) {
                        try {
                            //Desinfetar
                            this.sharedInfo.setModo(ModoUtilizacaoWC.DESINFETAR);
                            this.jradioDesinfetar.setSelected(true);
                            this.jradioManutencao.setSelected(false);
                            this.jradioUsar.setSelected(false);
                            this.sharedInfo.setEstado(EstadoWC.OCUPADO);
                            this.jradioOcupado.setSelected(true);
                            this.jradioLivre.setSelected(false);
                            this.jlabelAvisos.setText("A desinfetar...");
                            synchronized (logsystem) {
                                this.logsystem.registaAcao("Thread:Main", "Limpeza Forcada");
                            }
                            this.jprogressbar.setStringPainted(true);
                            this.jprogressbar.setVisible(true);
                            for (int i = 0; i < 10; i++) {
                                this.jprogressbar.setValue(i * 10);
                                Thread.sleep(1000);
                            }
                            this.jprogressbar.setVisible(false);
                            
                            //Volta a Disponivel
                            this.sharedInfo.setModo(ModoUtilizacaoWC.USAR);
                            this.jradioDesinfetar.setSelected(false);
                            this.jradioManutencao.setSelected(false);
                            this.jradioUsar.setSelected(true);
                            this.sharedInfo.setEstado(EstadoWC.LIVRE);
                            this.jradioOcupado.setSelected(false);
                            this.jradioLivre.setSelected(true);
                            this.jlabelAvisos.setText("WC Disponivel");
                             if(this.semMainTeclado.availablePermits()>=0){
                                this.semMainTeclado.drainPermits();
                            }
                        } catch (InterruptedException ex) {
                        }
                    } else {
                        this.jlabelAvisos.setText("A casa de banho esta a ser utilizada.Aguarde.");
                    }
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jlabelAvisos;
    private javax.swing.JLabel jlabelDinheiroAtual;
    private javax.swing.JProgressBar jprogressbar;
    private javax.swing.JRadioButton jradioDesinfetar;
    private javax.swing.JRadioButton jradioLivre;
    private javax.swing.JRadioButton jradioManutencao;
    private javax.swing.JRadioButton jradioOcupado;
    private javax.swing.JRadioButton jradioUsar;
    // End of variables declaration//GEN-END:variables
}
