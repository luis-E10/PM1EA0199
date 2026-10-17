# PM1EA0199 — Agenda de Contactos
Java · MVC + DAO · SQLite · Versión A
Cuenta: 201910040199

## Abrir y ejecutar en Windows
1. Termina la instalación de Android Studio, con configuración Standard y sus componentes SDK.
2. Extrae TODO este ZIP: clic derecho > Extraer todo. No abras archivos dentro del ZIP.
3. En Android Studio: Open. Selecciona la carpeta PM1EA0199 que contiene settings.gradle.
4. Acepta la confianza del proyecto si aparece y espera a que termine Gradle Sync. La primera vez necesita Internet.
5. Si pide instalar Android SDK Platform 35 o Build Tools, acepta. El proyecto usa AGP 8.7.3, Gradle 8.9 y Java 17. En Settings > Build, Execution, Deployment > Build Tools > Gradle selecciona un Gradle JDK compatible (17 o 21).
6. En Device Manager crea un dispositivo Android con API 23 o posterior y descarga su imagen; también puedes conectar un Android físico con depuración USB.
7. Selecciona el dispositivo y pulsa Run (triángulo verde). La primera compilación puede tardar.
8. Para generar un APK: abre la terminal del proyecto y ejecuta .\gradlew.bat assembleDebug. El resultado está en app/build/outputs/apk/debug/app-debug.apk.

## Uso
Completa país, nombre, teléfono, nota y selecciona una fotografía de galería/archivos. Guarda y abre Ver contactos. Toca una fila para seleccionarla: aparece la confirmación de llamada. Pulsa No para usar las acciones Actualizar, Eliminar, Compartir o Ver Imagen. Pulsa Sí para abrir la pantalla de llamada y solicitar el permiso. Usa el buscador para filtrar por nombre, teléfono o país. La pantalla Llamar confirma con AlertDialog y solicita CALL_PHONE al autorizar la primera llamada.
El teléfono acepta exactamente ocho dígitos. El nombre admite letras Unicode, acentos y espacios. Se consideran obligatorios los seis datos del registro, salvo id, que se genera automáticamente.
Las fotografías se copian al almacenamiento privado de la app y su ruta se guarda en SQLite. No se requiere permiso general de almacenamiento. Compartir envía los datos de texto del contacto mediante ACTION_SEND.
Las llamadas y el texto compartido incorporan el prefijo internacional del país seleccionado. El emulador no realiza llamadas telefónicas reales.

## Arquitectura
- model/Contacto.java: modelo (id, pais, nombre, telefono, nota, imagen).
- dao/ContactoDAO.java: creación de SQLite y operaciones insertar, listar, buscar, actualizar y eliminar.
- view/Vistas.java: construcción de las vistas nativas reutilizables.
- controller/: tres Activity controlan eventos, validaciones y navegación.
Las vistas se construyen en Java; no se necesitan archivos de diseño XML.

## Comprobación manual antes de entregar
- Guardar vacío: debe avisar. Nombre con números: rechazar. Teléfono de 7/9 dígitos: rechazar.
- Registrar un contacto con foto; cerrar y abrir app: debe conservarse.
- Editar datos y fotografía; verificar cambios en la lista.
- Seleccionar contacto, compartirlo y comprobar su texto en otra aplicación.
- Ver fotografía; eliminar cancelando y después confirmando.
- Cancelar llamada: no llamar. Confirmar y denegar permiso: avisar. Confirmar y concederlo en teléfono real: abrir llamada.

## GitHub
Crea un repositorio llamado PM1EA0199 en tu GitHub. Desde esta carpeta:
```
git init
git add .
git commit -m "Agenda de contactos MVC DAO"
git branch -M main
git remote add origin https://github.com/TU_USUARIO/PM1EA0199.git
git push -u origin main
```
Sustituye TU_USUARIO. Comparte el enlace del repositorio con tu docente. No subas local.properties, carpetas build, .idea o .gradle. El wrapper JAR sí debe subirse.

## Alcance de la verificación
El proyecto fuente se entrega con wrapper Gradle. No incluye APK compilado. Las seis clases Java se verificaron con un compilador Java y las referencias de API 35; esta comprobación no reemplaza la compilación Gradle ni las pruebas en dispositivo. En el entorno de creación no hay Android SDK, por lo que la compilación y las pruebas en dispositivo deben completarse en Android Studio. El diseño se ajustó al PDF de referencia: foto superior, selector de país con prefijo, nota verde, botones verde/azul, buscador, filas azules alternadas, cuatro acciones inferiores y pantalla de llamada con número internacional. El encabezado UTH es texto; no se incluye el escudo institucional exacto. La cámara recibe la miniatura devuelta por la aplicación externa; la galería permite elegir una imagen con mayor resolución. No se implementó el punto extra de agregar países desde la aplicación.
Revisa y comprende el código y respeta las reglas de ayuda externa que indique tu docente.

Referencias oficiales: https://developer.android.com/guide/components/intents-common y https://developer.android.com/training/data-storage/shared/documents-files
