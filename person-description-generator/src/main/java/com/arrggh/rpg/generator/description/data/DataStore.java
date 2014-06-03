package com.arrggh.rpg.generator.description.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DataStore {
    private Map<String, Map<String, Map<String, SystemRaceSexEntry>>> data = new HashMap<>();

    public Set<String> getSystems() {
        return data.keySet();
    }

    public Set<String> getRaces(String system) {
        return data.get(system).keySet();
    }

    public Set<String> getSexes(String system, String race) {
        return data.get(system).get(race).keySet();
    }

    public void add(String system, Map<String, Map<String, SystemRaceSexEntry>> races) {
        data.put(system, races);
    }

    public SystemRaceSexEntry getEntry(String system, String race, String sex) {
        return data.get(system).get(race).get(sex);
    }
}
