package services;

import core.Command;
import core.Request;
import services.factory.BuilderFactory;
import services.factory.CommandServiceFactory;

public class CommandProcessor {

    private CommandServiceFactory commandFactory;

    public CommandProcessor(CommandServiceFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void processCommand(String[] command){
        Command commandType = Command.valueOf(command[0]);
        CommandService commandService = commandFactory.getService(commandType);
        if(commandService == null) {
            System.out.println("Invalid command");
            return;
        }
        Builder builder = BuilderFactory.getRequestBuilder(commandType);
        builder.setValues(command);
        Request request = builder.build();
        commandService.process(request);
    }


}
