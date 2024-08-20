package com.puru.security.controller;

import com.puru.security.entities.Employee;
import com.puru.security.entities.PuruUser;
import com.puru.security.repo.EmployeeRepo;
import com.puru.security.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);


    @Autowired
    private EmployeeRepo employeeRepo;


    @Autowired
    private UserRepository userRepo;

    @GetMapping("/init-emp-user")
    public void init() {
        fetchAllEmploye("localhost");
        fetchAllUser("localhost");
    }

    @GetMapping("populateAllEmployee/{serverIP}")
    public String fetchAllEmploye(@PathVariable String serverIP) {
        try {
            logger.info("fetchAllEmploye- started");
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://" + serverIP +":8081/allemployees/neon/0";
            Employee[] employeeList = restTemplate.getForObject(url, Employee[].class);
            System.out.println("employeeList.length = " + employeeList.length);
            employeeRepo.saveAll(new ArrayList<>(Arrays.asList(employeeList)));
            logger.info("fetchAllEmploye- completed");
            return "Employee Inserted Successfully";
        } catch (Exception e) {
            throw new RuntimeException("Error in fetchAllEmployee" + e.getMessage(), e);
        }
    }

    @GetMapping("populateAllUser/{serverIP}")
    public String fetchAllUser(@PathVariable String serverIP) {
        try {
            logger.info("fetchAllUser- started");
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://"+ serverIP +":8081/allpuruuser/neon/0";
            PuruUser[] employeeList = restTemplate.getForObject(url, PuruUser[].class);
            System.out.println("employeeList.length = " + employeeList.length);

            ArrayList<PuruUser> userArrayList = new ArrayList<>(Arrays.asList(employeeList));
            for (PuruUser user : userArrayList) {
                try {
                    userRepo.save(user);
                } catch (Exception e) {
                    logger.error("Unable to save User: {}-{}, error: {}", user.getUsername(), user.getEmployee().getFullName(), e.getMessage());
                }
            }
//			userRepo.saveAll(userArrayList);

            logger.info("fetchAllUser- completed");
            return "User Inserted Successfully";
        } catch (Exception e) {
            throw new RuntimeException("Unable to fetch all users", e);
        }
    }


//	@Autowired
//	private TextSuggestionService textSuggestionService;

//	@Autowired
//	private RTService rtService;

//	@Autowired
//	private OPDQueueRepo opdQueueRepo;

    //TODO: ONE TIME
//	@GetMapping("/correctemployeedata")
//	public String correctEmployeeData() {
//		List<Employee> eList = employeeRepo.findByActiveTrue();
//
//		for (Employee employee : eList) {
//
//			String gender = employee.getGender();
//			switch (gender) {
//			case "Male":
//				gender = "m";
//				break;
//			case "Female":
//				gender = "f";
//				break;
//			default:
//				break;
//			}
//
//			employee.setGender(gender);
//			employee.contructName();
//			employeeRepo.save(employee);
//		}
//
//		return "Success";
//	}
//
//	@GetMapping("/getconsultantemployee")
//	public List<Employee> getConsultantEmployee() {
////		List<Employee> e = employeeRepo.findByConsultantTrueAndActiveTrue();
//		List<Employee> e = employeeService.getAllActiveConsultant();
//		return e;
//	}
//
////	@GetMapping("/validateemployeeid/{longIdString}")
////	public PuruResult validateEemployeeById(@PathVariable("longIdString") String longIdString) {
////		Long longId = Long.parseLong(longIdString);
////		Employee e = employeeRepo.findByLongId(longId);
////		PuruResult pr = new PuruResult(false);
////		if(e == null) pr.setB(true);
////		return pr;
////	}
//
//	@GetMapping("/getempbylongid/{longIdString}")
//	public Employee getEmpByLongId(@PathVariable("longIdString") Long longId) {
////		Long longId = Long.parseLong(longIdString);
////		Employee e = employeeRepo.findByLongId(longId);
////		return e;
//
//		return employeeService.getEmpByLongIdForEdit(longId);
//	}
//
//	@GetMapping("/maxempid")
//	public Employee getMaxEmpID() {
//
//		Long longId = employeeRepo.getMaxUserLongId();
//		Employee e = new Employee();
//		e.setLongId(longId + 1);
//		return e;
//	}
//
//	@GetMapping("/gettextsuggestions")
//	public List<TextSuggestion> getTextSuggestionForEmployee(Principal user) {
//		return textSuggestionService.getAllTextSuggestionForEmployee(user);
//	}
//
//	@PostMapping("/employee")
//	public Employee upsertEmployee(@RequestBody Employee e, Principal user) {
//		PuruUser updatedBy = userRepo.findByUsername(user.getName());
//		e.setUpdatedBy(updatedBy);
//		e.contructName();
//
//		if (e.getStatus() == HASConstant.EmployeeStatus.RESIGNED || e.getStatus() == HASConstant.EmployeeStatus.TERMINATED) e.setActive(false);
//
//		e = employeeRepo.save(e);
////TODO: Try to set when sclass= "First Visit" is saved for any employee
////		if (e.getConsultant()) {
////			OPDQueue opdQueue = opdQueueRepo.findByConsultant(e);
////			if (opdQueue == null) {
////				opdQueue = new OPDQueue(e);
////				opdQueueRepo.saveFamAtStep1(opdQueue);
////			}
////		}
//
//
//		if (e.getConsultant()) {
//			rtService.saveEmployee(e);
//		}
//
//		return e;
//	}
//
//	@GetMapping("/employee-by-long-id/{longId}")
//	public Employee getEmployeeByLongId(@PathVariable long longId) {
//		return employeeService.getEmpByLongId(longId);
//	}
}
