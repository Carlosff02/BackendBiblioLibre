FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copiamos mvnw y .mvn para usar el wrapper y habilitar cache de dependencias
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Asegurar que mvnw sea ejecutable (útil en algunos entornos)
RUN chmod +x mvnw

# Descargar dependencias (mejor cache)
RUN ./mvnw dependency:go-offline -B

# Copiar el código fuente
COPY src ./src

# Compilar el jar
RUN ./mvnw clean package -DskipTests -B

EXPOSE 8080

# Ejecutar el jar generado (ajusta el nombre si tu artifactId/version difieren)
CMD ["java", "-jar", "target/biblo-0.0.1-SNAPSHOT.jar"]
