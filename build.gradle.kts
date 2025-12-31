plugins {
    alias(libs.plugins.android.application) apply false
    // alias(libs.plugins.kotlin.android) apply false  <-- ลบบรรทัดนี้ทิ้ง หรือใส่ // ไว้ข้างหน้า
    alias(libs.plugins.kotlin.compose) apply false

    id("com.google.dagger.hilt.android") version "2.51.1" apply false

    // ใช้ 2 บรรทัดนี้คู่กัน (Kotlin 1.9.23 + KSP 1.9.23-1.0.20)
    id("org.jetbrains.kotlin.android") version "1.9.23" apply false
    id("com.google.devtools.ksp") version "2.0.0-1.0.21" apply false
}