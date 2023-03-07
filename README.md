# DoctorBooking_Project
## Frameworks and languages used
* SpringBoot
* Java

## Data flow in the project
1. Controller - It is used to define the path flow of service.
2. Services - It is used to perform the bussiness logics to get desired out put.
3. Repository - it is used to store the data modeling methods.
4. DataBase Design - it is used to store the data.

## Data Structure Used in Project
* ArrayList
## Project Summary
DoctorBooking is project where We used to store the data of Doctors and Patient in Mysql Database.
In this project we had used MVC(Model View Controller) Design.
* When ever we click on the link the action takes place in the Contoller.
* Then it goes to Service layer to perform some business operation and according to the request we had given it will perform.
* Then it goes to the dao layer which is known as Repository layer to store and manipulate the date of Doctor and Patient.

## API's
### Doctor
#### Get : fetch data
* Get All Doctor
```
http://localhost:8080/getAll
```
* Get Doctor by their DoctorId :- required Id in String format.
* it is param variable so we just provide the value in the param. 
```
http://localhost:8080/Doctor
```
#### Post : add data
* Add Doctor
```
http://localhost:8080/CreateDoctor
```
#### Put : Update data
* Update Doctor by their Id :- required Id in String format.
* we need to provide the pathvariable of UserId 
```http
http://localhost:8080/user/{DoctorId}
```
#### The above Links are used to perform operation on the Doctor.

### Posts
#### Get : fetch data
* Get Todo using DoctorId and PatientId as params
```
http://localhost:8080/Doctor?
```
#### Post : add data
* Add Patient
```
 http://localhost:8080/createPatient
```
#### Update : update data
* To update Patient
* We need to give the patientId as path variable
```
http://localhost:8080/post/{patientId}
```
#### The above Links are used to perform operation on the patient.
