package com.df.sheJiMoShi.order;

public abstract class Command {
    Reciver reciver;

    public Command(Reciver reciver) {
        this.reciver = reciver;
    }

    abstract void excuted();
}
