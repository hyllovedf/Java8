package com.df.sheJiMoShi.order;

public abstract class Command {
    Chef chef;

    public Command( Chef chef) {
        this.chef = chef;
    }

    abstract void excuted();
}
