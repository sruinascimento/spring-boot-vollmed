package br.com.rsfot.vollmed.domain.appointment;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record NewAppointmentRequest(
        @NotNull
        @Min(1)
        Long doctorId,
        @NotNull
        @Min(1)
        Long patientId,
        @NotNull
        @Future
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime date) {
}
