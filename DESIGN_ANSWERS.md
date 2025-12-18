# Hotel Reservation System - Design Questions

## Question 1: Should all functions be in the same Service class?

### Current Approach
All business logic is centralized in a single Service class handling room management, user management, booking operations, and reporting.

### Is This Recommended?

No, this violates the Single Responsibility Principle (SRP).

### Recommended Approach

Separate into dedicated services:
- RoomService, UserService, BookingService,  ReportService