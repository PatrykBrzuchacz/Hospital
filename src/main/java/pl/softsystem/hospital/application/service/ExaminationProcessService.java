package pl.softsystem.hospital.application.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.softsystem.hospital.domain.model.Examination;
import pl.softsystem.hospital.domain.model.Patient;
import pl.softsystem.hospital.domain.model.Question;
import pl.softsystem.hospital.domain.model.Result;
import pl.softsystem.hospital.domain.repository.ExaminationRepository;
import pl.softsystem.hospital.domain.repository.PatientRepository;
import pl.softsystem.hospital.web.dto.ExaminationProcessRequest;
import pl.softsystem.hospital.web.dto.PatientExaminationDto;
import pl.softsystem.hospital.web.dto.QuestionWithValueDto;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ExaminationProcessService {

    @Autowired
    private ExaminationRepository examinationRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Transactional //do rollbacku
    public PatientExaminationDto savePatientExamination(ExaminationProcessRequest examinationProcessRequest) {

        Patient patient = patientRepository.findById(examinationProcessRequest.getPatientId()).orElse(null);
        Examination examination = examinationRepository.findById(examinationProcessRequest.getExaminationId()).orElse(null);

        patient.addExamination(examination);

        saveResultExamination(examination.getQuestions(), examinationProcessRequest.getQuestionWithValues(), patient);
        return new PatientExaminationDto(patient.getName(), examination.getName());
    }

    private void saveResultExamination(List<Question> questions, List<QuestionWithValueDto> questionsWithValues, Patient patient) {
        questions.forEach(q -> questionsWithValues.stream()
                .filter(questionWithValueDto -> q.getId().equals(questionWithValueDto.getQuestionId()))
                .findFirst()
                .ifPresent(found -> q.addResult(new Result(found.getValue(), q, patient)))
        );
    }


//    private void saveResultExamination(List<Question> questions, List<QuestionWithValueDto> questionsWithValues, Patient patient) {
//        questions.forEach(q -> {
//                    QuestionWithValueDto found = questionsWithValues.stream()
//                            .filter(questionWithValueDto -> q.getId().equals(questionWithValueDto.getQuestionId()))
//                            .findFirst()
//                            .orElse(null);
//                    if (found != null) {
//                        q.addResult(new Result(found.getValue(), q, patient));
//                    }
//                }
//        );
//    }

}
