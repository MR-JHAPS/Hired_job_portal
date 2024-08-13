# HIRED & HIRE Job Portal

HIRED & HIRE is a dynamic web project that serves as a job portal. This application manages and displays data using the `a_hired.sql` database.

## Job Portal Features

### For Employees:
- **Sign Up & Sign In**: Register as an employee to access the portal.
- **Search for Jobs**: Find jobs posted by companies, and either **SAVE** them for later or **APPLY** directly.
- **Update Account Information**: Modify your profile details once signed in.
- **Delete Account**: Remove your account from the platform.

### For Companies:
- **Post a Job**: List job vacancies and view them on the homepage.
- **View Applicants**: Access information on candidates who have applied to your postings.
- **Update Account Information**: Edit your company profile after signing in.
- **Delete Account**: Delete your company account from the portal.

## Job Portal Data Logic

- **Employee/Client**: An individual seeking employment.
- **Company**: An organization offering job opportunities.

### Package Structure

The project includes three primary components within the `com.jobmarket` package:

1. **Interfaces:**
   - `File_name`: Contains file names as constants.
   - `DB_config`: Includes database information and properties such as database source, table names, stored procedures, column names, and callable statements as constants.

2. **Modules:**
   - **`com.jobmarket.client`**:
     - **Controller**: Manages actions and requests related to employees.
     - **Model**: Contains classes relevant to employee operations.
   - **`com.jobmarket.company`**:
     - **Controller**: Manages actions and requests related to companies.
     - **Model**: Contains classes relevant to company operations.
   - **`com.jobmarket.hired`**:
     - **Controller**: Provides default settings for job categories, contract types, salary amounts, and country lists.
     - **Model**: Contains classes for default values provided by HIRED & HIRE.

### Important Classes
- `DB_helper_employee.java`
- `DB_helper_company.java`
- `DB_helper_hired.java`

These classes contain methods for key operations such as signing up, login verification, and job display.

## Database Structure

The project database includes the following 10 tables, which are interrelated through foreign keys and multiples views and Store Procedure:

- `employee`
- `company`
- `job`
- `address`
- `city`
- `country`
- `job_category`
- `job_contract`
- `job_salary`
- `employee_saved_job`

**Example Relationships:**
- `company` → `address` → `city` → `country`
- `employee` → `address` → `city` → `country`
- **Job Relationships:**
  - `job` → `job_category`
  - `job` → `job_contract`
  - `job` → `job_salary`
  - `job` → `company`
  - `job`→ `address` → `city` → `country`

---

This README provides an overview of the HIRED & HIRE job portal project, including its features, architecture, and database structure.
