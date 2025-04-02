# 📰 Daily Pulse — News Aggregator App (Kotlin Multiplatform)

A cross-platform news aggregation app built with **Kotlin Multiplatform (KMP/KMM)**, sharing core logic between Android and iOS.

---

## 📱 Platform Support

- ✅ Android (Jetpack Compose)
- ✅ iOS (SwiftUI)
- ✅ Shared business logic (Ktor, SQLDelight)

---

## 🎥 Demo

### Android  
![Android Demo](assets/demo-android.gif)

### iOS  
![iOS Demo](assets/demo-ios.gif)

---

## 🛠 Tech Stack

- Kotlin Multiplatform Mobile (KMM)
- Ktor Client for networking
- SQLDelight for local data storage
- MVI + Clean architecture
- Jetpack Compose (Android UI)
- SwiftUI (iOS UI)

---

## 📦 Artifacts

- 📱 [Download APK](artifacts/DailyPulse_Android.apk)
- 🍏 [Download .app (Simulator)](artifacts/DailyPulse_iOS_Simulator.app)

> `.app` file is built for iOS Simulator only and won't run on physical devices.

---

## 🏅 Certification

![Certificate](assets/udemy-certificate.jpg)

Completed:  
**Kotlin Multiplatform Masterclass — KMP, KMM - Android, iOS**  
Instructor: Petros Efthymiou  
Date: April 2, 2025

---

## ⚙️ Run Locally

### Android

```bash
./gradlew :androidApp:assembleDebug
adb install androidApp/build/outputs/apk/debug/androidApp-debug.apk
```

### iOS

```bash
# Open the iOS project in Xcode
open iosApp/iosApp.xcodeproj
# Select a Simulator and press ⌘R
```

---

## 🙋‍♂️ Author

Pavel Kharlamov
GitHub: [@PavelKharlamov](https://github.com/PavelKharlamov)

---

## 📄 License

MIT License — feel free to use and contribute!