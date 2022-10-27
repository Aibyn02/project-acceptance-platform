package kz.edu.astanait.projectacceptanceplatform.dto.response;

import lombok.Data;

@Data
public class ProjectDtoResponse {

    private Long id;

    private String title;

    private String description;

    private String company;

    private String contact;

    private Integer accepted;
}
