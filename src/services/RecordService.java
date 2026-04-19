package services;

import models.*;
import java.util.*;

public class RecordService {
    private List<MaintenanceRecord> records = new ArrayList<>();

    public void addRecord(MaintenanceRecord r) {
        records.add(r);
        System.out.println("Record added!");
    }

    public void viewRecords() {
        if (records.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        for (MaintenanceRecord r : records) {
            r.display(); // polymorphism
        }
    }

    public List<MaintenanceRecord> getRecords() {
        return records;
    }
}