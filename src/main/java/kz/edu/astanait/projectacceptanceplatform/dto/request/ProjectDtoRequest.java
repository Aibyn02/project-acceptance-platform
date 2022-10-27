package kz.edu.astanait.projectacceptanceplatform.dto.request;

import lombok.Data;

@Data
public class ProjectDtoRequest {

    private String title;

    private String description;

    private String company;

    private String contact;

    private Integer accepted;
}
