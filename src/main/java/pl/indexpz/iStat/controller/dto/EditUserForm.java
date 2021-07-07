package pl.indexpz.iStat.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EditUserForm {
    @NotNull
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}
