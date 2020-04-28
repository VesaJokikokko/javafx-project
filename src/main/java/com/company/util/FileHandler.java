package com.company.util;

import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.stage.Stage;

public class FileHandler {


    private String tekstiTiedosto;

    public FileHandler() {

    }


    public FileHandler(String tekstiTiedosto) {
        this.tekstiTiedosto = tekstiTiedosto;
    }

    public String openFile() {
        try {
            String sisallys = Files.readString(Paths.get(tekstiTiedosto), Charset.defaultCharset());
            return sisallys;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public void saveFile(String sisalto) {
        try {
            Files.writeString(Paths.get(tekstiTiedosto), sisalto);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getTekstiTiedosto() {
        return tekstiTiedosto;
    }

    public void setTekstiTiedosto(String tekstiTiedosto) {
        this.tekstiTiedosto = tekstiTiedosto;
    }
}