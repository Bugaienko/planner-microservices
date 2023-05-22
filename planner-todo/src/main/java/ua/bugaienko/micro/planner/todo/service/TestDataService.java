package ua.bugaienko.micro.planner.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bugaienko.micro.planner.entity.Category;
import ua.bugaienko.micro.planner.entity.Priority;
import ua.bugaienko.micro.planner.entity.Task;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Sergii Bugaienko
 */

@Service
public class TestDataService {

    private final TaskService taskService;
    private final PriorityService priorityService;
    private final CategoryService categoryService;

    @Autowired
    public TestDataService(TaskService taskService, PriorityService priorityService, CategoryService categoryService) {
        this.taskService = taskService;
        this.priorityService = priorityService;
        this.categoryService = categoryService;
    }

    public boolean initTestData(Long userId) {
        Priority priority = new Priority();
        priority.setColor("#fff");
        priority.setTitle("High");
        priority.setUserId(userId);

        Priority priority1 = new Priority();
        priority1.setColor("#fff");
        priority1.setTitle("Normal");
        priority1.setUserId(userId);

        priority = priorityService.add(priority);
        priority1 = priorityService.add(priority1);

        Category category = new Category();
        category.setTitle("Job");
        category.setUserId(userId);

        Category category1 = new Category();
        category1.setTitle("Family");
        category1.setUserId(userId);

        category = categoryService.add(category);
        category1 = categoryService.add(category1);

        Date tomorrow = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(tomorrow);
        c.add(Calendar.DATE, 1);
        tomorrow = c.getTime();

        Date oneWeek = new Date();
        Calendar c1 = Calendar.getInstance();
        c1.setTime(tomorrow);
        c1.add(Calendar.DATE, 7);
        oneWeek = c1.getTime();


        Task task1 = new Task();
        task1.setTitle("Shopping");
        task1.setCategory(category);
        task1.setPriority(priority);
        task1.setCompleted(true);
        task1.setTaskDate(tomorrow);
        task1.setUserId(userId);

        Task task2 = new Task();
        task2.setTitle("Walking");
        task2.setCategory(category1);
        task2.setPriority(priority1);
        task2.setCompleted(false);
        task2.setTaskDate(oneWeek);
        task2.setUserId(userId);

        taskService.add(task1);
        taskService.add(task2);

        return true;

    }
}
