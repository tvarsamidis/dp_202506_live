package gr.codelearn.dp.service;

import gr.codelearn.dp.interfaces.DataChecker;
import gr.codelearn.dp.interfaces.DataConverter;
import gr.codelearn.dp.interfaces.DataReader;
import gr.codelearn.dp.interfaces.DataSender;

public class ServicePackage {
    private DataChecker dataChecker;
    private DataConverter dataConverter;
    private DataReader dataReader;
    private DataSender dataSender;

    public ServicePackage(ServicePackageBuilder spb) {
        dataChecker = spb.getDataChecker();
        dataConverter = spb.getDataConverter();
        dataReader = spb.getDataReader();
        dataSender = spb.getDataSender();
    }

    public DataChecker getDataChecker() {
        return dataChecker;
    }

    public DataConverter getDataConverter() {
        return dataConverter;
    }

    public DataReader getDataReader() {
        return dataReader;
    }

    public DataSender getDataSender() {
        return dataSender;
    }


    public static class ServicePackageBuilder {
        private DataChecker dataChecker;
        private DataConverter dataConverter;
        private DataReader dataReader;
        private DataSender dataSender;

        public ServicePackageBuilder dataChecker(DataChecker dataChecker) {
            this.dataChecker = dataChecker;
            return this;
        }

        public ServicePackageBuilder dataConverter(DataConverter dataConverter) {
            this.dataConverter = dataConverter;
            return this;
        }

        public ServicePackageBuilder dataReader(DataReader dataReader) {
            this.dataReader = dataReader;
            return this;
        }

        public ServicePackageBuilder dataSender(DataSender dataSender) {
            this.dataSender = dataSender;
            return this;
        }

        public DataChecker getDataChecker() {
            return dataChecker;
        }

        public DataConverter getDataConverter() {
            return dataConverter;
        }

        public DataReader getDataReader() {
            return dataReader;
        }

        public DataSender getDataSender() {
            return dataSender;
        }

        public ServicePackage build() {
            return new ServicePackage(this);
        }
    }
}