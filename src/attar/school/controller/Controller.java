package attar.school.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import attar.school.entity.Admin;
import attar.school.entity.Students;
import attar.school.entity.Subjects;
import attar.school.services.StudentService;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private StudentService studentservice;

	@InitBinder
	public void initbinderprocess(WebDataBinder databinder) {
		StringTrimmerEditor trimedit = new StringTrimmerEditor(true);
		databinder.registerCustomEditor(String.class, trimedit);
	}

	@RequestMapping("/")
	public String homepage(Model model) {

		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "home-page";
	}

	@RequestMapping("/accesspage")
	public String accesspage(@Valid @ModelAttribute("admin") Admin theadmin, BindingResult theresult, Model model) {

		if (!theresult.hasErrors()) {
			List<Students> students = studentservice.getStudents();
			model.addAttribute("students", students);

			return "students-list";
		}

		return "home-page";
	}

	@RequestMapping("/studentaverage")
	public String studentAverage(@RequestParam("studentid") Integer id, Model model) {
		List<Subjects> studentsubject = studentservice.getsubject(id);
		model.addAttribute("subject", studentsubject);

		return "student-subject";
	}

	@RequestMapping("/newstudent")
	public String Addnewstudent(Model model) {
		Students thestudent = new Students();
		model.addAttribute("student", thestudent);
		return "Add-Student";
	}

	@RequestMapping("/savestudent")
	public String SaveStudent(@Valid @ModelAttribute("student") Students thestudent, BindingResult resullt) {
		if (!(resullt.hasErrors())) {
			studentservice.saveStudent(thestudent);
			return "redirect:/accesspage";
		}

		return "Add-Student";

	}

	@RequestMapping("/NewAverage")
	public String FormAverage(@RequestParam("studentid") Integer id, ModelMap model) {
		Subjects newsubject = studentservice.getUpdateSubject(id);
		// if (newsubject == null) {
		// Subjects newsubjectt = new Subjects();
		// model.addAttribute("subject", newsubject);
		// model.addAttribute("id", id);
		// return "New-Average";
		// } else {
		model.addAttribute("subject", newsubject);
		model.addAttribute("id", id);
		return "New-Average";
		// }

	}

	@RequestMapping("/saveaverage")
	public String SaveAverage(@Valid @ModelAttribute("subject") Subjects thesubject, BindingResult result,
			@RequestParam("id") Integer id, Model model) {
		if (!(result.hasErrors())) {
			studentservice.saveAverage(thesubject, id);
			return "redirect:/accesspage";
		}
		model.addAttribute("id", id);
		return "New-Average";
	}

	@RequestMapping("/updatestudent")
	public String UpdateStudent(@RequestParam("studentid") Integer id, Model model) {
		Students thestudent = studentservice.getStudent(id);
		model.addAttribute("student", thestudent);
		return "Add-Student";
	}

	@RequestMapping("/deletestudent")
	public String deleteStudent(@RequestParam("studentid") Integer id) {
		studentservice.deleteStuednt(id);
		return "redirect:/accesspage";

	}
}
