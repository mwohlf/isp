

#### start keycloak

`gradle :keycloak:startContainer`

keycloak should be available at http://localhost:8001/auth/
login with admin/admin


#### build frontend

`gradle :frontned:build`


#### merge frontned into backend

`gradle mFIB`


#### start webapp

`gradle bootrun`

webapp should be available at http://localhost:8080/

