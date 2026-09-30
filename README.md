# PDF Detail Finder – Android

Offline Android app for searching the bundled electoral-roll PDF.

## Important fix
The app now bundles the extracted page index as `app/src/main/assets/pages.js` instead of loading `pages.json` with `fetch()`. This avoids Android WebView local-file loading/CORS problems that could cause every search to return 0 results.

Example searchable names include `Reshma`, `Amit Shivaji Awale`, EPIC numbers, institutes and addresses.

## Build online
Push this project to GitHub. The included `.github/workflows/build-apk.yml` builds a debug APK with GitHub Actions.

In GitHub:
1. Open **Actions**
2. Select **Build APK**
3. Click **Run workflow**
4. After success, download **PDF-Detail-Finder-APK** from Artifacts.
