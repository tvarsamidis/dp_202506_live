package gr.codelearn.dp;

import gr.codelearn.dp.exception.BusinessException;
import gr.codelearn.dp.interfaces.DataSender;
import gr.codelearn.dp.service.DataSenderSelector;
import gr.codelearn.dp.service.EnglishChecker;
import gr.codelearn.dp.service.FileDataReader;
import gr.codelearn.dp.service.ServicePackage;
import gr.codelearn.dp.service.UpperCaseConverter;

import java.util.List;

public class MainNew {
    private static final String ROOT = "data\\";
    private static ServicePackage servicePackage = null;

    public static void main(String[] args) {
        System.out.println("Processing started");
        runBusinessWithExceptionHandlers();
        System.out.println("Processing completed");
    }

    private static ServicePackage getServicePackage() {
        if (servicePackage == null) {
            servicePackage = buildServicePackage();
        }
        return servicePackage;
    }

    private static void runBusinessWithExceptionHandlers() {
        try {
			runBusiness();
		} catch (BusinessException e) {
            e.printStackTrace();
        }
    }

	private static void runBusiness() throws BusinessException {
		System.out.println("Before readFile");
		List<String> originalLines = readData();
		System.out.println("After readFile");
		if (!checkLanguage(originalLines)) {
            processNoValidLanguage();
            return;
        }
		List<String> convertedLines = convertLines(originalLines);
		sendData(convertedLines);
	}

    private static void processNoValidLanguage() {
        System.out.println("No english text, no processing done");
        System.exit(1);
    }

    private static ServicePackage buildServicePackage() {
        System.out.println("At buildServicePackage");
        ServicePackage servicePackage = new ServicePackage.ServicePackageBuilder()
                .dataConverter(new UpperCaseConverter())
                .dataSender(DataSenderSelector.selectSender())
                .dataReader(new FileDataReader())
                .dataChecker(new EnglishChecker())
                .build();
        return servicePackage;
    }

    private static List<String> convertLines(List<String> lines){
        List<String> newLines = getServicePackage().getDataConverter().convertData(lines);
        return newLines;
    }

    private static void sendData(List<String> lines) throws BusinessException {
        DataSender ds = getServicePackage().getDataSender();
        ds.setLines(lines);
        ds.setTarget(ROOT + "output.txt");
        ds.execute();
        if (ds.getResponse().isError()) {
            System.out.println("******** ERROR : " + ds.getResponse().getException().getMessage() + " *********");
        }
    }

    private static boolean checkLanguage(List<String> lines) {
        boolean isEnglish = getServicePackage().getDataChecker().checkData(lines);
        return isEnglish;
    }

    private static List<String> readData() throws BusinessException {
        List<String> lines = getServicePackage().getDataReader().readData(ROOT + "input.txt");
        return lines;
    }
}
