// I vl configure store here
// src/store/store.js

import { configureStore } from "@reduxjs/toolkit"
import UserReducer from "./reducers/UserReducer";
import AppointmentReducer from "./reducers/AppointmentReducer";
import ConsultationReducer from "./reducers/ConsultationReducer";
import MedicalRecordReducer from "./reducers/MedicalRecordReducer";
import TestReducer from "./reducers/TestReducer";
import DoctorReducer from "./reducers/DoctorReducer";

// Register all your reducers
const store = configureStore({
    reducer: {
        user: UserReducer,
        appointment: AppointmentReducer,
        consultations: ConsultationReducer,
        medicalRecords: MedicalRecordReducer,
        tests: TestReducer,
        doctor: DoctorReducer
    }
})

export default store; 