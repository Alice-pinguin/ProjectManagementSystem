package ua.goit;

import lombok.SneakyThrows;
import ua.goit.controller.ConsoleController;

import ua.goit.repository.QueryExecutor;
import ua.goit.repository.QueryExecutorImpl;
import ua.goit.utils.ScriptExecutor;
import ua.goit.view.Console;


public class Application {

   @SneakyThrows
    public static void main(String[] args)  {
       ScriptExecutor.start();
       ConsoleController consoleController = new ConsoleController (new Console ());
consoleController.process ();
   }

    }

