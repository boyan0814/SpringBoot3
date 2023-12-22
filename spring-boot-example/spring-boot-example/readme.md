Can use .properties or .yaml for setting app properties.

Postgres Docker-compose cmd :
1. compose up : docker compose up -d
2. look for container : docker ps
3. read container logs : docker logs postgres -f
4. exec : docker exec -it postgres bash
5. postgres login : psql -U boyan
6. look for db : \l
7. conn to "customer" db : \c customer
8. look for table : \d
9. run sql : SELECT * FROM customer;

From:https://www.youtube.com/watch?v=-mwpoE0x0JQ&ab_channel=Amigoscode