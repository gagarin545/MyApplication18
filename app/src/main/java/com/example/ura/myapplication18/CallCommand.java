package com.example.ura.myapplication18;

class CallCommand implements Command{
Icommand icomm;

    public CallCommand(Icommand icommand) {
        this.icomm = icommand;
    }
    @Override
    public void execute(int i) {
        icomm.commit(i);
    }
}
