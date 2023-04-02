FROM postgres

COPY psql_tables.sql /psql-tables.sql

RUN sleep 1m

RUN psql -h localhost -U pg -d postgres -a -f /psql-tables.sql