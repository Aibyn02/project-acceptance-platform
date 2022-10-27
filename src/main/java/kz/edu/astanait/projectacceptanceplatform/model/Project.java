package kz.edu.astanait.projectacceptanceplatform.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "company")
    private String company;

    @Column(name = "contact")
    private String contact;

    @Column(name = "accepted")
    private Integer accepted;
}
