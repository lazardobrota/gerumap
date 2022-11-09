package raf.dsw.gerumap.gui.swing.error;

import raf.dsw.gerumap.core.ErrorLogger;

public class ConsoleLogger implements ErrorLogger {

    @Override
    public String log(ErrorType errorType) {
        if (errorType.equals(ErrorType.ERROR)) {
            System.out.println("Imas error");
        }
        else if (errorType.equals(ErrorType.EXCEPTION)) {
            System.out.println("Imas exception");
        }
        else if (errorType.equals(ErrorType.WARNING)) {
            System.out.println("Imas warning");
        }

        return null;
    }
}
