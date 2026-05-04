package com.lab.variant;

import com.lab.variant.utils.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FurnitureService {

    private static final String FILE_PATH = "C:/Users/Captain/IdeaProjects/Java/Lab2/src/main/resourсes/data.json";   // ← ИЗМЕНИЛ

    private List<Furniture> furnitures;

    public FurnitureService() {
        furnitures = loadFurnitures();
    }

    public List<Furniture> getAllFurnitures() {
        return furnitures;
    }

    public void addFurniture(Furniture furniture) {
        furnitures.add(furniture);
        saveFurnitures();
    }

    public boolean updateFurniture(Furniture updatedFurniture) {
        for (int i = 0; i < furnitures.size(); i++) {
            if (furnitures.get(i).getId().equals(updatedFurniture.getId())) {
                furnitures.set(i, updatedFurniture);
                saveFurnitures();
                return true;
            }
        }
        return false;
    }

    public boolean deleteFurniture(String id) {
        boolean removed = furnitures.removeIf(f -> f.getId().equals(id));
        if (removed) saveFurnitures();
        return removed;
    }

    private List<Furniture> loadFurnitures() {
        try {
            String json = FileUtil.readFromFile(FILE_PATH);
            System.out.println("JSON loaded: " + json);   // для отладки
            return new Gson().fromJson(json, new TypeToken<List<Furniture>>(){}.getType());
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private void saveFurnitures() {
        try {
            String json = new Gson().toJson(furnitures);
            FileUtil.writeToFile(FILE_PATH, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}