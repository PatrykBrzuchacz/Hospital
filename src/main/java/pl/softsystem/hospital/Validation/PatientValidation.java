//package pl.softsystem.hospital.Validation;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import pl.softsystem.hospital.application.service.PatientService;
//import org.springframework.validation.Validator;
//import pl.softsystem.hospital.domain.model.Patient;
//
//import javax.validation.Validation;
//
//
//@Component
//public class PatientValidation implements Validator {
//
//    @Autowired
//    private PatientService patientService;
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return false;
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Patient patient = (Patient) target;
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "notEmpty");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pesel", "notEmpty");
//
//        if (patient.getName().length() < 5 || patient.getName().length() > 20)
//            errors.rejectValue("name", "name.size");
//
//
//        if (patientService.findByName(patient.getName()) != null) {
//            errors.rejectValue("patient", "patient.duplication");
//        }
//
//        if (patient.getPesel() < 8 || patient.getPesel() > 13)
//            errors.rejectValue("pesel", "pesel.size");
//
//
//        if (patientService.findByPesel(patient.getPesel()) != null) {
//            errors.rejectValue("patient", "patient.duplication");
//        }
//    }
//
//}