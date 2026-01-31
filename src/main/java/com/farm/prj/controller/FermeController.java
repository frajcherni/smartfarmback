package com.farm.prj.controller;

import com.farm.prj.dto.FermeDTO;
import com.farm.prj.dto.FermeRequestDTO;
import com.farm.prj.model.Ferme;
import com.farm.prj.service.FermeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.farm.prj.security.JwtUtil;
import org.springframework.http.HttpStatus;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/fermes")
public class FermeController {

    private final FermeService fermeService;
    private final JwtUtil jwtUtil;

    public FermeController(FermeService fermeService, JwtUtil jwtUtil) {
        this.fermeService = fermeService;
        this.jwtUtil = jwtUtil;
    }

    // GET : /api/fermes
    @GetMapping("/getAllFerme")
    public ResponseEntity<?> getAllFermes(@RequestHeader("Authorization") String token) {
        try {
            System.out.println("DEBUG: getAllFermes called with token: "
                    + token.substring(0, Math.min(token.length(), 15)) + "...");

            if (token == null || !token.startsWith("Bearer ")) {
                System.out.println("DEBUG: Token format invalid: " + token);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Token Format");
            }

            String jwt = token.substring(7);
            Long userId = jwtUtil.extractUserId(jwt);
            System.out.println("DEBUG: Extracted UserId: " + userId);

            if (userId == null) {
                System.out.println("DEBUG: userId is null. Returning 401.");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            List<FermeDTO> fermes = fermeService.getAllFermes(userId)
                    .stream()
                    .map(FermeDTO::new)
                    .toList();
            System.out.println("DEBUG: Found " + fermes.size() + " fermes for user " + userId);
            return ResponseEntity.ok(fermes);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR in getAllFermes: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    // GET : /api/fermes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<FermeDTO> getFermeById(@PathVariable Long id) {
        Ferme ferme = fermeService.getFermeById(id)
                .orElseThrow(() -> new RuntimeException("Ferme non trouvée avec l'id : " + id));
        return ResponseEntity.ok(new FermeDTO(ferme));
    }

    @GetMapping("/test")
    public String test() {
        return "ok";
    }

    // POST : /api/fermes
    @PostMapping("/addFerme")
    public ResponseEntity<FermeDTO> createFerme(@Valid @RequestBody FermeRequestDTO request,
            @RequestHeader("Authorization") String token) {
        String jwt = token.substring(7);
        Long userId = jwtUtil.extractUserId(jwt);

        Ferme ferme = request.toEntity();
        ferme.setUserId(userId);
        Ferme saved = fermeService.saveFerme(ferme);

        return ResponseEntity
                .created(URI.create("/api/fermes/" + saved.getId()))
                .body(new FermeDTO(saved));
    }

    // PUT : /api/fermes/{id}
    @PutMapping("/{id}")
    public ResponseEntity<FermeDTO> updateFerme(@PathVariable Long id,
            @Valid @RequestBody FermeRequestDTO request) {
        Ferme ferme = fermeService.getFermeById(id)
                .orElseThrow(() -> new RuntimeException("Ferme non trouvée avec l'id : " + id));
        request.updateEntity(ferme);
        Ferme updated = fermeService.saveFerme(ferme);
        return ResponseEntity.ok(new FermeDTO(updated));
    }

    // DELETE : /api/fermes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFerme(@PathVariable Long id) {
        fermeService.getFermeById(id)
                .orElseThrow(() -> new RuntimeException("Ferme non trouvée avec l'id : " + id));
        fermeService.deleteFerme(id);
        return ResponseEntity.noContent().build();
    }
}
