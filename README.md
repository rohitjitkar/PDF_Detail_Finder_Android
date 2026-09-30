# PDF Detail Finder — Android

This is the Android Studio project for the first version of the app.

## Included
- The supplied 112-page PDF
- A pre-indexed searchable page database
- Offline search by name, EPIC, institute, address, and other text
- Source page references
- No network permission and no external API required

## Build the APK
Open this folder in Android Studio, let Gradle sync, then:
Build > Build Bundle(s) / APK(s) > Build APK(s)

The generated APK will be under:
app/build/outputs/apk/debug/

## Important
This version uses page-level full-text search. It is deliberately local and free.
The next version can parse each voter into structured fields and add multiple-PDF importing, database updates, OCR, and a shared cloud backend.
