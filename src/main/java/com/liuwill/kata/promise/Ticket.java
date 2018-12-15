package com.liuwill.kata.promise;

public interface Ticket<T> {

    void resolve(T response);

    void reject(Exception exception);

    Exception getException();

    void setErrorHandler(ErrorHandler errorHandler);

    T prevTicketData();

}
