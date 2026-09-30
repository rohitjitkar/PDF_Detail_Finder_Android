# PDF Detail Finder – Android

Offline searchable PDF record app.

### Source PDF button
The **VIEW SOURCE PDF** button now uses Android's PDF sharing/opening mechanism (FileProvider + ACTION_VIEW) instead of a `file://` link. The PDF is copied from the app assets to the app cache and opened by an installed PDF viewer.

If the phone has no PDF viewer, Android will show a message.

Build:
GitHub Actions → Build APK → Run workflow → download PDF-Detail-Finder-APK.
