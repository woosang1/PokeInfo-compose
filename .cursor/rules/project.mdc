---
alwaysApply: true
---

# 프로젝트 아키텍처 및 코드 스타일 규칙

## 1. 프로젝트 개요 파악
- 현재 프로젝트는 Android 네이티브 앱 개발 중심으로, Jetpack Compose와 MVI(Model-View-Intent) 패턴을 핵심 아키텍처로 채택하고 있다.
- 멀티모듈 구조(예: app, core, domain, data, di 등)를 사용하며, KMP(Kotlin Multiplatform) 도입을 고려 중이다.
- 주요 기술 스택: Kotlin, Compose Multiplatform, Retrofit/OkHttp(네트워크), Hilt/Dagger(DI), Room/SQLDelight(로컬 DB), Coroutines/Flow(비동기).
- 디자인 패턴: MVI를 UI 레이어에서 엄격히 적용. ViewModel에서 Intent → State 변환을 통해 단방향 데이터 흐름 유지. Unidirectional Data Flow(UD F)를 준수.
- 이전 구현 예시: KCB 본인인증(WebView + MVI), PDF 업로드(Multipart Retrofit + Compose UI)에서 MVI와 Compose를 통합적으로 사용.

모든 코드 생성/수정 시, 위 아키텍처를 정확히 파악하고 통일성을 유지하라. 신규 기능 추가 시, 기존 모듈(예: :feature:auth, :ui:common)에 맞춰 확장.

## 2. 아키텍처 및 디자인 패턴 통일
- **MVI 패턴 강제**: 모든 UI 컴포넌트(Composable)에서 MVI를 적용.
  - Intent: 사용자 입력(예: onClick, onTextChange) → ViewModel의 public fun 메서드(예: `onUploadIntent(fileUri: Uri)`).
  - State: Sealed Class나 Data Class로 정의(예: `sealed class UploadState { object Idle : UploadState(); data class Progress(val percent: Int) : UploadState(); data class Success(val message: String) : UploadState(); data class Error(val throwable: Throwable) : UploadState(); }`).
  - Effect/SideEffect: Toast, Navigation 등 부수 효과는 `ChannelFlow`나 `SharedFlow`로 처리.
- **Compose 통합**: 모든 UI는 @Composable 함수로 작성. Modifier 체인(예: `Modifier.fillMaxSize().padding(16.dp)`)과 Theme 일관성 유지. LazyColumn/LazyRow로 리스트 렌더링.
- 레이어 분리: Presentation(ViewModel + Composable) | Domain(UseCase) | Data(Repository + API/DAO). Clean Architecture 준수.
- 네이밍: 프로젝트 워딩 통일 – "Upload" 대신 "FileUpload", "Auth" 대신 "IdentityVerification", "KCB" 대신 "OkNameAuth" (이전 구현 참조).

신규 코드 작성 시, MVI + Compose를 기본으로 제안. 예외 시 이유 설명.

## 3. 코드 컨벤션 및 네이밍 통일
- **Kotlin 컨벤션**: ktlint 또는 detekt 스타일 가이드 준수. camelCase 변수/함수, PascalCase 클래스, UPPER_SNAKE_CASE 상수.
- **네이밍 워딩**: 프로젝트 용어 사용.
  - UI: `VerificationScreen`, `UploadProgressDialog` (Screen/Composable 접미사).
  - ViewModel: `VerificationViewModel` (MVI Intent 메서드: `handleIntent`, `reduceState`).
  - Repository: `AuthRepository`, `FileUploadRepository`.
  - Intent/State: `VerificationIntent` (sealed), `VerificationState` (data/sealed).
  - 에러: `VerificationException` (custom Exception 클래스).
- 주석: KDoc으로 함수/클래스 설명. "// TODO: [이유]" 형식.
- Import: 불필요한 import 제거. `import androidx.compose.*` 그룹화.

코드 생성 시, 기존 파일(예: VerificationActivity.kt, UploadApi.kt) 스타일을 분석해 일치시킴.

## 4. 자동 코드 작성 시 빌드 테스트
- 생성된 코드가 즉시 빌드 가능하도록 검증: compile-time 에러 없음, 의존성 누락 없음.
- 테스트: 단위 테스트(예: ViewModelTest with Turbine for Flow/State 검증) 자동 추가 제안.
- 빌드 확인: Gradle sync 후 `./gradlew build` 시뮬레이션(에러 발생 시 수정 제안).
- 에지 케이스: API 호출 시 null-safety, Compose recomposition 최적화(remember, derivedStateOf) 확인.

코드 제안 후, "이 코드를 빌드 테스트해 보세요" 메시지 추가. 에러 발생 시 자동 수정 루프 실행.