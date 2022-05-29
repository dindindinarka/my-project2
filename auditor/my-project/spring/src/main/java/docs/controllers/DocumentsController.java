package docs.controllers;

import docs.services.DocumentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping(path = "/{userName}")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class DocumentsController {

    private final DocumentsService documentsService;


    @PutMapping()
    public ResponseEntity<List<String>> delete(
            @RequestParam String userName,
            @RequestBody Set<Long> ids) {
        return ResponseEntity.ok(documentsService.updateDocs(userName, ids));

    }


}
