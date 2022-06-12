package perc.controllers;

import javafx.util.Pair;
import perc.entities.TempOfLocationEntity;
import perc.services.PersentillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class PercentillController {

    private final PersentillService persentillService;

    @PostMapping()
    public ResponseEntity<TempOfLocationEntity> acceptMeasurement(
            @RequestParam int locationId,
            @RequestParam int temperature) {
        return ResponseEntity.ok(persentillService.create(locationId, temperature));

    }

    @GetMapping()
    public ResponseEntity<List<Pair<String, Integer>>> getTemperatureStatistics()
            {
        return ResponseEntity.ok(persentillService.getPercentill());

    }




}
