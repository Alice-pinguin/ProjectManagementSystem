package ua.goit;


import ua.goit.model.Company;
import ua.goit.model.Developer;
import ua.goit.model.Project;
import ua.goit.model.Skill;
import ua.goit.model.Customer;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;

public class CommentQuery {
    public static void main(String[] args) {

        CrudRepository<Developer, Long> developerRepository = RepositoryFactory.of (Developer.class);
        CrudRepository<Company, Long> companyRepository = RepositoryFactory.of (Company.class);
        CrudRepository<Project, Long> projectRepository = RepositoryFactory.of (Project.class);
        CrudRepository<Skill, Long> skillRepository = RepositoryFactory.of (Skill.class);
        CrudRepository<Customer, Long> customerRepository = RepositoryFactory.of (Customer.class);

//        Company company = Company.builder ()
//                .name ("Epam")
//                .city ("Dnipro")
//                .build ();
//        companyRepository.create (company);
//
//        Developer developer = Developer.builder ()
//                .name ("Sam Winchester")
//                .age (32)
//                .gender ("Men")
//                .salary (1234L)
//                .build ();
//
//        developerRepository.create (developer);
//
//        Project project = Project.builder ()
//                .name ("Suternatural")
//                .field ("Movie")
//                .cost (1_000_000L)
//                .createDate ("2020-06-06")
//                .build ();
//        projectRepository.create (project);
//
//        Skill skill = Skill.builder ()
//                .language ("C#")
//                .level ("Middle")
//                .build ();
//        skillRepository.create (skill);
//
//        Customer customer = Customer.builder ()
//                .name ("Fergus Crouly")
//                .industry ("hell king")
//                .city ("Hell city")
//                .build ();
//
//    }
    }
}
