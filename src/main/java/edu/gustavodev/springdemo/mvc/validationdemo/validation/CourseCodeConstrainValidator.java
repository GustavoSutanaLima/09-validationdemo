package edu.gustavodev.springdemo.mvc.validationdemo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstrainValidator implements ConstraintValidator<CourseCode, String>{

    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String codeTypedByUserAtTheHtmlForm, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = codeTypedByUserAtTheHtmlForm.startsWith(coursePrefix);
        return result;
    }

}
