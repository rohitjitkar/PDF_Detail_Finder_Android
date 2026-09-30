# PDF Detail Finder – Android

Offline searchable PDF record app.

This version includes:
- Professional home page based on the PDF headings
- Structured searchable record database
- Clean record cards
- Android FileProvider source-PDF opening
- AndroidX configuration
- GitHub Actions APK build

## Important build fix
`android.useAndroidX=true` and `android.enableJetifier=true` are enabled in `gradle.properties`, because the app uses the AndroidX Core FileProvider dependency.

## Build online
GitHub → Actions → Build APK → Run workflow → download PDF-Detail-Finder-APK from Artifacts.
