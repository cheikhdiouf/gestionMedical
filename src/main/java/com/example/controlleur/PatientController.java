package com.example.controlleur;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Consultation;
import com.example.entities.Medecine;
import com.example.entities.Patient;
import com.example.repository.ConsultationRepository;
import com.example.repository.MedecineRepository;
import com.example.repository.PatientRepository;
import com.example.repository.RendezVousRepository;

@RestController
public class PatientController {
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	RendezVousRepository RendezVous;
	@Autowired
	MedecineRepository medecineRepository;
	@Autowired
	ConsultationRepository consultationRepository;

	@GetMapping(path = "/index")
	public String index() {
		return "index";
	}

	 @GetMapping(path = "/patients")
	public String list(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "mot", defaultValue = "") String mc) {
		Page<Patient> pagePatients = patientRepository.findByNameContains(mc, PageRequest.of(page, size));
		model.addAttribute("patients", pagePatients.getContent());
		model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("mot", mc);
		return "patients";
	}

	@GetMapping(path = "/deletePatient")
	public String deletePatient(Long id) {
		patientRepository.deleteById(id);
		return "redirect:/patients";
	}

	@GetMapping(path = "/formPatient")
	public String formPatient(Model model) {
		model.addAttribute("patient", new Patient());
		return "formPatient";
	}

	@PostMapping(path = "/savePatient")
	public String savePatient(Model model, @Valid Patient patient, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "formPatient";
		patientRepository.save(patient);
		model.addAttribute("patient", patient);
		return "confirmation";
	}

	@GetMapping(path = "/editePatient")
	public String editePatient(Model model, Long id)

	{
		Patient p = patientRepository.findById(id).get();
		model.addAttribute("patient", p);
		return "formPatient";
	}

	@GetMapping(path = "/listPatient")
	@ResponseBody
	public List<Patient> list() {
		return patientRepository.findAll();
	}

	@GetMapping(path = "/listPatient/{id}")
	@ResponseBody
	public Patient listId(@PathVariable Long id) {
		return patientRepository.findById(id).get();
	}

	@GetMapping(path = "/templete1")
	public String index1() {
		return "templete1";
	}

	// controlleur medecine

	@GetMapping(path = "/medecine")
	public String medecin(Model model) {
		List<Medecine> medecine = medecineRepository.findAll();

		model.addAttribute("medecine", medecine);
		return "medecine";
	}

	@GetMapping(path = "/formMedecine")
	public String formMe(Model model) {
		model.addAttribute("medecine", new Medecine());
		return "formMedecine";
	}

	@GetMapping(path = "/deleteMedecine")
	public String DelecteMe(Long id) {
		medecineRepository.deleteById(id);
		return "redirect:/medecine";
	}

	@GetMapping(path = "/editeMdecine")
	public String editeMe(Model model, Long id) {
		Medecine m = medecineRepository.findById(id).get();
		model.addAttribute("medecine", m);
		return "formMedecine";
	}

	@PostMapping(path = "/saveMedecine")
	public String saveMedecine(Model model, @Valid Medecine medecine, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "formMedecine";
		medecineRepository.save(medecine);
		model.addAttribute("medecine", medecine);
		return "medecine";
	}

// consultation

	/*
	 * @GetMapping(path = "/consultation") public String consultation(Model model)
	 * {List<Consultation>consultation=consultationRepository.findAll();
	 * model.addAttribute("consultation",consultation); return"consultation"; }
	 * 
	 * @GetMapping(path = "/formConsultation") public String formCons(Model model) {
	 * model.addAttribute("consultation", new Consultation()); return
	 * "formConsultation"; }
	 * 
	 * @PostMapping(path ="/saveConsultation") public String saveConsultation(Model
	 * model, @Valid Consultation consultation, BindingResult bindingResult) { if
	 * (bindingResult.hasErrors()) return "formConsultation";
	 * consultationRepository.save(consultation); model.addAttribute("consultation",
	 * consultation); return "consultation"; }
	 */
}