



//import modules.Main;
//import modules.SharedInfo;

public class DemoApp {

    public static void main(String[] args){

        SharedInfo sharedObj=new SharedInfo();
         
        Main main=new Main(sharedObj);
        Thread mainBoard=new Thread(main);
        
        mainBoard.start();
        
        try {
            mainBoard.join();
        } catch (InterruptedException ex) {}
    }
    
}
