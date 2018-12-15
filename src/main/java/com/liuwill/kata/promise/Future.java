package com.liuwill.kata.promise;

public class Future<T> {
    private Caller<T> caller;
    private Ticket<T> ticket;

    public Future(Caller<T> caller) {
        this.caller = caller;
        this.ticket = new FutureTicket<T>(this);
    }

    Future<T> then(Action<T> action) {
        return new Future<T>((tick) -> {
            try {
                this.caller.next(this.ticket);
                T callResult = this.ticket.lastTicketData();
                tick.resolve(action.done(callResult));
            } catch (Exception exception) {
                tick.reject(exception);
            }
        });
    }

    Future<T> catchError(Exception exception) {
        return new Future<T>((tick) -> {
            tick.reject(exception);
        });
    }
}
