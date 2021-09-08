<h3>Village-SpringBoot API</h3>

This is a REST-API project on village structures in the Central Java region. Using the java programming language, springboot technology/framework, and PostgreSQL relational database.

there are 3 entities

<b>Hamlet(RW)</b>
- id
- head of hamlet
- an area

<b>Neighbourhood(RT)</b>
- id
- head of the neighborhood
- an area
- Hamlet data

<b>Citizen(data-warga)</b>
- id
- head of the family
- number of family members
- KK number
- neighborhood data
- Hamlet data
  
<h6>Each entity has 6 mapping controllers</h6>
- get all data
- get data by id
- get data filtered by other entity
- data entry
- update data
- delete data