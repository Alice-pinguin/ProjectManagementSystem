package ua.goit.command;



import ua.goit.model.BaseEntity;

import java.util.List;

public interface SQLQuery <ID,E extends BaseEntity<ID>> {

    Object getTotalSalaryDevelopers(Long id);

    List<E> getDeveloperBySkills(String level);

    List<E> getDevelopersByActivity(String activity);

    List<E> projectsWithCountDevelopers();

    List<E> getDevelopersByProjectID(Long id);

}

