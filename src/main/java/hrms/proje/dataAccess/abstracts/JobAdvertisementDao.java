package hrms.proje.dataAccess.abstracts;

import hrms.proje.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {


}
