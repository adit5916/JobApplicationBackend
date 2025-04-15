# Job Board Application Documentation

## Overview
The Job Board Application is a full-stack platform that connects job seekers with employers. The system allows job seekers to browse and apply for jobs, track their application status, while employers can post job listings and manage applications. An admin role provides oversight of the entire platform, including user and content management.

## Tech Stack
- **Backend**: Java Spring Boot
- **Frontend**: Angular
- **Database**: MySQL/PostgreSQL
- **Authentication**: JWT (JSON Web Token)
- **ORM**: Hibernate (via Spring Data JPA)

## User Roles

### Job Seeker
- View all available job listings
- Apply for jobs
- Track application status (Pending, Accepted, Rejected)
- Manage personal profile

### Employer
- Create, edit, and manage job postings
- View applications for all their job listings or for specific jobs
- Accept or reject job applications
- Maintain job status (Open, Filled, Closed)

### Admin
- Full system oversight
- View and edit all jobs, applications, and user accounts
- Manage user access and permissions

## Data Models

### User Entity
```
User {
    id: number;
    first_name: string;
    last_name: string;
    email: string;
    phone: string;
    password: string;
    user_role: UserRole; // ADMIN, EMPLOYER, JOBSEEKER
    user_status: UserStatus; // ACTIVE, INACTIVE
    date_created: string;
}
```

### Job Entity
```
Jobs {
    id: number;
    employer_id: User;
    title: string;
    description: string;
    requirements: string;
    location: string;
    salary_min: number;
    salary_max: number;
    skills: string[];
    experience_required: string;
    education_required: string;
    posted_date: string;
    closing_date: string;
    job_type: JobType; // FULL_TIME, PART_TIME
    job_status: JobStatus; // OPEN, CLOSED, FILLED
}
```

### Application Entity
```
Applications {
    id: number;
    job_id: Job;
    user_id: User;
    apply_date: string;
    application_status: ApplicationStatus; // PENDING, REJECTED, ACCEPTED
}
```

## Authentication Flow

1. User submits login credentials (email and password)
2. Backend validates credentials
3. Upon successful validation, backend generates JWT token containing:
   - JWT token string
   - User role
   - User ID
4. Frontend stores token for subsequent API requests
5. All secured endpoints verify token validity before processing requests

## API Endpoints

### Authentication

#### POST `/api/auth/signup`
- **Description**: Register a new user
- **Access**: Public
- **Request Body**: User registration details
- **Response**: Success message upon registration

#### GET `/api/auth/login`
- **Description**: Authenticate user and generate JWT token
- **Access**: Public
- **Request Body**: Email and password
- **Response**: 
  ```json
  {
    "jwt": "token_string",
    "userRole": "ADMIN|EMPLOYER|JOBSEEKER",
    "userId": 1
  }
  ```

### User Management

#### GET `/api/users`
- **Description**: Get all users
- **Access**: Admin

#### GET `/api/users/{id}`
- **Description**: Get user by ID
- **Access**: Admin or the user themselves

#### GET `/api/users/email/{email}`
- **Description**: Get user by email
- **Access**: Admin or the user themselves

#### POST `/api/users`
- **Description**: Create a new user
- **Access**: Admin
- **Request Body**: User details

#### PUT `/api/users/{id}`
- **Description**: Update an existing user
- **Access**: Admin or the user themselves
- **Request Body**: Updated user details

#### GET `/api/users/role/{role}`
- **Description**: Get users by role (ADMIN, EMPLOYER, JOBSEEKER)
- **Access**: Admin only

### Job Management

#### GET `/api/jobs`
- **Description**: Get all jobs
- **Access**: Public

#### GET `/api/jobs/{id}`
- **Description**: Get job by ID
- **Access**: Public

#### GET `/api/jobs/title/{title}`
- **Description**: Get jobs by title
- **Access**: Public

#### GET `/api/jobs/employer/email/{email}`
- **Description**: Get jobs by employer email
- **Access**: Admin or the specific employer

