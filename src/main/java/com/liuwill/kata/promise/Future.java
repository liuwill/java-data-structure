package com.liuwill.kata.promise;

public class Future<T> {
    private Caller<T> caller;
    private Ticket<T> ticket;
    private T nextResult = null;

    public Future(Caller<T> caller) {
        this.caller = caller;
        this.ticket = new FutureTicket<T>(this);
    }

    Future<T> then(Action<T> action) {
        this.caller.next(this.ticket);
        T callResult = this.ticket.prevTicketData();

        Future<T> nextFuture = new Future<T>((tick) -> {
            try {
                tick.resolve(this.nextResult);
            } catch (Exception exception) {
                tick.reject(exception);
            }
        });

        try {
            this.nextResult = action.done(callResult);
        } catch (Exception exception) {
            nextFuture.ticket.reject(exception);
        }

        return nextFuture;
    }

    Future<T> catchError(ErrorHandler<T> errorHandler) {
        this.ticket.setErrorHandler(errorHandler);
        return new Future<T>((tick) -> {
            tick.reject(this.ticket.getException());
        });
    }
}
