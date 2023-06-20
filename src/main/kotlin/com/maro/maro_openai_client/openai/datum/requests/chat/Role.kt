package com.maro.maro_openai_client.openai.datum.requests.chat

/**
"system": 이 역할은 일반적으로 대화에 대한 높은 수준의 지침을 제공하는 시스템 수준 메시지 또는 지침에 사용됩니다.
"user": 이 역할은 최종 사용자 또는 보조자와의 대화에 참여하는 사용자가 작성한 메시지에 사용됩니다.
"assistant": 이 역할은 AI 비서 자체가 생성한 메시지를 나타냅니다. 여기에는 응답, 제안 또는 기타 생성된 내용이 포함됩니다.
 */
enum class Role(
    val value: String
) {
    SYSTEM("system"),
    USER("user"),
    ASSISTANT("assistant"),
}