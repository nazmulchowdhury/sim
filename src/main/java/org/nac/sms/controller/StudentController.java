package org.nac.sms.controller;

import java.util.List;
import javax.validation.Valid;

import org.nac.sms.model.Student;
import org.nac.sms.dao.StudentDao;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

    /**
     * **************Creating a new record in database*****************
     */
    @RequestMapping(value = "student", method = RequestMethod.GET)
    public String registrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    @RequestMapping(value = "student", method = RequestMethod.POST)
    public String registeredStudent(@Valid @ModelAttribute Student student,
            BindingResult result, Model model, RedirectAttributes redir) {
        if (result.hasErrors()) {
            return "register";
        }
        boolean status = studentDao.insertStudent(student);
        if (status) {
            redir.addFlashAttribute("message", "Information successfully registered");
            return "redirect:student/list";
        } else {
            model.addAttribute("message", "Sorry, (Roll or Email or Phone Number or "
                    + "National ID) is already used");
            return "register";
        }
    }

    /**
     * ****************Showing all registered students*******************
     */
    @RequestMapping(value = "student/list", method = RequestMethod.GET)
    public ModelAndView listOfStudents(ModelAndView modelView) {
        List<Student> students = studentDao.getAllStudents();
        modelView.setViewName("list");
        modelView.addObject("students", students);
        return modelView;
    }

    /**
     * *****************Showing a student info**************************
     */
    @RequestMapping(value = "student/{id}", method = RequestMethod.GET)
    public String viewStudent(@PathVariable int id, Model model, RedirectAttributes redir) {
        Student student = studentDao.getStudent(id);
        model.addAttribute("student", student);
        return "view";
    }

    /**
     * ********************Updating a student info***********************
     */
    @RequestMapping(value = "student/{id}", method = RequestMethod.POST)
    public String updateForm(@PathVariable int id, Model model, RedirectAttributes redir) {
        Student studentToBeUpdated = studentDao.getStudent(id);
        model.addAttribute("studentToBeUpdated", studentToBeUpdated);
        return "edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String updatedStudent(@Valid @ModelAttribute("studentToBeUpdated") Student studentToBeUpdated, BindingResult result, Model model, RedirectAttributes redir) {
        if (result.hasErrors()) {
            model.addAttribute("studentToBeUpdated", studentToBeUpdated);
            model.addAttribute("errors", result.getAllErrors());
            return "edit";
        }
        boolean status = studentDao.updateStudent(studentToBeUpdated);
        if (status) {
            redir.addFlashAttribute("message", "Information successfully updated");
            return "redirect:student/list";
        } else {
            model.addAttribute("studentToBeUpdated", studentToBeUpdated);
            model.addAttribute("message", "Sorry, (Roll or Email or Phone Number or "
                    + "National ID) is already used");
            return "edit";
        }
    }

    /**
     * *********************Deleting student from database********************
     */
    @RequestMapping(value = "student", params = {"id"}, method = RequestMethod.POST)
    public String deletedStudent(@RequestParam(value = "id") int id, RedirectAttributes redir) {
        studentDao.deleteStudent(id);
        redir.addFlashAttribute("message", "Information successfully deleted");
        return "redirect:student/list";
    }
}
