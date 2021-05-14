package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Save_schedule;

public class Save_scheduleValidator {
    public static List<String> validate(Save_schedule ss){
        List<String> errors = new ArrayList<String>();

        String monday1_error = _validateMonday1(ss.getMonday1());
        if(!monday1_error.equals("")){
            errors.add(monday1_error);
        }

        String monday2_error = _validateMonday2(ss.getMonday2());
        if(!monday2_error.equals("")){
            errors.add(monday2_error);
        }

        String tuesday1_error = _validateTuesday1(ss.getTuesday1());
        if(!tuesday1_error.equals("")){
            errors.add(tuesday1_error);
        }

        String tuesday2_error = _validateTuesday2(ss.getTuesday2());
        if(!tuesday2_error.equals("")){
            errors.add(tuesday2_error);
        }

        String wednesday1_error = _validateWednesday1(ss.getWednesday1());
        if(!wednesday1_error.equals("")){
            errors.add(wednesday1_error);
        }

        String wednesday2_error = _validateWednesday2(ss.getWednesday2());
        if(!wednesday2_error.equals("")){
            errors.add(wednesday2_error);
        }

        String thursday1_error = _validateThursday1(ss.getThursday1());
        if(!thursday1_error.equals("")){
            errors.add(thursday1_error);
        }

        String thursday2_error = _validateThursday2(ss.getThursday2());
        if(!thursday2_error.equals("")){
            errors.add(thursday2_error);
        }

        String friday1_error = _validateFriday1(ss.getFriday1());
        if(!friday1_error.equals("")){
            errors.add(friday1_error);
        }

        String friday2_error = _validateFriday2(ss.getFriday2());
        if(!friday2_error.equals("")){
            errors.add(friday2_error);
        }

        String saturday1_error = _validateSaturday1(ss.getSaturday1());
        if(!saturday1_error.equals("")){
            errors.add(saturday1_error);
        }

        String saturday2_error = _validateSaturday2(ss.getSaturday2());
        if(!saturday2_error.equals("")){
            errors.add(saturday2_error);
        }

        String sunday1_error = _validateSunday1(ss.getSunday1());
        if(!sunday1_error.equals("")){
            errors.add(sunday1_error);
        }

        String sunday2_error = _validateSunday2(ss.getSunday2());
        if(!sunday2_error.equals("")){
            errors.add(sunday2_error);
        }
        return errors;
    }

    private static String _validateMonday1(String monday1){
        if(monday1 == null || monday1.equals("")){
            return "月曜日の開始時間を入力してください。";
        }
        return "";
    }

    private static String _validateMonday2(String monday2){
        if(monday2 == null || monday2.equals("")){
            return "月曜日の終了時間を入力してください。";
        }
        return "";
    }

    private static String _validateTuesday1(String tuesday1){
        if(tuesday1 == null || tuesday1.equals("")){
            return "火曜日の開始時間を入力してください。";
        }
        return "";
    }

    private static String _validateTuesday2(String tuesday2){
        if(tuesday2 == null || tuesday2.equals("")){
            return "火曜日の終了時間を入力してください。";
        }
        return "";
    }

    private static String _validateWednesday1(String wednesday1){
        if(wednesday1 == null || wednesday1.equals("")){
            return "水曜日の開始時間を入力してください。";
        }
        return "";
    }

    private static String _validateWednesday2(String wednesday2){
        if(wednesday2 == null || wednesday2.equals("")){
            return "水曜日の終了時間を入力してください。";
        }
        return "";
    }

    private static String _validateThursday1(String thursday1){
        if(thursday1 == null || thursday1.equals("")){
            return "木曜日の開始時間を入力してください。";
        }
        return "";
    }

    private static String _validateThursday2(String thursday2){
        if(thursday2 == null || thursday2.equals("")){
            return "木曜日の終了時間を入力してください。";
        }
        return "";
    }

    private static String _validateFriday1(String friday1){
        if(friday1 == null || friday1.equals("")){
            return "金曜日の開始時間を入力してください。";
        }
        return "";
    }

    private static String _validateFriday2(String friday2){
        if(friday2 == null || friday2.equals("")){
            return "金曜日の終了時間を入力してください。";
        }
        return "";
    }

    private static String _validateSaturday1(String saturday1){
        if(saturday1 == null || saturday1.equals("")){
            return "土曜日の開始時間を入力してください。";
        }
        return "";
    }

    private static String _validateSaturday2(String saturday2){
        if(saturday2 == null || saturday2.equals("")){
            return "土曜日の終了時間を入力してください。";
        }
        return "";
    }

    private static String _validateSunday1(String sunday1){
        if(sunday1 == null || sunday1.equals("")){
            return "日曜日の開始時間を入力してください。";
        }
        return "";
    }

    private static String _validateSunday2(String sunday2){
        if(sunday2 == null || sunday2.equals("")){
            return "日曜日の終了時間を入力してください。";
        }
        return "";
    }
}
