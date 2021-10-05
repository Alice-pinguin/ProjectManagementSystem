package ua.goit.repository;


import ua.goit.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QueryExecutorImpl implements QueryExecutor{

    CrudRepository<Developer, Long> developerRepository = RepositoryFactory.of (Developer.class);
    CrudRepository<Company, Long> companyRepository = RepositoryFactory.of (Company.class);
    CrudRepository<Project, Long> projectRepository = RepositoryFactory.of (Project.class);
    CrudRepository<Skill,Long> skillRepository = RepositoryFactory.of (Skill.class);
    CrudRepository<DeveloperProject, Long> developerProjectRepository = RepositoryFactory.of (DeveloperProject.class);
    CrudRepository<DeveloperSkill, Long> developerSkillRepository = RepositoryFactory.of (DeveloperSkill.class);

    List<Developer> developerList = new ArrayList<> ();
    List<Developer> developerLevel = new ArrayList<> ();
    List<Developer> developerLanguage = new ArrayList<> ();

    @Override
    public Long getTotalSalaryDevelopersByProject(Long id) {
        return developerList.stream()
                .mapToLong (Developer::getSalary)
                .sum();
    }
    @Override
    public  List getListOfDevelopersFromProject(Long id) {
        List<Long> resultId = developerProjectRepository.findAll ().stream ()
                .filter (e -> e.getProjectId ().equals (id))
                .map (DeveloperProject::getDelevoperId)
                .collect (Collectors.toList ());

        for (Long i : resultId) {
            Optional<Developer> byId = developerRepository.findById (i);
            developerList.add (byId.get ());
        }
        return developerList;
    }
    @Override
    public List getDevelopersBySkill(String skill) {
        List<Long> resultSkill = skillRepository.findAll ().stream ()
                .filter (s -> s.getLanguage ().equals (skill))
                .map (Skill::getId)
                .collect (Collectors.toList ());

        for (Long id : resultSkill) {
            List<Long> result = developerSkillRepository.findAll ().stream ()
                    .filter (s -> s.getSkillId ().equals (id))
                    .map (DeveloperSkill::getDeveloperId)
                    .collect (Collectors.toList ());

            for (Long i : result) {
                Optional<Developer> byId = developerRepository.findById (i);
                developerLanguage.add (byId.get ());
            }
        }
            return developerLanguage;

    }

    @Override
    public List getDeveloperByLevel(String level) {
        List<Long> resultLevel = skillRepository.findAll ().stream ()
                .filter (s -> s.getLevel ().equals (level))
                .map (Skill::getId)
                .collect (Collectors.toList ());

        for (Long id : resultLevel) {
            List<Long> result = developerSkillRepository.findAll ().stream ()
                    .filter (s -> s.getSkillId ().equals (id))
                    .map (DeveloperSkill::getDeveloperId)
                    .collect (Collectors.toList ());

            for (Long i : result) {
                Optional<Developer> byId = developerRepository.findById (i);
                developerLevel.add (byId.get ());
            }
        }
        return developerLevel;

    }

    @Override
    public List projectWithCountDevAndDate() {
        return projectRepository.findAll ().stream ()
                .map(p -> p.getCreateDate ().toString() + " - " + p.getName()+ " "+
                        developerList.size ())
                .collect(Collectors.toList());


    }

}





