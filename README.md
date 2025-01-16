# A Smart PGJDBC

This repository hosts a **smart** version `pgjdbc` driver developed on top of the open-source [pgjdbc project](https://github.com/pgjdbc/pgjdbc).

### Why is it `smart`? 
 - It intercepts `SELECT` SQL queries and sends them to a `VisBooster` server for query rewriting.
 - By applying customizable rewriting rules, the rewritten SQL queries returned by `VisBooster` are much more efficient than the original queries.

The [`VisBooster` project](https://github.com/ISG-ICS/VisBooster) aims to rewrite SQL queries to an equivelant but more efficient form.

For more information of original `pgjdbc` project, refer to the original [README file](README_pgjdbc.md).

## Deveop and Build
To build the project, a tested working command is the following:
```bash
./gradlew build -x test -x :postgresql:generateFeatures -x :postgresql:generateKar -x :postgresql:publishAllPublicationsToLocalRepository
```
After build, the output jar file is at `pgjdbc/build/libs/postgresql-XX.X.X-SNAPSHOT.jar`.

For more development information, refer to the original [CONTRIBUTING.md](CONTRIBUTING.md).


Here is an example `smart-pgjdbc.config` file.

```config
# This is the url that the JDBC driver will talk to for rewriting queries.
#  - By default pointing to QueryBooster public server.
#  - You can change it to your private QueryBooster server. 
# smartjdbc.server.url=http://querybooster.ics.uci.edu/
smartjdbc.server.url=http://localhost:8000/

# This is the GUID of the Application created in the QueryBooster website.
#  - You can find this value in the "Applications" page in the QueryBooster website.
# app.guid=9565c0e4-23a6-11ef-93eb-f40343be1870
app.guid=02fd209a-2228-11ef-b413-f018982d3476
```

