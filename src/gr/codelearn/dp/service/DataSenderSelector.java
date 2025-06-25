package gr.codelearn.dp.service;

import gr.codelearn.dp.interfaces.DataSender;

public class DataSenderSelector {

    private static DataSender selectedSender;

    public static DataSender selectSender() {
        if (selectedSender == null) {
            selectedSender = isSendToFileChoice() ? new FileDataWriter() : new ScreenWriter();
        }
        return selectedSender;
    }

    private static boolean isSendToFileChoice() {
        return Math.random() >= 0.5;
    }
}
