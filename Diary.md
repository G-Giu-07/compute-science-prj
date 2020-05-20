# Diary

## 16/05/2020 - Setup the project

### Tools

I never used **git** or **GitHub** before, I will use [these convetions](https://www.conventionalcommits.org/en/v1.0.0/) to write the commits.

Markdown is a standard on GitHub, so I am writing this diary on **markdown**.

### Database and Unix Commands

The database size is very high, about 7 GB, I will use the command **head** to extract the little part of the database.

Specifically, I think that the first 2k lines are enough for the sample.
```bash
head -2000 db.m4 > sample.m4
```

I am planning to use the *head* command again to split the database in little parts and **run the script in parallel**.

### Preprocessing

The database is very high, with the sample extracted using the **head** command I can work on it.  
How? I think to work on a preprocessing step which will filter all the useless data to reduce more the database size and extract only the part of the sample that will be used to build the first graph sample.

The script consists of extracting the part of the database which contains only the interesting overlaps.

Moreover, during the preprocessing could be useful to add a new column "ID" to define a key which will be the vertex of the graph.


### Post-preprocessing

I didn't have any issue about RAM or any needs to parallel the preprocessing.java script to filter the database.
The filtered database is **2.6 GB**, I hope to have no issues when I will use it to build the graph.


## 16/05/2020 - minor improvements and starting the graph

I need to improve the **preprocessing step** creating a "converter" for the identifiers to integers.
