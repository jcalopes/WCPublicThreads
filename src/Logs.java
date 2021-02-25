/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 
 *  Nome:João Carlos Abreu Lopes 
    Número:8190221
    Turma:T1
 */
public class Logs {
    
    public void registaAcao(String utilizador,String acao){
       
        try {
            File file = new File("logs/logs.log");
            file.createNewFile();

            Path path = Paths.get("logs/logs.log");
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
            Date date = new Date(); 

            String event="\n"+dateFormat.format(date)+" : "+utilizador+" : "+ acao;
            Files.write(path, event.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);

        } catch (IOException ex) {
        }
       
}
}
