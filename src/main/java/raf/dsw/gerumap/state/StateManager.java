package raf.dsw.gerumap.state;

import raf.dsw.gerumap.state.concrate.*;

public class StateManager {

    private State currentState;
    private AddElementState addElementState;
    private ConnectState connectState;
    private EraseState eraseState;
    private MoveState moveState;
    private SelectState selectState;
    private ZoomState zoomState;

    public StateManager() {
        initStates();
    }

    private void initStates() {

        this.addElementState = new AddElementState();
        this.connectState = new ConnectState();
        this.eraseState = new EraseState();
        this.moveState = new MoveState();
        this.selectState = new SelectState();
        this.zoomState = new ZoomState();

        this.currentState = addElementState;//Random pocetna vrednost
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setAddElementState() {
        this.currentState = addElementState;
    }

    public void setConnectState() {
        this.currentState = connectState;
    }

    public void setEraseState() {
        this.currentState = eraseState;
    }

    public void setMoveState() {
        this.currentState = moveState;
    }

    public void setSelectState() {
        this.currentState = selectState;
    }

    public void setZoomState() {
        this.currentState = zoomState;
    }
}