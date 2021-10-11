package ua.goit.service.skill;


import ua.goit.model.Skill;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.CrudCommand;
import ua.goit.view.View;

import java.util.Map;

public class SaveSkill extends CrudCommand {

    public SaveSkill(View view, Map<String, Command> commands) {
        super (view, commands, Skill.class);
    }

        @Override
    public String commandName() {
        return "Save skill";
    }

    @Override
    public String description() {
        return "For saving a new skill, please enter the language and the level of a skill";
    }

    @Override
    public void process() {
        Skill skill = Skill.builder()
                .language (view.read())
                .level (view.read())
                .build();

    }
}
