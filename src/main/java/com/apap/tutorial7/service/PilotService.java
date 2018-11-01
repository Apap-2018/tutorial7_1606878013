package com.apap.tutorial7.service;

import com.apap.tutorial7.model.PilotModel;

public interface PilotService {
    PilotModel getPilotDetailByLicenseNumber (String licenseNumber);
    PilotModel addPilot (PilotModel pilot);
    void deletePilot (PilotModel pilot);
    void updatePilot (PilotModel pilot, String name, int flyHour);

    PilotModel getPilotById(long pilotId);
}
