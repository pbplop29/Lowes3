# Errors (For Prabhat Sir)

From being filled:

<div align ="center">
<img src="https://i.ibb.co/LZWRFQB/chrome-quis-BBIHV4.png">
</div>

Json Data being sent:

```json
{
  "surveyTitle": "Survey 1",
  "surveyDescription": "Survey 1 Description",
  "questions": [
    {
      "questionType": "Descriptive",
      "questionDescription": "Question 1 Survey 1"
    },
    {
      "questionType": "Descriptive",
      "questionDescription": "Question 2 Survey 1"
    }
  ]
}
```

Survey table being updated:

<div align ="center">
<img src="https://i.ibb.co/cQMVHnx/chrome-Vk-FDITD7qr.png">
</div>
Question table being updated:
<div align ="center">
<img src="https://i.ibb.co/kQVfFjZ/chrome-q-U8bqayf-Bt.png">
</div>
Errors:
<div align ="center">
<img src="https://i.ibb.co/KjMpNzL/chrome-d-Io-At-Pi6fc.png">
</div>
<div align ="center">
<img src="https://i.ibb.co/98CJRHx/chrome-wc4si-GUna-Q.png">
</div>

# Tasks done

> 1. Rest API using JAVA and Springboot
> 2. Frontend using REACT

```
✅✅✅ Last stable : Submitting the create survey form on react page,
         adds the survey and respective questions to their tables in
         the database through the REST API with proper mapping


Created Pages and Routes:✅
Routing ✅
Home Page ✅
Create Survey Page -- Generates Json for Survey ✅


Routes Created but Content Remaining:❓
About Page ❓
Edit Survey Page ❓
Respond to Survey Page ❓

No Routes and No Pages:❌
SignUp/SignIn Page ❌
User Authentication ❌

Connection to Spring REST API:❌
Create Survey Page ✅
Edit Survey Page ❌
Respond to Survey Page ❌
Get Survey Details ❌
```

# Establishing Relationship

Please Go through the following link to understand the OneToMany, ManyToOne and other types of mappings.

> swagger stuff please look into, easier than postman

> https://dev.to/jhonifaber/hibernate-onetoone-onetomany-manytoone-and-manytomany-8ba

<div align ="center">
<img title="Task" alt="Task Description Image" src="https://i.ibb.co/Lns5bXJ/Whats-App-Image-2023-04-23-at-15-08-52.jpg">
</div>

<div align ="center">
<img title="Task" alt="Task Description Image" src="https://i.ibb.co/F0YzbxT/Whats-App-Image-2023-04-23-at-15-48-15.jpg">
</div>

# Tasks

<div align ="center">
<img title="Task" alt="Task Description Image" src="https://i.ibb.co/wB0dQ3p/brave-6-Weah0-AXje.png">
</div>

# System Requirements

1. Java version 17 or higher
2. MySQL Installed and set up (If we later need MySQL instead of H2)
3. IntelliJIdea IDE Installed and set up

# Getting Started

1. Go to https://start.spring.io/
2. Set up as follows:
<div align ="center">
<img src="https://i.ibb.co/5Y2vv6j/brave-8w0-Mvj-JE6-T.png">
</div>

```
Note that, the package name, artifact and group are to be changed as per the project's demand.
```

3. Click on Generate to download the project
4. Extract the downloaded project
5. Open IDE and click on Open Project and give path to open

# Understanding Project Structure

<div align ="center">
<img src="https://i.ibb.co/61HDkkf/idea64-gk-KMq5-Q3d-A.png">
</div>

1. We are mainly concerned about **_pom.xml_** and **_src_**
2. **_pom.xml_** has all the dependencies and project settings, you can add new dependencies as needed and update maven project to rebuild the project basically installing the newly added dependencies

```
I understand it by comparing it to package.json in REACT/NODE stack.
```

3. **_src_**, well, it is what it is.
4. Inside **_src_** lies the main part of the project
<div align ="center">
<img src="https://i.ibb.co/6s7LWGv/idea64-6-Va1t22q-O3.png">
</div>

5. We dont need **_test_** folder as of now.
6. In **_resources_**, **_application.properties_** has the details about the database we are using and the url, id and password like stuff related to it whereas **_static_** is not needed as of now.
7. At the start, the **_com.lowes3.osp_** "Usecase3 OnlineSurveyPortal (fun name)" is only present.
8. We create packages called controller, dao, entity and service in the main package.

```
Packages are basically organized as folders in project directory (if you go through windows explorer), and the files inside them make necessary imports.
```

# Understanding the Packages

We should understand that, these packages have only significance and that is project organization. It looks good, and the project is well organized.

## Entity

- Entities are all the tables that we will be needing.
- They are basically objects.
- They are initialized as classes and are given various fields and their respective getter, setter, constructors are created.

## Service

- All the functions or operations we do on Entities are provided inside Service.
- For example:

```
- An Employee Entity will have an Employee Service.
- Also, there is an concept of Employee Service Implementation.
- Employee Service basically declares the main methods/functions we will be using/creating.
- Employee Serive Implementation will then describe each of the methods by implementing the Employee Service. (Polymorphism and all)
```

## DAO

- Refers to Data Access Object
- Helps Access Database
- Basically consists of Repositories for the entities
- These help create and perform operation on the database tables
- The Repository classes in these extend or implement the CRUDRepostory class, which has all the CRUD operations within it, thus making our life easier as we don't have to manually configure all the CRUD operations.

## Controller

- Has all the URL declaration and the **_"getting/setting"_** related **_internet stuff_** things inside it.
- What URL will be used to do what is declared in this.
- For a certain URL a certain service is performed.

## Gist

- Our project needs 3 tables
- Hence our project needs 3 entities
  > > > 1.  Survey
  > > > 2.  Questions
  > > > 3.  Responses
- For all entities we need to create the database table and operate on them, thus we need three Repositories inside dao
  > > > 1.  SurveyRepository
  > > > 2.  QuestionsRepository
  > > > 3.  ResponsesRepository
- For all entities we need to perform operations on the entities, thus services and their implementation.
- For all entities, we may have independently accessible URLs for all the operations, thus controllers and their implementation.

# Testing the backend

1. Have users already present and created
2. Create Survey first
3. Add questions to survey
4. Add resonses to the questions
5. Do required CRUD operations

```json
{
  "userName": "qwertyuiokjhgfdszxcvbnm"
}
```

```json
{
  "surveyTitle": "ABCDEFGHIJ",
  "surveyDescription": "loremipsumqwertyuioplkjhgfdsazxcvbnm"
}
```

```json
{
  "questionType": "qwertyuioplkjhgfdsa",
  "questionDescription": "qwertyuioplkjhgfdsazxcvbnm",
  "survey": {
    "surveyId": 1
  }
}
```

```json
{
  "responseDetails": "sdfgjkjhgfdsxcgh",
  "question": {
    "questionId": 4
  },
  "user": {
    "userId": 4
  }
}
```
