package ua.goit;

import lombok.SneakyThrows;
import ua.goit.controller.ConsoleController;

import ua.goit.repository.QueryExecutor;
import ua.goit.repository.QueryExecutorImpl;
import ua.goit.utils.ScriptExecutor;



public class Application {

   @SneakyThrows
    public static void main(String[] args)  {
//      ScriptExecutor.start();
//       ConsoleController consoleController = new ConsoleController ();
//       consoleController.run ();

       QueryExecutor queryExecutor = new QueryExecutorImpl ();

       System.out.println (queryExecutor.getListOfDevelopersFromProject (1L));

       System.out.println (queryExecutor.getTotalSalaryDevelopersByProject (3L));


   }

    }

