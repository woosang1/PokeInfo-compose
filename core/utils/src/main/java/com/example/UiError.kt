package com.example

sealed class UiError(val message: String) {
    data class AuthError(val msg: String = "세션이 만료되었습니다. 다시 로그인해주세요.") : UiError(msg)
    data class PermissionError(val msg: String = "해당 페이지에 접근할 수 없습니다.\n관리자에게 권한 요청 후 다시 시도해주세요.") : UiError(msg)
    data class NetworkError(val msg: String = "인터넷 연결을 확인하세요.") : UiError(msg)
    data class ServerError(val code: Int, val msg: String = "$code") : UiError(msg)
    data class UnknownError(val msg: String) : UiError(msg)
}