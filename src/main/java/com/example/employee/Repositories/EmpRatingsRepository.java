package com.example.employee.Repositories;

import com.example.employee.Models.EmpRatings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRatingsRepository extends JpaRepository<EmpRatings,Integer> {
}
