package com.necl.function;

import com.necl.model.ConfigSystem;

/**
 *
 * return Number current with variable ConfigMemo (TYPE1511/0001) * ticket current use 
 * and return current number ConfigRun + 1  (TYPE1511/0002) 
 */
public class RunConfigNumber {

    public static ConfigSystem getJobNo(ConfigSystem configSystem) {
        RunConfigNumber runConfigNumber = new RunConfigNumber();
        return runConfigNumber.createJobNo(configSystem);
    }

    private ConfigSystem createJobNo(ConfigSystem configSystem) {
        //JOB
        String type = configSystem.getConfigPrefix();
        //YYMM
        String yymm = configSystem.getConfigText();
        //0000++++
        String numberRun = configSystem.getConfigRun();

        String numberTicket = type + yymm + numberRun;

        String numberRunAfterPlus = plusNumberRun(configSystem.getConfigRun());

        configSystem.setConfigMemo(numberTicket);
        configSystem.setConfigRun(numberRunAfterPlus);

        return configSystem;
    }

    // Plus TicketNumber 
    private String plusNumberRun(String strNumber) {

        int number = Integer.parseInt(strNumber);
        int lengthInDB = 4;
        number++;

        strNumber = String.valueOf(number);

        int round = lengthInDB - strNumber.length();

        for (int i = 0; i < round; i++) {
            strNumber = "0" + strNumber;
        }

        return strNumber;
    }

}
