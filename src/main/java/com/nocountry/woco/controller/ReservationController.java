package com.nocountry.woco.controller;

import com.nocountry.woco.model.request.ReservationRequest;
import com.nocountry.woco.model.response.ReservationResponse;
import com.nocountry.woco.service.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final IReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<ReservationResponse>> getAllReservations() {
        List<ReservationResponse> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponse> getReservationById(@PathVariable int id) {
        ReservationResponse reservation = reservationService.getReservationById(Long.valueOf(id));
        if (reservation != null) {
            return ResponseEntity.ok(reservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ReservationResponse> createReservation(@RequestBody ReservationRequest reservationRequest) {
        ReservationResponse createdReservation = reservationService.createReservation(reservationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationResponse> updateReservation(
            @PathVariable int id, @RequestBody ReservationRequest reservationRequest) {
        ReservationResponse updatedReservation = reservationService.updateReservation(Long.valueOf(id), reservationRequest);
        if (updatedReservation != null) {
            return ResponseEntity.ok(updatedReservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable int id) {
        boolean deleted = reservationService.deleteReservation(Long.valueOf(id));
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<ReservationResponse>> getReservationsByUserId(@PathVariable int id) {
        List<ReservationResponse> reservations = reservationService.getAllReservationsByUserId(Long.valueOf(id));
        return ResponseEntity.ok(reservations);
    }
}

