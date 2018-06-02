#!/usr/bin/env groovy
@Grab(group='ru.yandex.qatools.embed', module='postgresql-embedded', version='2.9')

import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres
import static ru.yandex.qatools.embed.postgresql.distribution.Version.*
import static ru.yandex.qatools.embed.postgresql.EmbeddedPostgres.cachedRuntimeConfig
import java.sql.Connection
import java.sql.DriverManager
import java.nio.file.Paths

EmbeddedPostgres postgres = new EmbeddedPostgres(V9_6_8)
String url = postgres.start(cachedRuntimeConfig(Paths.get("/tmp/postgresql-embedded")))
Connection conn = DriverManager.getConnection(url)
conn.createStatement().execute("CREATE TABLE data (code char(5));");
conn.close()
postgres.stop()
