package com.epam.mjc.io;

import java.io.*;

public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = "", age = "", email = "", phone = "";
        try (java.io.FileReader fileReader = new java.io.FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str;
            int i = 0;
            while ((str = bufferedReader.readLine()) != null) {
                switch (i) {
                    case 0:
                        name = str;
                        break;
                    case 1:
                        age = str;
                        break;
                    case 2:
                        email = str;
                        break;
                    case 3:
                        phone = str;
                        break;
                    default:
                        break;
                }
                i++;
            }
            bufferedReader.close();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

        name = name.replace("Name: ", "");
        age = age.replace("Age: ", "");
        email = email.replace("Email: ", "");
        phone = phone.replace("Phone: ", "");

        return new Profile(name, Integer.parseInt(age), email, Long.parseLong(phone));
    }
}
