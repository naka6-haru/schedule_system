package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Schedule_date;

public class Schedule_dateValidator {
    public static List<String> validate(Schedule_date s){
        List<String> errors = new ArrayList<String>();

        String start_error = _validateStart(s.getSchedule_start());
        if(!start_error.equals("")){
            errors.add(start_error);
        }

        String last_error = _validateLast(s.getSchedule_last());
        if(!last_error.equals("")){
            errors.add(last_error);
        }

        return errors;
    }

    private static String _validateStart(String schedule_start){
        if(schedule_start == null || schedule_start.equals("")){
            return "はじめの日付を入力してください。";
        }

        return "";
    }

    private static String _validateLast(String schedule_last){
        if(schedule_last == null || schedule_last.equals("")){
            return "さいごの日付を入力してください。";
        }

        return "";
    }
}
