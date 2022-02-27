package hrms.proje.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Employees")
public class Employee extends User{

    @Column(name = "firstname", length = 25, nullable = false)
    private String firstname;

    @Column(name = "lastname", length = 25, nullable = false)
    private String lastname;

    @Column(name = "birth_of_year", length = 4, nullable = false)
    private String birthOfYear;

    @Column(name = "identity_number", length = 11, nullable = false)
    private String identityNumber;

}
