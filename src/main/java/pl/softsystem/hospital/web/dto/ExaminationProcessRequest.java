package pl.softsystem.hospital.web.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExaminationProcessRequest {

    private Long patientId;
    private Long examinationId;
    private List<QuestionWithValueDto> questionWithValues;
}
