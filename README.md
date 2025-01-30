# FactusDian-SDK

## Introducción
Introducción

FactusDian SDK es una biblioteca Android diseñada para interactuar con la API de Haltech Factus. Este SDK permite gestionar autenticaciones, facturas, notas crédito, productos y otras operaciones relacionadas con la facturación electrónica en Colombia.

Nota: este SDK Factus está en desarrollo, y algunas funcionalidades podrían estar incompletas.

Importante: Este SDK actúa únicamente como intermediario para la comunicación entre dispositivos Android y la API de Factus. No me hago responsable de los resultados, problemas o implicaciones derivadas del uso del SDK. Además, es necesario solicitar acceso a la API de Haltech Factus antes de poder utilizar este SDK.

Documentación oficial de la API: developers.factus.com.co

---

## Requisitos

- Android 7.0 (API 24) o superior
- Java 8 o superior
- Kotlin 1.9.24
- Android Gradle Plugin 8.3.0

---

## Instalación
### Usando JitPack
1. Agrega el repositorio de JitPack a tu archivo `settings.gradle`:

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
```

2. Agrega la dependencia en tu archivo `build.gradle` del módulo:

```gradle
implementation("com.github.juacosoft:FactusDian-SDK:<version>")
```

Reemplaza `<version>` con la versión deseada publicada en JitPack.

---

## Inicialización del SDK
Se recomienda inicializar el SDK en la clase `Application` de tu proyecto para garantizar que esté listo para su uso en toda la aplicación.

### Ejemplo:

```kotlin
import android.app.Application
import com.martinezdev.factusdian.sdk.FactusSDK

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        FactusSDK.initialize(
            baseUrl = "https://api.factus.com.co",
            clientId = "your-client-id",
            clientSecret = "your-client-secret",
            isDebugMode = true
        )

        // Verificar en la consola
        // Deberías ver: "Factus SDK initialized"
    }
}
```

---

## Uso del SDK

### 1. Autenticación
Obtén un token de autenticación:

```kotlin
suspend fun login() {
    val result = FactusSDK.getAuthToken("usuario", "contraseña")
    result.onSuccess { authResponse ->
        println("Token: ${authResponse.token}")
    }.onFailure { exception ->
        println("Error: ${exception.message}")
    }
}
```

### 2. Facturas
Obtener facturas:

```kotlin
suspend fun fetchInvoices() {
    val token = "your-token"
    val result = FactusSDK.getInvoices(token, "Bearer", page = 1)
    result.onSuccess { invoicesResponse ->
        println("Facturas: ${invoicesResponse.data}")
    }.onFailure { exception ->
        println("Error: ${exception.message}")
    }
}
```

### 3. Municipios
Obtener municipios:

```kotlin
suspend fun fetchMunicipalities() {
    val token = "your-token"
    val result = FactusSDK.getMunicipalities(token, "Bearer")
    result.onSuccess { municipalities ->
        println("Municipios: ${municipalities.data}")
    }.onFailure { exception ->
        println("Error: ${exception.message}")
    }
}
```

---

## Funcionalidades soportadas

### Autenticación
- **getAuthToken:** Obtener un token de autenticación.
- **refreshToken:** Refrescar el token de autenticación.

### Facturas
- **getInvoices:** Obtener facturas.
- **createInvoice:** Crear una nueva factura.
- **downloadFactPDF:** Descargar una factura en formato PDF.

### Datos transversales
- **getMunicipalities:** Obtener municipios.
- **getNumeringRanges:** Obtener rangos de numeración.
- **getTributesProducts:** Obtener tributos de productos.
- **getMeasureUnits:** Obtener unidades de medida.

### Notas crédito
- **getCreditNotes:** Obtener notas crédito.
- **getCreditNotePDF:** Descargar una nota crédito en formato PDF.
- **createCreditNote:** Crear una nueva nota crédito.

---

## Contribuciones
Si deseas contribuir a este proyecto, envíame un correo o contáctame directamente.

**Joaquín Martínez Marulanda**
- Email: [joaquinalfonso.martinez@gmail.com](mailto:joaquinalfonso.martinez@gmail.com)
- Teléfono: +57 304 363 0346
- Ubicación: Barichara, Santander, Colombia

---

## Licencia
Licencia
Este proyecto está protegido bajo licencia Apache 2.0. 
Consulta el archivo [LICENSE](https://github.com/juacosoft/FactusDian-SDK/blob/master/LICENSE) para más información.


