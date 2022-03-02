package hrms.proje.dataAccess.abstracts;

import hrms.proje.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

    List<JobAdvertisement> getByEnabledTrue();

    List<JobAdvertisement> getByEnabledFalse();

    List<JobAdvertisement> getByEnabledTrueOrderByJobPostingDateAsc();

    List<JobAdvertisement> getByEnabledTrueOrderByJobPostingDateDesc();

    List<JobAdvertisement> getByEnabledTrueAndEmployer_Id(int employerId);

}
