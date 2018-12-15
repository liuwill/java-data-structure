package com.liuwill.kata.promise;

public class FutureTicket<T> implements Ticket<T> {
    private Future future;
    private T data;
    private ErrorHandler errorHandler;
    private Exception exception;

    public FutureTicket(Future future) {
        this.future = future;
    }

    public void resolve(T response) {
        this.data = response;
    }

    public void reject(Exception exception) {
        this.exception = exception;
        if (this.errorHandler != null) {
            this.errorHandler.handle(exception);
        }
    }

    public Exception getException() {
        if (this.exception == null) {
            return new Exception();
        }
        return this.exception;
    }

    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    public T prevTicketData() {
        return this.data;
    }

}
