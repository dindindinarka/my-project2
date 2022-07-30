package perc.services;


import javafx.util.Pair;
import org.springframework.stereotype.Service;
import perc.entities.TempOfLocationEntity;
import perc.repositories.LocationRepository;
import perc.repositories.PersentilRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class PersentillService {

    private final PersentilRepository persentilRepository;
    private final LocationRepository locationRepository;
    HashMap temps = new HashMap<Integer, HashMap<Integer, Integer>>();


    public PersentillService(PersentilRepository persentilRepository, LocationRepository locationRepository) {
        this.persentilRepository = persentilRepository;
        this.locationRepository = locationRepository;
        this.temps = getPercentill();

    }
    @ProfilerCustom
    public HashMap<Integer, Integer> create(int locationId, int temperature) {

        var temp = persentilRepository.findByLocationidAndTemperature(locationId, temperature);
        if ((temps.get(locationId) != null) && (!temp.isEmpty())) {
            var count = temp.get(0).getCounttemp() + 1;
            temp.get(0).setCounttemp(count);
            persentilRepository.save(temp.get(0));
            temps.replace(locationId, getPercentillByLocation(locationId));
        } else {
            TempOfLocationEntity newRecord = new TempOfLocationEntity();
            newRecord.setLocationid(locationId);
            newRecord.setTemperature(temperature);
            newRecord.setCounttemp(1);
            persentilRepository.save(newRecord);
            var calcPerc = getPercentillByLocation(locationId);
            temps.putIfAbsent(locationId, new HashMap<Integer, Integer>(temperature, calcPerc));
            temps.replace(locationId, calcPerc);

        }
        return temps;
    }

    @ProfilerCustom
    public HashMap<Integer, HashMap<Integer, Integer>> getPercentill() {
        var listAll = persentilRepository.findAll();
        for (TempOfLocationEntity list : listAll) {
            var percCalc = getPercentillByLocation(list.getLocationid());
            temps.put(list.getLocationid(), percCalc);
        }
        return temps;
    }

    @ProfilerCustom
    public List<Pair<Integer, Integer>> convertToPair(HashMap<Integer, HashMap<Integer, Integer>> hashMap) {
        List<Pair<Integer, Integer>> listPair = new ArrayList<Pair<Integer, Integer>>();
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            listPair.add(new Pair<>(key, getPercentillByLocation(key)));
        }
        return listPair;
    }

    @ProfilerCustom
    public Integer getPercentillByLocation(Integer locationId) {
        Integer p = null;
        var t = persentilRepository.findByLocationid(locationId);
        if (!t.isEmpty()) p = calcPercentile(t, 90);

        return p;
    }


   @ProfilerCustom
    public static int calcPercentile(List<TempOfLocationEntity> latencies, double percentile) {
        latencies.stream().map(TempOfLocationEntity::getTemperature).sorted().
                collect(Collectors.toList());
        int index = (int) Math.ceil(percentile / 100.0 * latencies.size());
        var p = latencies.get(index - 1).getTemperature();
        return p;
    }
}


