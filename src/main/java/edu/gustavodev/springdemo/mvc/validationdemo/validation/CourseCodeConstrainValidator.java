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
    public boolean isValid(String codePassedOnTheHtmlFile, ConstraintValidatorContext context) {

        boolean result;

        if (codePassedOnTheHtmlFile != null) {
            result = codePassedOnTheHtmlFile.startsWith(coursePrefix);
        }

        else {
            result = true; //porque esse field não é required;
        }
        
        return result;
    }

}
