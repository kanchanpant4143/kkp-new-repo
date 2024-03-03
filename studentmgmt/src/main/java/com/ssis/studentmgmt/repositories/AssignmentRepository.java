package com.ssis.studentmgmt.repositories;

import com.ssis.studentmgmt.models.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("assignmentRepo")
public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

    @Query("select a from Assignment a where str_to_date(a.assignedDate,'%Y-%m-%d') = str_to_date(:dated,'%Y-%m-%d')")
    List<Assignment> getAssignmentsByDate(@Param("dated") String dated);

}
