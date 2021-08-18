package ua.goit.service;

import ua.goit.model.Developers;

public class DevelopersService extends SQLConnection<Developers, Long> {

    public DevelopersService(String tableName, String... columns) {
        super("developers", "id_developer", "name", "age", "gender", "salary");
    }
}
