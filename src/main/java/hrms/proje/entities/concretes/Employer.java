package hrms.proje.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Employers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "job_advertisements"})
public class Employer extends User{

    @Column(name = "company_name", length = 50, nullable = false)
    private String companyName;

    @Column(name = "website", length = 50, nullable = false)
    private String website;

    @Column(name = "telephone_number", length = 10, nullable = false)
    private String telephoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;

}
