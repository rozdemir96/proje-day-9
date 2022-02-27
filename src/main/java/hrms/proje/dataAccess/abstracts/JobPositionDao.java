package hrms.proje.dataAccess.abstracts;

import hrms.proje.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {

    JobPosition findByPositionName(String positionName);
}
