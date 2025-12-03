## Descripción

Aely-Project es una aplicación para la gestión y venta de vuelos. Permite a los usuarios buscar, reservar y comprar boletos de avión de manera sencilla y eficiente.

## Características

- Búsqueda avanzada de vuelos por destino, fecha y precio.
- Reservas y compras seguras de boletos.
- Gestión de usuarios y perfiles.
- Panel de administración para gestión de vuelos y reservas.
- Notificaciones y confirmaciones por correo electrónico.
- Dashboard interactivo

## Tecnologías utilizadas

- Frontend: Angular 19
- Backend: Spring boot
- Base de datos: MySQL
- Autenticación: JWT

## Instalación

1. Clona el repositorio:
    ```bash
    git clone https://github.com/tu-usuario/Aely-Project.git
    ```
2. Instala las dependencias:
    ```bash
    cd Aely-Project
    npm install
    ```
3. Configura las variables de entorno en un archivo `.env`.
4. Inicia la aplicación:
    ```bash
    npm start
    ```

## Uso

Accede a la aplicación en `http://localhost:4200` y comienza a buscar vuelos.

## Backend Testing

The backend includes a comprehensive test suite covering:

- **Service Layer Tests**: Unit tests for business logic in service implementations (UsuarioServiceImpl, VueloServiceImpl, ReservaServiceImpl, TicketServiceImpl)
- **Controller Tests**: Integration tests for REST API endpoints (UsuarioController, VueloController)
- **Mapper Tests**: Unit tests for DTO mapping utilities (UsuarioMapper, VueloMapper, ReservaMapper, TicketMapper, RolMapper)
- **Security Tests**: Unit tests for JWT token generation and validation (JwtUtils)
- **Exception Handling Tests**: Tests for custom exception handling (ResourceNotFound, ExceptionHandleController)

### Running Backend Tests

Navigate to the backend directory and run tests using Gradle:

```bash
cd BackEnd/AerlyApi

# Run all tests
./gradlew test

# Run tests with detailed output
./gradlew test --info

# Run a specific test class
./gradlew test --tests "org.carpio.aerlyapi.service.impl.UsuarioServiceImplTest"

# Generate test report
./gradlew test jacocoTestReport
```

Test reports are generated at:
- `BackEnd/AerlyApi/build/reports/tests/test/index.html`

### Test Configuration

Tests use an H2 in-memory database configured in `src/test/resources/application.properties`, allowing tests to run without requiring a MySQL database connection.

