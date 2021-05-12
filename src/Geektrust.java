
import services.CommandProcessor;
import services.LedgerDao;
import services.factory.CommandServiceFactory;
import services.impl.LedgerDaoImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Geektrust {

    public static void main(String[] args) {

        LedgerDao LedgerDao = new LedgerDaoImpl();
        CommandServiceFactory commandServiceFactory = new CommandServiceFactory(LedgerDao);
        CommandProcessor commandProcessor = new CommandProcessor(commandServiceFactory);



        String filePath = args[0];
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException ex){
            System.out.println("File not found");
            return;
        }
        String line = null;
        while(true){
            try {
                line = br.readLine();
            } catch (IOException e){
                System.out.println("Unable to read file");
                return;
            }
            if(line == null)
                break;
            String[] values = line.split(" ");
            commandProcessor.processCommand(values);
        }


    }
}
