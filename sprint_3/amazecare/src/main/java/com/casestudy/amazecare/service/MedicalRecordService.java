package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.model.Consultation;
import com.casestudy.amazecare.model.MedicalRecord;
import com.casestudy.amazecare.model.Prescription;
import com.casestudy.amazecare.repository.AppointmentRepository;
import com.casestudy.amazecare.repository.ConsultationRepository;
import com.casestudy.amazecare.repository.MedicalRecordRepository;
import com.casestudy.amazecare.repository.PrescriptionRepository;

/**
 * Service class for handling business logic related to Medical Records.
 */
@Service
public class MedicalRecordService {

    private MedicalRecordRepository medicalRecordRepository;
    private AppointmentRepository appointmentRepository;
    private ConsultationRepository consultationRepository;
    private PrescriptionRepository prescriptionRepository;

    // Constructor-based injection
    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository,
                                AppointmentRepository appointmentRepository,
                                ConsultationRepository consultationRepository,
                                PrescriptionRepository prescriptionRepository) {
        super();
        this.medicalRecordRepository = medicalRecordRepository;
        this.appointmentRepository = appointmentRepository;
        this.consultationRepository = consultationRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    /**
     * Create a medical record by linking appointment, consultation, and optionally prescription.
     * @param appointmentId ID of the appointment
     * @param consultationId ID of the consultation
     * @param prescriptionId (optional) ID of the prescription
     * @param record MedicalRecord object with summary/notes
     * @return Saved MedicalRecord
     * @throws ResourceNotFoundException if any linked resource is missing
     */
    public MedicalRecord createMedicalRecord(int appointmentId, int consultationId, int prescriptionId, MedicalRecord record) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));

        Consultation consultation = consultationRepository.findById(consultationId)
                .orElseThrow(() -> new ResourceNotFoundException("Consultation not found with ID: " + consultationId));

        Prescription prescription = prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription not found with ID: " + prescriptionId));

        record.setAppointment(appointment);
        record.setConsultation(consultation);
        record.setPrescription(prescription);

        return medicalRecordRepository.save(record);
    }

    /**
     * Get all medical records linked to an appointment.
     * @param appointmentId ID of appointment
     * @return List of medical records
     */
    public List<MedicalRecord> getRecordsByAppointment(int appointmentId) {
        return medicalRecordRepository.findByAppointmentId(appointmentId);
    }

    /**
     * Update a medical record.
     * @param recordId ID of the medical record
     * @param updated Updated fields
     * @return Updated MedicalRecord
     * @throws ResourceNotFoundException if record is not found
     */
    public MedicalRecord updateMedicalRecord(int recordId, MedicalRecord updated) {
        MedicalRecord existing = medicalRecordRepository.findById(recordId)
                .orElseThrow(() -> new ResourceNotFoundException("Medical record not found with ID: " + recordId));

        existing.setDiagnosisSummary(updated.getDiagnosisSummary());
        existing.setNotes(updated.getNotes());

        return medicalRecordRepository.save(existing);
    }

    /**
     * Delete a medical record.
     * @param recordId ID of the record
     * @throws ResourceNotFoundException if not found
     */
    public void deleteMedicalRecord(int recordId) {
        MedicalRecord record = medicalRecordRepository.findById(recordId)
                .orElseThrow(() -> new ResourceNotFoundException("Medical record not found with ID: " + recordId));
        medicalRecordRepository.delete(record);
    }
}
