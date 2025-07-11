package Proyecto.Code.src.Model;

import java.io.*;
import java.util.Objects;

public class TripData {
    private String baseFolder = "Trips";

    public void createFolderAndFile(String mail) throws IOException {
        File baseDir = new File(baseFolder);
        if (!baseDir.exists()) {
            baseDir.mkdir();
        }

        File mailDir = new File(baseDir, mail);
        if (!mailDir.exists()) {
            mailDir.mkdir();
        }

        int fileIndex = 1;
        File newFile;
        do {
            newFile = new File(mailDir, "trip " + fileIndex + ".txt");
            fileIndex++;
        } while (newFile.exists());

        newFile.createNewFile();
        System.out.println("Archivo creado: " + newFile.getAbsolutePath());
    }

    public void saveDirectionToFile(String mail, String direction, String type) throws IOException {
        File mailDir = new File(baseFolder, mail);
        if (!mailDir.exists()) {
            return;
        }
        File latestTripFile = findLatestTripFile(mailDir);
        if (latestTripFile != null) {
            try (FileWriter writer = new FileWriter(latestTripFile, true)) {
                writer.write(type + ": " + direction + "\n");
            } catch (IOException e) {
                System.out.println("Error saving the direction: " + e.getMessage());
            }
        }
    }

    private File findLatestTripFile(File mailDir) {
        int highestIndex = 0;
        File latestFile = null;

        for (File file : Objects.requireNonNull(mailDir.listFiles())) {
            if (file.getName().startsWith("trip ")) {
                try {
                    int currentIndex = Integer.parseInt(
                            file.getName().substring(5, file.getName().length() - 4));
                    if (currentIndex > highestIndex) {
                        highestIndex = currentIndex;
                        latestFile = file;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error getting the lates file: " + e.getMessage());
                }
            }
        }
        return latestFile;
    }
    public String getLastPickupAddress(String mail) throws IOException {
        File mailDir = new File(baseFolder, mail);
        if (!mailDir.exists()) {
            return null;
        }

        File latestTripFile = findLatestTripFile(mailDir);
        if (latestTripFile == null) {
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(latestTripFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Pickup: ")) {
                    return line.substring("Pickup: ".length()).trim();
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error getting the pick up direction: " + e.getMessage());
        }
        return null;
    }
    public String getLastArrvieAddress(String mail) throws IOException {
        File mailDir = new File(baseFolder, mail);
        if (!mailDir.exists()) {
            return null;
        }

        File latestTripFile = findLatestTripFile(mailDir);
        if (latestTripFile == null) {
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(latestTripFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Arrive: ")) {
                    return line.substring("Arrive: ".length()).trim();
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error getting the pick up direction: " + e.getMessage());
        }
        return null;
    }
}