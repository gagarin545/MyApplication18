package com.example.ura.myapplication18;


class Control {
    private Command slot;
    Control() {        super();    }
    void SetCommand(Command command) {
        this.slot = command;
    }
    void press(int i){
        slot.execute(i);
    }
}
