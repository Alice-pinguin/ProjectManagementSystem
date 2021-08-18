package ua.goit.service;

import ua.goit.model.Companies;


public  class CompanyService extends SQLConnection<Companies, Long>{

    public CompanyService(String tableName, String... columns) {
        super("companies", "id_company", "name", "city");
    }
}

