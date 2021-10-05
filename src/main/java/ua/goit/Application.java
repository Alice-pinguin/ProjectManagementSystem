package ua.goit;

import lombok.SneakyThrows;
import ua.goit.controller.ConsoleController;
import ua.goit.model.Company;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.utils.ScriptExecutor;



public class Application {

   @SneakyThrows
    public static void main(String[] args)  {
//      ScriptExecutor.start();
       ConsoleController consoleController = new ConsoleController ();
       consoleController.run ();



   }

    }

