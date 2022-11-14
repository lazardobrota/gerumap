package raf.dsw.gerumap.gui.swing.error;


import raf.dsw.gerumap.core.ErrorLogger;
import raf.dsw.gerumap.gui.swing.messageGen.Message;

import java.io.*;


public class FileLogger implements ErrorLogger {

    @Override
    public void log(Message message) {

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter("src\\main\\resources\\loggerFile.txt",true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(message.toString()).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Object notification) {
        this.log((Message) notification);
    }
}
