package com.example.ems.model.enums;

public enum AttendanceStatus {
    PRESENT,
    ABSENT,
    LATE,
    ON_LEAVE,  // Note: underscores for multi-word names (Java convention)
    HALF_DAY

//    /**
//     * Converts database string value to enum.
//     * Useful when using @Enumerated(EnumType.STRING) in JPA.
//     */
//    public static AttendanceStatus fromString(String status) {
//        if (status == null || status.trim().isEmpty()) {
//            return null;
//        }
//        // Handle spaces in DB values like "On Leave" → ON_LEAVE
//        switch (status.trim().toLowerCase()) {
//            case "present": return PRESENT;
//            case "absent": return ABSENT;
//            case "late": return LATE;
//            case "on leave": return ON_LEAVE;
//            case "half day": return HALF_DAY;
//            default: throw new IllegalArgumentException("Unknown attendance status: " + status);
//        }
//    }
//
//    /**
//     * Converts enum to database-friendly string (with spaces).
//     * Matches your MySQL ENUM values exactly.
//     */
//    public String toDatabaseValue() {
//        switch (this) {
//            case ON_LEAVE: return "On Leave";
//            case HALF_DAY: return "Half Day";
//            default: return this.name().substring(0, 1).toUpperCase() +
//            this.name().substring(1).toLowerCase().replace('_', ' ');
//        }
//    }
}
