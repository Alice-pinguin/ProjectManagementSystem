package ua.goit.service.company;


import ua.goit.model.Company;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.CrudCommand;
import ua.goit.view.View;

import java.util.Map;

public class SaveCompany extends CrudCommand {

    public SaveCompany(View view, Map<String, Command> commands) {
        super (view, commands, Company.class);
    }

        @Override
    public String commandName() {
        return "Save company";
    }

    @Override
    public String description() {
        return "for saving a new company, please enter the name and the city of a company";
    }

    @Override
    public void process() {
        Company company = Company.builder()
                .name(view.read())
                .city(view.read())
                .build();

    }
}
