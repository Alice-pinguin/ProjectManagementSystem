package ua.goit.service.company;


import ua.goit.model.Company;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.view.Command;
import ua.goit.view.View;

public class CreateCompany implements Command {

    private final View view;
    private CrudRepository<Company, Long> companyRepository;

    public CreateCompany(View view,CrudRepository<Company, Long> companyRepository) {
        this.view = view;
        companyRepository = RepositoryFactory.of (Company.class);
    }

    @Override
    public String commandName() {
        return "Create company";
    }

    @Override
    public void process() {

        view.write("Enter a company name");
        String name = view.read();
        view.write("Enter a company city");
        String city = view.read();

        Company company = new Company();
        company.setName (name);
        company.setCity (city);
        companyRepository.create (company);
        view.write("Company created");
    }
}