#### GET `/api/jobs/employer/{id}`
- **Description**: Get jobs by employer ID
- **Access**: Admin or the specific employer

#### POST `/api/jobs`
- **Description**: Create a new job listing
- **Access**: Employers
- **Request Body**: Job details

#### PUT `/api/jobs/{id}`
- **Description**: Update an existing job
- **Access**: Admin or the job creator
- **Request Body**: Updated job details

### Application Management

#### GET `/api/applications`
- **Description**: Get all applications
- **Access**: Admin

#### GET `/api/applications/{id}`
- **Description**: Get application by ID
- **Access**: Admin, the applicant, or the job's employer

#### GET `/api/applications/job/{id}`
- **Description**: Get applications by job ID
- **Access**: Admin or the job's employer

#### GET `/api/applications/employer/{id}`
- **Description**: Get applications by employer ID
- **Access**: Admin or the specific employer

#### GET `/api/applications/user/{id}`
- **Description**: Get applications by user ID
- **Access**: Admin or the specific user

#### POST `/api/applications/add/{jobid}`
- **Description**: Submit a job application
- **Access**: Job seekers
- **Note**: User ID is extracted from JWT token

## User Guides

### Job Seeker Guide

#### Registration and Login
1. Navigate to the login page and select "Register"
2. Complete the registration form, selecting "Job Seeker" as role
3. Login with your email and password

#### Browsing Jobs
1. From the dashboard, view all available job listings
2. Use filters or search to find specific jobs
3. Click on a job to view full details

#### Applying for Jobs
1. From the job details page, click "Apply"
2. Confirm your application submission
3. Track your application status on your dashboard

### Employer Guide

#### Registration and Login
1. Register as an "Employer" on the registration page
2. Login with your email and password

#### Managing Job Listings
1. From your dashboard, view your existing job listings
2. Click "Add New Job" to create a job posting
3. Fill in all required details and set job status to "Open"
4. Use the edit function to update job details or change status

#### Managing Applications
1. View all applications from your dashboard
2. Filter applications by job or status
3. Review individual applications and update status to "Accepted" or "Rejected"

### Admin Guide

#### User Management
1. Access the admin dashboard
2. View and manage all users
3. Edit user details or change user status as needed

#### Content Management
1. View all jobs and applications in the system
2. Edit or remove inappropriate content
3. Manage job and application statuses as needed

## Installation and Setup

### Prerequisites
- Java 17+
- Node.js and Angular CLI
- MySQL/PostgreSQL database

### Backend Setup
1. Clone the repository
2. Configure database connection in application properties
3. Run `mvn clean install` to build the project
4. Start the Spring Boot application

### Frontend Setup
1. Navigate to the Angular project directory
2. Run `npm install` to install dependencies
3. Configure API endpoint in environment files
4. Run `ng serve` to start the development server
5. Access the application at `http://localhost:4200`

## Security Considerations

### JWT Implementation
- Tokens are signed with a secure secret key
- Tokens include user role and ID for authorization
- Token validation occurs for all secured endpoints

### Role-Based Access Control
- Endpoints are secured based on user roles
- Frontend routes are protected with route guards
- API requests verify both authentication and authorization

## Deployment Guide

### Backend Deployment
1. Build the Spring Boot application with `mvn package`
2. Deploy the resulting JAR file to your server
3. Configure environment variables for production

### Frontend Deployment
1. Build the Angular application with `ng build --prod`
2. Deploy the resulting build artifacts to a web server
3. Configure the server to redirect all routes to index.html for Angular routing

## Troubleshooting

### Common Issues
1. **Authentication Failures**
   - Verify correct email and password
   - Check that JWT token is properly stored and included in requests

2. **Permission Errors**
   - Verify user has the correct role for the attempted action
   - Check API endpoint authorization settings

3. **Database Connection Issues**
   - Verify database credentials and connection string
   - Check database server status
