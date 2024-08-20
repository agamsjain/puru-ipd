package com.puru.security.repo;

import com.puru.security.entities.Employee;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface EmployeeRepo extends JpaRepositoryImplementation<Employee, String> {

//	List<Employee> findByActiveTrue();
//	List<Employee> findByActiveTrueOrderByLongId();
//	List<Employee> findByConsultantTrueAndActiveTrue();
//	List<Employee> findByActiveTrueAndLastTimeUpdatedGreaterThan(Date date);
//
//	Optional<Employee> findAllByEmail(String email);
//
//	@Query(" select max(e.longId) from Employee e")
//	Long getMaxUserLongId();
//
//	Employee findByLongId(long longId);
//
//	List<Employee> findByFullNameContainingIgnoreCaseAndActiveTrue(String regex);
//	List<Employee> findByFullNameContainingIgnoreCaseAndActiveTrueAndPuruUserStatusTrue(String regex);
//	List<Employee> findByFullNameContainingIgnoreCaseAndActiveTrueAndConsultantTrue(String regex);
//
//	List<Employee> findByConsultantTrue();

    Employee findFirstByLongId(long longId);
}
