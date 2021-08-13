package com.codegym.until.impl;

import com.codegym.until.Age;
import lombok.SneakyThrows;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


public class AgeValidator implements ConstraintValidator<Age, String> {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    ;

    @SneakyThrows
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        String[] startDateArr = value.split("-");
        String dateStarCovert = startDateArr[1] + "/" + startDateArr[2] + "/" + startDateArr[0];
        Date dateStart = simpleDateFormat.parse(dateStarCovert);

        String end = LocalDate.now().toString();
        String[] endDateArr = end.split("-");
        String dateEndCovert = endDateArr[1] + "/" + endDateArr[2] + "/" + endDateArr[0];
        Date dateEnd = simpleDateFormat.parse(dateEndCovert);

        double ageDays = Math.round((dateEnd.getTime() - dateStart.getTime()) / (double) 86400000);

        return ageDays >= 18 * 365;
    }
}
