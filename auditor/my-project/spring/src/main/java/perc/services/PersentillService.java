package perc.services;


import javafx.util.Pair;
import org.springframework.stereotype.Service;
import perc.entities.LocationEntity;
import perc.entities.TempOfLocationEntity;
import perc.repositories.LocationRepository;
import perc.repositories.PersentilRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PersentillService {

    private  final PersentilRepository persentilRepository;
    private  final LocationRepository locationRepository;

    public PersentillService(PersentilRepository persentilRepository, LocationRepository locationRepository) {
        this.persentilRepository = persentilRepository;
        this.locationRepository = locationRepository;
    }

    public TempOfLocationEntity create(int locationId, int temperature) {
        TempOfLocationEntity newRecord = new TempOfLocationEntity();
        newRecord.setLocationid(locationId);
        newRecord.setTemperature(temperature);
        persentilRepository.save(newRecord);
        return newRecord;
    }

    public List<Pair< String, Integer>> getPercentill() {

        List<Pair<String, Integer>> l = new ArrayList<>();
        List<LocationEntity> locs = locationRepository.findAll();

        for (LocationEntity locs2: locs){
            l.add(new Pair<>
                    (locs2.getLocationname(), percentile(persentilRepository.findByLocationid(locs2.getId()), 90)));
           /*  locs.stream().map(LocationEntity::getLocationname)
                    .map(id ->l.add(new Pair<>(
                            id, percentile(persentilRepository.findByLocationid(locs2.getId()), 90)))
                    ).collect(Collectors.toList());*/
        };
        return  l;
    }

    public static int percentile(List<TempOfLocationEntity> latencies, double percentile) {

        latencies.stream().map(TempOfLocationEntity::getTemperature).sorted().
                collect(Collectors.toList());
        int index = (int) Math.ceil(percentile / 100.0 * latencies.size());
        var p = latencies.get(index - 1).getTemperature();
        return p;
    }
}


