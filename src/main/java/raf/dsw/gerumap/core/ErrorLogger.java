package raf.dsw.gerumap.core;

import raf.dsw.gerumap.gui.swing.error.ErrorType;

public interface ErrorLogger {

    String log(ErrorType errorType);
}
