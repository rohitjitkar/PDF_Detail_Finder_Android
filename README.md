# PDF Detail Finder – Android

Professional offline search app for the bundled electoral-roll PDF.

This version includes:
- Structured local record database
- Professional home page based on the PDF headings
- Search across voter fields
- Android FileProvider support for opening the source PDF
- GitHub Actions APK build

## Build online
1. Upload/replace the project files in GitHub.
2. Open **Actions**.
3. Select **Build APK**.
4. Click **Run workflow**.
5. Wait for the green check.
6. Download **PDF-Detail-Finder-APK** under Artifacts.

The source-PDF fix requires the AndroidX Core dependency included in `app/build.gradle`.
