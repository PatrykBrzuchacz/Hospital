package pl.softsystem.hospital.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.softsystem.hospital.application.service.ExaminationProcessService;
import pl.softsystem.hospital.web.dto.ExaminationProcessRequest;
import pl.softsystem.hospital.web.dto.PatientExaminationDto;

@PreAuthorize("hasRole('DOCTOR')")
@RepositoryRestController
public class ExaminationProcessController {


    @Autowired
    private ExaminationProcessService examinationProcessService;


    @PostMapping("patient/examination/save")
    public ResponseEntity<PatientExaminationDto> savePatientExamination(@RequestBody ExaminationProcessRequest examinationProcessRequest) {
        return ResponseEntity.ok(examinationProcessService.savePatientExamination(examinationProcessRequest));
    }

}
