package com.imos;

import java.util.List;

public class ExceptionMain {

    public static void main(String[] args) {
        try {
            ExceptionMain main = new ExceptionMain();
            String value = main.execute("Testing");
            System.out.println(value);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause().getClass().getName());
            System.out.println(e.getCause().getMessage());
            System.out.println(e.getResponse());
        }
    }

    public <I, O> O execute(I data) throws ServiceException {
        try {
//            return (O) data;
            throw new IllegalArgumentException("Invalid Entry");
        } catch (Exception e) {
//            throw new ServiceException("The execution Failed", e);
            throw ServiceException.builder()
                    .message("The execution Failed")
                    .cause(e)
                    .response(data)
                    .build();
        }
    }

    public static class ServiceException extends Exception {

        private int status;
        private String causeMessage;
        private List<String> validationErrors;
        private Object response;

        public static ServiceExceptionBuilder builder() {
            return new ServiceExceptionBuilder();
        }

        public ServiceException(String message, Throwable cause, int status, String causeMessage, List<String> validationErrors, Object data) {
            super(message, cause);
            this.status = status;
            this.causeMessage = causeMessage;
            this.validationErrors = validationErrors;
            this.response = data;
        }

        public static class ServiceExceptionBuilder {
            private int status;
            private String causeMessage;
            private List<String> validationErrors;
            private Object response;
            private String message;
            private Throwable cause;

            ServiceExceptionBuilder() {

            }

            public ServiceExceptionBuilder status(int status) {
                this.status = status;
                return this;
            }

            public ServiceExceptionBuilder message(String message) {
                this.message = message;
                return this;
            }

            public ServiceExceptionBuilder cause(Throwable cause) {
                this.cause = cause;
                return this;
            }

            public <T> ServiceExceptionBuilder response(T response) {
                this.response = response;
                return this;
            }

            public ServiceException build() {
                return new ServiceException(message, cause, status, causeMessage, validationErrors, response);
            }
        }

        public int getStatus() {
            return status;
        }

        public String getCauseMessage() {
            return causeMessage;
        }

        public List<String> getValidationErrors() {
            return validationErrors;
        }

        public Object getResponse() {
            return response;
        }
    }
}
