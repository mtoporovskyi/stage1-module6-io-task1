package com.epam.mjc.io;

import java.io.*;
import java.util.HashMap;

public class FileReader {

    public Profile getDataFromFile(File file) {
        String line = null;
        HashMap<String, String> map = new HashMap<>();

        try (BufferedReader in = new BufferedReader(new java.io.FileReader(file))) {
            while ((line = in.readLine()) != null) {
                String[] keyValuePair = line.split(":", 2);
                if (keyValuePair.length > 1) {
                    map.put(keyValuePair[0].trim(), keyValuePair[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.generateProfile(map);
    }

    private Profile generateProfile(HashMap<String, String> map) {
        Profile profile = new Profile();
        profile.setName(map.get("Name"));
        profile.setAge(Integer.valueOf(map.get("Age")));
        profile.setEmail(map.get("Email"));
        profile.setPhone(Long.valueOf(map.get("Phone")));

        return profile;
    }
}